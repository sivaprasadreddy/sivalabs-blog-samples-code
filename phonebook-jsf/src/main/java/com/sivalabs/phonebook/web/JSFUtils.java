
package com.sivalabs.phonebook.web;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

import com.sivalabs.phonebook.entities.User;

/**
 * @author Siva
 *
 */
public final class JSFUtils {
	
	public static void setLoggedinUser(User user)
	{
		FacesContext context = FacesContext.getCurrentInstance();
		HttpSession session = (HttpSession) context.getExternalContext().getSession(true);
		session.setAttribute("LOGIN_USER", user);
	}
	
	public static User getLoggedinUser()
	{
		FacesContext context = FacesContext.getCurrentInstance();
		HttpSession session = (HttpSession) context.getExternalContext().getSession(true);
		return (User) session.getAttribute("LOGIN_USER");
	}
	
	public static void addInfoMsg(String msg) {
		FacesContext.getCurrentInstance().addMessage(null, 
					new FacesMessage(FacesMessage.SEVERITY_INFO, msg, msg));
	}
	
	public static void addErrorMsg(String msg) {
		FacesContext.getCurrentInstance().addMessage(null, 
				new FacesMessage(FacesMessage.SEVERITY_ERROR, msg, msg));
	}
	
	public static void addInfoMsg(String componentId, String msg) {
		FacesContext.getCurrentInstance().addMessage(componentId, 
					new FacesMessage(FacesMessage.SEVERITY_INFO, msg, msg));
	}
	
	public static void addErrorMsg(String componentId, String msg) {
		FacesContext.getCurrentInstance().addMessage(componentId, 
				new FacesMessage(FacesMessage.SEVERITY_ERROR, msg, msg));
	}
}
