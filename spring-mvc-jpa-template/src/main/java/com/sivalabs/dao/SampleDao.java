/**
 * 
 */
package com.sivalabs.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import com.sivalabs.model.User;

/**
 * @author Siva
 *
 */
@Repository
public class SampleDao 
{
	@PersistenceContext(type=PersistenceContextType.EXTENDED)
	private EntityManager entityManager;
	
	public String getDefaultUserGreeting() 
	{
		TypedQuery<User> query = this.entityManager.createQuery("select u from User u where u.userId=1", User.class);
		List<User> users = query.getResultList();
		if(users!=null && users.size()>0){
			return users.get(0).getName();
		}
		return "Guest";
	}
	
}
