/**
 * 
 */
package com.sivalabs.springmvc.web.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author skatam
 *
 */
@Controller
public class WelcomeController 
{
	@RequestMapping("welcome.htm")
	public String welcome() {
		return "welcome";
	}
	
	@RequestMapping("home.htm")
	public String home() {
		return "home";
	}
}
