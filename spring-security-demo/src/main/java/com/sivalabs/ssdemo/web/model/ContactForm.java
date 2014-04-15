/**
 * 
 */
package com.sivalabs.ssdemo.web.model;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

/**
 * @author Siva
 *
 */
@XmlRootElement
public class ContactForm 
{
	@NotNull
	@Email(message="Please enter valid Email")
	private String email;
	@Size(min=5, max=100, message="Title should be 5 to 100 chars")
	private String title;
	@NotEmpty(message="Please enter message")
	@Size(max=500)
	private String message;
	
	public ContactForm() {
	}
	
	public ContactForm(String email, String title, String message) {
		this.email = email;
		this.title = title;
		this.message = message;
	}

	@Override
	public String toString() {
		return "ContactForm [email=" + email + ", title=" + title
				+ ", message=" + message + "]";
	}

	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	
}
