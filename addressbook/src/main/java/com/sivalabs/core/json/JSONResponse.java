package com.sivalabs.core.json;

import java.util.ArrayList;
import java.util.List;


public class JSONResponse<T>
{
	private boolean success = true;
	private String errorCode;
	private String errorMsg;
	private T data;
	
	private List<FieldError> errors = new ArrayList<FieldError>();
	
	public JSONResponse(){ }
	public JSONResponse(T data){this.data = data;}
	
	public boolean isSuccess() {return success; }
	public String getErrorCode(){return errorCode;}
	public void setErrorCode(String errorCode){this.errorCode = errorCode;}
	public String getErrorMsg(){return errorMsg;}
	public T getData(){return data;}
	public void setSuccess(boolean success){this.success = success;}
	public void setErrorMsg(String errorMsg){this.errorMsg = errorMsg;}
	public void setData(T data){this.data = data;}
	public List<FieldError> getErrors(){return errors;}
	public void addErrors(List<FieldError> errors){this.errors.addAll(errors);}
	public void addFieldError(FieldError error){this.errors.add(error);	}
	public void addFieldError(String fieldId, String fieldError)
	{this.errors.add(new FieldError(fieldId, fieldError));}
	
	
}
