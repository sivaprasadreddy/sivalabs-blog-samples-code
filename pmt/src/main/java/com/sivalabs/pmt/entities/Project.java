package com.sivalabs.pmt.entities;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Siva
 *
 */
public class Project
{
	private int id;
	private String name;
	private String description;
	private List<Task> tasks = new ArrayList<>();
	private List<User> team = new ArrayList<>();
	
	public Project()
	{
	}

	public Project(int id, String name, String description)
	{
		this.id = id;
		this.name = name;
		this.description = description;
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

	public String getDescription()
	{
		return description;
	}

	public void setDescription(String description)
	{
		this.description = description;
	}

	public List<Task> getTasks()
	{
		return tasks;
	}

	public void setTasks(List<Task> tasks)
	{
		this.tasks = tasks;
	}

	public List<User> getTeam()
	{
		return team;
	}

	public void setTeam(List<User> team)
	{
		this.team = team;
	}
	
}
