package com.sivalabs.sample;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

public class DeleteUserController extends AbstractController
{
	private static final long serialVersionUID = 1L;
	
	private HibernateUserDAO userDAO;
	public void setHibernateUserDAO(HibernateUserDAO userDAO)
	{
		this.userDAO = userDAO;
	}
	
	public ModelAndView handleRequestInternal(HttpServletRequest req,
			HttpServletResponse res)
	{
		int id = Integer.parseInt(req.getParameter("id"));
		ModelAndView mav = new ModelAndView("redirect:showUsers.htm");
		this.userDAO.delete(id);
		return mav;
	}
}
