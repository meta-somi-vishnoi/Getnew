package com.metacube.training.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailService {

    private JavaMailSender javaMailSender;

    @Autowired
    public EmailService(JavaMailSender javaMailSender) {
        this.javaMailSender = javaMailSender;
    }

    public void sendEmail(String email, String password) {

        SimpleMailMessage mail = new SimpleMailMessage();
        mail.setTo("somi123vishnoi@gmail.com");
        mail.setSubject("FORGET PASSWORD");
        mail.setText("Hello " + email + " " + " your Password is : " + password);
        javaMailSender.send(mail);
    }
}
