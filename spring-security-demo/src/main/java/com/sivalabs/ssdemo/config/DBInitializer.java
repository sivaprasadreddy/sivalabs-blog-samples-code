/**
 * 
 */
package com.sivalabs.ssdemo.config;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.sivalabs.ssdemo.entities.Message;
import com.sivalabs.ssdemo.entities.Role;
import com.sivalabs.ssdemo.entities.User;
import com.sivalabs.ssdemo.services.MessageService;
import com.sivalabs.ssdemo.services.UserService;

/**
 * @author Siva
 * 
 */
@Component
public class DBInitializer
{
	private static Logger logger = LoggerFactory.getLogger(DBInitializer.class);

	@Autowired
	private UserService userService;
	@Autowired
	private MessageService messageService;

	@Value("${init-db:false}")
	private String initDatabase;

	@PostConstruct
	public void init()
	{
		try {
			logger.info("############## InitDatabase :" + initDatabase + " ########################");
			if (Boolean.parseBoolean(initDatabase)) {
				initDatabase();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	void initDatabase()
	{

		logger.info("Initializing Database with sample data");
		
		Role role1 = new Role("ROLE_USER");
		Role role2 = new Role("ROLE_ADMIN");
		
		User user1 = new User(1, "admin", "admin", "Administrator", "admin@gmail.com");
		User user2 = new User(2, "siva", "siva", "Siva", "sivaprasadreddy.k@gmail.com");
		
		user1.addRoles(role1, role2);
		user2.addRoles(role1);
		
		userService.createUser(user1);
		userService.createUser(user2);
		
		Message m1 = new Message(0, "Message 1", user1);
		Message m2 = new Message(0, "Message 2", user1);
		Message m3 = new Message(0, "Message 3", user2);

		messageService.createMessage(m1);
		messageService.createMessage(m2);
		messageService.createMessage(m3);

	}
}
