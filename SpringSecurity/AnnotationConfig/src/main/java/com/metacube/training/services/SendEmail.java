package com.metacube.training.services;
/*
import java.util.Properties;
import javax.mail.*;
import javax.mail.internet.*;
import java.sql.*;
import javax.sql.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class SendEmail {
  private Connection con = null;

  protected String username;

  public static void emailPassword(String email, String password) {
    String host = "mail";
    String from = "somi123@gmail.com";

    Properties props = System.getProperties();

    props.put("mail.smtp.host", host);
    Session session = Session.getDefaultInstance(props, null);
    MimeMessage message = new MimeMessage(session);

    try {
      message.setFrom(new InternetAddress(from));
      message.addRecipient(Message.RecipientType.TO, new InternetAddress(email));
      message.setSubject("Password Reminder");
      message.setText("Hi " + email + ",\nYour password is: " + password + "\nregards - "
          + from);
      Transport.send(message);
    } catch (Exception ae) {
    } 
  }
}*/

import java.util.*;
import javax.mail.*;
import javax.mail.internet.*;
import javax.activation.*;

public class SendEmail {

   public static void SendEmail(String email, String password) {    
      // Recipient's email ID needs to be mentioned.
      String to = email;

      // Sender's email ID needs to be mentioned
      String from = email;

      // Assuming you are sending email from localhost
  //    String host = "localhost";

      // Get system properties
      Properties properties = System.getProperties();

      // Setup mail server
      properties.setProperty("mail.smtp.host", "127.0.0.1");

      // Get the default Session object.
      Session session = Session.getDefaultInstance(properties);

      try {
         // Create a default MimeMessage object.
         MimeMessage message = new MimeMessage(session);

         // Set From: header field of the header.
         message.setFrom(new InternetAddress(from));

         // Set To: header field of the header.
         message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));

         // Set Subject: header field
         message.setSubject("Password Reset!");

         // Now set the actual message
         message.setText("The new password for username " + email + " is " + password);

         // Send message
         Transport.send(message);
         System.out.println("Sent message successfully....");
      } catch (MessagingException mex) {
         mex.printStackTrace();
      }
   }
}
