/**
 * 
 */
package com.sivalabs.angularcrud.services;

import java.util.Set;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.sivalabs.angularcrud.config.AppConfig;
import com.sivalabs.angularcrud.entities.Role;
import com.sivalabs.angularcrud.entities.User;

/**
 * @author Siva
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes=AppConfig.class)
public class UserServiceTests 
{
	@Autowired
	private UserService userService;
	
	@Test
	public void testFindUserByEmail() {
		User user = userService.findUserByEmail("admin@gmail.com");
		System.err.println(user);
		Set<Role> roles = user.getRoles();
		System.err.println(roles);
		for (Role role : roles) {
			System.out.println(role);
		}
	}
}
