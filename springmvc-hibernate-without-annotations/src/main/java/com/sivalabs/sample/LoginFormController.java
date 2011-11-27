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
public class LoginFormController extends SimpleFormController
{
	private HibernateUserDAO userDAO;
	public void setHibernateUserDAO(HibernateUserDAO userDAO)
	{
		this.userDAO = userDAO;
	}
	
	public LoginFormController()
	{
		setCommandClass(User.class);
		setCommandName("login");
	}
	
	@Override
	protected Object formBackingObject(HttpServletRequest request)
			throws Exception
	{
		User user = new User();
		user.setUserId("test");
		return user;
	}
	
	@Override
	protected ModelAndView onSubmit(HttpServletRequest request,
			HttpServletResponse response, Object command, BindException errors)
			throws Exception
	{
		
		User loginBean = (User) command;
		ModelAndView mav = new ModelAndView();
		String view = "login";
		String userId = loginBean.getUserId();
		String password = loginBean.getPassword();
		
		//if("admin".equals(username) && "admin".equals(password))
		User user = userDAO.login(userId, password);
		if(user != null)
		{
			logger.info("User authenticated successfully");
			request.getSession().setAttribute("LOGGEDIN_USER", user);
			view = "redirect:showUsers.htm";
		}else {
			logger.error("User authentication failed");
			request.setAttribute("ERROR", "Invalid Username and Password");
			mav.addObject("login", loginBean);
		}
		mav.setViewName(view);
		return mav;
	}
}
