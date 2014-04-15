package com.sivalabs.forum.rest.model;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author Siva
 *
 */
@XmlRootElement(name="response")
public class AjaxResponse<T>
{
	private boolean status=true;
	private String message;
	private List<String> errors;
	private T data;
	
	public boolean isStatus()
	{
		return status;
	}
	public void setStatus(boolean status)
	{
		this.status = status;
	}
	public String getMessage()
	{
		return message;
	}
	public void setMessage(String message)
	{
		this.message = message;
	}
	
	public List<String> getErrors()
	{
		if(errors == null){
			errors = new ArrayList<>();
		}
		return errors;
	}
	public void setErrors(List<String> errors)
	{
		this.errors = errors;
	}
	
	public void addError(String error)
	{
		getErrors().add(error);
	}
	public T getData() {
		return data;
	}
	public void setData(T data) {
		this.data = data;
	}
	
}
