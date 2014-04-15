package com.sivalabs.forum.web.controllers;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;

import com.sivalabs.forum.entities.User;
import com.sivalabs.forum.services.ForumService;
import com.sivalabs.forum.services.UserService;

/**
 * @author Siva
 * 
 */
public abstract class BaseController
{
	@Autowired ForumService forumService;
	@Autowired UserService userService;
	
	@InitBinder
	private void dateBinder(WebDataBinder binder)
	{
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		CustomDateEditor editor = new CustomDateEditor(dateFormat, true);
		binder.registerCustomEditor(Date.class, editor);
	}
	
	public static User getCurrentUser(HttpSession session) {
		User loginUser = (User) session.getAttribute("LOGIN_USER");
		return loginUser;
	}
	
	public static boolean isLoggedIn(HttpSession session) {
	    return getCurrentUser(session) != null;
	}
	
}
