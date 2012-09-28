#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
/**
 * 
 */
package ${package}.boot;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import ${package}.entities.User;
import ${package}.service.UserService;

/**
 * @author Siva
 *
 */
@Component
public class DBInitializer
{
	private static Logger logger = LoggerFactory.getLogger(DBInitializer.class);
	
	@Value("${symbol_dollar}{InitDB}")
	private boolean executeDBInitScript;
	
	@Autowired
	private UserService userService;
	
	@PostConstruct
	void init()
	{
		if(!executeDBInitScript){
			return;
		}
		User admin = new User();
		admin.setUserName("admin");
		admin.setPassword("admin");
		admin.setEmailId("admin@gmail.com");
		
		createUserQuietly(admin);
		
		User test = new User();
		test.setUserName("test");
		test.setPassword("test");
		test.setEmailId("test@gmail.com");
		
		createUserQuietly(test);
		
	}
	
	private void createUserQuietly(User user){
		try
		{
			userService.createUser(user);
		} catch (Exception e)
		{
			logger.error(e.getMessage());
		}
	}
	
}
