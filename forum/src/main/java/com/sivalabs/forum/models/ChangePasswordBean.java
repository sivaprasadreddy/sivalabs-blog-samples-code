/**
 * 
 */
package com.sivalabs.forum.models;

import java.io.Serializable;

/**
 * @author Siva
 *
 */
public class ChangePasswordBean implements Serializable
{
	private static final long serialVersionUID = 1L;
	private String email;
	private String oldPwd;
	private String newPwd;
	private String confPwd;
	
	public ChangePasswordBean() {
	}

	public ChangePasswordBean(String email, String oldPwd, String newPwd, String confPwd) {
		this.email = email;
		this.oldPwd = oldPwd;
		this.newPwd = newPwd;
		this.confPwd = confPwd;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getOldPwd() {
		return oldPwd;
	}

	public void setOldPwd(String oldPwd) {
		this.oldPwd = oldPwd;
	}

	public String getNewPwd() {
		return newPwd;
	}

	public void setNewPwd(String newPwd) {
		this.newPwd = newPwd;
	}

	public String getConfPwd() {
		return confPwd;
	}

	public void setConfPwd(String confPwd) {
		this.confPwd = confPwd;
	}
	
}
