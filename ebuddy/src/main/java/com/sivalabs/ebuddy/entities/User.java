package com.sivalabs.ebuddy.entities;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;

import org.hibernate.validator.constraints.NotEmpty;


/**
 * @author skatam
 *
 */
@Entity
public class User 
{
	@Id @GeneratedValue(strategy=GenerationType.AUTO)
	private Integer userId;
	@NotEmpty(message="UserName is required.", groups={User.LoginValidation.class, User.RegistrationValidation.class})
	private String userName;
	@NotEmpty(message="Password is required.", groups={User.LoginValidation.class, User.RegistrationValidation.class})
	private String password;
	@NotEmpty(message="FirstName is required.", groups={User.RegistrationValidation.class})
	private String firstName;
	private String lastName;
	private String email;
	private Date dob;
	@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.LAZY, mappedBy="postedBy")
	@OrderBy("postedOn DESC")
	private List<Link> links = new ArrayList<Link>();
	
	public User()
	{
	}
	
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Date getDob() {
		return dob;
	}
	public void setDob(Date dob) {
		this.dob = dob;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public List<Link> getLinks() {
		return links;
	}

	public void setLinks(List<Link> links) {
		this.links = links;
	}
	
	
	public interface LoginValidation {}
	public interface RegistrationValidation {}
	
}
