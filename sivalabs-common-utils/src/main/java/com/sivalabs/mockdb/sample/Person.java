/**
*
*
*/
package com.sivalabs.mockdb.sample;

import java.util.Date;

import com.sivalabs.mockdb.Identifiable;

public class Person implements Identifiable<Integer>
{
	private static final long serialVersionUID = 1L;
	private Integer id;
	private String email;
	private String password;
	private String firstName;
	private String lastName;
	private Date dob;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public Date getDob() {
		return dob;
	}
	public void setDob(Date dob) {
		this.dob = dob;
	}
	
	
	public static class PersonBuilder 
	{
		private Person p;
		private PersonBuilder(Person p) {
			this.p = p;
		}
		public static PersonBuilder create(){
			return new PersonBuilder(new Person());
		}
		public Person build(){
			return this.p;
		}
		public PersonBuilder id(Integer id){
			this.p.id = id; return this;
		}
		public PersonBuilder email(String email){
			this.p.email= email; return this;
		}
		public PersonBuilder password(String password){
			this.p.password= password; return this;
		}
		public PersonBuilder firstName(String firstName){
			this.p.firstName= firstName; return this;
		}
		public PersonBuilder lastName(String lastName){
			this.p.lastName= lastName; return this;
		}
		public PersonBuilder dob(Date dob){
			this.p.dob= dob; return this;
		}
	}
}
