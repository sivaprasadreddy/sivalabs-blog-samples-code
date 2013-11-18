package com.sivalabs.pmt.web.rest.model;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

import com.sivalabs.pmt.entities.User;

/**
 * @author Siva
 * 
 */
@XmlRootElement(name="Response")
@XmlAccessorType(XmlAccessType.FIELD)
public class UsersResource
{
	@XmlElementWrapper(name="users")
	@XmlElement(name="user")
	private List<User> users = new ArrayList<>();

	public UsersResource()
	{
	}

	public UsersResource(List<User> users)
	{
		this.users = users;
	}

	public List<User> getUsers()
	{
		return users;
	}

	public void setUsers(List<User> users)
	{
		this.users = users;
	}

}
