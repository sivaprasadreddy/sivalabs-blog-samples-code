/**
 * 
 */
package sivalabs.dashboard.config;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import sivalabs.dashboard.entities.Role;
import sivalabs.dashboard.entities.User;
import sivalabs.dashboard.repositories.RoleRepository;
import sivalabs.dashboard.repositories.UserRepository;
import sivalabs.dashboard.services.UserService;

/**
 * @author Siva
 * 
 */
@Component
public class DBInitializer
{
	private static Logger logger = LoggerFactory.getLogger(DBInitializer.class);

	@Autowired private UserRepository userRepository;
	@Autowired private RoleRepository roleRepository;
	
	@Autowired private UserService userService;
	
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
		
		role1 = roleRepository.save(role1);
		role2 = roleRepository.save(role2);
		
		User user1 = new User(1, "admin@gmail.com", "admin", "Administrator");
		User user2 = new User(2, "siva@gmail.com", "siva", "Siva");
		
		user1.addRoles(role1, role2);
		user2.addRoles(role1);
		
		role1.getUsers().add(user1);
		role1.getUsers().add(user2);
		
		role2.getUsers().add(user2);
		
		user1 = userRepository.save(user1);
		user2 = userRepository.save(user2);
		
		
	}
}
