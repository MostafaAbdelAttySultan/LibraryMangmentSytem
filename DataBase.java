/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package backend;

/**
 *
 * @author ADMIN
 */
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author dell
 */
public abstract class DataBase {
    public String filename;
    ArrayList<Record> records = new ArrayList<> ();

     
    void readFromFile()
    {
        String Read;
        try {
            File file = new File(filename);
            Scanner scan = new Scanner(file);
            while (scan.hasNextLine()) {
                Read = scan.nextLine();
                this.records.add(createRecordFrom(Read));
                //System.out.println(Read);
            }
            //System.out.println("ahhhh");
            scan.close();
            System.out.println("Reading Done successfully!!" + records.size());
        }
        catch (FileNotFoundException e){
            System.out.println("An error occured can not find the file");
        }
    }
    
    abstract Record createRecordFrom(String read);
    public ArrayList<Record> returnAllRecords()
    {
        return records;
    }
    public boolean contains(String key)
    {
        Record search;
        for (int i = 0; i < records.size() ; i++) {
            search=records.get(i);
            //System.out.println(search.lineRepresentation());
            if(search.getSearchKey().equalsIgnoreCase(key))
                return true;
        }
        return false;
    }
    public Record getRecord(String key)
    {
        Record search;
        for (int i = 0; i < records.size() ; i++) {
            search=records.get(i);
        //    System.out.println("Get record " + search.lineRepresentation());
            if(search.getSearchKey().equalsIgnoreCase(key))
                return search; 
             //   System.out.println("yeaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
        }
      
        return null;
    }
    public Boolean insertRecord(Record record)
    {
        
        System.out.println(record.lineRepresentation());
        if(contains(record.getSearchKey()))
           return false;
        else{ 
            records.add(record);
        return true;
        }
    }
    public int getIndex(String key)// return the index of a given ID
    {
        Record search;
        for (int i = 0; i < records.size() ; i++) {
            search=records.get(i);
            if(search.getSearchKey().equalsIgnoreCase(key))
                return i;
        }
        return -1;
    }
    public void deleteRecord(String key)
    {
        records.remove(getIndex(key));
    }
    public void saveToFile()
    {
        try {
            FileWriter  fileWriter = new FileWriter(filename);
            fileWriter.flush();
            for (int i = 0; i < records.size(); i++) {
                Record user =records.get(i);
                fileWriter.write(user.lineRepresentation());
                fileWriter.write("\n");
                 //System.out.println("ahhhhhhhhhhhhhhhhhhhhhhh");
            }
            fileWriter.close();
        }
        catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
    
}
