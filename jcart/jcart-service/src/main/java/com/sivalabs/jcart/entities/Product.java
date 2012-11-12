package com.sivalabs.jcart.entities;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.MapKeyColumn;
import javax.persistence.Table;


/**
 * The persistent class for the book database table.
 * 
 */
@Entity
@Table(name="product")
public class Product implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="product_id", unique=true, nullable=false)
	private int productId;
	@Column(name="product_name", unique=true, nullable=false)
	private String productName;
	private String description;
	private BigDecimal price;	

	@ElementCollection
    @MapKeyColumn(name="name")
    @Column(name="value")
    @CollectionTable(name="product_attributes", joinColumns=@JoinColumn(name="product_id"))    
	private Map<String, String> attributes = new HashMap<String, String>();
	
    public Product() {
    }

	public int getProductId()
	{
		return productId;
	}

	public void setProductId(int productId)
	{
		this.productId = productId;
	}

	public String getProductName()
	{
		return productName;
	}

	public void setProductName(String productName)
	{
		this.productName = productName;
	}

	public String getDescription()
	{
		return description;
	}

	public void setDescription(String description)
	{
		this.description = description;
	}

	public BigDecimal getPrice()
	{
		return price;
	}

	public void setPrice(BigDecimal price)
	{
		this.price = price;
	}

	public Map<String, String> getAttributes()
	{
		return attributes;
	}

	public void setAttributes(Map<String, String> attributes)
	{
		this.attributes = attributes;
	}
	public void setAttribute(String name, String value)
	{
		this.attributes.put(name, value);
	}
	
	
}