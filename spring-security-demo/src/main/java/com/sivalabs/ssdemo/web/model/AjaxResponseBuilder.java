package com.sivalabs.ssdemo.web.model;

/**
 * @author Siva
 *
 */
public class AjaxResponseBuilder
{
	private AjaxResponse ajaxResponse;
	
	public AjaxResponseBuilder()
	{
		ajaxResponse = new AjaxResponse();
	}
	
	public AjaxResponseBuilder ok(){
		ajaxResponse.setStatus(true);
		return this;
	}
	
	public AjaxResponseBuilder notOk(){
		ajaxResponse.setStatus(false);
		return this;
	}
	
	public AjaxResponseBuilder message(String msg){
		ajaxResponse.setMessage(msg);
		return this;
	}
	
	public AjaxResponseBuilder error(String error){
		ajaxResponse.addError(error);
		return this;
	}
	
	public AjaxResponse build()
	{
		return ajaxResponse;
	}
}
