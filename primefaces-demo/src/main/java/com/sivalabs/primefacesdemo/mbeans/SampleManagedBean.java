/**
 * 
 */
package com.sivalabs.primefacesdemo.mbeans;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import com.sivalabs.primefacesdemo.model.User;

/**
 * @author skatam
 *
 */
@ManagedBean
@RequestScoped
public class SampleManagedBean 
{
	private User user;
	private String loginStatus;
	
	public void login(){
		if("admin".equals(user.getUserName()) && "admin".equals(user.getPassword())){
			this.loginStatus = "Login Success";
		} else {
			this.loginStatus = "Login failed";
		}
	}
	
	
	
	public User getUser() {
		if(user==null){
			System.out.println("New User");
			user = new User();
		}
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	public String getLoginStatus() {
		return loginStatus;
	}
	public String getWelcomeMsg()
	{
		return "Welcome "+this.getUser().getFirstName();
	}
}
