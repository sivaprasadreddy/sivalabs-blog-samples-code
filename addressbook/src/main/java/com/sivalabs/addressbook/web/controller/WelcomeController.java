/**
 * 
 */
package com.sivalabs.addressbook.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author siva
 *
 */
@Controller
public class WelcomeController {

	@RequestMapping("welcome")
	public String welcome() {
		return "welcome";
	}
	
}
