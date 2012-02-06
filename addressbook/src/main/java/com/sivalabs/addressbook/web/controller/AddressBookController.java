/**
 * 
 */
package com.sivalabs.addressbook.web.controller;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.support.ByteArrayMultipartFileEditor;

import com.sivalabs.addressbook.model.Contact;
import com.sivalabs.addressbook.repositories.ContactRepository;
import com.sivalabs.core.json.JSONResponse;

/**
 * @author siva
 *
 */ 
@Controller
public class AddressBookController {

	@Autowired
	private ContactRepository contactRepository;
	
	@InitBinder
	protected void initBinder(ServletRequest request, ServletRequestDataBinder binder) throws Exception {
	    // to actually be able to convert Multipart instance to byte[] we have to register a custom editor
	    binder.registerCustomEditor(byte[].class, new ByteArrayMultipartFileEditor());
	    // now Spring knows how to handle multipart object and convert
	    
	    DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
	    CustomDateEditor editor = new CustomDateEditor(df, true);
	    binder.registerCustomEditor(Date.class, editor);
	}
	
	@RequestMapping("phonebook")
	public @ResponseBody JSONResponse<List<Contact>> getContactsJSON(HttpServletRequest request, HttpServletResponse response) throws IOException 
	{
		/*String json = "";
		json += "{\"ResultSet\":{\"Result\":[{\"id\":\"1\",\"name\":\"siva\"},{\"id\":\"2\", \"name\":\"prasad\"},{\"id\":3, \"name\":\"neha\"}]}}";
		response.setContentType("application/json");
		response.getWriter().write(json);
		return null;*/
		
		/*List<Contact> contacts = new ArrayList<Contact>();
		contacts.add(new Contact(1l,"siva"));
		contacts.add(new Contact(2l,"prasad"));*/
		String searchName = request.getParameter("searchName");
		if(searchName == null || searchName.trim().length()==0){
			searchName = "";
		}
		searchName = searchName+"%";
		List<Contact> contacts = contactRepository.findByFirstnameOrLastname(searchName, searchName);
		
		return new JSONResponse<List<Contact>>(contacts);
	}
	
	@RequestMapping(method=RequestMethod.GET, value="newContact")
	public String newContactForm(Model model) 
	{
		model.addAttribute("contact", new Contact());
		return "phonebook/newContact";
	}
	
	@RequestMapping(method=RequestMethod.POST, value="newContact")
	public String saveContact(Contact contact) 
	{
		contactRepository.save(contact);
		return "redirect:page?view=phonebook/phonebook";
	}
	
	@RequestMapping("getContactJSON")
	public @ResponseBody JSONResponse<Contact> getContactJSON(@RequestParam("id")Long id) {
		Contact contact =this.contactRepository.findOne(id);
		return new JSONResponse<Contact>(contact);
		
	}
	
	@RequestMapping(method=RequestMethod.POST, value="updateContact")
	public String updateContact(Contact contact) 
	{
		contactRepository.save(contact);
		return "redirect:page?view=phonebook/phonebook";
	}
	
	@RequestMapping(method=RequestMethod.GET, value="deleteContact")
	public @ResponseBody JSONResponse<String> deleteContact(@RequestParam("id")Long id) {
		contactRepository.delete(id);
		return new JSONResponse<String>("Deleted Successfully");
	}
}
