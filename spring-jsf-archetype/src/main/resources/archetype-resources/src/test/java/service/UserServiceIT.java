#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.service;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import ${package}.entities.User;

//@SpringJUnit4TestConfig
public class UserServiceIT extends BaseIT
{

	@Autowired
	private UserService userService;
	
	@Test
	public void testCreateUser() {
		User user = new User();
		user.setUserName("guest");
		user.setPassword("secret");
		user.setEmailId("guest@gmail.com");

		userService.createUser(user);
		assertNotNull(user.getUserId());
	}

	@Test
	public void testUserLogin() {
		User user = userService.login("admin", "admin");
		assertNotNull(user);
		user = userService.login("admin1", "admin1");
		assertNull(user);
	}

	@Test
	public void testGetUserById() {
		User user = userService.getUserById(1L);
		assertNotNull(user);
	}

	@Test
	public void testGetUserByName() {
		User user = userService.getUserByName("admin");
		assertNotNull(user);
	}

	@Test
	public void testGetUserByEmail() {
		User user = userService.getUserByEmail("admin@gmail.com");
		assertNotNull(user);
	}

}
