/**
 * 
 */
package com.sivalabs.forum.web.interceptors;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.sivalabs.forum.entities.User;
import com.sivalabs.forum.services.UserService;

/**
 * @author Siva
 * 
 */
@Component("authenticationInterceptor")
public class AuthenticationInterceptor extends HandlerInterceptorAdapter {
	
	@Autowired
	private UserService userService;
	
	@Override
	public boolean preHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler) throws Exception {

		User loginUser = (User) request.getSession().getAttribute("LOGIN_USER");
		String loginUserDetailsChanged = (String) request.getSession().getAttribute("LOGIN_USER_DETAILS_CHANGED");
		if (loginUser == null || Boolean.valueOf(loginUserDetailsChanged)) {
			Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		    if(principal instanceof org.springframework.security.core.userdetails.User){
		    	String email = ((org.springframework.security.core.userdetails.User)principal).getUsername();
		    	User user = userService.findUserByEmail(email);
		    	request.getSession().setAttribute("LOGIN_USER", user);
		    	request.getSession().removeAttribute("LOGIN_USER_DETAILS_CHANGED");
		    }
		}

		return true;
	}
}
