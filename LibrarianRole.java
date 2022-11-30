/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package backend;

/**
 *
 * @author ADMIN
 */
import constants.FileNames;
import java.util.ArrayList;
import java.time.LocalDate;
import java.time.Period;
/**
 *
 * @author dell
 */
public class LibrarianRole implements LogOut,FileNames{
    private BookDatabase booksDatabase;
    private StudentBookDatabase sBDatabase;
    
    //const
    public LibrarianRole()
    {
        
        booksDatabase = new BookDatabase(BOOKS_FILENAME);
        booksDatabase.readFromFile();
        //System.out.println("aaaahhhhh");
        sBDatabase = new StudentBookDatabase(STUDENTSBOOKS_FILENAME);
        sBDatabase.readFromFile();
    }
    
    //methods
    public boolean addBook(String id, String title, String authorName,String publisherName, int quantity){
        Book book = new Book(id,title,authorName,publisherName,quantity);
        boolean flag=  booksDatabase.insertRecord(book);
       return flag;
        //System.out.println("Book:"+ book.lineRepresentation());
       
    }
    public Book[] getListOfBooks(){
       ArrayList <Record> b = booksDatabase.returnAllRecords();
       Book[] r = new Book[b.size()];
       r = b.toArray(r);
       return r;
    }
    public StudentBook[] getListOfBorrowingOperations(){
       ArrayList <Record> b = sBDatabase.returnAllRecords();
       StudentBook[] r = new StudentBook[b.size()];
       r = b.toArray(r);
       return r;
    }
    public int borrowBook(String studentId, String bookId, LocalDate borrowDate)
    {
       
        Book borrowed = (Book) booksDatabase.getRecord(bookId);
        
        System.out.println("Borrowed Book:"+ borrowed.lineRepresentation());
        if(borrowed == null)
        {
            System.out.println("Error Book not found");
            return -1; 
        }
        if(borrowed.getQuantity()==0)
            return 0;
        else if(sBDatabase.contains(studentId+","+bookId))
        {   System.out.println("Borrowed Book return 1studentId:"+ borrowed.lineRepresentation());
            return 1;
        }
        else
        {
            Book targeted = (Book) booksDatabase.getRecord(bookId);
            targeted.setQuantity(targeted.getQuantity()-1);
                    //System.out.println("Borrowed Book return 2:"+ targeted.lineRepresentation());

            StudentBook newBorrow = sBDatabase.createRecordFrom(bookId+","+studentId+","+borrowDate);
            sBDatabase.insertRecord(newBorrow);
            return 2;
        }
            
    }
    public double returnBook(String studentId, String bookId, LocalDate returnDate)
    {  
        String record = studentId+","+bookId;
        System.out.println("Returned searchKey in return book: " + record);
        StudentBook returnedRecord=(StudentBook)sBDatabase.getRecord(record);
        if (returnedRecord == null)
            return -1;
//        System.out.println("returnedBook" + returnedRecord.lineRepresentation());
        Book targeted = (Book) booksDatabase.getRecord(bookId);
      //  System.out.println("*******************************");
        targeted.setQuantity(targeted.getQuantity()+1);
        Period period = Period.between(returnedRecord.getBorrowDate(),returnDate);
        sBDatabase.deleteRecord(record);
        int duration = period.getDays() + period.getMonths()*30;
        System.out.println("Duration = "+duration);
        logout();
        if(duration > 7)
            return (duration - 7)*0.5;
        else 
            return 0;
    }
    public void logout(){
        booksDatabase.saveToFile();
        sBDatabase.saveToFile();
    }
    
}
