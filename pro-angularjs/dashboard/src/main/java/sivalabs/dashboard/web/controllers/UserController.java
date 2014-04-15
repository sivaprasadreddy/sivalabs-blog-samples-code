/**
 * 
 */
package sivalabs.dashboard.web.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import sivalabs.dashboard.entities.User;
import sivalabs.dashboard.services.UserService;

/**
 * @author Siva
 *
 */
@RestController
@RequestMapping(value="/users", produces=MediaType.APPLICATION_JSON_VALUE)
public class UserController 
{
	@Autowired
	private UserService userService;
	
	@RequestMapping(value="/", method=RequestMethod.GET)
	public List<User> getUsers() {
		return userService.findAllUsers();
	}
	
	@RequestMapping(value="/search", method=RequestMethod.GET)
	public List<User> searchUsers(@RequestParam(value="query", defaultValue="", required=false)String query) {
		return userService.searchUsers(query);
	}
	
	@RequestMapping(value="/{userId}", method=RequestMethod.GET)
	public User getUser(@PathVariable("userId") int userId) {
		return userService.findUserById(userId);
	}
	
	@RequestMapping(value="/", method=RequestMethod.POST)
	public ResponseEntity<Map<String, Object>> createUser(@RequestBody User user) {
		try {
			User savedUser = userService.createUser(user);
			Map<String, Object> map = new HashMap<>();
			map.put("user", savedUser);
			return new ResponseEntity<>(map, HttpStatus.CREATED);
		} catch (Exception e) {
			e.printStackTrace();
			Map<String, Object> map = new HashMap<>();
			map.put("error", e.getMessage());
			return new ResponseEntity<Map<String,Object>>(map, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
	}
	
	@RequestMapping(value="/", method=RequestMethod.PUT)
	public User updateUser(@RequestBody User user) {
		return userService.updateUser(user);
	}
	
	@RequestMapping(value="/{userId}", method=RequestMethod.DELETE)
	public void deleteUser(@PathVariable("userId") int userId) {
		userService.deleteUser(userId);
	}
	
}
