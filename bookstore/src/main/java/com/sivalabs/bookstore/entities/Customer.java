package com.sivalabs.bookstore.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;


/**
 *
 * @author Siva
 */
@Entity
@Table(name = "customers")
@XmlRootElement
public class Customer implements Serializable 
{
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cust_id")
    private Integer id;
    @Size(max = 100)
    @Column(name = "email", unique=true, nullable=false)
    private String email;
    @Size(max = 50)
    @Column(name = "password", nullable=false)
    private String password;
    @Size(max = 50)
    @Column(name = "firstname", nullable=false)
    private String firstName;
    @Size(max = 50)
    @Column(name = "lastname")
    private String lastName;
    @Size(max = 15)
    @Column(name = "phone")
    private String phone;
    @Column(name = "created_on")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdOn = new Date();
    @Column(name = "updated_on")
    @Temporal(TemporalType.TIMESTAMP)
    private Date updatedOn;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "customer")
    private Set<Order> orders;
    

    public Customer() {
    }

    public Customer(Integer id) {
        this.id = id;
    }
    
    public Customer(Integer id, String email, String password,
			String firstName, String lastName, String phone) {
		this.id = id;
		this.email = email;
		this.password = password;
		this.firstName = firstName;
		this.lastName = lastName;
		this.phone = phone;
	}

	public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(Date createdOn) {
        this.createdOn = createdOn;
    }

    public Date getUpdatedOn() {
        return updatedOn;
    }

    public void setUpdatedOn(Date updatedOn) {
        this.updatedOn = updatedOn;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

    public Set<Order> getOrders() {
        return orders;
    }

    public void setOrders(Set<Order> customerOrderSet) {
        this.orders = customerOrderSet;
    }

	@Override
	public String toString() {
		return "Customer [id=" + id + ", email=" + email + ", password="
				+ password + ", firstName=" + firstName + ", lastName="
				+ lastName + ", phone=" + phone + ", createdOn=" + createdOn
				+ ", updatedOn=" + updatedOn + "]";
	}
    
}
