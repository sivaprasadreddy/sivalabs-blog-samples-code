/**
 * 
 */
package com.sivalabs.springmvc.web.controllers;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;

import com.sivalabs.springmvc.model.User;
import com.sivalabs.springmvc.services.UserService;
import com.sivalabs.springmvc.web.validators.UserFormValidator;

/**
 * @author siva
 *
 */
@Controller
public class UserController {
	
	@Autowired
	private UserFormValidator validator;
	
	@Autowired
	private UserService userService;
	
	@InitBinder
	public void initBinder(WebDataBinder binder) 
	{
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
		dateFormat.setLenient(false);
		binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
	}

	@RequestMapping("/searchUsers")
	public ModelAndView searchUsers(@RequestParam(required= false, defaultValue="") String name)
	{
		ModelAndView mav = new ModelAndView("showUsers");
		List<User> users = userService.searchUsers(name.trim());
		mav.addObject("SEARCH_USERS_RESULTS_KEY", users);
		return mav;
	}

	@RequestMapping("/viewAllUsers")
	public ModelAndView getAllUsers()
	{
		ModelAndView mav = new ModelAndView("showUsers");
		List<User> users = userService.getAllUsers();
		System.out.println(users);
		mav.addObject("SEARCH_USERS_RESULTS_KEY", users);
		return mav;
	}

	@RequestMapping(value="/saveUser", method=RequestMethod.GET)
	public ModelAndView newuserForm()
	{
		ModelAndView mav = new ModelAndView("newUser");
		User user = new User();
		mav.getModelMap().put("newUser", user);
		return mav;
	}

	@RequestMapping(value="/saveUser", method=RequestMethod.POST)
	public String create(@ModelAttribute("newUser")User user, BindingResult result, SessionStatus status)
	{
		validator.validate(user, result);
		if (result.hasErrors()) 
		{				
			return "newUser";
		}
		userService.save(user);
		status.setComplete();
		return "redirect:viewAllUsers";
	}

	@RequestMapping(value="/updateUser", method=RequestMethod.GET)
	public ModelAndView edit(@RequestParam("id")Long id)
	{
		ModelAndView mav = new ModelAndView("editUser");
		User user = userService.getById(id);
		mav.addObject("editUser", user);
		return mav;
	}

	@RequestMapping(value="/updateUser", method=RequestMethod.POST)
	public String update(@ModelAttribute("editUser") User user, BindingResult result, SessionStatus status)
	{
		validator.validate(user, result);
		if (result.hasErrors()) {
			return "editUser";
		}
		userService.update(user);
		status.setComplete();
		return "redirect:viewAllUsers";
	}


	@RequestMapping("deleteUser")
	public ModelAndView delete(@RequestParam("id")Long id)
	{
		ModelAndView mav = new ModelAndView("redirect:viewAllUsers");
		userService.delete(id);
		return mav;
	}
}
