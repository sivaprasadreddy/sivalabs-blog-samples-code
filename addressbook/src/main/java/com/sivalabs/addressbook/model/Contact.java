/**
 * 
 */
package com.sivalabs.addressbook.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Transient;

import org.codehaus.jackson.map.annotate.JsonSerialize;

import com.sivalabs.core.json.CustomDateSerializer;

/**
 * @author siva
 *
 */
@Entity
public class Contact {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	private String firstname;
	private String lastname;
	private String email;
	private String password;
	private String phone;
	private String mobile;
	
	private Date dob;
	
	@Transient
	private byte[] picture;
	
	public Contact() {
	}

	public Contact(Long id, String firstname, String lastname, String email,
			String password, String phone, String mobile, Date dob) {
		super();
		this.id = id;
		this.firstname = firstname;
		this.lastname = lastname;
		this.email = email;
		this.password = password;
		this.phone = phone;
		this.mobile = mobile;
		this.dob = dob;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	@JsonSerialize(using = CustomDateSerializer.class)
	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	public byte[] getPicture() {
		return picture;
	}

	public void setPicture(byte[] picture) {
		this.picture = picture;
	}
	
	
	
}
