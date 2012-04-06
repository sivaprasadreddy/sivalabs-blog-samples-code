/**
 * 
 */
package com.sivalabs.ebuddy.web.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author skatam
 *
 */
@Controller
public class HelperController 
{
	@RequestMapping("welcome.htm")
	public String welcome() 
	{
		return "welcome";
	}
}
