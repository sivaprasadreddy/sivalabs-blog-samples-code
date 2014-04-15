/**
 * 
 */
package com.sivalabs.phonebook.config;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.sivalabs.phonebook.entities.Contact;
import com.sivalabs.phonebook.entities.User;
import com.sivalabs.phonebook.services.PhoneBookService;
import com.sivalabs.phonebook.services.UserService;

/**
 * @author Siva
 * 
 */
@Component
public class DBInitializer
{
	private static Logger logger = LoggerFactory.getLogger(DBInitializer.class);

	@Autowired private UserService userService;
	@Autowired private PhoneBookService phoneBookService;
	
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
		
		
		User user1 = new User(null, "admin@gmail.com", "admin", "Administrator");
		User user2 = new User(null, "siva@gmail.com", "siva", "Siva");
		
		user1 = userService.createUser(user1);
		user2 = userService.createUser(user2);
		
		Contact c1 = new Contact();
		c1.setName("Ramu");
		c1.setEmail("ramu@gmail.com");
		c1.setMobile("9874568584");
		c1.setUser(user1);
		
		Contact c2 = new Contact();
		c2.setName("Suman");
		c2.setEmail("suman@gmail.com");
		c2.setMobile("965852222");
		c2.setUser(user1);
		
		Contact c3 = new Contact();
		c3.setName("Anil");
		c3.setEmail("anil@gmail.com");
		c3.setMobile("966666666");
		c3.setUser(user2);
		
		phoneBookService.createContact(user1.getId(), c1);
		phoneBookService.createContact(user1.getId(), c2);
		phoneBookService.createContact(user2.getId(), c3);
		
	}
}
