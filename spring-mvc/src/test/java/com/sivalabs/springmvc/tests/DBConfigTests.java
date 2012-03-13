package com.sivalabs.springmvc.tests;

import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.sivalabs.springmvc.entities.User;
import com.sivalabs.springmvc.services.UserService;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="classpath:spring/applicationContext.xml")
@ActiveProfiles("dev")
public class DBConfigTests 
{
	@Autowired ApplicationContext applicationContext;
	@Autowired UserService userService;
	
	@BeforeClass
	public static void init() 
	{
		
	}
	
	@AfterClass
	public static void destroy() 
	{
		
	}
	
	@Test
	public void verifyDBProperties()
	{
		User user1 = new User(null, "Siva", "Katamreddy","sivaprasadreddy.k@gmail.com", null);
		Integer user1Id  = userService.createUser(user1);
		assertNotNull(user1Id);
		User user2 = new User(null, "Prasad", "Katamreddy","sivaprasadreddy.k@gmail.com", null);
		Integer user2Id  = userService.createUser(user2);
		assertNotNull(user2Id);
		List<User> users = userService.findAllUsers();
		assertNotNull(users);
		for (User user : users) 
		{
			System.out.println(user);
		}
	}
	
	public static void main(String[] args) 
	{

	}

}
