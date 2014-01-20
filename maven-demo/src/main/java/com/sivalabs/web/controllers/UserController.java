/**
 * 
 */
package com.sivalabs.web.controllers;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.sivalabs.bo.UserBO;
import com.sivalabs.domain.User;
import com.sivalabs.web.model.AjaxResponse;
import com.sivalabs.web.model.AjaxResponseBuilder;


/**
 * @author Siva
 *
 */
@Controller
public class UserController 
{
	@Autowired
	private UserBO userBO;
	
	@InitBinder
	public void initBinder(WebDataBinder binder) 
	{
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
		CustomDateEditor editor = new CustomDateEditor(dateFormat, true);
		binder.registerCustomEditor(Date.class, editor);
	}
	
	@RequestMapping(value = "login", method = RequestMethod.GET)
	public String loginForm(Model model)
	{
		model.addAttribute("user", new User());
		return "login";
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String handleLogin(@ModelAttribute("user") User user, BindingResult errors, 
								Model model, RedirectAttributes redirectAttributes, 
								HttpServletRequest request)
	{
		if (errors.hasErrors()) {
			return "login";
		}
		try {
			User loginUser = userBO.login(user.getUserName(), user.getPassword());
			if(loginUser != null){
				request.getSession().setAttribute("LOGIN_USER", loginUser);
				return "redirect:welcome";
			}
			else
			{
				//model.addAttribute("error", "Wrong UserName and Password.");
				//return "login";
				
				redirectAttributes.addFlashAttribute("error", "Wrong UserName and Password.");
				return "redirect:login";
			}
		} catch (Exception e) {
			e.printStackTrace();
			redirectAttributes.addFlashAttribute("error", e.getMessage());
			return "redirect:login";
		}
	}

	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public String registrationForm(Model model)
	{
		model.addAttribute("user", new User());
		return "register";
	}

	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public String handleRegistration(@ModelAttribute("user") User user, BindingResult errors, 
									Model model,RedirectAttributes redirectAttributes)
	{
		if (errors.hasErrors()) {
			return "register";
		}
		try {
			userBO.createUser(user);
			redirectAttributes.addFlashAttribute("msg", "Registered successfully");			
			return "redirect:login";
		} catch (Exception e) {
			e.printStackTrace();
			//redirectAttributes.addFlashAttribute("error", e.getMessage());
			//redirectAttributes.addFlashAttribute("user",user);
			model.addAttribute("error", e.getMessage());
			return "register";
		}
	}

	@RequestMapping(value = "/logout")
	public String logout(HttpSession session)
	{
		session.invalidate();
		return "redirect:login?logout=true";
	}
	
	@ResponseBody
	@RequestMapping(value = "/checkUserNameExists", produces = "application/json")
	public AjaxResponse checkUserNameExists(@RequestParam("userName") String userName)
	{
		boolean exists = userBO.checkUserNameExists(userName);
		if (exists) {
			return new AjaxResponseBuilder().notOk().error("UserName [" + userName + "] already exist").build();
		} else {
			return new AjaxResponseBuilder().ok().build();
		}
	}

	@ResponseBody
	@RequestMapping(value = "/checkEmailExists", produces = "application/json")
	public AjaxResponse checkEmailExists(@RequestParam("email") String email)
	{
		boolean exists = userBO.checkEmailExists(email);
		if (exists) {
			return new AjaxResponseBuilder().notOk().error("Email [" + email + "] already exist").build();
		} else {
			return new AjaxResponseBuilder().ok().build();
		}
	}
}
