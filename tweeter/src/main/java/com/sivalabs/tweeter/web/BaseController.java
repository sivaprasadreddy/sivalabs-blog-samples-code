package com.sivalabs.tweeter.web;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpSession;

import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;

import com.sivalabs.tweeter.entities.User;

/**
 * @author Siva
 * 
 */
public abstract class BaseController
{
	@InitBinder
	private void dateBinder(WebDataBinder binder)
	{
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
		CustomDateEditor editor = new CustomDateEditor(dateFormat, true);
		binder.registerCustomEditor(Date.class, editor);
	}

	public void setLoginUser(HttpSession session, User user)
	{
		session.setAttribute("LOGIN_USER", user);
	}

	public User getLoginUser(HttpSession session)
	{
		return (User) session.getAttribute("LOGIN_USER");
	}
}
