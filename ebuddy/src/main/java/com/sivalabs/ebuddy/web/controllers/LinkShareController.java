package com.sivalabs.ebuddy.web.controllers;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.sivalabs.ebuddy.entities.Link;
import com.sivalabs.ebuddy.entities.User;
import com.sivalabs.ebuddy.services.LinkShareService;


/**
 * @author skatam
 *
 */
@Controller
public class LinkShareController 
{
	private static Logger logger = LoggerFactory.getLogger(LinkShareController.class);
	
	@Autowired
	private LinkShareService linkShareService;
	
	@InitBinder
	protected void initBinder(HttpServletRequest request, 
		    ServletRequestDataBinder binder) throws Exception 
	{
		DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
	    df.setLenient(false);
	    CustomDateEditor editor = new CustomDateEditor(df, true);
	    binder.registerCustomEditor(Date.class, editor);
	}
	
	
	@RequestMapping("showUsers")
	public String showUsers(Model model) 
	{
		List<User> users = this.linkShareService.findAllUsers();
		model.addAttribute("USERS_KEY", users);
		return "showUsers";
	}
	
	@RequestMapping(value="registration", method=RequestMethod.GET)
	public String showRegistrationForm(Model model) 
	{
		model.addAttribute("user", new User());
		return "registration";
	}
	
	@RequestMapping(value="registration", method=RequestMethod.POST)
	public String registerUser(@Validated(User.RegistrationValidation.class) @ModelAttribute User user, BindingResult result, Model model) 
	{
		if(result.hasErrors())
		{
			return "registration";
		}
		Integer userId = this.linkShareService.createUser(user);
		logger.debug("New UserId : "+userId);
		return "redirect:login.htm";
	}
	
	@RequestMapping(value="login", method=RequestMethod.GET)
	public String showLoginForm(Model model) 
	{
		model.addAttribute("user", new User());
		return "login";
	}
	
	@RequestMapping(value="login", method=RequestMethod.POST)
	public String login(@Validated(User.LoginValidation.class) @ModelAttribute User user, BindingResult result, Model model, HttpSession session) 
	{
		if(result.hasErrors())
		{
			return "login";
		}
		System.out.println(user.getUserName()+":"+ user.getPassword());
		User loginUser = this.linkShareService.login(user.getUserName(), user.getPassword());
		logger.debug("loginUser : "+loginUser);
		if(loginUser !=null)
		{
			session.setAttribute("LOGIN_USER", loginUser);
			return "redirect:home.htm";
		}
		return "login";
	}
	
	@RequestMapping(value="home")
	public String home(Model model, HttpSession session) 
	{
		User loginUser = (User) session.getAttribute("LOGIN_USER");
		List<Link> allLinks = this.linkShareService.findAllLinks();
		List<Link> userLinks = this.linkShareService.findUserLinks(loginUser.getUserId());
		model.addAttribute("ALL_LINKS", allLinks);
		model.addAttribute("USER_LINKS", userLinks);
		return "home";
	}
}
