/**
 * 
 */
package com.sivalabs.springmvc.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * @author siva
 *
 */
@Entity
public class User 
{
		
		@Id
		@GeneratedValue(strategy = GenerationType.AUTO)
		private Long userId;
		private String emailId;
		private String password;
		private String firstname;
		private String lastname;
		private String phone;
		private Date dob;
		
		public User() {
		}

		public User(Long userId, String emailId, String password,
				String firstname) {
			super();
			this.userId = userId;
			this.emailId = emailId;
			this.password = password;
			this.firstname = firstname;
		}
		
		public User(Long userId, String emailId, String password,
				String firstname, String lastname, String phone, Date dob) {
			super();
			this.userId = userId;
			this.emailId = emailId;
			this.password = password;
			this.firstname = firstname;
			this.lastname = lastname;
			this.phone = phone;
			this.dob = dob;
		}

		public Long getUserId() {
			return userId;
		}

		public void setUserId(Long userId) {
			this.userId = userId;
		}

		public String getEmailId() {
			return emailId;
		}

		public void setEmailId(String emailId) {
			this.emailId = emailId;
		}

		public String getPassword() {
			return password;
		}

		public void setPassword(String password) {
			this.password = password;
		}

		public String getFirstname() {
			return firstname;
		}

		public void setFirstname(String firstname) {
			this.firstname = firstname;
		}

		public String getLastname() {
			return lastname;
		}

		public void setLastname(String lastname) {
			this.lastname = lastname;
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
		
}
