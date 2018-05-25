/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package courseenrolment;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.*;
/**
 *
 * @author wathsara
 */
public class Db {
    String url = "jdbc:mysql://localhost:3306/course";
    String username = "root";
    String password = "9423738@";
    ResultSet a= null;
    Connection con = null;
    PreparedStatement pst = null;
    Users u = new Users();
    void addUser(Users u){
        try{
            con = (Connection)DriverManager.getConnection(url,username,password);
            String query = "SELECT * FROM users";
             pst = (com.mysql.jdbc.PreparedStatement) con.prepareStatement(query);
             a= pst.executeQuery();
            
             while(a.next()){
                 
                 if(u.getFirstName().equals(a.getString("LastName")) && u.getLastName().equals(a.getString("FirstName"))){
                     Home h = new Home();
                     h.setVisible(true);
                     //System.out.println("Wathz");
                     
                 }else{
                     //System.out.println("Hello");
                 }
             }
             
             
        }catch(Exception e){
            System.err.println(e);
        }
    }
    
    
}
