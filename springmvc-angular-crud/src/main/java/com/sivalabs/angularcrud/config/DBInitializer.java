/**
 * 
 */
package com.sivalabs.angularcrud.config;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.sivalabs.angularcrud.entities.Contact;
import com.sivalabs.angularcrud.entities.Role;
import com.sivalabs.angularcrud.entities.User;
import com.sivalabs.angularcrud.services.UserService;

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

		initDBWithServices();

	}
	
	void initDBWithSqlScript()
	{
		
	}
	
	void initDBWithServices()
	{
		logger.info("Initializing Database with sample data");
		
		Role role1 = new Role("ROLE_USER");
		Role role2 = new Role("ROLE_ADMIN");
		
		User user1 = new User(1, "admin@gmail.com", "admin", "Administrator");
		User user2 = new User(2, "siva@gmail.com", "siva", "Siva");
		
		user1.addRoles(role1, role2);
		user2.addRoles(role1);
		
		Contact contact1 = new Contact(null, "abcd@gmail.com", "Abcd", null, null, user2);
		Contact contact2 = new Contact(null, "xyz@gmail.com", "Xyz", null, null, user2);
		user2.addContacts(contact1, contact2);
		
		userService.createUser(user1);
		userService.createUser(user2);
		
		
	}
	
}
