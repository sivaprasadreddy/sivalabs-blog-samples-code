/**
 * 
 */
package com.sivalabs.sample;

/**
 * @author skatam
 *
 */
public class User
{
	private int id;
	private String userId;
	private String password;
	private String username;
	private String emailId;
	
	public User()
	{
	}

	public User(int id, String userId, String password, String username,String emailId)
	{
		this.id = id;
		this.userId = userId;
		this.password = password;
		this.username = username;
		this.emailId = emailId;
	}

	public int getId()
	{
		return id;
	}

	public void setId(int id)
	{
		this.id = id;
	}

	public String getUserId()
	{
		return userId;
	}

	public void setUserId(String userId)
	{
		this.userId = userId;
	}

	public String getPassword()
	{
		return password;
	}

	public void setPassword(String password)
	{
		this.password = password;
	}

	public String getUsername()
	{
		return username;
	}

	public void setUsername(String username)
	{
		this.username = username;
	}

	public String getEmailId()
	{
		return emailId;
	}

	public void setEmailId(String emailId)
	{
		this.emailId = emailId;
	}
	
}
