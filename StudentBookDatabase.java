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
import java.time.LocalDate;
// 

public class StudentBookDatabase extends DataBase{
    //private ArrayList<StudentBook>records = new ArrayList<>();
    
    //constructor
    public StudentBookDatabase(String filename){
        this.filename = filename;
    }
  
    //methods 
    @Override
    public StudentBook createRecordFrom(String line){
        String input[] = line.split(",");
        System.out.println("line in createRecordFrom "+line);
        StudentBook s2=new StudentBook(input[0], input[1],LocalDate.parse(input[2]));
        System.out.println(s2.lineRepresentation());
        return s2;
       
    }
    
}
