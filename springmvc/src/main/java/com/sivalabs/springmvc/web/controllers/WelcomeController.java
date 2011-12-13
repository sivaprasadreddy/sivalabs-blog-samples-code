/**
 * This software is developed by author of http://sivalabs.blogspot.com.
 * This is a freeware. You can use it, change it, redistribute it.
 */
package com.sivalabs.springmvc.web.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author K. Siva Prasad Reddy
 * Date  : Dec 13, 2011
 *
 */
@Controller
public class WelcomeController
{
	@RequestMapping({"/","/welcome","/home"})
	public String welcome()
	{
		return "welcome";
	}
}
