/**
 * 
 */
package com.sivalabs.phonebook.web;

import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.sivalabs.phonebook.entities.Contact;
import com.sivalabs.phonebook.entities.User;
import com.sivalabs.phonebook.services.PhoneBookService;
import com.sivalabs.phonebook.services.UserService;

/**
 * @author Siva
 *
 */
@Component
@Scope("session")
public class PhoneBookController {

	@Autowired UserService userService;
	@Autowired PhoneBookService phoneBookService;
	
	private String searchQuery;
	private List<Contact> contacts;
	private Contact newContact;
	private Contact editContact;
	
	@PostConstruct
	public void inti() {
		contacts = phoneBookService.findUserContacts(getLoginUserId());
	}
	public String getSearchQuery() {
		return searchQuery;
	}
	public void setSearchQuery(String searchQuery) {
		this.searchQuery = searchQuery;
	}
	public List<Contact> getContacts() {
		return contacts;
	}
	public void setContacts(List<Contact> contacts) {
		this.contacts = contacts;
	}	
	public Contact getNewContact() {
		if(newContact == null){
			newContact = new Contact();
		}
		return newContact;
	}
	public void setNewContact(Contact newContact) {
		this.newContact = newContact;
	}
	public Contact getEditContact() {
		if(editContact == null){
			//editContact = new Contact();
		}
		return editContact;
	}
	public void setEditContact(Contact editContact) {
		this.editContact = editContact;
	}
	
	/* Action Methods */
	
	public int getLoginUserId() {
		return JSFUtils.getLoggedinUser().getId();
	}
	public void searchContacts() {
		contacts = phoneBookService.findUserContacts(getLoginUserId());
		editContact = null;
		newContact=null;
	}
	public void createContact() {
		newContact.setUser(new User(getLoginUserId()));
		phoneBookService.createContact(getLoginUserId(), newContact);
		JSFUtils.addInfoMsg("Contact added successfully");
		contacts = phoneBookService.findUserContacts(getLoginUserId());
		newContact=null;
	}
	
	public void updateContact() {
		phoneBookService.updateContact(editContact);
		JSFUtils.addInfoMsg("Contact updated successfully");
		contacts = phoneBookService.findUserContacts(getLoginUserId());
		editContact = null;
		
	}
	
	public void deleteContact() {
		phoneBookService.deleteContact(editContact.getId());
		JSFUtils.addInfoMsg("Contact deleted successfully");
		contacts = phoneBookService.findUserContacts(getLoginUserId());
		editContact = null;		
	}
}
