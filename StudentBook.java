/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package backend;

/**
 *
 * @author ADMIN
 */
import java.time.LocalDate;

public class StudentBook implements Record{
    private String studentId;
    private String bookId;
    LocalDate borrowDate;
    
    //setters&&getters
   public String getStudentId()
   {
       return studentId;
   }
   public String getBookId()
   {
       return bookId;
   }
   public LocalDate getBorrowDate()
   {
       return borrowDate;
   }
    
    //const
    public StudentBook(String studentId, String bookId, LocalDate borrowDate)
    {
        
        this.studentId=studentId;
       this.bookId=bookId;
       this.borrowDate=borrowDate;
    }

    
    //method implemented from record interface
    @Override
    public String lineRepresentation(){
        String data="";
        data=data+this.bookId;
        data=data+",";
        data=data+studentId;
        data=data+",";
        data=data+borrowDate;
        return data;
    }
    @Override
    public String getSearchKey() {
        String data="";
        data=data+this.bookId;
        data=data+",";
        data=data+studentId;
        return data;
    }
    
}
