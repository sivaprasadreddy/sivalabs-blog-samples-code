package com.sivalabs.forum.services;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.sivalabs.forum.entities.Category;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:applicationContext.xml"})
public class ForumServiceTest
{
	@Autowired private UserService userService;
	@Autowired private ForumService forumService;
	
	@Test
	public void findAllCategories()
	{
		List<Category> categories = forumService.findAllCategories();
		for (Category category : categories) {
			System.err.println(category);
		}
	}

}
