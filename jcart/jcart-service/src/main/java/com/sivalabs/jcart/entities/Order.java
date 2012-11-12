package com.sivalabs.jcart.entities;

import java.util.Date;
import java.util.Set;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author Siva
 *
 */
@Entity
@Table(name="orders")
@XmlRootElement
public class Order
{
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="order_id", unique=true, nullable=false)
	private long orderId;

    @Temporal( TemporalType.TIMESTAMP)
	@Column(name="created_on", nullable=false)
	private Date createdOn;

	@Column(length=50)
	private String status;

    @Temporal( TemporalType.TIMESTAMP)
	@Column(name="updated_on", nullable=false)
	private Date updatedOn;
    
    @OneToOne(fetch=FetchType.EAGER, cascade=CascadeType.ALL)
	@JoinColumn(name="customer_id", nullable=false)
    private Customer customer;
    
    @OneToOne(fetch=FetchType.EAGER, cascade=CascadeType.ALL)
	@JoinColumn(name="receiver_id", nullable=false)
    private Customer receiver;
    
    @OneToMany(cascade=CascadeType.ALL, mappedBy="order")
    private Set<LineItem> lineItems;

	public long getOrderId()
	{
		return orderId;
	}

	public void setOrderId(long orderId)
	{
		this.orderId = orderId;
	}

	public Date getCreatedOn()
	{
		return createdOn;
	}

	public void setCreatedOn(Date createdOn)
	{
		this.createdOn = createdOn;
	}

	public String getStatus()
	{
		return status;
	}

	public void setStatus(String status)
	{
		this.status = status;
	}

	public Date getUpdatedOn()
	{
		return updatedOn;
	}

	public void setUpdatedOn(Date updatedOn)
	{
		this.updatedOn = updatedOn;
	}

	public Customer getCustomer()
	{
		return customer;
	}

	public void setCustomer(Customer customer)
	{
		this.customer = customer;
	}

	public Customer getReceiver()
	{
		return receiver;
	}

	public void setReceiver(Customer receiver)
	{
		this.receiver = receiver;
	}

	public Set<LineItem> getLineItems()
	{
		return lineItems;
	}

	public void setLineItems(Set<LineItem> lineItems)
	{
		this.lineItems = lineItems;
	}
    
    
    
}
