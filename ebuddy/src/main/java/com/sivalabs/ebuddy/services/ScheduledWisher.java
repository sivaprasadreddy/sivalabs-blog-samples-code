/**
 * 
 */
package com.sivalabs.ebuddy.services;

import java.util.Date;
import java.util.Random;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import com.sivalabs.ebuddy.email.Email;
import com.sivalabs.ebuddy.email.EmailService;

/**
 * @author skatam
 *
 */
@Service
public class ScheduledWisher 
{
	private static Logger logger = LoggerFactory.getLogger(ScheduledWisher.class);
	@Autowired
	private EmailService emailService;
	
	@Scheduled(cron="0 0 * * * *")
	public void emailTime() 
	{
		try 
		{
			String content = "Hello Siva, Now the Time is :"+new Date();
			Email email = new Email();
			email.setFrom("sivaprasadreddy.k@sivalabs.in");
			email.setTo("sivalabs.blogspot@gmail.com");
			// email.setCc("sivaprasadreddy.k@gmail.com");
			email.setSubject("Hello From EBuddy");
			email.setText(content);
			emailService.sendEmail(email);
			logger.info("Sent Successfully.");
		} 
		catch (Exception e) 
		{
			logger.error("Error while wishing the Admin.", e);
		}

	}
	/*
	//@Scheduled(cron="0 0 * * * *")
	public void sayHello() 
	{
		try {
			String imgPrefix = "wed_annv";
		    String imgName = imgPrefix+new Random().nextInt(7)+".jpg";
			
		String content = "<img alt=\"Happy Wedding Anniversary\" src=\"http://ebuddy.cloudfoundry.com/resources/images/"+imgName+"\">";
		//content += "<br>Now the Time is :"+new Date();
		content += "<br>From: http://ebuddy.cloudfoundry.com";
		logger.debug("Email Content: "+content);
		Email email = new Email();
		email.setFrom("sivalabs.admin@sivalabs.in");
		email.setTo("sivaprasadreddy.k@gmail.com");
		//email.setCc("sivaprasadreddy.k@gmail.com");
		email.setSubject("Congratulations!!!");
		email.setText(content);
		
		byte[] data = null;
			ClassPathResource img = new ClassPathResource(imgName);
		    InputStream inputStream = img.getInputStream();
		    data = new byte[inputStream.available()];
		    while((inputStream.read(data)!=-1));
		    Attachment attachment = new Attachment(data, "HappyWeddingAnniversary","image/jpg", true);
		   // email.addAttachment(attachment);
		    logger.debug("Sending Wedding Anniversary Email."+new Date());
			emailService.sendEmail(email );
			logger.info("Sent Successfully.");
		} catch (Exception e) {
			logger.error("Error while wishing the Admin.",e);
		}
	}
	*/
	public static void main(String[] args) {
		Random random = new Random();
		for (int i = 0; i < 10; i++) {
			System.out.println(random.nextInt(8));
		}
	}
}
