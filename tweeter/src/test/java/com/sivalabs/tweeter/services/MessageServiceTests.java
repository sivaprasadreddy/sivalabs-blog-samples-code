/**
 * 
 */
package com.sivalabs.tweeter.services;

import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.sivalabs.tweeter.config.AppConfig;
import com.sivalabs.tweeter.entities.Message;
import com.sivalabs.tweeter.entities.User;

/**
 * @author Siva
 * 
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { AppConfig.class })
public class MessageServiceTests
{
	@Autowired
	UserService userService;
	@Autowired
	MessageService messageService;

	@Test
	public void testGetAllMessages()
	{
		List<Message> messages = messageService.getAllMessages();
		System.err.println(messages);
	}

	@Test
	public void testGetAllMessagesSize()
	{
		List<Message> messages = messageService.getAllMessages(5);
		System.err.println(messages);
	}

	@Test
	public void testCreateMessage()
	{
		Message msg = new Message(0, "Test Msg posted on " + new Date(), new User(1));
		messageService.createMessage(msg);
	}
}
