package com.sivalabs.jcart.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;


/**
 * The persistent class for the address database table.
 * 
 */
@Entity
@Table(name="address")
@XmlRootElement
public class Address implements Serializable 
{
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="addr_id", unique=true, nullable=false)
	private int addrId;

	@Column(nullable=false, length=50)
	private String city;

	@Column(nullable=false, length=50)
	private String country;

	@Column(nullable=false, length=50)
	private String state;

	@Column(nullable=false, length=50)
	private String street;

	@Column(name="zip_code", nullable=false, length=10)
	private String zipCode;

    public Address() {
    }

	public int getAddrId() {
		return this.addrId;
	}

	public void setAddrId(int addrId) {
		this.addrId = addrId;
	}

	public String getCity() {
		return this.city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getCountry() {
		return this.country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getState() {
		return this.state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getStreet() {
		return this.street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getZipCode() {
		return this.zipCode;
	}

	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}

}