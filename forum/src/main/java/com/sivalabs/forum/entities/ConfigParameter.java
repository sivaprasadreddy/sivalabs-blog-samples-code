package com.sivalabs.forum.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * @author K. Siva Prasad Reddy
 * Date : 02-Jun-2013
 */
@Entity
@Table(name="CONFIG_PARAMS")
public class ConfigParameter implements Serializable
{
 	private static final long serialVersionUID = 1L;
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "param_id")
    private Integer id;
    @Column(name="param_name",nullable=false, unique=true)
    private String name;
    @Column(name="param_value", nullable=false)
    private String value;
    private String description;
    @Column(name="created_on")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdOn;
    @Column(name="updated_on")
    @Temporal(TemporalType.TIMESTAMP)
    private Date updatedOn;
    
    public ConfigParameter()
	{
	}
    
    public ConfigParameter(Integer id, String name, String value)
	{
		this.id = id;
		this.name = name;
		this.value = value;
	}
    
	public ConfigParameter(Integer id, String name, String value, String description)
	{
		this.id = id;
		this.name = name;
		this.value = value;
		this.description = description;
	}

	public Integer getId()
	{
		return id;
	}
	public void setId(Integer id)
	{
		this.id = id;
	}
	public String getName()
	{
		return name;
	}
	public void setName(String name)
	{
		this.name = name;
	}
	public String getValue()
	{
		return value;
	}
	public void setValue(String value)
	{
		this.value = value;
	}
	public String getDescription()
	{
		return description;
	}
	public void setDescription(String description)
	{
		this.description = description;
	}

	public Date getCreatedOn()
	{
		return createdOn;
	}

	public void setCreatedOn(Date createdOn)
	{
		this.createdOn = createdOn;
	}

	public Date getUpdatedOn()
	{
		return updatedOn;
	}

	public void setUpdatedOn(Date updatedOn)
	{
		this.updatedOn = updatedOn;
	}
	    
}
