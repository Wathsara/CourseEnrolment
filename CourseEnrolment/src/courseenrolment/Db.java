/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package courseenrolment;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.*;
import java.util.ArrayList;
import javax.swing.JOptionPane;
/**
 *
 * @author wathsara
 */
public class Db {
    String url = "jdbc:mysql://localhost:3306/course?useSSL=false";
    String username = "root";
    String password = "9423738@";
    ResultSet a= null;
    Connection con = null;
    PreparedStatement pst = null;
    Users u = new Users();
    
    int total=0;
    int insertadmin =0;
    byte[] im=null;
    String logname;
    int logid;
    void check(Users u){
        try{
            con = (Connection)DriverManager.getConnection(url,username,password);
            String query = "SELECT * FROM users";
             pst = (com.mysql.jdbc.PreparedStatement) con.prepareStatement(query);
             a= pst.executeQuery();
             
             
             while(a.next()){
                 
                 if(u.getUserName().equals(a.getString("Email")) && u.getPassword().equals(a.getString("Password"))){
                     logid =a.getInt("PersonID");
                     
                     logname=u.getUserName();
                     Home h = new Home();
                    
                     h.setVisible(true);
                     total =1;
                    
                     
                     System.out.println(logname+" "+logid);
                     return;
                     
                 }
             }
//             if(total==0){
//                 Login l =new Login();
//                 JOptionPane.showMessageDialog(l, "OOps Credentials missmatch Try Again !!");
//             }
             
             
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
            
        }
    }
    
    public boolean insertAdmin(AdminInsert a){
        try {
            con = (Connection)DriverManager.getConnection(url,username,password);
            String query = "INSERT INTO users values (?,?,?,?,?,?,?)";
            pst = (PreparedStatement)con.prepareStatement(query);
            pst.setInt(1,a.getId());
            pst.setString(2, a.getFullName());
            pst.setString(3, a.getEmail());
            pst.setString(4, a.getAddress());
            pst.setString(5, a.getContact());
            pst.setString(6, a.getPassword());
            pst.setBytes(7, a.getPic());
            pst.executeUpdate();
            return true;
            
            
            
            
            
            
        } 
        catch (Exception e) {
            System.err.print(e);
            return false;
            
            
            
        }
        
        
        
    }
    
    public void view(){
        
        try{
            con = (Connection)DriverManager.getConnection(url,username,password);
            String query = "SELECT * FROM users";
             pst = (com.mysql.jdbc.PreparedStatement) con.prepareStatement(query);
             a= pst.executeQuery();
             while(a.next()){
                 System.out.println(logid+" "+logname);
                 if(a.getInt("PersonID")==5){
                     im =a.getBytes("Pic");
                     System.out.println(im);
                 }
                 
             }
             
             
             
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
            
        }
    }
    
    ArrayList<AdminInsert> getAdmin(){
        try {
             ArrayList<AdminInsert> list = new ArrayList<AdminInsert>();
             con = (Connection)DriverManager.getConnection(url,username,password);
             String query = "SELECT * FROM users";
             pst = (com.mysql.jdbc.PreparedStatement) con.prepareStatement(query);
             a= pst.executeQuery();
             
             while(a.next()){
                 AdminInsert ad = new AdminInsert();
                 ad.setFullName(a.getString(2));
                 ad.setEmail(a.getString(3));
                 ad.setAddress(a.getString(4));
                 ad.setContact(a.getString(5));
                 list.add(ad);
                 
             }
             return list;
            
        } catch (Exception e) {
            System.out.println(e);
            return null;
        }
        
        
    }
    
        
}
    
   
