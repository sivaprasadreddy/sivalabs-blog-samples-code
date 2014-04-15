package com.sivalabs.forum.rest.model;

/**
 * @author Siva
 *
 */
public class AjaxResponseBuilder<T>
{
	private AjaxResponse<T> ajaxResponse;
	
	public AjaxResponseBuilder()
	{
		ajaxResponse = new AjaxResponse<T>();
	}
	
	public AjaxResponseBuilder<T> ok(){
		ajaxResponse.setStatus(true);
		return this;
	}
	
	public AjaxResponseBuilder<T> notOk(){
		ajaxResponse.setStatus(false);
		return this;
	}
	
	public AjaxResponseBuilder<T> message(String msg){
		ajaxResponse.setMessage(msg);
		return this;
	}
	
	public AjaxResponseBuilder<T> error(String error){
		ajaxResponse.addError(error);
		return this;
	}
	
	public AjaxResponse<T> build()
	{
		return ajaxResponse;
	}
}
