package com.sivalabs.jcart.entities;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author Siva
 *
 */
@Entity
@Table(name="inventory")
@XmlRootElement
public class Inventory
{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="inventory_id", unique=true, nullable=false)
	private int inventoryId;
	
	@ManyToOne
	@JoinColumn(name="product_id", nullable=false)
	private Product product;
	
	@Column(name="stock_level", nullable=false)
	private long stockLevel;

	public int getInventoryId()
	{
		return inventoryId;
	}

	public void setInventoryId(int inventoryId)
	{
		this.inventoryId = inventoryId;
	}

	public Product getProduct()
	{
		return product;
	}

	public void setProduct(Product product)
	{
		this.product = product;
	}

	public long getStockLevel()
	{
		return stockLevel;
	}

	public void setStockLevel(long stockLevel)
	{
		this.stockLevel = stockLevel;
	}
	
	
}
