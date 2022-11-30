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

public class LibrarianUserDatabase extends DataBase{
    //private ArrayList<LibrarianUser> records = new ArrayList<>();
    
    
    //const
    public LibrarianUserDatabase(String filename){
        this.filename = filename;
    }
    
    //methods
    @Override
    public LibrarianUser createRecordFrom(String line)
    {
        String Input[] = line.split(",");
        if(contains(Input[0]))
            return null;
        LibrarianUser newUser=new LibrarianUser(Input[0], Input[1], Input[2], Input[3], Input[4]);
        return newUser;
    }
    public int getSize()
    {
        return records.size();
    }



    
}
