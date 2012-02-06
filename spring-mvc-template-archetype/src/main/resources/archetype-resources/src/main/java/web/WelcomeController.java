#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
/**
 * 
 */
package ${package}.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import ${package}.service.SampleService;

/**
 * @author Siva
 *
 */
@Controller
public class WelcomeController 
{
	@Autowired
	private SampleService sampleService;
	
	@RequestMapping(value={"/","/index","/welcome","/home"})
	public String welcome(Model model) 
	{
		model.addAttribute("GREETING",this.sampleService.getDefaultUserGreeting());
		return "welcome";
	}
}
