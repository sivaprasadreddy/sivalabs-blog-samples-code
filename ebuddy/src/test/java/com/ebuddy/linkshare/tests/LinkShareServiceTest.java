/**
 * 
 */
package com.ebuddy.linkshare.tests;

import java.util.Date;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.sivalabs.ebuddy.entities.Link;
import com.sivalabs.ebuddy.entities.User;
import com.sivalabs.ebuddy.services.LinkShareService;

/**
 * @author skatam
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="classpath:spring/applicationContext.xml")
@ActiveProfiles("dev")
public class LinkShareServiceTest 
{
	//private static final Logger LOGGER = LoggerFactory.getLogger(LinkShareServiceTest.class);
	@Autowired private LinkShareService linkShareService;
	
	//@Test
	public void testCreateUser() {
		User user = new User();
		user.setUserName("admin");
		user.setPassword("admin");
		user.setFirstName("Siva");
		user.setEmail("sivaprasad@gmail.com");
	
		Integer userId = this.linkShareService.createUser(user);
		Assert.assertNotNull(userId);
	}
	
	//@Test
	public void addUserLink() {
		Link link1 = new Link();
		link1.setTitle("TheServerSide");
		link1.setUrl("www.theserverside.com");
		link1.setPostedOn(new Date());
		
		Link link2 = new Link();
		link2.setTitle("Twitter");
		link2.setUrl("www.twitter.com");
		link2.setPostedOn(new Date());
		
		this.linkShareService.createUserLinks(1, link1, link2);
	}
	
	@Test
	public void login() {
		User user = this.linkShareService.login("admin1", "admin");
		System.out.println(user);
	}
}
