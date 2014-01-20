/**
 * 
 */
package com.sivalabs.bo;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.sivalabs.config.AppConfig;
import com.sivalabs.domain.User;

/**
 * @author Siva
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes={AppConfig.class})
public class UserBOIT 
{
	@Autowired
	private UserBO userBO;
	
	@Test
	public void findAllUsers()  {
		List<User> users = userBO.findAllUsers();
		assertNotNull(users);
		System.err.println(users);
	}
}
