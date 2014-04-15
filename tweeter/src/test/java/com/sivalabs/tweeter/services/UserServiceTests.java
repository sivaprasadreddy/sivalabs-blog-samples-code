/**
 * 
 */
package com.sivalabs.tweeter.services;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.sivalabs.tweeter.config.AppConfig;
import com.sivalabs.tweeter.entities.User;

/**
 * @author Siva
 * 
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { AppConfig.class })
public class UserServiceTests
{
	@Autowired
	UserService userService;

	@Test
	public void testFindAllUsers()
	{
		List<User> users = userService.findAllUsers();
		System.err.println(users);
	}

	@Test
	public void testCreateUser()
	{
		User user1 = new User(1, "test", "test", "Test", "test@gmail.com");
		userService.createUser(user1);
	}
}
