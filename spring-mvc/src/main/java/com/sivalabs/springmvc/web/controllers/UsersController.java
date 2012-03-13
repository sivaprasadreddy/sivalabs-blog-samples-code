package com.sivalabs.springmvc.web.controllers;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.sivalabs.springmvc.entities.User;
import com.sivalabs.springmvc.services.UserService;
import com.sivalabs.springmvc.web.forms.ChangePwdForm;
import com.sivalabs.springmvc.web.validators.ChangePwdFormValidator;
import com.sivalabs.springmvc.web.validators.LoginFormValidator;
import com.sivalabs.springmvc.web.validators.RegistrationFormValidator;
import com.sivalabs.springmvc.web.validators.UpdateUserFormValidator;

/**
 * @author skatam
 *
 */
@Controller
public class UsersController 
{
	private static Logger logger = LoggerFactory.getLogger(UsersController.class);
	
	@Autowired private LoginFormValidator loginFormValidator;
	@Autowired private RegistrationFormValidator registrationFormValidator;
	@Autowired private UpdateUserFormValidator updateUserFormValidator;
	@Autowired private ChangePwdFormValidator changePwdFormValidator;
	
	@InitBinder
	protected void initBinder(HttpServletRequest request, 
		    ServletRequestDataBinder binder) throws Exception 
	{
		DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
	    df.setLenient(false);
	    CustomDateEditor editor = new CustomDateEditor(df, true);
	    binder.registerCustomEditor(Date.class, editor);
	}
	
	@Autowired
	private UserService userService;
	
	@RequestMapping("showUsers.htm")
	public String showUsers(Model model) 
	{
		List<User> users = this.userService.findAllUsers();
		model.addAttribute("USERS_KEY", users);
		return "showUsers";
	}
	
	@RequestMapping(value="login.htm", method=RequestMethod.GET)
	public String showLoginForm(Model model) 
	{
		model.addAttribute("loginUser", new User());
		return "login";
	}
	
	@RequestMapping(value="login.htm", method=RequestMethod.POST)
	public String login(@Valid @ModelAttribute("loginUser") User user, BindingResult result, 
			Model model, HttpSession session) 
	{
		this.loginFormValidator.validate(user, result);
		if(result.hasErrors())
		{
			return "login";
		}
		User loggedinUser= this.userService.login(user);
		logger.debug("loggedinUser : "+loggedinUser);
		
		if(loggedinUser !=null){
			session.setAttribute("LOGGEDIN_USER", loggedinUser);
			return "redirect:home.htm";
		}else {
			result.addError(new ObjectError("loginUser", "Invalid UserName and Password.Try again."));
			return "login";
		}
		
	}
	
	@RequestMapping(value="registration.htm", method=RequestMethod.GET)
	public String showRegistrationForm(Model model) 
	{
		model.addAttribute("registrationUser", new User());
		return "registration";
	}
	
	@RequestMapping(value="registration.htm", method=RequestMethod.POST)
	public String register(@Valid  @ModelAttribute("registrationUser") User user, 
			BindingResult result, Model model, HttpSession session) 
	{
		this.registrationFormValidator.validate(user, result);
		if(result.hasErrors())
		{
			return "registration";
		}
		Integer userId = this.userService.createUser(user);
		
		if(userId !=null){
			return "redirect:login.htm";
		}else {
			result.addError(new ObjectError("registrationUser", "Registration Failed."));
			return "registration";
		}
		
	}
	
	@RequestMapping(value="logout.htm", method=RequestMethod.GET)
	public String logout(HttpSession session) 
	{
		session.invalidate();
		return "redirect:login.htm";
	}
		
	@RequestMapping(value="updateUser.htm", method=RequestMethod.GET)
	public String showUpdateUserForm(Model model, HttpSession session) 
	{
		User loggedinUser = (User) session.getAttribute("LOGGEDIN_USER");
		model.addAttribute("updateUser", loggedinUser);
		return "updateUser";
	}
	
	@RequestMapping(value="updateUser.htm", method=RequestMethod.POST)
	public String updateUser(@Valid  @ModelAttribute("updateUser") User user, 
			BindingResult result, Model model, HttpSession session) 
	{
		this.updateUserFormValidator.validate(user, result);
		if(result.hasErrors())
		{
			return "updateUser";
		}
		Integer userId = this.userService.updateUser(user);
		
		if(userId !=null){
			return "redirect:home.htm";
		}else {
			result.addError(new ObjectError("updateUser", "Update Failed."));
			return "updateUser";
		}
		
	}
	
	@RequestMapping(value="changePwd.htm", method=RequestMethod.GET)
	public String showChangePwdForm(Model model, HttpSession session) 
	{
		User loggedinUser = (User) session.getAttribute("LOGGEDIN_USER");
		ChangePwdForm changePwdForm = new ChangePwdForm();
		changePwdForm.setUserId(loggedinUser.getUserId());
		//changePwdForm.setCurrentPwd(loggedinUser.getPassword());
		model.addAttribute("changePwd", changePwdForm);
		return "changePwd";
	}
	
	@RequestMapping(value="changePwd.htm", method=RequestMethod.POST)
	public String updateUser(@Valid  @ModelAttribute("changePwd") ChangePwdForm changePwdForm, 
			BindingResult result, Model model, HttpSession session) 
	{
		
		this.changePwdFormValidator.validate(changePwdForm, result);
		if(result.hasErrors())
		{
			return "changePwd";
		}
		User loggedinUser = (User) session.getAttribute("LOGGEDIN_USER");
		if(!loggedinUser.getPassword().equals(changePwdForm.getCurrentPwd())){
			result.addError(new ObjectError("changePwd", "Incorrect Password."));
			return "changePwd";
		}
		this.userService.changePassword(changePwdForm);
		loggedinUser = this.userService.findUser(loggedinUser.getUserId());
		session.setAttribute("LOGGEDIN_USER", loggedinUser);
		return "redirect:home.htm";
		
		
	}
}
