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
public class EditUserFormController extends SimpleFormController
{
	private HibernateUserDAO userDAO;
	public void setHibernateUserDAO(HibernateUserDAO userDAO)
	{
		this.userDAO = userDAO;
	}
	
	public EditUserFormController()
	{
		//User user = new User();
		setCommandClass(User.class);
		setCommandName("editUser");
	}
	
	@Override
	protected Object formBackingObject(HttpServletRequest request)
			throws Exception
	{
		Integer id = Integer.parseInt(request.getParameter("id"));
		User user = this.userDAO.getUserById(id);		
		return user;
	}
	
	@Override
	protected ModelAndView onSubmit(HttpServletRequest request,
			HttpServletResponse response, Object command, BindException errors)
			throws Exception
	{
		ModelAndView mav = new ModelAndView("redirect:showUsers.htm");
		User user = (User) command;
		this.userDAO.update(user);
		return mav;
	}
}
