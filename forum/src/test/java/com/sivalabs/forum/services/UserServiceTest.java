package com.sivalabs.forum.services;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.sivalabs.forum.entities.User;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:applicationContext.xml"})
public class UserServiceTest
{
	@Autowired
	private UserService userService;
	
	@Test
	public void findAllUsers()
	{
		List<User> users = userService.findAllUsers();
		for (User user : users) {
			System.err.println(user);
		}
	}

}
