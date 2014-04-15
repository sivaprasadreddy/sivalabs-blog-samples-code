/**
 * 
 */
package com.sivalabs.angularcrud.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.stereotype.Service;

/**
 * @author Siva
 *
 */
@Service
public class EmailService {

	@Autowired
	private Environment env;
	
	@Autowired
	private JavaMailSenderImpl mailSender;
	
	public void sendMail(String from, String to, String subject, String msg) {
		 
		SimpleMailMessage message = new SimpleMailMessage();
		message.setFrom(from);
		message.setTo(to);
		message.setSubject(subject);
		message.setText(msg);
		mailSender.send(message);	
	}
	
	public void sendMail(String from, String subject, String msg) {
		 
		SimpleMailMessage message = new SimpleMailMessage();
		message.setFrom(env.getProperty("support.email"));
		message.setTo(env.getProperty("support.email"));
		message.setSubject(subject);
		message.setText(msg+"\n\nThanks,\n"+from);
		mailSender.send(message);	
	}
}
