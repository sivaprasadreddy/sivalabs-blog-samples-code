package com.sivalabs.jcart.entities;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the customer database table.
 * 
 */
@Entity
@Table(name="customer")
public class Customer implements Serializable 
{
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="customer_id", unique=true, nullable=false)
	private int customerId;

	@Column(name="email_id", nullable=false, length=50)
	private String emailId;

	@Column(name="first_name", nullable=false, length=50)
	private String firstName;

	@Column(name="last_name", length=50)
	private String lastName;

	@Column(name="phone_number", nullable=false, length=15)
	private String phoneNumber;

    @OneToOne(cascade=CascadeType.ALL, fetch=FetchType.EAGER)
	@JoinColumn(name="address_id", nullable=false)
	private Address address;

    public Customer() {
    }

	public int getCustomerId() {
		return this.customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	public String getEmailId() {
		return this.emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getFirstName() {
		return this.firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return this.lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getPhoneNumber() {
		return this.phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public Address getAddress() {
		return this.address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}
	
}