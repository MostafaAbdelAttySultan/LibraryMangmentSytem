/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package backend;

/**
 *
 * @author ADMIN
 */
import java.util.ArrayList;
/**
 *
 * @author dell
 */
public class BookDatabase extends DataBase{
    private ArrayList<Book> records = new ArrayList<>();
    //const
    public BookDatabase(String filename)
    {
        this.filename = filename;
    }
    
    //methods
    @Override
    public Book createRecordFrom(String line)
    {
       String[] bookFeatures = line.split(",");
        //System.out.println(line);
       Book newBook = new Book(bookFeatures[0],bookFeatures[1],bookFeatures[2],bookFeatures[3],Integer.parseInt(bookFeatures[4]));
       return newBook ;
    }
    
    
}
