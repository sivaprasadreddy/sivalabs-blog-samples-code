package sivalabs.app.core.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * @author Siva
 * 
 */
@Entity
@Table(name = "PERSONS")
public class Person implements Serializable
{
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "person_id")
	private Integer id;
	@Column(name = "name", nullable = false, length = 50)
	private String name;
	@Column(name = "username", nullable = false, unique = true,  length = 50)
	private String userName;
	@Column(name = "password", nullable = false, length = 50)
	private String password;
	@Column(name = "email", nullable = false, length = 50)
	private String email;
	@Column(name = "picture")
	private byte[] picture;
	
	@Enumerated(EnumType.STRING)
	private Gender gender;
	@Temporal(TemporalType.DATE)
	private Date dob;
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="created_on")
	private Date createdOn;
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="updated_on")
	private Date updatedOn;

	public Person() {
	}
	public Person(Integer id) {
		this.id = id;
	}
	public Person(Integer id, String name, String userName, String password, String email) {
		this.id = id;
		this.name = name;
		this.userName = userName;
		this.password = password;
		this.email = email;
	}
	public Person(Integer id, String name, String userName, String password,
			String email, byte[] picture) {
		this.id = id;
		this.name = name;
		this.userName = userName;
		this.password = password;
		this.email = email;
		this.picture = picture;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public byte[] getPicture() {
		return picture;
	}

	public void setPicture(byte[] picture) {
		this.picture = picture;
	}
	public Gender getGender()
	{
		return gender;
	}
	public void setGender(Gender gender)
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
	public Date getCreatedOn()
	{
		return createdOn;
	}
	public void setCreatedOn(Date createdOn)
	{
		this.createdOn = createdOn;
	}
	public Date getUpdatedOn()
	{
		return updatedOn;
	}
	public void setUpdatedOn(Date updatedOn)
	{
		this.updatedOn = updatedOn;
	}



}
