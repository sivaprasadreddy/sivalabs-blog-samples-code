/**
 * 
 */
package com.sivalabs.jacksondemo.rest.endpoints;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.sivalabs.jacksondemo.entities.Contact;
import com.sivalabs.jacksondemo.entities.User;
import com.sivalabs.jacksondemo.services.ContactService;
import com.sivalabs.jacksondemo.services.UserService;

/**
 * @author Siva
 *
 */
@RestController
@RequestMapping("/users/{userId}/contacts")
public class ContactRestController 
{
	private static final String JSON_TYPE = MediaType.APPLICATION_JSON_VALUE;
	@Autowired
	private UserService userService;
	@Autowired
	private ContactService contactService;
	
	@RequestMapping(value="/{contactId}", method=RequestMethod.GET, produces=JSON_TYPE)
	public ResponseEntity<Contact> findContact(@PathVariable("contactId") Integer contactId) {
		Contact contact = contactService.findContactById(contactId);
		ResponseEntity<Contact> response = new ResponseEntity<>(getCopy(contact), HttpStatus.OK);
		return response;
	}
	
	@RequestMapping(value="", method=RequestMethod.GET, produces=JSON_TYPE)
	public ResponseEntity<List<Contact>> findContacts(@PathVariable("userId") Integer userId) {
		List<Contact> contacts = contactService.findUserContacts(userId);
		ResponseEntity<List<Contact>> response = new ResponseEntity<>(getCopy(contacts), HttpStatus.OK);
		return response;
	}
	
	@RequestMapping(value="", method=RequestMethod.POST, consumes=JSON_TYPE)
	public ResponseEntity<Void> createContact(@RequestBody Contact contact, @PathVariable("userId") Integer userId) {
		contact.setUser(new User(userId));
		contactService.createContact(contact);
		return new ResponseEntity<>(HttpStatus.CREATED);
	}
	
	
	@RequestMapping(value="", method=RequestMethod.PUT, consumes=JSON_TYPE)
	public ResponseEntity<Void> updateContact(@RequestBody Contact contact, @PathVariable("userId") Integer userId) {
		contact.setUser(new User(userId));
		contactService.updateContact(contact);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@RequestMapping(value="/{contactId}", method=RequestMethod.DELETE, consumes=JSON_TYPE)
	public ResponseEntity<Void> deleteContact(@PathVariable("contactId") Integer contactId) {
		contactService.deleteContact(contactId);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	List<Contact> getCopy(List<Contact> contacts)
	{
		if(contacts == null){
			return null;
		}
		List<Contact> contactsCopy = new ArrayList<>();
		for (Contact contact : contacts) {
			contactsCopy.add(getCopy(contact));
		}
		
		return contactsCopy;
	}
	Contact getCopy(Contact contact)
	{
		if(contact == null){
			return contact;
		}
		Contact contactCopy = new Contact();
		contactCopy.setId(contact.getId());
		contactCopy.setFirstName(contact.getFirstName());
		contactCopy.setLastName(contact.getLastName());
		contactCopy.setEmail(contact.getEmail());
		contactCopy.setPhone(contact.getPhone());
		contactCopy.setDob(contact.getDob());
		
		return contactCopy;
	}
}
