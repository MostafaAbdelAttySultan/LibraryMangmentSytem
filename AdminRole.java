/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package backend;

/**
 *
 * @author ADMIN
 */
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */


/**
 * 
 * @author dell
 */
import constants.FileNames;
import java.util.ArrayList;

public class AdminRole implements LogOut,FileNames{
    private LibrarianUserDatabase database;
    //const
    public AdminRole() // can be modified to add teh path you want for the file
    {
        database = new LibrarianUserDatabase(LIBRARIANS_FILENAME);// opens the file given
        database.readFromFile();
    }
    //methods
    public boolean addLibrarian(String librarianId, String name, String email,String address, String phoneNumber)// addsLibrarian to the database
    {
        LibrarianUser user=new LibrarianUser(librarianId,name,email,address,phoneNumber);
       boolean flag= database.insertRecord(user);
       if(flag)return true;
       else return false;
    }
    public LibrarianUser[] getListOfLibrarians() // returns an array of Librairans
    {
        ArrayList <Record> users =  database.returnAllRecords();
        LibrarianUser[] usersList=new LibrarianUser[database.getSize()];
        usersList = users.toArray(usersList);
        return usersList;
    }
    public void removeLibrarian(String key)
    {
        if(database.contains(key))
            database.deleteRecord(key);
        else
            System.out.println("Not found!");

    }
    public void logout(){
        database.saveToFile();
    }
    
}
