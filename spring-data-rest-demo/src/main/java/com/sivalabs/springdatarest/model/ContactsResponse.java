/**
 * 
 */
package com.sivalabs.springdatarest.model;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

import com.sivalabs.springdatarest.entities.Contact;

/**
 * @author katsi02
 *
 */
@XmlRootElement(name="Response")
public class ContactsResponse extends BaseResponse<List<Contact>>
{
	public ContactsResponse() {
		setData(new ArrayList<Contact>());
	}
	
	public ContactsResponse(List<Contact> contacts) {
		setData(contacts);
	}
	
}
