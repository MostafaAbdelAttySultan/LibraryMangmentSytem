/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package backend;

/**
 *
 * @author ADMIN
 */
public class Book implements Record{
    

    private String bookId;
    private String title;
    private String authorName;
    private String publisherName;
    private int quantity;
    
    
    //const
    public Book(String bookId, String title, String authorName, String publisherName, int quantity){
        this.bookId = bookId;
        this.title = title;
        this.authorName = authorName;
        this.publisherName = publisherName;
        this.quantity = quantity;
    }
    
    //setter and getter 
    public int getQuantity()
    {
        return quantity;
    }
    public void setQuantity(int quantity)
    {
        this.quantity = quantity;
    }
    
    //methods implemented from record
    @Override
    public String lineRepresentation(){
        String data="";
        data=data+bookId;
        data=data+",";
        data=data+title;
        data=data+",";
        data=data+authorName;
        data=data+",";
        data=data+publisherName;
        data=data+",";
        data=data+quantity;
        return data;
    }
    @Override
    public String getSearchKey() {
        return this.bookId;
    }

}
