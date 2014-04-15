package com.sivalabs.tweeter.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author Siva
 * 
 */
@Entity
@Table(name = "MESSAGES")
@XmlRootElement
public class Message implements Serializable
{
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "msg_id")
	private Integer id;
	@Column(nullable = false)
	private String text;
	@Column(name = "created_on")
	@Temporal(TemporalType.TIMESTAMP)
	private Date createdOn = new Date();
	@ManyToOne
	@JoinColumn(name = "posted_by")
	private User postedBy;

	public Message()
	{
	}

	public Message(Integer id, String text)
	{
		this.id = id;
		this.text = text;
	}

	public Message(Integer id, String text, Date createdOn)
	{
		this.id = id;
		this.text = text;
		this.createdOn = createdOn;
	}

	public Message(Integer id, String text, User postedBy)
	{
		this.id = id;
		this.text = text;
		this.postedBy = postedBy;
	}

	public Integer getId()
	{
		return id;
	}

	public void setId(Integer id)
	{
		this.id = id;
	}

	public String getText()
	{
		return text;
	}

	public void setText(String text)
	{
		this.text = text;
	}

	public Date getCreatedOn()
	{
		return createdOn;
	}

	public void setCreatedOn(Date createdOn)
	{
		this.createdOn = createdOn;
	}

	public User getPostedBy()
	{
		return postedBy;
	}

	public void setPostedBy(User postedBy)
	{
		this.postedBy = postedBy;
	}

}
