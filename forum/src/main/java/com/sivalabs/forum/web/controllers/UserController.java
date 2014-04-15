package com.sivalabs.forum.web.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.sivalabs.forum.entities.User;
import com.sivalabs.forum.models.ChangePasswordBean;

/**
 * @author Siva
 * 
 */
@Controller
public class UserController extends BaseController
{

	@RequestMapping(value = "loginForm", method = RequestMethod.GET)
	public String loginForm(Model model)
	{
		model.addAttribute("user", new User());
		return "login";
	}

	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public String registrationForm(Model model)
	{
		model.addAttribute("user", new User());
		return "register";
	}

	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public String handleRegistration(@ModelAttribute("user") User user, BindingResult errors, Model model,RedirectAttributes redirectAttributes)
	{
		if (errors.hasErrors()) {
			return "register";
		}
		try {
			userService.createUser(user);
			redirectAttributes.addFlashAttribute("msg", "You have registered successfully");
			return "redirect:loginForm";
		} catch (Exception e) {
			e.printStackTrace();
			model.addAttribute("ERROR", e.getMessage());
			return "register";
		}
	}
	
	
	@RequestMapping(value = "/myAccount", method = RequestMethod.GET)
	public String showMyAccount(Model model, HttpSession session)
	{
		User user = getCurrentUser(session);
		//User user = userService.findUserByEmail(currentUser.getEmail());
		model.addAttribute("user", user);
		return "user/myaccount";
	}
	
	@RequestMapping(value = "/updateUser", method = RequestMethod.POST)
	public String updateUser(@ModelAttribute("user") User user, BindingResult errors, Model model,RedirectAttributes redirectAttributes, HttpSession session)
	{
		if (errors.hasErrors()) {
			return "user/myaccount";
		}
		try {
			userService.updateUser(user);
			redirectAttributes.addFlashAttribute("msg", "Saved successfully");
			session.setAttribute("LOGIN_USER_DETAILS_CHANGED","true");
			return "redirect:myAccount";
		} catch (Exception e) {
			e.printStackTrace();
			model.addAttribute("ERROR", e.getMessage());
			return "user/myaccount";
		}
	}
	
	@RequestMapping(value = "/changePwd", method = RequestMethod.GET)
	public String showChangePwdForm(Model model, HttpSession session)
	{
		User user = getCurrentUser(session);
		ChangePasswordBean changePwdBean = new ChangePasswordBean();
		changePwdBean.setEmail(user.getEmail());
		//User user = userService.findUserByEmail(currentUser.getEmail());
		model.addAttribute("changePwdBean", changePwdBean);
		return "user/changePwd";
	}
	
	@RequestMapping(value = "/changePwd", method = RequestMethod.POST)
	public String changePwd(ChangePasswordBean changePwdBean, BindingResult errors, 
							Model model,RedirectAttributes redirectAttributes, HttpSession session)
	{
		if (errors.hasErrors()) {
			return "user/changePwd";
		}
		try {
			userService.changePwd(changePwdBean);
			redirectAttributes.addFlashAttribute("msg", "Password changed successfully");
			session.setAttribute("LOGIN_USER_DETAILS_CHANGED","true");
			return "redirect:changePwd";
		} catch (Exception e) {
			e.printStackTrace();
			model.addAttribute("ERROR", e.getMessage());
			return "user/changePwd";
		}
	}
}
