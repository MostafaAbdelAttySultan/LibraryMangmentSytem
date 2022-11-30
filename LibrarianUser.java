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
public class LibrarianUser implements Record{
        private String librarianId;
        private String Name;
        private String Email;
        private String Address;
        private String PhoneNumber;
        //setters
        
        //constructor
        public LibrarianUser(String librarianId, String name, String email, String address, String phoneNumber) {
            this.librarianId = librarianId;
            this.Name = name;
            this.Email = email;
            this.Address = address;
            this.PhoneNumber = phoneNumber;
        }

        //methods implemented from interface record
        public String lineRepresentation(){
            String data="";
            data=data+librarianId;
            data=data+",";
            data=data+Name;
            data=data+",";
            data=data+Email;
            data=data+",";
            data=data+Address;
            data=data+",";
            data=data+PhoneNumber;
            return data;}
        public String getSearchKey(){
            return this.librarianId;
        }
        
    }
