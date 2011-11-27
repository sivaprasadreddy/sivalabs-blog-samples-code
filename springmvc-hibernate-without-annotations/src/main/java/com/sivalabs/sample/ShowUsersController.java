package com.sivalabs.sample;

import java.util.Collection;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

public class ShowUsersController extends AbstractController
{
	private static final long serialVersionUID = 1L;
	
	private HibernateUserDAO userDAO;
	public void setHibernateUserDAO(HibernateUserDAO userDAO)
	{
		this.userDAO = userDAO;
	}
	
	@SuppressWarnings("unchecked")
	public ModelAndView handleRequestInternal(HttpServletRequest req,
			HttpServletResponse res)
	{
		ModelAndView mav = new ModelAndView("showUsers");
		String name = req.getParameter("name");
		Collection<User> users = this.userDAO.searchUsers(name);
		mav.getModel().put("USERS_KEY", users);
		return mav;
	}
	
}
