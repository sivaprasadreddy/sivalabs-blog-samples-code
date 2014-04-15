/**
 * 
 */
package com.sivalabs.jacksondemo.rest.endpoints;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.sivalabs.jacksondemo.entities.Contact;
import com.sivalabs.jacksondemo.entities.User;
import com.sivalabs.jacksondemo.rest.model.AjaxResponse;
import com.sivalabs.jacksondemo.services.UserService;

/**
 * @author Siva
 *
 */
@RestController
@RequestMapping(value="/users")
public class UserRestController 
{
	private static final String JSON_TYPE = MediaType.APPLICATION_JSON_VALUE;
	@Autowired
	private UserService userService;
	
	@RequestMapping(value="/{userId}", method=RequestMethod.GET, produces=JSON_TYPE)
	public ResponseEntity<User> findUserById(@PathVariable("userId") Integer userId) 
	{
		User user = userService.findUserById(userId);
		//ResponseEntity<User> responseEntity = new ResponseEntity<User>(getCopy(user), HttpStatus.OK);
		ResponseEntity<User> responseEntity = new ResponseEntity<User>(user, HttpStatus.OK);
		return responseEntity;
	}
	
	@RequestMapping(value="/authenticate", method=RequestMethod.GET, produces=JSON_TYPE)
	public ResponseEntity<User> authenticate(@RequestHeader("email") String email, @RequestHeader("password") String password) 
	{
		User user = userService.login(email, password);
		//ResponseEntity<User> responseEntity = new ResponseEntity<User>(getCopy(user), HttpStatus.OK);
		ResponseEntity<User> responseEntity = new ResponseEntity<User>(user, HttpStatus.OK);
		return responseEntity;
	}
	
	@RequestMapping(value="", method=RequestMethod.GET, produces=JSON_TYPE)
	public ResponseEntity<AjaxResponse<List<User>>> findAllUsers() 
	{
		List<User> userList = new ArrayList<>();
		List<User> users = userService.findAllUsers();
		for (User user : users) {
			//userList.add(getCopy(user));
			//Set<Contact> contacts = user.getContacts();
			//System.out.println("contacts-->"+contacts);
			//for (Contact contact : contacts) {
			//	System.out.println(contact);
			//}
			userList.add(user);
		}
		AjaxResponse<List<User>> resp = new AjaxResponse<>();
		resp.setData(userList);
		ResponseEntity<AjaxResponse<List<User>>> responseEntity = new ResponseEntity<>(resp, HttpStatus.OK);
		return responseEntity;
	}
	
	/*
	User getCopy(User user)
	{
		if(user == null){
			return null;
		}
		User userCopy = new User();
		userCopy.setId(user.getId());
		userCopy.setEmail(user.getEmail());
		userCopy.setPassword(user.getPassword());
		userCopy.setFirstName(user.getFirstName());
		userCopy.setLastName(user.getLastName());
		userCopy.setDob(user.getDob());
		return userCopy;		
	}
	*/
}
