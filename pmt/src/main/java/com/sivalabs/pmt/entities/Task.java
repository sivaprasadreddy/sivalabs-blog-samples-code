package com.sivalabs.pmt.entities;

/**
 * @author Siva
 *
 */
public class Task
{
	private int id;
	private String title;
	private String description;
	private int projectId;
	private int assignedTo;
	private TaskStatus status;
	
	public Task()
	{
	}
	
	public Task(int id, String title, String description, int projectId, int assignedTo, TaskStatus status)
	{
		this.id = id;
		this.title = title;
		this.description = description;
		this.projectId = projectId;
		this.assignedTo = assignedTo;
		this.status = status;
	}

	public int getId()
	{
		return id;
	}
	public void setId(int id)
	{
		this.id = id;
	}
	public String getTitle()
	{
		return title;
	}
	public void setTitle(String title)
	{
		this.title = title;
	}
	public String getDescription()
	{
		return description;
	}
	public void setDescription(String description)
	{
		this.description = description;
	}
	public int getProjectId()
	{
		return projectId;
	}
	public void setProjectId(int projectId)
	{
		this.projectId = projectId;
	}
	public int getAssignedTo()
	{
		return assignedTo;
	}
	public void setAssignedTo(int assignedTo)
	{
		this.assignedTo = assignedTo;
	}
	public TaskStatus getStatus()
	{
		return status;
	}
	public void setStatus(TaskStatus status)
	{
		this.status = status;
	}
	
}
