package com.sivalabs.pmt.services

import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.test.context.ContextConfiguration
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner

import com.sivalabs.pmt.config.AppConfig
import com.sivalabs.pmt.entities.User

/**
 * @author Siva
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes=[AppConfig.class])
class UserServiceTest
{
	@Autowired
	UserService userService;
	
	@Test
	public void findAllUsers() {
		List<User> users = userService.findAllUsers();
		users.each { user ->
			println user
		}	
	}
	
	@Test
	public void findUser() {
		User user = userService.findUser(2)
		println "User[2]: "+user
	}
	
	@Test
	public void loginUser() {
		User user = userService.login("admin","admin")
		println "LoginUser : "+user
	}
	
	@Test
	public void createUser() {
		User user = new User(username:"guest",password:"guest",email:"guest@gmail.com")
		userService.createUser(user)
		println "New User Id: "+user.id
		
	}
	
	@Test
	public void updateUser() {
		User user = new User(username:"siva",password:"siva123")
		userService.updateUser(user)
		println "Updated User: "+user
		
	}
	
	@Test
	public void deleteUser() {
		userService.deleteUser(3)
		println "delete User: ";
		
	}
	
	
}
