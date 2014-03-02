/**
 * 
 */
package com.sivalabs.springdatarest.config;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.sivalabs.springdatarest.entities.Role;
import com.sivalabs.springdatarest.entities.User;
import com.sivalabs.springdatarest.services.UserService;

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

		logger.info("Initializing Database with sample data");
		
		Role role1 = new Role("ROLE_USER");
		Role role2 = new Role("ROLE_ADMIN");
		
		User user1 = new User(1, "admin", "admin", "Administrator", "admin@gmail.com");
		User user2 = new User(2, "siva", "siva", "Siva", "sivaprasadreddy.k@gmail.com");
		
		user1.addRoles(role1, role2);
		user2.addRoles(role1);
		
		userService.createUser(user1);
		userService.createUser(user2);
		
		

	}
}
