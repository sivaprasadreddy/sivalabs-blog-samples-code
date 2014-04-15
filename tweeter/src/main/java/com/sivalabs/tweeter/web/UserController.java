package com.sivalabs.tweeter.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.sivalabs.tweeter.entities.User;
import com.sivalabs.tweeter.services.UserService;
import com.sivalabs.tweeter.web.model.AjaxResponse;
import com.sivalabs.tweeter.web.model.AjaxResponseBuilder;

/**
 * @author Siva
 * 
 */
@Controller
public class UserController extends BaseController
{
	@Autowired
	private UserService userService;

	@RequestMapping(value = "login", method = RequestMethod.GET)
	public String loginForm(Model model)
	{
		model.addAttribute("user", new User());
		return "login";
	}

	@RequestMapping(value = "login", method = RequestMethod.POST)
	public String handleLogin(@ModelAttribute("user") User user, BindingResult result,
			RedirectAttributes redirectAttributes, HttpServletRequest request)
	{
		User loginUser = userService.login(user.getUserName(), user.getPassword());
		if (loginUser != null) {
			setLoginUser(request.getSession(), loginUser);
			return "redirect:welcome";
		} else {
			redirectAttributes.addFlashAttribute("user", user);
			redirectAttributes.addFlashAttribute("ERROR", "Invalid UserName and Password");
			return "redirect:login";
		}
	}

	@RequestMapping(value = "logout")
	public String logout(HttpSession session)
	{
		session.invalidate();
		return "redirect:login";
	}

	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public String registrationForm(Model model)
	{
		model.addAttribute("user", new User());
		return "register";
	}

	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public String handleRegistration(@ModelAttribute("user") User user, BindingResult errors, Model model)
	{
		if (errors.hasErrors()) {
			return "register";
		}
		try {
			userService.createUser(user);
			return "redirect:login";
		} catch (Exception e) {
			e.printStackTrace();
			model.addAttribute("ERROR", e.getMessage());
			return "register";
		}
	}

	@ResponseBody
	@RequestMapping(value = "/checkUserNameExists", produces = "application/json")
	public AjaxResponse checkUserNameExists(@RequestParam("userName") String userName)
	{
		boolean exists = userService.checkUserNameExists(userName);
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
		boolean exists = userService.checkEmailExists(email);
		if (exists) {
			return new AjaxResponseBuilder().notOk().error("Email [" + email + "] already exist").build();
		} else {
			return new AjaxResponseBuilder().ok().build();
		}
	}
}
