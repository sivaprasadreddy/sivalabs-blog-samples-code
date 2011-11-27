/**
 * 
 */
package com.sivalabs.sample;

import java.util.Collection;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;

/**
 * @author skatam
 *
 */

public class HibernateUserDAO
{
	private SessionFactory sessionFactory;
	public void setSessionFactory(SessionFactory sessionFactory)
	{
		this.sessionFactory = sessionFactory;
	}
	
	public Integer create(User user)
	{
		this.sessionFactory.getCurrentSession().save(user);
		return user.getId();
	}
	
	public User getUserById(int id)
	{
		return (User)this.sessionFactory.getCurrentSession().get(User.class, id);
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public Collection<User> searchUsers(String name)
	{
		if(name == null){
			name = "";
		}
		name = name.trim();
		Criteria criteria = this.sessionFactory.getCurrentSession().createCriteria(User.class);
		criteria.add(Restrictions.like("username", "%"+name+"%"));
		List list = criteria.list();
		return list;
	}
	public void update(User user)
	{
		this.sessionFactory.getCurrentSession().saveOrUpdate(user);
	}
	public void delete(int id)
	{
		User user = this.getUserById(id);
		if(user != null)
		{
			this.sessionFactory.getCurrentSession().delete(user);
		}
	}

	@SuppressWarnings("rawtypes")
	public User login(String userId, String password)
	{
		Criteria criteria = this.sessionFactory.getCurrentSession().createCriteria(User.class);
		criteria.add(Restrictions.eq("userId", userId));
		criteria.add(Restrictions.eq("password", password));
		List list = criteria.list();
		if(list !=null && list.size() >0){
			return (User) list.get(0);
		}		
		return null;
	}

	public void deleteAllUsers()
	{
		Query query = this.sessionFactory.getCurrentSession().createQuery("delete from User");
		query.executeUpdate();
	}
}


