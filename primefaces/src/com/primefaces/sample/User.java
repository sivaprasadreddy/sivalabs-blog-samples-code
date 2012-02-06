package com.primefaces.sample;
import java.util.Date;

public class User
{
    private Integer userId;
    private String username;
    private String emailId;
    private String phone;
    private Date dob;
    private String gender;
    private String address;
    
    public User()
    {}
    public User(Integer userId, String username, String emailId, String phone,
            Date dob, String gender, String address)
    {
        this.userId = userId;
        this.username = username;
        this.emailId = emailId;
        this.phone = phone;
        this.dob = dob;
        this.gender = gender;
        this.address = address;
    }
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public Date getDob() {
		return dob;
	}
	public void setDob(Date dob) {
		this.dob = dob;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
    
}