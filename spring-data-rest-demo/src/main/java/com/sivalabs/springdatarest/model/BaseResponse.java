package com.sivalabs.springdatarest.model;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author Siva
 * 
 */
@XmlRootElement(name = "response")
public abstract class BaseResponse<T>
{
	private boolean success = true;
	private String message;
	private List<String> errors = new ArrayList<>();
	private T data;

	public boolean isSuccess() {
		return success;
	}

	public void setSuccess(boolean success) {
		this.success = success;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public List<String> getErrors() {
		return errors;
	}

	public void setErrors(List<String> errors) {
		this.errors = errors;
	}

	public void addError(String error) {
		getErrors().add(error);
	}
	public T getData() {
		return data;
	}
	public void setData(T data) {
		this.data = data;
	}
}
