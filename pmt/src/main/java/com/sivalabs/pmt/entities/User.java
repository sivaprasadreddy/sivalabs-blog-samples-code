package com.sivalabs.pmt.entities;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author Siva
 *
 */
@XmlRootElement
public class User
{
	private int id;
	private String username;
	private String password;
	private String email;
	private List<Project> projects = new ArrayList<>();
	private List<Task> tasks = new ArrayList<>();
	public User()
	{
	}
	
	public User(int id, String username, String password, String email)
	{
		this.id = id;
		this.username = username;
		this.password = password;
		this.email = email;
	}

	@Override
	public String toString()
	{
		return "User [id=" + id + ", username=" + username + ", password=" + password + ", email=" + email + "]";
	}

	public int getId()
	{
		return id;
	}

	public void setId(int id)
	{
		this.id = id;
	}

	public String getUsername()
	{
		return username;
	}

	public void setUsername(String username)
	{
		this.username = username;
	}

	public String getPassword()
	{
		return password;
	}

	public void setPassword(String password)
	{
		this.password = password;
	}

	public String getEmail()
	{
		return email;
	}

	public void setEmail(String email)
	{
		this.email = email;
	}

	public List<Project> getProjects()
	{
		return projects;
	}

	public void setProjects(List<Project> projects)
	{
		this.projects = projects;
	}

	public List<Task> getTasks()
	{
		return tasks;
	}

	public void setTasks(List<Task> tasks)
	{
		this.tasks = tasks;
	}
	
	
}
