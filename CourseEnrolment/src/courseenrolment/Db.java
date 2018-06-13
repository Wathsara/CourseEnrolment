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

    String url = "jdbc:mysql://localhost:3360/course?useSSL=false";
    String username = "root";
    String password = "";
    ResultSet rs = null;
    Connection con = null;
    PreparedStatement pst = null;
    Users u = new Users();

    int total = 0;
    double gp = 0.0000;
    int insertadmin = 0;
    byte[] im = null;
    String logname;
    int logid;

    void check(Users u) {
        try {
            con = (Connection) DriverManager.getConnection(url, username, password);
            String query = "SELECT * FROM users";
            pst = (com.mysql.jdbc.PreparedStatement) con.prepareStatement(query);
            rs = pst.executeQuery();

            while (rs.next()) {

                if (u.getUserName().equals(rs.getString("Email")) && u.getPassword().equals(rs.getString("Password"))) {
                    GetUser g = new GetUser();
                    g.setId(rs.getInt("PersonID"));
                    g.setName(rs.getString("FullName"));
                    g.setAddress(rs.getString("Address"));
                    g.setEmail(rs.getString("Email"));
                    g.setCno(rs.getString("ContactNo"));

                    logname = u.getUserName();
                    Home h = new Home();
                    h.q = g.getId();
                    h.name = g.getName();
                    h.email = g.getEmail();
                    h.cno = g.getCno();
                    h.address = g.getAddress();
                    h.setVisible(true);
                    total = 1;

                    System.out.println(logname + " " + logid);

                    return;

                }
            }
//             if(total==0){
//                 Login l =new Login();
//                 JOptionPane.showMessageDialog(l, "OOps Credentials missmatch Try Again !!");
//             }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);

        }
    }

    public boolean insertAdmin(AdminInsert a) {
        try {
            con = (Connection) DriverManager.getConnection(url, username, password);
            String query = "INSERT INTO users values (?,?,?,?,?,?,?)";
            pst = (PreparedStatement) con.prepareStatement(query);
            pst.setInt(1, a.getId());
            pst.setString(2, a.getFullName());
            pst.setString(3, a.getEmail());
            pst.setString(4, a.getAddress());
            pst.setString(5, a.getContact());
            pst.setString(6, a.getPassword());
            pst.setBytes(7, a.getPic());
            pst.executeUpdate();
            return true;

        } catch (Exception e) {
            System.err.print(e);
            return false;

        }

    }

    public void view(int x) {

        try {
            GetUser g = new GetUser();
            con = (Connection) DriverManager.getConnection(url, username, password);
            String query = "SELECT * FROM users";
            pst = (com.mysql.jdbc.PreparedStatement) con.prepareStatement(query);
            rs = pst.executeQuery();
            while (rs.next()) {

                if (rs.getInt("PersonID") == x) {
                    im = rs.getBytes("Pic");
                    System.out.println(im);
                }

            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);

        }
    }

    ArrayList<AdminInsert> getAdmin() {
        try {
            ArrayList<AdminInsert> list = new ArrayList<AdminInsert>();
            con = (Connection) DriverManager.getConnection(url, username, password);
            String query = "SELECT * FROM users";
            pst = (com.mysql.jdbc.PreparedStatement) con.prepareStatement(query);
            rs = pst.executeQuery();

            while (rs.next()) {
                AdminInsert ad = new AdminInsert();
                ad.setFullName(rs.getString(2));
                ad.setEmail(rs.getString(3));
                ad.setAddress(rs.getString(4));
                ad.setContact(rs.getString(5));
                ad.setId(rs.getInt(1));
                ad.setPic(rs.getBytes(7));
                list.add(ad);

            }
            return list;

        } catch (Exception e) {
            System.out.println(e);

            return null;
        }

    }

    public boolean updateAdmin(AdminInsert ai) {
        try {
            con = (Connection) DriverManager.getConnection(url, username, password);
            String query = "UPDATE users SET FullName='" + ai.getFullName() + "',Email='" + ai.getEmail() + "',Address='" + ai.getAddress() + "',ContactNo='" + ai.getContact() + "' WHERE PersonID=" + ai.getId();
            pst = (com.mysql.jdbc.PreparedStatement) con.prepareStatement(query);
            pst.executeUpdate();
            return true;

        } catch (Exception e) {
            System.err.println(e);
            return false;

        }
    }

    public boolean deleteAdmin(AdminInsert ai) {
        try {
            con = (Connection) DriverManager.getConnection(url, username, password);
            String query = "DELETE FROM users WHERE PersonID=" + ai.getId();
            pst = (com.mysql.jdbc.PreparedStatement) con.prepareStatement(query);
            pst.executeUpdate();
            return true;

        } catch (Exception e) {
            System.err.println(e);
            return false;

        }

    }

    boolean sobStudent(Student a) {
        try {
            con = (Connection) DriverManager.getConnection(url, username, password);
            String query = "INSERT INTO sobIntake values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
            pst = (PreparedStatement) con.prepareStatement(query);
            pst.setInt(1, a.getId());
            pst.setString(2, a.getName());
            pst.setString(3, a.getEmail());
            pst.setString(4, a.getDob());
            pst.setString(5, a.getAddress());
            pst.setString(6, a.getCno());
            pst.setString(7, a.getIntake());
            pst.setInt(8, a.getYear());
            pst.setInt(9, a.getAcademicYear());
            pst.setString(10, a.getStream());
            pst.setString(11, a.getzScore());
            pst.setString(12, a.getRank());
            pst.setBytes(13, a.getPic());
            pst.setString(14, a.getGender());
            pst.setDouble(15, a.getGp());
            pst.setInt(16, a.getCredits());

            pst.executeUpdate();

            return true;
        } catch (Exception e) {
            System.err.println(e);
            return false;

        }
    }

    boolean sobSemOne(Student a) {
        try {
            con = (Connection) DriverManager.getConnection(url, username, password);
            String query = "INSERT INTO sobSemOne values (?,?,?,?,?,?,?)";
            pst = (PreparedStatement) con.prepareStatement(query);
            pst.setInt(1, a.getId());
            pst.setString(2, a.getName());
            pst.setString(3, a.getFirstSemFirst());
            pst.setString(4, a.getFirstSemSecond());
            pst.setString(5, a.getFirstSemThird());
            pst.setString(6, a.getFirstSemFourth());
            pst.setInt(7, a.getAcademicYear());
            pst.executeUpdate();
            return true;
        } catch (Exception e) {
            System.err.println(e);
            return false;

        }
    }

    boolean sobSemtwo(Student a) {
        try {
            con = (Connection) DriverManager.getConnection(url, username, password);
            String query = "INSERT INTO sobSemTwo values (?,?,?,?,?,?,?)";
            pst = (PreparedStatement) con.prepareStatement(query);
            pst.setInt(1, a.getId());
            pst.setString(2, a.getName());
            pst.setString(3, a.getSecondSemFirst());
            pst.setString(4, a.getSecondSemSecond());
            pst.setString(5, a.getSecondSemThird());
            pst.setString(6, a.getSecondSemFourth());
            pst.setInt(7, a.getAcademicYear());
            pst.executeUpdate();
            return true;
        } catch (Exception e) {
            System.err.println(e);
            return false;

        }
    }

    boolean socStudent(Student a) {
        try {
            con = (Connection) DriverManager.getConnection(url, username, password);
            String query = "INSERT INTO socIntake values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
            pst = (PreparedStatement) con.prepareStatement(query);
            pst.setInt(1, a.getId());
            pst.setString(2, a.getName());
            pst.setString(3, a.getEmail());
            pst.setString(4, a.getDob());
            pst.setString(5, a.getAddress());
            pst.setString(6, a.getCno());
            pst.setString(7, a.getIntake());
            pst.setInt(8, a.getYear());
            pst.setInt(9, a.getAcademicYear());
            pst.setString(10, a.getStream());
            pst.setString(11, a.getzScore());
            pst.setString(12, a.getRank());
            pst.setBytes(13, a.getPic());
            pst.setString(14, a.getGender());
            pst.setDouble(15, a.getGp());
            pst.setInt(16, a.getCredits());

            pst.executeUpdate();

            return true;
        } catch (Exception e) {
            System.err.println(e);
            return false;

        }
    }

    boolean socSemOne(Student a) {
        try {
            con = (Connection) DriverManager.getConnection(url, username, password);
            String query = "INSERT INTO socSemOne values (?,?,?,?,?,?,?)";
            pst = (PreparedStatement) con.prepareStatement(query);
            pst.setInt(1, a.getId());
            pst.setString(2, a.getName());
            pst.setString(3, a.getFirstSemFirst());
            pst.setString(4, a.getFirstSemSecond());
            pst.setString(5, a.getFirstSemThird());
            pst.setString(6, a.getFirstSemFourth());
            pst.setInt(7, a.getAcademicYear());
            pst.executeUpdate();
            return true;
        } catch (Exception e) {
            System.err.println(e);
            return false;

        }
    }

    boolean socSemtwo(Student a) {
        try {
            con = (Connection) DriverManager.getConnection(url, username, password);
            String query = "INSERT INTO socSemTwo values (?,?,?,?,?,?,?)";
            pst = (PreparedStatement) con.prepareStatement(query);
            pst.setInt(1, a.getId());
            pst.setString(2, a.getName());
            pst.setString(3, a.getSecondSemFirst());
            pst.setString(4, a.getSecondSemSecond());
            pst.setString(5, a.getSecondSemThird());
            pst.setString(6, a.getSecondSemFourth());
            pst.setInt(7, a.getAcademicYear());
            pst.executeUpdate();
            return true;
        } catch (Exception e) {
            System.err.println(e);
            return false;

        }
    }

    boolean soeStudent(Student a) {
        try {
            con = (Connection) DriverManager.getConnection(url, username, password);
            String query = "INSERT INTO soeIntake values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
            pst = (PreparedStatement) con.prepareStatement(query);
            pst.setInt(1, a.getId());
            pst.setString(2, a.getName());
            pst.setString(3, a.getEmail());
            pst.setString(4, a.getDob());
            pst.setString(5, a.getAddress());
            pst.setString(6, a.getCno());
            pst.setString(7, a.getIntake());
            pst.setInt(8, a.getYear());
            pst.setInt(9, a.getAcademicYear());
            pst.setString(10, a.getStream());
            pst.setString(11, a.getzScore());
            pst.setString(12, a.getRank());
            pst.setBytes(13, a.getPic());
            pst.setString(14, a.getGender());
            pst.setDouble(15, a.getGp());
            pst.setInt(16, a.getCredits());

            pst.executeUpdate();

            return true;
        } catch (Exception e) {
            System.err.println(e);
            return false;

        }
    }

    boolean soeSemOne(Student a) {
        try {
            con = (Connection) DriverManager.getConnection(url, username, password);
            String query = "INSERT INTO soeSemOne values (?,?,?,?,?,?,?)";
            pst = (PreparedStatement) con.prepareStatement(query);
            pst.setInt(1, a.getId());
            pst.setString(2, a.getName());
            pst.setString(3, a.getFirstSemFirst());
            pst.setString(4, a.getFirstSemSecond());
            pst.setString(5, a.getFirstSemThird());
            pst.setString(6, a.getFirstSemFourth());
            pst.setInt(7, a.getAcademicYear());
            pst.executeUpdate();
            return true;
        } catch (Exception e) {
            System.err.println(e);
            return false;

        }
    }

    boolean soeSemtwo(Student a) {
        try {
            con = (Connection) DriverManager.getConnection(url, username, password);
            String query = "INSERT INTO soeSemTwo values (?,?,?,?,?,?,?)";
            pst = (PreparedStatement) con.prepareStatement(query);
            pst.setInt(1, a.getId());
            pst.setString(2, a.getName());
            pst.setString(3, a.getSecondSemFirst());
            pst.setString(4, a.getSecondSemSecond());
            pst.setString(5, a.getSecondSemThird());
            pst.setString(6, a.getSecondSemFourth());
            pst.setInt(7, a.getAcademicYear());
            pst.executeUpdate();
            return true;
        } catch (Exception e) {
            System.err.println(e);
            return false;

        }
    }

    boolean sobPostStudent(Student a) {
        try {
            con = (Connection) DriverManager.getConnection(url, username, password);
            String query = "INSERT INTO sobPostIntake values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
            pst = (PreparedStatement) con.prepareStatement(query);
            pst.setInt(1, a.getId());
            pst.setString(2, a.getName());
            pst.setString(3, a.getEmail());
            pst.setString(4, a.getDob());
            pst.setString(5, a.getAddress());
            pst.setString(6, a.getCno());
            pst.setString(7, a.getIntake());
            pst.setInt(8, a.getYear());
            pst.setInt(9, a.getAcademicYear());
            pst.setString(10, a.getStream());
            pst.setString(11, a.getzScore());
            pst.setString(12, a.getRank());
            pst.setString(13, a.getQualification());
            pst.setString(14, a.getInstitution());
            pst.setString(15, a.getGraYear());
            pst.setBytes(16, a.getPic());
            pst.setString(17, a.getGender());
            pst.setDouble(18, a.getGp());
            pst.setInt(19, a.getCredits());

            pst.executeUpdate();

            return true;
        } catch (Exception e) {
            System.err.println(e);
            return false;

        }
    }

    boolean sobPostSemOne(Student a) {
        try {
            con = (Connection) DriverManager.getConnection(url, username, password);
            String query = "INSERT INTO sobPostSemOne values (?,?,?,?,?,?,?)";
            pst = (PreparedStatement) con.prepareStatement(query);
            pst.setInt(1, a.getId());
            pst.setString(2, a.getName());
            pst.setString(3, a.getFirstSemFirst());
            pst.setString(4, a.getFirstSemSecond());
            pst.setString(5, a.getFirstSemThird());
            pst.setString(6, a.getFirstSemFourth());
            pst.setInt(7, a.getAcademicYear());
            pst.executeUpdate();
            return true;
        } catch (Exception e) {
            System.err.println(e);
            return false;

        }
    }

    boolean sobPostSemTwo(Student a) {
        try {
            con = (Connection) DriverManager.getConnection(url, username, password);
            String query = "INSERT INTO sobPostSemTwo values (?,?,?,?,?,?,?)";
            pst = (PreparedStatement) con.prepareStatement(query);
            pst.setInt(1, a.getId());
            pst.setString(2, a.getName());
            pst.setString(3, a.getSecondSemFirst());
            pst.setString(4, a.getSecondSemSecond());
            pst.setString(5, a.getSecondSemThird());
            pst.setString(6, a.getSecondSemFourth());
            pst.setInt(7, a.getAcademicYear());
            pst.executeUpdate();
            return true;
        } catch (Exception e) {
            System.err.println(e);
            return false;

        }
    }

    boolean socPostStudent(Student a) {
        try {
            con = (Connection) DriverManager.getConnection(url, username, password);
            String query = "INSERT INTO socPostIntake values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
            pst = (PreparedStatement) con.prepareStatement(query);
            pst.setInt(1, a.getId());
            pst.setString(2, a.getName());
            pst.setString(3, a.getEmail());
            pst.setString(4, a.getDob());
            pst.setString(5, a.getAddress());
            pst.setString(6, a.getCno());
            pst.setString(7, a.getIntake());
            pst.setInt(8, a.getYear());
            pst.setInt(9, a.getAcademicYear());
            pst.setString(10, a.getStream());
            pst.setString(11, a.getzScore());
            pst.setString(12, a.getRank());
            pst.setString(13, a.getQualification());
            pst.setString(14, a.getInstitution());
            pst.setString(15, a.getGraYear());
            pst.setBytes(16, a.getPic());
            pst.setString(17, a.getGender());
            pst.setDouble(18, a.getGp());
            pst.setInt(19, a.getCredits());

            pst.executeUpdate();

            return true;
        } catch (Exception e) {
            System.err.println(e);
            return false;

        }
    }

    boolean socPostSemOne(Student a) {
        try {
            con = (Connection) DriverManager.getConnection(url, username, password);
            String query = "INSERT INTO socPostSemOne values (?,?,?,?,?,?,?)";
            pst = (PreparedStatement) con.prepareStatement(query);
            pst.setInt(1, a.getId());
            pst.setString(2, a.getName());
            pst.setString(3, a.getFirstSemFirst());
            pst.setString(4, a.getFirstSemSecond());
            pst.setString(5, a.getFirstSemThird());
            pst.setString(6, a.getFirstSemFourth());
            pst.setInt(7, a.getAcademicYear());
            pst.executeUpdate();
            return true;
        } catch (Exception e) {
            System.err.println(e);
            return false;

        }
    }

    boolean socPostSemTwo(Student a) {
        try {
            con = (Connection) DriverManager.getConnection(url, username, password);
            String query = "INSERT INTO socPostSemTwo values (?,?,?,?,?,?,?)";
            pst = (PreparedStatement) con.prepareStatement(query);
            pst.setInt(1, a.getId());
            pst.setString(2, a.getName());
            pst.setString(3, a.getSecondSemFirst());
            pst.setString(4, a.getSecondSemSecond());
            pst.setString(5, a.getSecondSemThird());
            pst.setString(6, a.getSecondSemFourth());
            pst.setInt(7, a.getAcademicYear());
            pst.executeUpdate();
            return true;
        } catch (Exception e) {
            System.err.println(e);
            return false;

        }
    }

    boolean soePostStudent(Student a) {
        try {
            con = (Connection) DriverManager.getConnection(url, username, password);
            String query = "INSERT INTO soePostIntake values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
            pst = (PreparedStatement) con.prepareStatement(query);
            pst.setInt(1, a.getId());
            pst.setString(2, a.getName());
            pst.setString(3, a.getEmail());
            pst.setString(4, a.getDob());
            pst.setString(5, a.getAddress());
            pst.setString(6, a.getCno());
            pst.setString(7, a.getIntake());
            pst.setInt(8, a.getYear());
            pst.setInt(9, a.getAcademicYear());
            pst.setString(10, a.getStream());
            pst.setString(11, a.getzScore());
            pst.setString(12, a.getRank());
            pst.setString(13, a.getQualification());
            pst.setString(14, a.getInstitution());
            pst.setString(15, a.getGraYear());
            pst.setBytes(16, a.getPic());
            pst.setString(17, a.getGender());
            pst.setDouble(18, a.getGp());
            pst.setInt(19, a.getCredits());

            pst.executeUpdate();

            return true;
        } catch (Exception e) {
            System.err.println(e);
            return false;

        }
    }

    boolean soePostSemOne(Student a) {
        try {
            con = (Connection) DriverManager.getConnection(url, username, password);
            String query = "INSERT INTO soePostSemOne values (?,?,?,?,?,?,?)";
            pst = (PreparedStatement) con.prepareStatement(query);
            pst.setInt(1, a.getId());
            pst.setString(2, a.getName());
            pst.setString(3, a.getFirstSemFirst());
            pst.setString(4, a.getFirstSemSecond());
            pst.setString(5, a.getFirstSemThird());
            pst.setString(6, a.getFirstSemFourth());
            pst.setInt(7, a.getAcademicYear());
            pst.executeUpdate();
            return true;
        } catch (Exception e) {
            return false;

        }
    }

    boolean soePostSemTwo(Student a) {
        try {
            con = (Connection) DriverManager.getConnection(url, username, password);
            String query = "INSERT INTO soePostSemTwo values (?,?,?,?,?,?,?)";
            pst = (PreparedStatement) con.prepareStatement(query);
            pst.setInt(1, a.getId());
            pst.setString(2, a.getName());
            pst.setString(3, a.getSecondSemFirst());
            pst.setString(4, a.getSecondSemSecond());
            pst.setString(5, a.getSecondSemThird());
            pst.setString(6, a.getSecondSemFourth());
            pst.setInt(7, a.getAcademicYear());
            pst.executeUpdate();
            return true;
        } catch (Exception e) {
            return false;

        }
    }

    boolean newLec(Lecturer a) {
        try {
            con = (Connection) DriverManager.getConnection(url, username, password);
            String query = "INSERT INTO lecturer values (?,?,?,?,?,?,?,?,?,?,?,?,?)";
            pst = (PreparedStatement) con.prepareStatement(query);
            pst.setInt(1, a.getLecID());
            pst.setString(2, a.getName());
            pst.setString(3, a.getEmail());
            pst.setString(4, a.getGender());
            pst.setString(5, a.getDob());
            pst.setString(6, a.getAddress());
            pst.setString(7, a.getCno());
            pst.setString(8, a.getQualification());
            pst.setString(9, a.getInstitution());
            pst.setString(10, a.getGraYear());
            pst.setString(11, a.getFaculty());
            pst.setString(12, a.getType());
            pst.setBytes(13, a.getPic());
            pst.executeUpdate();

            return true;
        } catch (Exception e) {
            System.err.println(e);
            return false;

        }

    }

    boolean sobSubject(Subject a) {
        try {
            con = (Connection) DriverManager.getConnection(url, username, password);
            String query = "INSERT INTO sobSubject values (?,?,?,?,?,?,?,?,?,?)";
            pst = (PreparedStatement) con.prepareStatement(query);

            pst.setString(1, a.getSubCode());
            pst.setString(2, a.getSubName());
            pst.setString(3, a.getFaculty());
            pst.setString(4, a.getType());
            pst.setString(5, a.getAcademicYear());
            pst.setString(6, a.getSemester());
            pst.setString(7, a.getSubType());
            pst.setInt(8, a.getCredit());
            pst.setInt(9, a.getSubFee());
            pst.setString(10, a.getLecturerIncharge());

            pst.executeUpdate();

            return true;
        } catch (Exception e) {
            System.err.println(e);
            return false;

        }
    }

    boolean socSubject(Subject a) {
        try {
            con = (Connection) DriverManager.getConnection(url, username, password);
            String query = "INSERT INTO socSubject values (?,?,?,?,?,?,?,?,?,?)";
            pst = (PreparedStatement) con.prepareStatement(query);

            pst.setString(1, a.getSubCode());
            pst.setString(2, a.getSubName());
            pst.setString(3, a.getFaculty());
            pst.setString(4, a.getType());
            pst.setString(5, a.getAcademicYear());
            pst.setString(6, a.getSemester());
            pst.setString(7, a.getSubType());
            pst.setInt(8, a.getCredit());
            pst.setInt(9, a.getSubFee());
            pst.setString(10, a.getLecturerIncharge());

            pst.executeUpdate();

            return true;
        } catch (Exception e) {
            System.err.println(e);
            return false;

        }
    }

    boolean soeSubject(Subject a) {
        try {
            con = (Connection) DriverManager.getConnection(url, username, password);
            String query = "INSERT INTO soeSubject values (?,?,?,?,?,?,?,?,?,?)";
            pst = (PreparedStatement) con.prepareStatement(query);

            pst.setString(1, a.getSubCode());
            pst.setString(2, a.getSubName());
            pst.setString(3, a.getFaculty());
            pst.setString(4, a.getType());
            pst.setString(5, a.getAcademicYear());
            pst.setString(6, a.getSemester());
            pst.setString(7, a.getSubType());
            pst.setInt(8, a.getCredit());
            pst.setInt(9, a.getSubFee());
            pst.setString(10, a.getLecturerIncharge());

            pst.executeUpdate();

            return true;
        } catch (Exception e) {
            System.err.println(e);
            return false;

        }
    }

    boolean newInstructor(Lecturer a) {
        try {
            con = (Connection) DriverManager.getConnection(url, username, password);
            String query = "INSERT INTO instructor values (?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
            pst = (PreparedStatement) con.prepareStatement(query);
            pst.setInt(1, a.getLecID());
            pst.setString(2, a.getName());
            pst.setString(3, a.getEmail());
            pst.setString(4, a.getGender());
            pst.setString(5, a.getDob());
            pst.setString(6, a.getAddress());
            pst.setString(7, a.getCno());
            pst.setString(8, a.getSubject());
            pst.setString(9, a.getQualification());
            pst.setString(10, a.getInstitution());
            pst.setString(11, a.getGraYear());
            pst.setString(12, a.getFaculty());
            pst.setString(13, a.getType());
            pst.setBytes(14, a.getPic());
            pst.executeUpdate();

            return true;
        } catch (Exception e) {
            System.err.println(e);
            return false;

        }

    }

    boolean sobHall(RoomAllocation a) {
        try {
            con = (Connection) DriverManager.getConnection(url, username, password);
            String query = "INSERT INTO sobHall values (?,?,?,?,?,?,?,?,?)";
            pst = (PreparedStatement) con.prepareStatement(query);

            pst.setString(1, a.getType());
            pst.setString(2, a.getAcademicYear());
            pst.setString(3, a.getSemester());
            pst.setString(4, a.getSubject());
            pst.setString(5, a.getLecIns());
            pst.setString(6, a.getDay());
            pst.setString(7, a.getTimeFrom());
            pst.setString(8, a.getTimeTo());
            pst.setString(9, a.getRoom());

            pst.executeUpdate();

            return true;
        } catch (Exception e) {
            System.err.println(e);
            return false;

        }
    }

    boolean socHall(RoomAllocation a) {
        try {
            con = (Connection) DriverManager.getConnection(url, username, password);
            String query = "INSERT INTO socHall values (?,?,?,?,?,?,?,?,?)";
            pst = (PreparedStatement) con.prepareStatement(query);

            pst.setString(1, a.getType());
            pst.setString(2, a.getAcademicYear());
            pst.setString(3, a.getSemester());
            pst.setString(4, a.getSubject());
            pst.setString(5, a.getLecIns());
            pst.setString(6, a.getDay());
            pst.setString(7, a.getTimeFrom());
            pst.setString(8, a.getTimeTo());
            pst.setString(9, a.getRoom());

            pst.executeUpdate();

            return true;
        } catch (Exception e) {
            System.err.println(e);
            return false;

        }
    }

    boolean soeHall(RoomAllocation a) {
        try {
            con = (Connection) DriverManager.getConnection(url, username, password);
            String query = "INSERT INTO soeHall values (?,?,?,?,?,?,?,?,?)";
            pst = (PreparedStatement) con.prepareStatement(query);

            pst.setString(1, a.getType());
            pst.setString(2, a.getAcademicYear());
            pst.setString(3, a.getSemester());
            pst.setString(4, a.getSubject());
            pst.setString(5, a.getLecIns());
            pst.setString(6, a.getDay());
            pst.setString(7, a.getTimeFrom());
            pst.setString(8, a.getTimeTo());
            pst.setString(9, a.getRoom());

            pst.executeUpdate();

            return true;
        } catch (Exception e) {
            System.err.println(e);
            return false;

        }
    }

    boolean sobMarks(Marks a) {
        try {
            con = (Connection) DriverManager.getConnection(url, username, password);
            String query = "INSERT INTO sobMarks values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
            pst = (PreparedStatement) con.prepareStatement(query);
            pst.setInt(1, a.getId());
            pst.setString(2, a.getAcademicYear());
            pst.setString(3, a.getSemester());
            pst.setString(4, a.getSub1());
            pst.setString(5, a.getGrade1());
            pst.setString(6, a.getSub2());
            pst.setString(7, a.getGrade2());
            pst.setString(8, a.getSub3());
            pst.setString(9, a.getGrade3());
            pst.setString(10, a.getSub4());
            pst.setString(11, a.getGrade4());
            pst.setString(12, a.getSub5());
            pst.setString(13, a.getGrade5());
            pst.setString(14, a.getSub6());
            pst.setString(15, a.getGrade6());
            pst.executeUpdate();

            return true;
        } catch (Exception e) {
            System.err.println(e);
            return false;

        }

    }

    boolean sobGpaUpdate(Marks a) {
        try {
            con = (Connection) DriverManager.getConnection(url, username, password);
            String query = "UPDATE sobIntake SET gpa = ? , Credits= ? where StudentID = ?";
            pst = (PreparedStatement) con.prepareStatement(query);
            pst.setDouble(1, a.getGpa());
            pst.setInt(2, a.getCredit());
            pst.setInt(3, a.getId());
            pst.executeUpdate();
            return true;
        } catch (Exception e) {
            System.err.println(e);
            return false;
        }

    }

    boolean socMarks(Marks a) {
        try {
            con = (Connection) DriverManager.getConnection(url, username, password);
            String query = "INSERT INTO socMarks values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
            pst = (PreparedStatement) con.prepareStatement(query);
            pst.setInt(1, a.getId());
            pst.setString(2, a.getAcademicYear());
            pst.setString(3, a.getSemester());
            pst.setString(4, a.getSub1());
            pst.setString(5, a.getGrade1());
            pst.setString(6, a.getSub2());
            pst.setString(7, a.getGrade2());
            pst.setString(8, a.getSub3());
            pst.setString(9, a.getGrade3());
            pst.setString(10, a.getSub4());
            pst.setString(11, a.getGrade4());
            pst.setString(12, a.getSub5());
            pst.setString(13, a.getGrade5());
            pst.setString(14, a.getSub6());
            pst.setString(15, a.getGrade6());
            pst.executeUpdate();

            return true;
        } catch (Exception e) {
            System.err.println(e);
            return false;

        }
    }

    boolean socGpaUpdate(Marks a) {
        try {
            con = (Connection) DriverManager.getConnection(url, username, password);
            String query = "UPDATE socIntake SET gpa = ? , Credits= ? where StudentID = ?";
            pst = (PreparedStatement) con.prepareStatement(query);
            pst.setDouble(1, a.getGpa());
            pst.setInt(2, a.getCredit());
            pst.setInt(3, a.getId());
            pst.executeUpdate();
            return true;
        } catch (Exception e) {
            System.err.println(e);
            return false;
        }

    }

    boolean soeMarks(Marks a) {
        try {
            con = (Connection) DriverManager.getConnection(url, username, password);
            String query = "INSERT INTO soeMarks values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
            pst = (PreparedStatement) con.prepareStatement(query);
            pst.setInt(1, a.getId());
            pst.setString(2, a.getAcademicYear());
            pst.setString(3, a.getSemester());
            pst.setString(4, a.getSub1());
            pst.setString(5, a.getGrade1());
            pst.setString(6, a.getSub2());
            pst.setString(7, a.getGrade2());
            pst.setString(8, a.getSub3());
            pst.setString(9, a.getGrade3());
            pst.setString(10, a.getSub4());
            pst.setString(11, a.getGrade4());
            pst.setString(12, a.getSub5());
            pst.setString(13, a.getGrade5());
            pst.setString(14, a.getSub6());
            pst.setString(15, a.getGrade6());
            pst.executeUpdate();

            return true;
        } catch (Exception e) {
            System.err.println(e);
            return false;

        }
    }

    boolean soeGpaUpdate(Marks a) {
        try {
            con = (Connection) DriverManager.getConnection(url, username, password);
            String query = "UPDATE soeIntake SET gpa = ? , Credits= ? where StudentID = ?";
            pst = (PreparedStatement) con.prepareStatement(query);
            pst.setDouble(1, a.getGpa());
            pst.setInt(2, a.getCredit());
            pst.setInt(3, a.getId());
            pst.executeUpdate();
            return true;
        } catch (Exception e) {
            System.err.println(e);
            return false;
        }

    }

    boolean sobPostMarks(Marks a) {
        try {
            con = (Connection) DriverManager.getConnection(url, username, password);
            String query = "INSERT INTO sobPostMarks values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
            pst = (PreparedStatement) con.prepareStatement(query);
            pst.setInt(1, a.getId());
            pst.setString(2, a.getAcademicYear());
            pst.setString(3, a.getSemester());
            pst.setString(4, a.getSub1());
            pst.setString(5, a.getGrade1());
            pst.setString(6, a.getSub2());
            pst.setString(7, a.getGrade2());
            pst.setString(8, a.getSub3());
            pst.setString(9, a.getGrade3());
            pst.setString(10, a.getSub4());
            pst.setString(11, a.getGrade4());
            pst.setString(12, a.getSub5());
            pst.setString(13, a.getGrade5());
            pst.setString(14, a.getSub6());
            pst.setString(15, a.getGrade6());
            pst.executeUpdate();

            return true;
        } catch (Exception e) {
            System.err.println(e);
            return false;

        }

    }

    boolean sobPostGpaUpdate(Marks a) {
        try {
            con = (Connection) DriverManager.getConnection(url, username, password);
            String query = "UPDATE sobPostIntake SET gpa = ? , Credits= ? where StudentID = ?";
            pst = (PreparedStatement) con.prepareStatement(query);
            pst.setDouble(1, a.getGpa());
            pst.setInt(2, a.getCredit());
            pst.setInt(3, a.getId());
            pst.executeUpdate();
            return true;
        } catch (Exception e) {
            System.err.println(e);
            return false;
        }

    }

    boolean socPostMarks(Marks a) {
        try {
            con = (Connection) DriverManager.getConnection(url, username, password);
            String query = "INSERT INTO socPostMarks values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
            pst = (PreparedStatement) con.prepareStatement(query);
            pst.setInt(1, a.getId());
            pst.setString(2, a.getAcademicYear());
            pst.setString(3, a.getSemester());
            pst.setString(4, a.getSub1());
            pst.setString(5, a.getGrade1());
            pst.setString(6, a.getSub2());
            pst.setString(7, a.getGrade2());
            pst.setString(8, a.getSub3());
            pst.setString(9, a.getGrade3());
            pst.setString(10, a.getSub4());
            pst.setString(11, a.getGrade4());
            pst.setString(12, a.getSub5());
            pst.setString(13, a.getGrade5());
            pst.setString(14, a.getSub6());
            pst.setString(15, a.getGrade6());
            pst.executeUpdate();

            return true;
        } catch (Exception e) {
            System.err.println(e);
            return false;

        }
    }

    boolean socPostGpaUpdate(Marks a) {
        try {
            con = (Connection) DriverManager.getConnection(url, username, password);
            String query = "UPDATE socPostIntake SET gpa = ? , Credits= ? where StudentID = ?";
            pst = (PreparedStatement) con.prepareStatement(query);
            pst.setDouble(1, a.getGpa());
            pst.setInt(2, a.getCredit());
            pst.setInt(3, a.getId());
            pst.executeUpdate();
            return true;
        } catch (Exception e) {
            System.err.println(e);
            return false;
        }

    }

    boolean soePostMarks(Marks a) {
        try {
            con = (Connection) DriverManager.getConnection(url, username, password);
            String query = "INSERT INTO soePostMarks values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
            pst = (PreparedStatement) con.prepareStatement(query);
            pst.setInt(1, a.getId());
            pst.setString(2, a.getAcademicYear());
            pst.setString(3, a.getSemester());
            pst.setString(4, a.getSub1());
            pst.setString(5, a.getGrade1());
            pst.setString(6, a.getSub2());
            pst.setString(7, a.getGrade2());
            pst.setString(8, a.getSub3());
            pst.setString(9, a.getGrade3());
            pst.setString(10, a.getSub4());
            pst.setString(11, a.getGrade4());
            pst.setString(12, a.getSub5());
            pst.setString(13, a.getGrade5());
            pst.setString(14, a.getSub6());
            pst.setString(15, a.getGrade6());
            pst.executeUpdate();

            return true;
        } catch (Exception e) {
            System.err.println(e);
            return false;

        }
    }

    boolean soePostGpaUpdate(Marks a) {
        try {
            con = (Connection) DriverManager.getConnection(url, username, password);
            String query = "UPDATE soePostIntake SET gpa = ? , Credits= ? where StudentID = ?";
            pst = (PreparedStatement) con.prepareStatement(query);
            pst.setDouble(1, a.getGpa());
            pst.setInt(2, a.getCredit());
            pst.setInt(3, a.getId());
            pst.executeUpdate();
            return true;
        } catch (Exception e) {
            System.err.println(e);
            return false;
        }

    }

    ArrayList<Student> viewSobUnder() {
        try {
            ArrayList<Student> list = new ArrayList<Student>();
            con = (Connection) DriverManager.getConnection(url, username, password);
            String query = "SELECT * FROM sobIntake";
            pst = (com.mysql.jdbc.PreparedStatement) con.prepareStatement(query);
            rs = pst.executeQuery();

            while (rs.next()) {
                Student ad = new Student();
                ad.setId(rs.getInt(1));
                ad.setName(rs.getString(2));
                ad.setEmail(rs.getString(3));
                ad.setDob(rs.getString(4));
                ad.setAddress(rs.getString(5));
                ad.setCno(rs.getString(6));
                ad.setIntake(rs.getString(7));
                ad.setYear(rs.getInt(8));
                ad.setAcademicYear(rs.getInt(9));
                ad.setStream(rs.getString(10));
                ad.setzScore(rs.getString(11));
                ad.setRank(rs.getString(12));
                ad.setPic(rs.getBytes(13));
                ad.setGender(rs.getString(14));
                ad.setGp(rs.getDouble(15));
                ad.setCredits(rs.getInt(16));
                list.add(ad);

            }
            return list;

        } catch (Exception e) {
            System.out.println(e);

            return null;
        }

    }

    public boolean updateSobUnderProfile(Student a) {
        try {
            con = (Connection) DriverManager.getConnection(url, username, password);
            String query = "UPDATE sobIntake SET FullName = ?, Email = ?, Dob = ?, Address = ? , ContactNo = ?, Stream = ? , Zscore= ? , Rank= ?, Gender = ? WHERE StudentID= ?";
            pst = (com.mysql.jdbc.PreparedStatement) con.prepareStatement(query);
            pst.setString(1, a.getName());
            pst.setString(2, a.getEmail());
            pst.setString(3, a.getDob());
            pst.setString(4, a.getAddress());
            pst.setString(5, a.getCno());
            pst.setString(6, a.getStream());
            pst.setString(7, a.getzScore());
            pst.setString(8, a.getRank());
            pst.setString(9, a.getGender());
            pst.setInt(10, a.getId());

            pst.executeUpdate();
            return true;

        } catch (Exception e) {
            System.err.println(e);
            return false;

        }
    }

    public boolean updateSobUnderSemOneName(Student a) {
        try {
            con = (Connection) DriverManager.getConnection(url, username, password);
            String query = "UPDATE sobSemOne SET FullName = ? WHERE StudentID= ?";
            pst = (com.mysql.jdbc.PreparedStatement) con.prepareStatement(query);
            pst.setString(1, a.getName());
            pst.setInt(2, a.getId());

            pst.executeUpdate();
            return true;

        } catch (Exception e) {
            System.err.println(e);
            return false;

        }
    }

    public boolean updateSobUnderSemTwoName(Student a) {
        try {
            con = (Connection) DriverManager.getConnection(url, username, password);
            String query = "UPDATE sobSemTwo SET FullName = ? WHERE StudentID= ?";
            pst = (com.mysql.jdbc.PreparedStatement) con.prepareStatement(query);
            pst.setString(1, a.getName());
            pst.setInt(2, a.getId());

            pst.executeUpdate();
            return true;

        } catch (Exception e) {
            System.err.println(e);
            return false;

        }
    }

    ArrayList<Student> viewSobUnderAsc(int a) {
        try {
            ArrayList<Student> list = new ArrayList<Student>();
            con = (Connection) DriverManager.getConnection(url, username, password);
            String query = "SELECT * FROM sobIntake WHERE AcademicYear = ? ORDER BY gpa ASC";
            pst = (com.mysql.jdbc.PreparedStatement) con.prepareStatement(query);
            pst.setInt(1, a);
            rs = pst.executeQuery();

            while (rs.next()) {
                Student ad = new Student();
                ad.setId(rs.getInt(1));
                ad.setName(rs.getString(2));
                ad.setEmail(rs.getString(3));
                ad.setDob(rs.getString(4));
                ad.setAddress(rs.getString(5));
                ad.setCno(rs.getString(6));
                ad.setIntake(rs.getString(7));
                ad.setYear(rs.getInt(8));
                ad.setAcademicYear(rs.getInt(9));
                ad.setStream(rs.getString(10));
                ad.setzScore(rs.getString(11));
                ad.setRank(rs.getString(12));
                ad.setPic(rs.getBytes(13));
                ad.setGender(rs.getString(14));
                ad.setGp(rs.getDouble(15));
                ad.setCredits(rs.getInt(16));
                list.add(ad);

            }
            return list;

        } catch (Exception e) {
            System.out.println(e);

            return null;
        }

    }

    ArrayList<Student> viewSobUnderDsc(int a) {
        try {
            ArrayList<Student> list = new ArrayList<Student>();
            con = (Connection) DriverManager.getConnection(url, username, password);
            String query = "SELECT * FROM sobIntake WHERE AcademicYear = ? ORDER BY gpa DESC";
            pst = (com.mysql.jdbc.PreparedStatement) con.prepareStatement(query);
            pst.setInt(1, a);
            rs = pst.executeQuery();

            while (rs.next()) {
                Student ad = new Student();
                ad.setId(rs.getInt(1));
                ad.setName(rs.getString(2));
                ad.setEmail(rs.getString(3));
                ad.setDob(rs.getString(4));
                ad.setAddress(rs.getString(5));
                ad.setCno(rs.getString(6));
                ad.setIntake(rs.getString(7));
                ad.setYear(rs.getInt(8));
                ad.setAcademicYear(rs.getInt(9));
                ad.setStream(rs.getString(10));
                ad.setzScore(rs.getString(11));
                ad.setRank(rs.getString(12));
                ad.setPic(rs.getBytes(13));
                ad.setGender(rs.getString(14));
                ad.setGp(rs.getDouble(15));
                ad.setCredits(rs.getInt(16));
                list.add(ad);

            }
            return list;

        } catch (Exception e) {
            System.out.println(e);

            return null;
        }

    }

    ArrayList<Student> viewSocUnder() {
        try {
            ArrayList<Student> list = new ArrayList<Student>();
            con = (Connection) DriverManager.getConnection(url, username, password);
            String query = "SELECT * FROM socIntake";
            pst = (com.mysql.jdbc.PreparedStatement) con.prepareStatement(query);
            rs = pst.executeQuery();

            while (rs.next()) {
                Student ad = new Student();
                ad.setId(rs.getInt(1));
                ad.setName(rs.getString(2));
                ad.setEmail(rs.getString(3));
                ad.setDob(rs.getString(4));
                ad.setAddress(rs.getString(5));
                ad.setCno(rs.getString(6));
                ad.setIntake(rs.getString(7));
                ad.setYear(rs.getInt(8));
                ad.setAcademicYear(rs.getInt(9));
                ad.setStream(rs.getString(10));
                ad.setzScore(rs.getString(11));
                ad.setRank(rs.getString(12));
                ad.setPic(rs.getBytes(13));
                ad.setGender(rs.getString(14));
                ad.setGp(rs.getDouble(15));
                ad.setCredits(rs.getInt(16));
                list.add(ad);

            }
            return list;

        } catch (Exception e) {
            System.out.println(e);

            return null;
        }

    }

    ArrayList<Student> viewSocUnderAsc(int a) {
        try {
            ArrayList<Student> list = new ArrayList<Student>();
            con = (Connection) DriverManager.getConnection(url, username, password);
            String query = "SELECT * FROM socIntake WHERE AcademicYear = ? ORDER BY gpa ASC";
            pst = (com.mysql.jdbc.PreparedStatement) con.prepareStatement(query);
            pst.setInt(1, a);
            rs = pst.executeQuery();

            while (rs.next()) {
                Student ad = new Student();
                ad.setId(rs.getInt(1));
                ad.setName(rs.getString(2));
                ad.setEmail(rs.getString(3));
                ad.setDob(rs.getString(4));
                ad.setAddress(rs.getString(5));
                ad.setCno(rs.getString(6));
                ad.setIntake(rs.getString(7));
                ad.setYear(rs.getInt(8));
                ad.setAcademicYear(rs.getInt(9));
                ad.setStream(rs.getString(10));
                ad.setzScore(rs.getString(11));
                ad.setRank(rs.getString(12));
                ad.setPic(rs.getBytes(13));
                ad.setGender(rs.getString(14));
                ad.setGp(rs.getDouble(15));
                ad.setCredits(rs.getInt(16));
                list.add(ad);

            }
            return list;

        } catch (Exception e) {
            System.out.println(e);

            return null;
        }

    }

    ArrayList<Student> viewSocUnderDsc(int a) {
        try {
            ArrayList<Student> list = new ArrayList<Student>();
            con = (Connection) DriverManager.getConnection(url, username, password);
            String query = "SELECT * FROM socIntake WHERE AcademicYear = ? ORDER BY gpa DESC";
            pst = (com.mysql.jdbc.PreparedStatement) con.prepareStatement(query);
            pst.setInt(1, a);
            rs = pst.executeQuery();

            while (rs.next()) {
                Student ad = new Student();
                ad.setId(rs.getInt(1));
                ad.setName(rs.getString(2));
                ad.setEmail(rs.getString(3));
                ad.setDob(rs.getString(4));
                ad.setAddress(rs.getString(5));
                ad.setCno(rs.getString(6));
                ad.setIntake(rs.getString(7));
                ad.setYear(rs.getInt(8));
                ad.setAcademicYear(rs.getInt(9));
                ad.setStream(rs.getString(10));
                ad.setzScore(rs.getString(11));
                ad.setRank(rs.getString(12));
                ad.setPic(rs.getBytes(13));
                ad.setGender(rs.getString(14));
                ad.setGp(rs.getDouble(15));
                ad.setCredits(rs.getInt(16));
                list.add(ad);

            }
            return list;

        } catch (Exception e) {
            System.out.println(e);

            return null;
        }

    }

    public boolean updateSocUnderProfile(Student a) {
        try {
            con = (Connection) DriverManager.getConnection(url, username, password);
            String query = "UPDATE socIntake SET FullName = ?, Email = ?, Dob = ?, Address = ? , ContactNo = ?, Stream = ? , Zscore= ? , Rank= ?, Gender = ? WHERE StudentID= ?";
            pst = (com.mysql.jdbc.PreparedStatement) con.prepareStatement(query);
            pst.setString(1, a.getName());
            pst.setString(2, a.getEmail());
            pst.setString(3, a.getDob());
            pst.setString(4, a.getAddress());
            pst.setString(5, a.getCno());
            pst.setString(6, a.getStream());
            pst.setString(7, a.getzScore());
            pst.setString(8, a.getRank());
            pst.setString(9, a.getGender());
            pst.setInt(10, a.getId());

            pst.executeUpdate();
            return true;

        } catch (Exception e) {
            System.err.println(e);
            return false;

        }
    }

    public boolean updateSocUnderSemOneName(Student a) {
        try {
            con = (Connection) DriverManager.getConnection(url, username, password);
            String query = "UPDATE socSemOne SET FullName = ? WHERE StudentID= ?";
            pst = (com.mysql.jdbc.PreparedStatement) con.prepareStatement(query);
            pst.setString(1, a.getName());
            pst.setInt(2, a.getId());

            pst.executeUpdate();
            return true;

        } catch (Exception e) {
            System.err.println(e);
            return false;

        }
    }

    public boolean updateSocUnderSemTwoName(Student a) {
        try {
            con = (Connection) DriverManager.getConnection(url, username, password);
            String query = "UPDATE socSemTwo SET FullName = ? WHERE StudentID= ?";
            pst = (com.mysql.jdbc.PreparedStatement) con.prepareStatement(query);
            pst.setString(1, a.getName());
            pst.setInt(2, a.getId());

            pst.executeUpdate();
            return true;

        } catch (Exception e) {
            System.err.println(e);
            return false;

        }
    }

    ArrayList<Student> viewSoeUnder() {
        try {
            ArrayList<Student> list = new ArrayList<Student>();
            con = (Connection) DriverManager.getConnection(url, username, password);
            String query = "SELECT * FROM soeIntake";
            pst = (com.mysql.jdbc.PreparedStatement) con.prepareStatement(query);
            rs = pst.executeQuery();

            while (rs.next()) {
                Student ad = new Student();
                ad.setId(rs.getInt(1));
                ad.setName(rs.getString(2));
                ad.setEmail(rs.getString(3));
                ad.setDob(rs.getString(4));
                ad.setAddress(rs.getString(5));
                ad.setCno(rs.getString(6));
                ad.setIntake(rs.getString(7));
                ad.setYear(rs.getInt(8));
                ad.setAcademicYear(rs.getInt(9));
                ad.setStream(rs.getString(10));
                ad.setzScore(rs.getString(11));
                ad.setRank(rs.getString(12));
                ad.setPic(rs.getBytes(13));
                ad.setGender(rs.getString(14));
                ad.setGp(rs.getDouble(15));
                ad.setCredits(rs.getInt(16));
                list.add(ad);

            }
            return list;

        } catch (Exception e) {
            System.out.println(e);

            return null;
        }

    }

    ArrayList<Student> viewSoeUnderAsc(int a) {
        try {
            ArrayList<Student> list = new ArrayList<Student>();
            con = (Connection) DriverManager.getConnection(url, username, password);
            String query = "SELECT * FROM soeIntake WHERE AcademicYear = ? ORDER BY gpa ASC";
            pst = (com.mysql.jdbc.PreparedStatement) con.prepareStatement(query);
            pst.setInt(1, a);
            rs = pst.executeQuery();

            while (rs.next()) {
                Student ad = new Student();
                ad.setId(rs.getInt(1));
                ad.setName(rs.getString(2));
                ad.setEmail(rs.getString(3));
                ad.setDob(rs.getString(4));
                ad.setAddress(rs.getString(5));
                ad.setCno(rs.getString(6));
                ad.setIntake(rs.getString(7));
                ad.setYear(rs.getInt(8));
                ad.setAcademicYear(rs.getInt(9));
                ad.setStream(rs.getString(10));
                ad.setzScore(rs.getString(11));
                ad.setRank(rs.getString(12));
                ad.setPic(rs.getBytes(13));
                ad.setGender(rs.getString(14));
                ad.setGp(rs.getDouble(15));
                ad.setCredits(rs.getInt(16));
                list.add(ad);

            }
            return list;

        } catch (Exception e) {
            System.out.println(e);

            return null;
        }

    }

    ArrayList<Student> viewSoeUnderDsc(int a) {
        try {
            ArrayList<Student> list = new ArrayList<Student>();
            con = (Connection) DriverManager.getConnection(url, username, password);
            String query = "SELECT * FROM so3Intake WHERE AcademicYear = ? ORDER BY gpa DESC";
            pst = (com.mysql.jdbc.PreparedStatement) con.prepareStatement(query);
            pst.setInt(1, a);
            rs = pst.executeQuery();

            while (rs.next()) {
                Student ad = new Student();
                ad.setId(rs.getInt(1));
                ad.setName(rs.getString(2));
                ad.setEmail(rs.getString(3));
                ad.setDob(rs.getString(4));
                ad.setAddress(rs.getString(5));
                ad.setCno(rs.getString(6));
                ad.setIntake(rs.getString(7));
                ad.setYear(rs.getInt(8));
                ad.setAcademicYear(rs.getInt(9));
                ad.setStream(rs.getString(10));
                ad.setzScore(rs.getString(11));
                ad.setRank(rs.getString(12));
                ad.setPic(rs.getBytes(13));
                ad.setGender(rs.getString(14));
                ad.setGp(rs.getDouble(15));
                ad.setCredits(rs.getInt(16));
                list.add(ad);

            }
            return list;

        } catch (Exception e) {
            System.out.println(e);

            return null;
        }

    }

    public boolean updateSoeUnderProfile(Student a) {
        try {
            con = (Connection) DriverManager.getConnection(url, username, password);
            String query = "UPDATE soeIntake SET FullName = ?, Email = ?, Dob = ?, Address = ? , ContactNo = ?, Stream = ? , Zscore= ? , Rank= ?, Gender = ? WHERE StudentID= ?";
            pst = (com.mysql.jdbc.PreparedStatement) con.prepareStatement(query);
            pst.setString(1, a.getName());
            pst.setString(2, a.getEmail());
            pst.setString(3, a.getDob());
            pst.setString(4, a.getAddress());
            pst.setString(5, a.getCno());
            pst.setString(6, a.getStream());
            pst.setString(7, a.getzScore());
            pst.setString(8, a.getRank());
            pst.setString(9, a.getGender());
            pst.setInt(10, a.getId());

            pst.executeUpdate();
            return true;

        } catch (Exception e) {
            System.err.println(e);
            return false;

        }
    }

    public boolean updateSoeUnderSemOneName(Student a) {
        try {
            con = (Connection) DriverManager.getConnection(url, username, password);
            String query = "UPDATE soeSemOne SET FullName = ? WHERE StudentID= ?";
            pst = (com.mysql.jdbc.PreparedStatement) con.prepareStatement(query);
            pst.setString(1, a.getName());
            pst.setInt(2, a.getId());

            pst.executeUpdate();
            return true;

        } catch (Exception e) {
            System.err.println(e);
            return false;

        }
    }

    public boolean updateSoeUnderSemTwoName(Student a) {
        try {
            con = (Connection) DriverManager.getConnection(url, username, password);
            String query = "UPDATE soeSemTwo SET FullName = ? WHERE StudentID= ?";
            pst = (com.mysql.jdbc.PreparedStatement) con.prepareStatement(query);
            pst.setString(1, a.getName());
            pst.setInt(2, a.getId());

            pst.executeUpdate();
            return true;

        } catch (Exception e) {
            System.err.println(e);
            return false;

        }
    }

    ArrayList<Student> viewSobPost() {
        try {
            ArrayList<Student> list = new ArrayList<Student>();
            con = (Connection) DriverManager.getConnection(url, username, password);
            String query = "SELECT * FROM sobPostIntake";
            pst = (com.mysql.jdbc.PreparedStatement) con.prepareStatement(query);
            rs = pst.executeQuery();

            while (rs.next()) {
                Student ad = new Student();
                ad.setId(rs.getInt(1));
                ad.setName(rs.getString(2));
                ad.setEmail(rs.getString(3));
                ad.setDob(rs.getString(4));
                ad.setAddress(rs.getString(5));
                ad.setCno(rs.getString(6));
                ad.setIntake(rs.getString(7));
                ad.setYear(rs.getInt(8));
                ad.setAcademicYear(rs.getInt(9));
                ad.setStream(rs.getString(10));
                ad.setzScore(rs.getString(11));
                ad.setRank(rs.getString(12));
                ad.setQualification(rs.getString(13));
                ad.setInstitution(rs.getString(14));
                ad.setGraYear(rs.getString(15));
                ad.setPic(rs.getBytes(16));
                ad.setGender(rs.getString(17));
                ad.setGp(rs.getDouble(18));
                ad.setCredits(rs.getInt(19));

                list.add(ad);

            }
            return list;

        } catch (Exception e) {
            System.out.println(e);

            return null;
        }

    }

    ArrayList<Student> viewSobPostAsc(int a) {
        try {
            ArrayList<Student> list = new ArrayList<Student>();
            con = (Connection) DriverManager.getConnection(url, username, password);
            String query = "SELECT * FROM sobPostIntake WHERE AcademicYear = ? ORDER BY gpa ASC";
            pst = (com.mysql.jdbc.PreparedStatement) con.prepareStatement(query);
            pst.setInt(1, a);
            rs = pst.executeQuery();

            while (rs.next()) {
                Student ad = new Student();
                ad.setId(rs.getInt(1));
                ad.setName(rs.getString(2));
                ad.setEmail(rs.getString(3));
                ad.setDob(rs.getString(4));
                ad.setAddress(rs.getString(5));
                ad.setCno(rs.getString(6));
                ad.setIntake(rs.getString(7));
                ad.setYear(rs.getInt(8));
                ad.setAcademicYear(rs.getInt(9));
                ad.setStream(rs.getString(10));
                ad.setzScore(rs.getString(11));
                ad.setRank(rs.getString(12));
                ad.setQualification(rs.getString(13));
                ad.setInstitution(rs.getString(14));
                ad.setGraYear(rs.getString(15));
                ad.setPic(rs.getBytes(16));
                ad.setGender(rs.getString(17));
                ad.setGp(rs.getDouble(18));
                ad.setCredits(rs.getInt(19));
                list.add(ad);

            }
            return list;

        } catch (Exception e) {
            System.out.println(e);

            return null;
        }

    }

    ArrayList<Student> viewSobPostDsc(int a) {
        try {
            ArrayList<Student> list = new ArrayList<Student>();
            con = (Connection) DriverManager.getConnection(url, username, password);
            String query = "SELECT * FROM sobPostIntake WHERE AcademicYear = ? ORDER BY gpa DESC";
            pst = (com.mysql.jdbc.PreparedStatement) con.prepareStatement(query);
            pst.setInt(1, a);
            rs = pst.executeQuery();

            while (rs.next()) {
                Student ad = new Student();
                ad.setId(rs.getInt(1));
                ad.setName(rs.getString(2));
                ad.setEmail(rs.getString(3));
                ad.setDob(rs.getString(4));
                ad.setAddress(rs.getString(5));
                ad.setCno(rs.getString(6));
                ad.setIntake(rs.getString(7));
                ad.setYear(rs.getInt(8));
                ad.setAcademicYear(rs.getInt(9));
                ad.setStream(rs.getString(10));
                ad.setzScore(rs.getString(11));
                ad.setRank(rs.getString(12));
                ad.setQualification(rs.getString(13));
                ad.setInstitution(rs.getString(14));
                ad.setGraYear(rs.getString(15));
                ad.setPic(rs.getBytes(16));
                ad.setGender(rs.getString(17));
                ad.setGp(rs.getDouble(18));
                ad.setCredits(rs.getInt(19));
                list.add(ad);

            }
            return list;

        } catch (Exception e) {
            System.out.println(e);

            return null;
        }

    }
    
    public boolean updateSobPostProfile(Student a) {
        try {
            con = (Connection) DriverManager.getConnection(url, username, password);
            String query = "UPDATE sobPostIntake SET FullName = ?, Email = ?, Dob = ?, Address = ? , ContactNo = ?, Stream = ? , Zscore= ? , Rank= ?, Gender = ?, Qualification=? , Institution=? , GraYear=? WHERE StudentID= ?";
            pst = (com.mysql.jdbc.PreparedStatement) con.prepareStatement(query);
            pst.setString(1, a.getName());
            pst.setString(2, a.getEmail());
            pst.setString(3, a.getDob());
            pst.setString(4, a.getAddress());
            pst.setString(5, a.getCno());
            pst.setString(6, a.getStream());
            pst.setString(7, a.getzScore());
            pst.setString(8, a.getRank());
            pst.setString(9, a.getGender());
            pst.setString(10, a.getQualification());
            pst.setString(11, a.getInstitution());
            pst.setString(12, a.getGraYear());
            pst.setInt(13, a.getId());

            pst.executeUpdate();
            return true;

        } catch (Exception e) {
            System.err.println(e);
            return false;

        }
    }

    public boolean updateSobPostSemOneName(Student a) {
        try {
            con = (Connection) DriverManager.getConnection(url, username, password);
            String query = "UPDATE sobPostSemOne SET FullName = ? WHERE StudentID= ?";
            pst = (com.mysql.jdbc.PreparedStatement) con.prepareStatement(query);
            pst.setString(1, a.getName());
            pst.setInt(2, a.getId());

            pst.executeUpdate();
            return true;

        } catch (Exception e) {
            System.err.println(e);
            return false;

        }
    }

    public boolean updateSobPostSemTwoName(Student a) {
        try {
            con = (Connection) DriverManager.getConnection(url, username, password);
            String query = "UPDATE sobPostSemTwo SET FullName = ? WHERE StudentID= ?";
            pst = (com.mysql.jdbc.PreparedStatement) con.prepareStatement(query);
            pst.setString(1, a.getName());
            pst.setInt(2, a.getId());

            pst.executeUpdate();
            return true;

        } catch (Exception e) {
            System.err.println(e);
            return false;

        }
    }

    ArrayList<Student> viewSocPost() {
        try {
            ArrayList<Student> list = new ArrayList<Student>();
            con = (Connection) DriverManager.getConnection(url, username, password);
            String query = "SELECT * FROM socPostIntake";
            pst = (com.mysql.jdbc.PreparedStatement) con.prepareStatement(query);
            rs = pst.executeQuery();

            while (rs.next()) {
                Student ad = new Student();
                ad.setId(rs.getInt(1));
                ad.setName(rs.getString(2));
                ad.setEmail(rs.getString(3));
                ad.setDob(rs.getString(4));
                ad.setAddress(rs.getString(5));
                ad.setCno(rs.getString(6));
                ad.setIntake(rs.getString(7));
                ad.setYear(rs.getInt(8));
                ad.setAcademicYear(rs.getInt(9));
                ad.setStream(rs.getString(10));
                ad.setzScore(rs.getString(11));
                ad.setRank(rs.getString(12));
                ad.setQualification(rs.getString(13));
                ad.setInstitution(rs.getString(14));
                ad.setGraYear(rs.getString(15));
                ad.setPic(rs.getBytes(16));
                ad.setGender(rs.getString(17));
                ad.setGp(rs.getDouble(18));
                ad.setCredits(rs.getInt(19));

                list.add(ad);

            }
            return list;

        } catch (Exception e) {
            System.out.println(e);

            return null;
        }

    }

    ArrayList<Student> viewSocPostAsc(int a) {
        try {
            ArrayList<Student> list = new ArrayList<Student>();
            con = (Connection) DriverManager.getConnection(url, username, password);
            String query = "SELECT * FROM socPostIntake WHERE AcademicYear = ? ORDER BY gpa ASC";
            pst = (com.mysql.jdbc.PreparedStatement) con.prepareStatement(query);
            pst.setInt(1, a);
            rs = pst.executeQuery();

            while (rs.next()) {
                Student ad = new Student();
                ad.setId(rs.getInt(1));
                ad.setName(rs.getString(2));
                ad.setEmail(rs.getString(3));
                ad.setDob(rs.getString(4));
                ad.setAddress(rs.getString(5));
                ad.setCno(rs.getString(6));
                ad.setIntake(rs.getString(7));
                ad.setYear(rs.getInt(8));
                ad.setAcademicYear(rs.getInt(9));
                ad.setStream(rs.getString(10));
                ad.setzScore(rs.getString(11));
                ad.setRank(rs.getString(12));
                ad.setQualification(rs.getString(13));
                ad.setInstitution(rs.getString(14));
                ad.setGraYear(rs.getString(15));
                ad.setPic(rs.getBytes(16));
                ad.setGender(rs.getString(17));
                ad.setGp(rs.getDouble(18));
                ad.setCredits(rs.getInt(19));
                list.add(ad);

            }
            return list;

        } catch (Exception e) {
            System.out.println(e);

            return null;
        }

    }

    ArrayList<Student> viewSocPostDsc(int a) {
        try {
            ArrayList<Student> list = new ArrayList<Student>();
            con = (Connection) DriverManager.getConnection(url, username, password);
            String query = "SELECT * FROM socPostIntake WHERE AcademicYear = ? ORDER BY gpa DESC";
            pst = (com.mysql.jdbc.PreparedStatement) con.prepareStatement(query);
            pst.setInt(1, a);
            rs = pst.executeQuery();

            while (rs.next()) {
                Student ad = new Student();
                ad.setId(rs.getInt(1));
                ad.setName(rs.getString(2));
                ad.setEmail(rs.getString(3));
                ad.setDob(rs.getString(4));
                ad.setAddress(rs.getString(5));
                ad.setCno(rs.getString(6));
                ad.setIntake(rs.getString(7));
                ad.setYear(rs.getInt(8));
                ad.setAcademicYear(rs.getInt(9));
                ad.setStream(rs.getString(10));
                ad.setzScore(rs.getString(11));
                ad.setRank(rs.getString(12));
                ad.setQualification(rs.getString(13));
                ad.setInstitution(rs.getString(14));
                ad.setGraYear(rs.getString(15));
                ad.setPic(rs.getBytes(16));
                ad.setGender(rs.getString(17));
                ad.setGp(rs.getDouble(18));
                ad.setCredits(rs.getInt(19));
                list.add(ad);

            }
            return list;

        } catch (Exception e) {
            System.out.println(e);

            return null;
        }

    }
    
    public boolean updateSocPostProfile(Student a) {
        try {
            con = (Connection) DriverManager.getConnection(url, username, password);
            String query = "UPDATE socPostIntake SET FullName = ?, Email = ?, Dob = ?, Address = ? , ContactNo = ?, Stream = ? , Zscore= ? , Rank= ?, Gender = ?, Qualification=? , Institution=? , GraYear=? WHERE StudentID= ?";
            pst = (com.mysql.jdbc.PreparedStatement) con.prepareStatement(query);
            pst.setString(1, a.getName());
            pst.setString(2, a.getEmail());
            pst.setString(3, a.getDob());
            pst.setString(4, a.getAddress());
            pst.setString(5, a.getCno());
            pst.setString(6, a.getStream());
            pst.setString(7, a.getzScore());
            pst.setString(8, a.getRank());
            pst.setString(9, a.getGender());
            pst.setString(10, a.getQualification());
            pst.setString(11, a.getInstitution());
            pst.setString(12, a.getGraYear());
            pst.setInt(13, a.getId());

            pst.executeUpdate();
            return true;

        } catch (Exception e) {
            System.err.println(e);
            return false;

        }
    }

    public boolean updateSocPostSemOneName(Student a) {
        try {
            con = (Connection) DriverManager.getConnection(url, username, password);
            String query = "UPDATE socPostSemOne SET FullName = ? WHERE StudentID= ?";
            pst = (com.mysql.jdbc.PreparedStatement) con.prepareStatement(query);
            pst.setString(1, a.getName());
            pst.setInt(2, a.getId());

            pst.executeUpdate();
            return true;

        } catch (Exception e) {
            System.err.println(e);
            return false;

        }
    }

    public boolean updateSocPostSemTwoName(Student a) {
        try {
            con = (Connection) DriverManager.getConnection(url, username, password);
            String query = "UPDATE socPostSemTwo SET FullName = ? WHERE StudentID= ?";
            pst = (com.mysql.jdbc.PreparedStatement) con.prepareStatement(query);
            pst.setString(1, a.getName());
            pst.setInt(2, a.getId());

            pst.executeUpdate();
            return true;

        } catch (Exception e) {
            System.err.println(e);
            return false;

        }
    }
    
    ArrayList<Student> viewSoePost() {
        try {
            ArrayList<Student> list = new ArrayList<Student>();
            con = (Connection) DriverManager.getConnection(url, username, password);
            String query = "SELECT * FROM soePostIntake";
            pst = (com.mysql.jdbc.PreparedStatement) con.prepareStatement(query);
            rs = pst.executeQuery();

            while (rs.next()) {
                Student ad = new Student();
                ad.setId(rs.getInt(1));
                ad.setName(rs.getString(2));
                ad.setEmail(rs.getString(3));
                ad.setDob(rs.getString(4));
                ad.setAddress(rs.getString(5));
                ad.setCno(rs.getString(6));
                ad.setIntake(rs.getString(7));
                ad.setYear(rs.getInt(8));
                ad.setAcademicYear(rs.getInt(9));
                ad.setStream(rs.getString(10));
                ad.setzScore(rs.getString(11));
                ad.setRank(rs.getString(12));
                ad.setQualification(rs.getString(13));
                ad.setInstitution(rs.getString(14));
                ad.setGraYear(rs.getString(15));
                ad.setPic(rs.getBytes(16));
                ad.setGender(rs.getString(17));
                ad.setGp(rs.getDouble(18));
                ad.setCredits(rs.getInt(19));

                list.add(ad);

            }
            return list;

        } catch (Exception e) {
            System.out.println(e);

            return null;
        }

    }

    ArrayList<Student> viewSoePostAsc(int a) {
        try {
            ArrayList<Student> list = new ArrayList<Student>();
            con = (Connection) DriverManager.getConnection(url, username, password);
            String query = "SELECT * FROM soePostIntake WHERE AcademicYear = ? ORDER BY gpa ASC";
            pst = (com.mysql.jdbc.PreparedStatement) con.prepareStatement(query);
            pst.setInt(1, a);
            rs = pst.executeQuery();

            while (rs.next()) {
                Student ad = new Student();
                ad.setId(rs.getInt(1));
                ad.setName(rs.getString(2));
                ad.setEmail(rs.getString(3));
                ad.setDob(rs.getString(4));
                ad.setAddress(rs.getString(5));
                ad.setCno(rs.getString(6));
                ad.setIntake(rs.getString(7));
                ad.setYear(rs.getInt(8));
                ad.setAcademicYear(rs.getInt(9));
                ad.setStream(rs.getString(10));
                ad.setzScore(rs.getString(11));
                ad.setRank(rs.getString(12));
                ad.setQualification(rs.getString(13));
                ad.setInstitution(rs.getString(14));
                ad.setGraYear(rs.getString(15));
                ad.setPic(rs.getBytes(16));
                ad.setGender(rs.getString(17));
                ad.setGp(rs.getDouble(18));
                ad.setCredits(rs.getInt(19));
                list.add(ad);

            }
            return list;

        } catch (Exception e) {
            System.out.println(e);

            return null;
        }

    }

    ArrayList<Student> viewSoePostDsc(int a) {
        try {
            ArrayList<Student> list = new ArrayList<Student>();
            con = (Connection) DriverManager.getConnection(url, username, password);
            String query = "SELECT * FROM soePostIntake WHERE AcademicYear = ? ORDER BY gpa DESC";
            pst = (com.mysql.jdbc.PreparedStatement) con.prepareStatement(query);
            pst.setInt(1, a);
            rs = pst.executeQuery();

            while (rs.next()) {
                Student ad = new Student();
                ad.setId(rs.getInt(1));
                ad.setName(rs.getString(2));
                ad.setEmail(rs.getString(3));
                ad.setDob(rs.getString(4));
                ad.setAddress(rs.getString(5));
                ad.setCno(rs.getString(6));
                ad.setIntake(rs.getString(7));
                ad.setYear(rs.getInt(8));
                ad.setAcademicYear(rs.getInt(9));
                ad.setStream(rs.getString(10));
                ad.setzScore(rs.getString(11));
                ad.setRank(rs.getString(12));
                ad.setQualification(rs.getString(13));
                ad.setInstitution(rs.getString(14));
                ad.setGraYear(rs.getString(15));
                ad.setPic(rs.getBytes(16));
                ad.setGender(rs.getString(17));
                ad.setGp(rs.getDouble(18));
                ad.setCredits(rs.getInt(19));
                list.add(ad);

            }
            return list;

        } catch (Exception e) {
            System.out.println(e);

            return null;
        }

    }
    
    public boolean updateSoePostProfile(Student a) {
        try {
            con = (Connection) DriverManager.getConnection(url, username, password);
            String query = "UPDATE soePostIntake SET FullName = ?, Email = ?, Dob = ?, Address = ? , ContactNo = ?, Stream = ? , Zscore= ? , Rank= ?, Gender = ?, Qualification=? , Institution=? , GraYear=? WHERE StudentID= ?";
            pst = (com.mysql.jdbc.PreparedStatement) con.prepareStatement(query);
            pst.setString(1, a.getName());
            pst.setString(2, a.getEmail());
            pst.setString(3, a.getDob());
            pst.setString(4, a.getAddress());
            pst.setString(5, a.getCno());
            pst.setString(6, a.getStream());
            pst.setString(7, a.getzScore());
            pst.setString(8, a.getRank());
            pst.setString(9, a.getGender());
            pst.setString(10, a.getQualification());
            pst.setString(11, a.getInstitution());
            pst.setString(12, a.getGraYear());
            pst.setInt(13, a.getId());

            pst.executeUpdate();
            return true;

        } catch (Exception e) {
            System.err.println(e);
            return false;

        }
    }

    public boolean updateSoePostSemOneName(Student a) {
        try {
            con = (Connection) DriverManager.getConnection(url, username, password);
            String query = "UPDATE soePostSemOne SET FullName = ? WHERE StudentID= ?";
            pst = (com.mysql.jdbc.PreparedStatement) con.prepareStatement(query);
            pst.setString(1, a.getName());
            pst.setInt(2, a.getId());

            pst.executeUpdate();
            return true;

        } catch (Exception e) {
            System.err.println(e);
            return false;

        }
    }

    public boolean updateSoePostSemTwoName(Student a) {
        try {
            con = (Connection) DriverManager.getConnection(url, username, password);
            String query = "UPDATE soePostSemTwo SET FullName = ? WHERE StudentID= ?";
            pst = (com.mysql.jdbc.PreparedStatement) con.prepareStatement(query);
            pst.setString(1, a.getName());
            pst.setInt(2, a.getId());

            pst.executeUpdate();
            return true;

        } catch (Exception e) {
            System.err.println(e);
            return false;

        }
    }

    ArrayList<Payment> viewSobPayment() {
        try {
            ArrayList<Payment> list = new ArrayList<Payment>();
            con = (Connection) DriverManager.getConnection(url, username, password);
            String query = "SELECT * FROM sobPayment";
            pst = (com.mysql.jdbc.PreparedStatement) con.prepareStatement(query);
            rs = pst.executeQuery();

            while (rs.next()) {
                Payment ad = new Payment();
                ad.setId(rs.getInt(1));
                ad.setName(rs.getString(2));
                ad.setAcademicYear(rs.getInt(3));
                ad.setSemester(rs.getString(4));
                ad.setPay(rs.getDouble(5));
                list.add(ad);

            }
            return list;

        } catch (Exception e) {
            System.out.println(e);

            return null;
        }

    }
    ArrayList<Payment> viewSobPaymentFilter(int a) {
        try {
            ArrayList<Payment> list = new ArrayList<Payment>();
            con = (Connection) DriverManager.getConnection(url, username, password);
            String query = "SELECT * FROM sobPayment WHERE StudentID=?";
            pst = (com.mysql.jdbc.PreparedStatement) con.prepareStatement(query);
            pst.setInt(1,a);
            rs = pst.executeQuery();

            while (rs.next()) {
                Payment ad = new Payment();
                ad.setId(rs.getInt(1));
                ad.setName(rs.getString(2));
                ad.setAcademicYear(rs.getInt(3));
                ad.setSemester(rs.getString(4));
                ad.setPay(rs.getDouble(5));
                list.add(ad);

            }
            return list;

        } catch (Exception e) {
            System.out.println(e);

            return null;
        }

    }
    boolean sobPayments(Payment a) {
        try {
            con = (Connection) DriverManager.getConnection(url, username, password);
            String query = "INSERT INTO sobPayment values (?,?,?,?,?)";
            pst = (PreparedStatement) con.prepareStatement(query);

            pst.setInt(1, a.getId());
            pst.setString(2, a.getName());
            pst.setInt(3, a.getAcademicYear());
            pst.setString(4, a.getSemester());
            pst.setDouble(5, a.getPay());
            
            pst.executeUpdate();

            return true;
        } catch (Exception e) {
            System.err.println(e);
            return false;

        }
    }



}
