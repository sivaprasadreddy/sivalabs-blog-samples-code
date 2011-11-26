/**
 * 
 */
package com.sivalabs;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author siva
 *
 */
@Controller
public class HomeController {
	
	@Autowired
	private SampleService sampleService;
	
	@RequestMapping("home")
	public String home(Model model) 
	{
		model.addAttribute("STATUS", sampleService.getStatus());
		return "home";
	}
}
