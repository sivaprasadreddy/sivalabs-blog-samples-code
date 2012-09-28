#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
/**
 * 
 */
package ${package}.web.controller;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import ${package}.LinkshareException;
import ${package}.entities.User;
import ${package}.service.UserService;
import ${package}.web.FacesUtils;
import ${package}.web.UserContext;


/**
 * @author Siva
 *
 */
@Component
@ManagedBean
@SessionScoped
public class UserController 
{
	
	@Autowired
	private UserService userService;
	
	private User loginUser = null;
	private User registerUser = null;

	public User getLoginUser() {
		if(loginUser == null){
			this.loginUser = new User();
		}
		return loginUser;
	}

	public void setLoginUser(User loginUser) {
		this.loginUser = loginUser;
	}

	public User getRegisterUser() {
		if(registerUser == null){
			this.registerUser = new User();
		}
		return registerUser;
	}

	public void setRegisterUser(User registerUser) {
		this.registerUser = registerUser;
	}
	
	public String login() 
	{
		String view = "login";
		User user = this.userService.login(loginUser.getUserName(), loginUser.getPassword());
		if(user != null){
			this.loginUser = user;
			UserContext userContext = new UserContext();
			userContext.setUser(loginUser);
			FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("USER_CTX_KEY", userContext);
		    view = "home";
		}else{
			FacesUtils.addMessage("Invalid UserName & Password");
		}
		return view;
	}
	
	public String register() 
	{
		String view = "login";
		try {
			this.userService.createUser(registerUser);
			this.registerUser = null;
			FacesUtils.addMessage("User Registration Successful.");
			
			
		} catch (LinkshareException e) {
			FacesUtils.addMessage(e.getMessage());
		}
		catch (Exception e) {
			e.printStackTrace();
			FacesUtils.addMessage("User Registration Failed.");
		}
		return view;
	}
	
	public String logout()
	{
		ExternalContext ectx = FacesContext.getCurrentInstance().getExternalContext();
		HttpSession session = (HttpSession)ectx.getSession(false);
		session.invalidate();
		return "login.jsf?faces-redirect=true";
	}
}
