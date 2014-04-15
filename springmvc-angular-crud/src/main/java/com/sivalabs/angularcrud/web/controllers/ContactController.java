/**
 * 
 */
package com.sivalabs.angularcrud.web.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.sivalabs.angularcrud.entities.Contact;
import com.sivalabs.angularcrud.services.UserService;

/**
 * @author Siva
 *
 */
@RestController
@RequestMapping("/users/{userId}/contacts/")
public class ContactController 
{
	@Autowired
	private UserService userService;
	
	@RequestMapping(value="", method=RequestMethod.GET)
	public List<Contact> findAll(@PathVariable("userId") int userId) {
		return userService.findUserContacts(userId);
	}
	
	@RequestMapping(value="/{contactId}", method=RequestMethod.GET)
	public Contact findContact(@PathVariable("userId") int userId, @PathVariable("contactId") int contactId) {
		return userService.findUserContact(userId, contactId);
	}
	
	@RequestMapping(value="", method=RequestMethod.POST)
	public Contact createContact(@PathVariable("userId") int userId, Contact contact) {
		return userService.saveUserContact(contact);
	}
	
	@RequestMapping(value="", method=RequestMethod.PUT)
	public Contact updateContact(@PathVariable("userId") int userId, Contact contact) {
		return userService.saveUserContact(contact);
	}
	
	@RequestMapping(value="/{contactId}", method=RequestMethod.DELETE)
	public void deleteContact(@PathVariable("userId") int userId, @PathVariable("contactId") int contactId) {
		userService.deleteUserContact(userId, contactId);
	}
}
