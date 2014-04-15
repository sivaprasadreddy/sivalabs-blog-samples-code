package com.sivalabs.ssdemo.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlTransient;

import org.codehaus.jackson.annotate.JsonIgnore;

/**
 * @author Siva
 * 
 */
@Entity
@Table(name = "USERS")
public class User implements Serializable
{
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "user_id")
	private Integer id;
	@Column(name = "username", nullable = false, unique = true, length = 50)
	private String userName;
	@Column(name = "password", nullable = false, length = 50)
	private String password;
	@Column(name = "firstname", nullable = false, length = 50)
	private String firstName;
	@Column(name = "lastname", length = 50)
	private String lastName;
	@Column(name = "email", nullable = false, unique = true, length = 50)
	private String email;
	@Temporal(TemporalType.DATE)
	private Date dob;
	private boolean enabled=true;
	
	@OneToMany(fetch=FetchType.EAGER, cascade=CascadeType.ALL)
	@JoinColumn(name="user_id")
	private Set<Role> roles = new HashSet<>();
	
	
	@OneToMany(mappedBy = "postedBy")
	@XmlTransient
	@JsonIgnore
	private List<Message> messages = new ArrayList<>();

	public User()
	{
	}

	public User(Integer id)
	{
		this.id = id;
	}

	public User(Integer id, String userName, String password, String firstName, String email)
	{
		this.id = id;
		this.userName = userName;
		this.password = password;
		this.firstName = firstName;
		this.email = email;
	}

	public User(Integer id, String userName, String password, String firstName, String lastName, String email, Date dob)
	{
		this.id = id;
		this.userName = userName;
		this.password = password;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.dob = dob;
	}

	public Integer getId()
	{
		return id;
	}

	public void setId(Integer id)
	{
		this.id = id;
	}

	public String getUserName()
	{
		return userName;
	}

	public void setUserName(String userName)
	{
		this.userName = userName;
	}

	public String getPassword()
	{
		return password;
	}

	public void setPassword(String password)
	{
		this.password = password;
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

	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	public List<Message> getMessages() {
		return messages;
	}

	public void setMessages(List<Message> messages) {
		this.messages = messages;
	}

	public Set<Role> getRoles() {
		return roles;
	}

	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}

	public void addRoles(Role... roles) {
		this.roles.addAll(Arrays.asList(roles));
	}

}
