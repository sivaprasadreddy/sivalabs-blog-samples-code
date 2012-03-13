/**
 * 
 */
package com.sivalabs.springmvc.web.forms;

/**
 * @author skatam
 *
 */
public class ChangePwdForm {
	private Integer userId;
	private String currentPwd;
	private String newPwd;
	private String confirmPwd;
	
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public String getCurrentPwd() {
		return currentPwd;
	}
	public void setCurrentPwd(String currentPwd) {
		this.currentPwd = currentPwd;
	}
	public String getNewPwd() {
		return newPwd;
	}
	public void setNewPwd(String newPwd) {
		this.newPwd = newPwd;
	}
	public String getConfirmPwd() {
		return confirmPwd;
	}
	public void setConfirmPwd(String confirmPwd) {
		this.confirmPwd = confirmPwd;
	}
	
}
