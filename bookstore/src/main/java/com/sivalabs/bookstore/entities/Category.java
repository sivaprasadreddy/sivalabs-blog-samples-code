package com.sivalabs.bookstore.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Siva
 */
@Entity
@Table(name = "categories")
@XmlRootElement
public class Category implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cat_id")
    private Integer id;
    @Size(max = 100)
    @Column(name = "name")
    private String name;
    @Size(max = 512)
    @Column(name = "description")
    private String description;    
    @Column(name = "created_on")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdOn = new Date();
    @Column(name = "updated_on")
    @Temporal(TemporalType.TIMESTAMP)
    private Date updatedOn;
    
    @OneToMany(mappedBy = "category")
    private List<Product> products;
    
	public Category() {
    }

    public Category(Integer id) {
        this.id = id;
    }
    
    public Category(Integer id, String name, String description) {
		this.id = id;
		this.name = name;
		this.description = description;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @XmlElement(name="product")
	@XmlElementWrapper(name="products")
    public List<Product> getProducts() 
    {
    	if(products == null){
    		products = new ArrayList<Product>();
    	}
        return products;
    }
    
    public void setProducts(List<Product> products) {
        this.products = products;
    }
    public void addProduct(Product product) {
    	getProducts().add(product);
	}
    
	@Override
	public String toString() {
		return "Category [id=" + id + ", name=" + name + ", description="
				+ description + ", createdOn=" + createdOn + ", updatedOn="
				+ updatedOn + "]";
	}


    
}
