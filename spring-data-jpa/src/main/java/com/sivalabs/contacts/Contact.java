package com.sivalabs.contacts;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.apache.commons.lang.builder.ToStringBuilder;

/**
 * @author SivaLabs
 *
 */

@Entity
@Table(name="CONTACTS")
public class Contact
{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	@Column	private String name;
	@Column private String address; 
	@Column private String gender; 
	@Column private Date dob; 
	@Column private String email;
	@Column private String mobile; 
	@Column private String phone;
	
	public Contact()
	{
	}
	
	public Contact(int id, String name, String address, String gender,
			Date dob, String email, String mobile, String phone)
	{
		super();
		this.id = id;
		this.name = name;
		this.address = address;
		this.gender = gender;
		this.dob = dob;
		this.email = email;
		this.mobile = mobile;
		this.phone = phone;
	}
	@Override
	public String toString()
	{
		return ToStringBuilder.reflectionToString(this);
	}
	public int getId()
	{
		return id;
	}
	public void setId(int id)
	{
		this.id = id;
	}
	public String getName()
	{
		return name;
	}
	public void setName(String name)
	{
		this.name = name;
	}
	public String getAddress()
	{
		return address;
	}
	public void setAddress(String address)
	{
		this.address = address;
	}
	public String getGender()
	{
		return gender;
	}
	public void setGender(String gender)
	{
		this.gender = gender;
	}
	public Date getDob()
	{
		return dob;
	}
	public void setDob(Date dob)
	{
		this.dob = dob;
	}
	public String getEmail()
	{
		return email;
	}
	public void setEmail(String email)
	{
		this.email = email;
	}
	public String getMobile()
	{
		return mobile;
	}
	public void setMobile(String mobile)
	{
		this.mobile = mobile;
	}
	public String getPhone()
	{
		return phone;
	}
	public void setPhone(String phone)
	{
		this.phone = phone;
	}	
}
