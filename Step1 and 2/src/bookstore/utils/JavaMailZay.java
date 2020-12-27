/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bookstore.utils;

import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 *
 * @author Mehdi
 */
public class JavaMailZay {
    
    public static void mailSending(String recepient) throws MessagingException {
    
    System.out.println("Envoie du mail en preparation");
    Properties pro = new Properties();
    
    pro.put("mail.smtp.auth","true");
    pro.put("mail.smtp.starttls.enable","true");
    pro.put("mail.smtp.host","smtp.google.com");
    pro.put("mail.smtp.port","157");
    
    String myAccount = "bookstore.annonce@gmail.com";
    String myPassword = "bookstore.bookstore";
    
    Session s = Session.getInstance(pro, new Authenticator() {
        @Override
        protected PasswordAuthentication getPasswordAuthentication() {
        return new PasswordAuthentication(myAccount, myPassword); }
       });
    
    Message message = prepareMessage(s,myAccount,recepient);
    
    Transport.send(message);
    }

    private static Message prepareMessage(Session s, String myAccount, String recepient) {
        try {
            Message message = new MimeMessage(s);
            message.setFrom(new InternetAddress(myAccount));
            message.setRecipient(Message.RecipientType.TO,new InternetAddress(recepient));
            message.setSubject("Une nouvelle annonces de livres occasion a été ajouté !");
            message.setText("Cher Client, nous vous informons qu'une nouvelle annonce de livres a été ajoutée sur notre site."
                             + " Soyez les bienvenus et merci pour votre intéret."
                             + "Cordialement,"
                             + "de la part de toute l'equipe L'art de lire.");
            return message;
        } catch (Exception ex) {
            Logger.getLogger(JavaMailZay.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
}
