package com.sivalabs.springdatarest.web.controllers;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.http.HttpEntity;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sivalabs.springdatarest.entities.Contact;
import com.sivalabs.springdatarest.entities.User;
import com.sivalabs.springdatarest.model.ContactsResponse;
import com.sivalabs.springdatarest.services.UserService;

/**
 * @author Siva
 * 
 */
@Controller
@RequestMapping(value="/users/")
public class UserController
{
	@Autowired
	private UserService userService;

	@InitBinder
	private void dataBinder(WebDataBinder binder)
	{
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		CustomDateEditor editor = new CustomDateEditor(dateFormat, true);
		binder.registerCustomEditor(Date.class, editor);
	}
	
	@RequestMapping(value="/list", produces=MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public List<User> getUsers() {
		return userService.findAllUsers();
	}
	
	@RequestMapping(value="/{userId}", produces=MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public User getUsers(@PathVariable("userId") int userId) {
		return userService.findUserById(userId);
	}
	
	@RequestMapping(value="/{userId}/contacts", produces=MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public HttpEntity<ContactsResponse> getContacts(@PathVariable("userId") int userId) {
		List<Contact> contacts = userService.findUserContacts(userId);
		ContactsResponse contactsResponse = new ContactsResponse(contacts);
		return new HttpEntity<ContactsResponse>(contactsResponse);
	}
	
	@RequestMapping(value="/{userId}/contacts/{contactId}", produces=MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public HttpEntity<Contact> getContact(@PathVariable("userId") int userId, @PathVariable("contactId") int contactId) {
		Contact contact = userService.findUserContact(userId, contactId);
		return new HttpEntity<Contact>(contact);
	}
	
}
