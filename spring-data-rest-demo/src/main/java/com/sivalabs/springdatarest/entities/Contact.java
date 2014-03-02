package com.sivalabs.springdatarest.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * @author Siva
 * 
 */
@Entity
@Table(name = "CONTACTS")
public class Contact implements Serializable
{
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "contact_id")
	private Integer id;
	@Column(name = "firstname", nullable = false, length = 50)
	private String firstName;
	@Column(name = "lastname", length = 50)
	private String lastName;
	@Column(name = "email", nullable = false, unique = true, length = 50)
	private String email;
	@Temporal(TemporalType.DATE)
	private Date dob;
	
	@ManyToOne
	@JoinColumn(name = "user_id")
	private User user;

	public Contact()
	{
	}

	public Contact(Integer id)
	{
		this.id = id;
	}

	

	public Integer getId()
	{
		return id;
	}

	public void setId(Integer id)
	{
		this.id = id;
	}

	
	public String getFirstName()
	{
		return firstName;
	}

	public void setFirstName(String firstName)
	{
		this.firstName = firstName;
	}

	public String getLastName()
	{
		return lastName;
	}

	public void setLastName(String lastName)
	{
		this.lastName = lastName;
	}

	public String getEmail()
	{
		return email;
	}

	public void setEmail(String email)
	{
		this.email = email;
	}

	public Date getDob()
	{
		return dob;
	}

	public void setDob(Date dob)
	{
		this.dob = dob;
	}

}
