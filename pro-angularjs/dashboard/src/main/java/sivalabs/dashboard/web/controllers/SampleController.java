/**
 * 
 */
package sivalabs.dashboard.web.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import sivalabs.dashboard.entities.User;
import sivalabs.dashboard.services.UserService;

/**
 * @author Siva
 *
 */
@Controller
//@RequestMapping("/users")
public class SampleController {

	@Autowired
	private UserService userService;
	
	@RequestMapping(value="/searchUsers", method=RequestMethod.GET)
	@ResponseBody
	public List<User> searchUsers() {
		return userService.searchUsers("");
	}
	
}
