package com.sivalabs.forum.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.OrderBy;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * @author K. Siva Prasad Reddy
 * Date : 02-Jun-2013
 */
@Entity
@Table(name = "FORUMS")
public class Forum implements Serializable
{
	private static final long serialVersionUID = 1L;
	
	@Id @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "forum_id")
    private Integer id;
    @Column(nullable=false)
    private String name;
    private String description;
    @Column(name="display_order")
    private Integer order;
    @Column(name="created_on")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdOn = new Date();
    @Column(name="updated_on")
    @Temporal(TemporalType.TIMESTAMP)
    private Date updatedOn;
    
    @ManyToOne
    @JoinColumn(name="cat_id", nullable=false)
    private Category category;
    
    @OneToMany(cascade=CascadeType.ALL, mappedBy="forum")
    @OrderBy("created_on desc")
    private List<Topic> topics = new ArrayList<Topic>();
    
    
    @OneToOne(cascade=CascadeType.ALL)
    @JoinColumn(name="last_topic_id")
    private Topic lastTopic;
    /*
    @OneToOne(cascade=CascadeType.ALL)
    @JoinColumn(name="last_post_id")
    private Post lastPost;
    */
    /*
    @Column(name="last_topic_id")
    private Integer lastTopicId;
    
    @Embedded
    private LastPost lastPost;
    */
    public Forum()
	{
	}
    public Forum(Integer id)
	{
    	this.id = id;
	}
    
	public Forum(Integer id, String name, String description, Integer order)
	{
		this.id = id;
		this.name = name;
		this.description = description;
		this.order = order;
	}
	public Integer getId()
	{
		return id;
	}
	public void setId(Integer id)
	{
		this.id = id;
	}
	public Category getCategory()
	{
		return category;
	}
	public void setCategory(Category category)
	{
		this.category = category;
	}
	public String getName()
	{
		return name;
	}
	public void setName(String name)
	{
		this.name = name;
	}
	public String getDescription()
	{
		return description;
	}
	public void setDescription(String description)
	{
		this.description = description;
	}
	public Integer getOrder()
	{
		return order;
	}
	public void setOrder(Integer order)
	{
		this.order = order;
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
	public List<Topic> getTopics()
	{
		return topics;
	}
	public void setTopics(List<Topic> topics)
	{
		this.topics = topics;
	}
	/*public Integer getLastTopicId()
	{
		return lastTopicId;
	}
	public void setLastTopicId(Integer lastTopicId)
	{
		this.lastTopicId = lastTopicId;
	}
	public LastPost getLastPost()
	{
		return lastPost;
	}
	public void setLastPost(LastPost lastPost)
	{
		this.lastPost = lastPost;
	}*/
	public Topic getLastTopic() {
		return lastTopic;
	}
	public void setLastTopic(Topic lastTopic) {
		this.lastTopic = lastTopic;
	}
	/*
	public Post getLastPost() {
		return lastPost;
	}
	public void setLastPost(Post lastPost) {
		this.lastPost = lastPost;
	}
	*/
    
}
