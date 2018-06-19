/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package courseenrolment;

/**
 *
 * @author wathsara
 */
import java.util.Properties;
import javax.mail.*;
import javax.mail.internet.*;


public class SendEmail {

    boolean send(String stdemail,String s1,String s2,String s3,String s4,String s5,String s6,String g1,String g2,String g3,String g4,String g5,String g6) {
        String host = "smtp.gmail.com";
        final String user = "nsbmgreenuniversitymailcenter@gmail.com";//change accordingly  
        final String password = "nsbm@123";//change accordingly  

        String to = stdemail;//change accordingly  
        String emailbody= "Hello Students This is Your Marks For the Last Written Examination\n\n"+s1+"\t\t"+g1+"\n"+s2+"\t\t"+g2+"\n"+s3+"\t\t"+g3+"\n"+s4+"\t\t"+g4+"\n"+s5+"\t\t"+g5+"\n"+s6+"\t\t"+g6+"\n\n\nThank you.\n NSBM Green Univesity";
        //Get the session object  
        Properties props = new Properties();
        props.put("mail.smtp.host", host);
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.socketFactory.port", "465");
        props.put("mail.smtp.socketFactory.class","javax.net.ssl.SSLSocketFactory");

        Session session = Session.getDefaultInstance(props,
                new javax.mail.Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(user, password);
            }
        });

        //Compose the message  
        try {
            MimeMessage message = new MimeMessage(session);
            message.setFrom(new InternetAddress(user));
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
            message.setSubject("Examination Marks");
            message.setText(emailbody);

            //send the message  
            Transport.send(message);

            System.out.println("message sent successfully...");
            return true;
        } catch (MessagingException e) {
            e.printStackTrace();
            return false;

        }

    }
    
    boolean paymentmail(String name, String ayear, String semester,String email,String s,String s1,String s2,String s3,String s4,String sf,String sf1,String sf2,String sf3,String sf4,String t){
        String host = "smtp.gmail.com";
        final String user = "nsbmgreenuniversity692@gmail.com";//change accordingly  
        final String password = "nsbm@123";//change accordingly  

        String to = email;//change accordingly  
        String emailbody= "Hello "+name+" This Email Attaches Your Payment Details For the "+ayear+"st Year "+semester+".\n\n"+s+"\t"+sf+"/=\n"+s1+"\t"+sf1+"/=\n"+s2+"\t"+sf2+"/=\n"+s3+"\t"+sf3+"/=\n"+s4+"\t"+sf4+"/=\nTotal Charge \t"+t+"/=\n\n\nThank you.\n NSBM Green Univesity.";
        //Get the session object  
        Properties props = new Properties();
        props.put("mail.smtp.host", host);
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");

        Session session = Session.getDefaultInstance(props,
                new javax.mail.Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(user, password);
            }
        });

        //Compose the message  
        try {
            MimeMessage message = new MimeMessage(session);
            message.setFrom(new InternetAddress(user));
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
            message.setSubject("Payment Details");
            message.setText(emailbody);

            //send the message  
            Transport.send(message);

            System.out.println("message sent successfully...");
            return true;
        } catch (MessagingException e) {
            e.printStackTrace();
            return false;

        }
        
    }
}
