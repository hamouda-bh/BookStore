package bookstore.utils;


import bookstore.entities.Facture;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.activation.DataHandler;
import javax.activation.FileDataSource;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Dimassi Abdelhak
 */
public class JavamailUtil {
    public static void sendMail(String recepient) throws Exception{
        System.out.println("Preparing to send:");
        Properties properties = new Properties();
        
        
        String myAccountEmail ="a@mail.com";
        String password ="mdp";
        
        properties.put("com.hof.email.starttime","20170519094544");
        properties.put("mail.smtp.auth","true");
        properties.put("mail.smtp.connectiontimeout","60000");
        properties.put("mail.smtp.host","smtp.gmail.com");
        properties.put("mail.smtp.port","25");
        properties.put("mail.smtp.ssl.trust","*");
        properties.put("mail.smtp.starttls.enable","true");
        properties.put("mail.smtp.timeout","60000");
        properties.put("mail.transport.protocol","smtp");
        
        
        
        Session session = Session.getInstance(properties, new Authenticator(){
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(myAccountEmail, password);
            }
        });
        
        Message message = prepareMessage(session,myAccountEmail,recepient);
        
        Transport.send(message);
        System.out.println("message send successfully");
    }
    
    /*private static Message prepareMessage(Session session, String myAccountEmail,String recepient){
        try {
    //        FileDataSource f= new FileDataSource("C:/BookStore/facture.pdf");
                    System.out.println("found ");

            Message message = new MimeMessage(session);
            System.out.println("mime messagge 1 ");
            message.setFrom(new InternetAddress(myAccountEmail));
            message.setRecipient(Message.RecipientType.TO, new InternetAddress(recepient));
            message.setSubject("ma facture");
            System.out.println("subject name c bon ");
          //  message.setDataHandler(new DataHandler(f));
                        System.out.println("handler jawou mriguek");
            message.setText("ma facture");

          //  message.setFileName(f.getName());
                        System.out.println("file name c bon ");

            return message;

        } catch (MessagingException ex) {
            Logger.getLogger(JavamailUtil.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }*/
    
    private static Message prepareMessage(Session session, String myAccountEmail,String recepient){
        try {
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(myAccountEmail));
            message.setRecipient(Message.RecipientType.TO, new InternetAddress(recepient));
            message.setSubject("Ma facture");
            message.setText("Cher client, vous trouverez ci joint votre facture,");
             FileDataSource fichier_joint = new FileDataSource("c:/BookStore/facture.pdf");
             message.setDataHandler(new DataHandler(fichier_joint));
             message.setFileName(fichier_joint.getName());
            return message;
        } catch (MessagingException ex) {
            Logger.getLogger(JavamailUtil.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
}
