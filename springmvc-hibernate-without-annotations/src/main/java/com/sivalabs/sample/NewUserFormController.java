/**
 * 
 */
package com.sivalabs.sample;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.validation.BindException;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.SimpleFormController;

/**
 * @author skatam
 *
 */
public class NewUserFormController extends SimpleFormController
{
	private HibernateUserDAO userDAO;
	public void setHibernateUserDAO(HibernateUserDAO userDAO)
	{
		this.userDAO = userDAO;
	}
	
	public NewUserFormController()
	{
		setCommandClass(User.class);
		setCommandName("newUser");
	}
	
	@Override
	protected Object formBackingObject(HttpServletRequest request)
			throws Exception
	{
		User user = new User();
		return user;
	}
	@Override
	protected ModelAndView onSubmit(HttpServletRequest request,
			HttpServletResponse response, Object command, BindException errors)
			throws Exception
	{
		User user = (User) command;
		ModelAndView mav = new ModelAndView("redirect:showUsers.htm");
		this.userDAO.create(user);
		return mav;
	}
}
