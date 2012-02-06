package com.sivalabs.core.json;

/**
 * @author skatam
 *
 */
public class FieldError
{
	private String id;
	private String msg;
	
	public FieldError(String id, String msg)
	{
		this.id = id;
		this.msg = msg;
	}
	public String getId(){return id;}
	public String getMsg(){return msg;}
}
