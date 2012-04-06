/**
 * 
 */
package com.sivalabs.ebuddy.email;

import java.util.List;

import javax.activation.DataSource;
import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import javax.mail.util.ByteArrayDataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

@Service
public class EmailService 
{
	private static Logger logger = LoggerFactory.getLogger(EmailService.class);
	
	private JavaMailSenderImpl mailSender = null;

	@Autowired
	public void setMailSender(JavaMailSenderImpl mailSender) {
		this.mailSender = mailSender;
	}

	public void sendEmail(Email email) 
	{
		try {
			MimeMessage mimeMessage = mailSender.createMimeMessage();
			// use the true flag to indicate you need a multipart message
			boolean hasAttachments = (email.getAttachments() != null && email
					.getAttachments().size() > 0);
			MimeMessageHelper helper = new MimeMessageHelper(mimeMessage,
					hasAttachments);
			helper.setTo(email.getTo());
			helper.setFrom(email.getFrom());
			helper.setSubject(email.getSubject());
			helper.setText(email.getText(), true);

			List<Attachment> attachments = email.getAttachments();
			if (attachments != null && attachments.size() > 0) 
			{
				for (Attachment attachment : attachments) 
				{
					String filename = attachment.getFilename();
					DataSource dataSource = new ByteArrayDataSource(attachment.getData(), attachment.getMimeType());
					if (attachment.isInline()) 
					{
						helper.addInline(filename, dataSource);
					} else 
					{
						helper.addAttachment(filename, dataSource);
					}
				}
			}

			mailSender.send(mimeMessage);
		} catch (MailException e) {
			logger.error("Error while sending Email.",e);
		} catch (MessagingException e) {
			logger.error("Error while sending Email.",e);
		}
	}
}
