package com.example.Gestion.des.taches.project.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.example.Gestion.des.taches.project.model.User;

@Service
public class NotificationService {
	
	private JavaMailSender javaMailSender ;
	
	
	
	@Autowired
	public NotificationService(JavaMailSender javaMailSender) {
		this.javaMailSender = javaMailSender ;
	}
	
	public void sendNotification(User user) throws MailException {
		
		//send email
		SimpleMailMessage smm = new SimpleMailMessage();
		smm.setTo(user.getEmail());
		smm.setFrom("artdelire123@gmail.com");
		smm.setSubject("Welcome !");
		smm.setText("M/MRS " +user.getName()+ " " +user.getLast_name()+ " Bienvenue sur notre Dashboard "     );
		
		javaMailSender.send(smm);
	}

}
