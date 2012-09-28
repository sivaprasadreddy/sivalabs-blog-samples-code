#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
/**
 * 
 */
package ${package}.service;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import ${package}.entities.User;

/**
 * @author siva
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="classpath:spring/applicationContext.xml")
@ActiveProfiles("test")
public class UserServiceTest {

	@Autowired
	private UserService userService;
	
	@Test
	public void testUserLogin() {
		User user = userService.login("admin", "admin");
		Assert.assertNotNull(user);
		user = userService.login("admin1", "admin1");
		Assert.assertNull(user);
	}
	
	
}
