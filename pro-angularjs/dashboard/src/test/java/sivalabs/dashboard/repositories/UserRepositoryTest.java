/**
 * 
 */
package sivalabs.dashboard.repositories;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import sivalabs.dashboard.config.AppConfig;
import sivalabs.dashboard.entities.User;
import sivalabs.dashboard.repositories.UserRepository;

/**
 * @author Siva
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes={AppConfig.class})
public class UserRepositoryTest 
{
	@Autowired
	UserRepository userRepository;
	
	@Test
	public void findAll() {
		List<User> users = userRepository.findAll();
		Assert.assertNotNull(users);
	}
}
