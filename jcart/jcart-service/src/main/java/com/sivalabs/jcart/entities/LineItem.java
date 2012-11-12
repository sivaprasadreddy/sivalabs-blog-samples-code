package com.sivalabs.jcart.entities;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 * @author Siva
 *
 */
@Entity
@Table(name="lineitem")
@XmlRootElement
public class LineItem
{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="line_item_id", unique=true, nullable=false)
	private int lineItemId;
	
	@OneToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="product_id", nullable=false)
	private Product product;
	
	@Column(nullable=false)
	private int quantity;
	
	@ManyToOne
	@JoinColumn(name="order_id", nullable=false)
	private Order order;

	public int getLineItemId()
	{
		return lineItemId;
	}

	public void setLineItemId(int lineItemId)
	{
		this.lineItemId = lineItemId;
	}

	public Product getProduct()
	{
		return product;
	}

	public void setProduct(Product product)
	{
		this.product = product;
	}

	public int getQuantity()
	{
		return quantity;
	}

	public void setQuantity(int quantity)
	{
		this.quantity = quantity;
	}
	@XmlTransient
	public Order getOrder()
	{
		return order;
	}

	public void setOrder(Order order)
	{
		this.order = order;
	}
	
	
}
