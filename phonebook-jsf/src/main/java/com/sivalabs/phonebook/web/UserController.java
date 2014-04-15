/**
 * 
 */
package com.sivalabs.phonebook.web;

import java.io.Serializable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.sivalabs.phonebook.entities.User;
import com.sivalabs.phonebook.services.UserService;

/**
 * @author Siva
 *
 */
@Component
@Scope("session")
public class UserController implements Serializable
{
	private static final long serialVersionUID = 1L;

	@Autowired
	private UserService userService;
	
	private String email = "admin@gmail.com";
	private String password;
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	public String login() {
		System.out.println(email+":"+password);
		User loginUser = userService.login(email, password);
		System.out.println(loginUser);
		if(loginUser != null){
			JSFUtils.setLoggedinUser(loginUser);
			return "views/home?faces-redirect=true";
		} else {
			JSFUtils.addErrorMsg("Invalid Credentails");
			return null;
		}
		
	}
}
