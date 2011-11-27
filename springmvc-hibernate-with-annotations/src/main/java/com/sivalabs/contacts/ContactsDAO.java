package com.sivalabs.contacts;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author SivaLabs
 *
 */
@Repository
@Transactional
public class ContactsDAO
{
	@Autowired
	private SessionFactory sessionFactory;
	
	public Contact getById(int id)
	{
		return (Contact) sessionFactory.getCurrentSession().get(Contact.class, id);
	}
	
	@SuppressWarnings("unchecked")
	public List<Contact> searchContacts(String name)
	{
		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(Contact.class);
		criteria.add(Restrictions.ilike("name", name+"%"));
		return criteria.list();
	}
	
	@SuppressWarnings("unchecked")
	public List<Contact> getAllContacts()
	{
		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(Contact.class);
		return criteria.list();
	}
	
	public int save(Contact contact)
	{
		return (Integer) sessionFactory.getCurrentSession().save(contact);
	}
	
	public void update(Contact contact)
	{
		sessionFactory.getCurrentSession().merge(contact);
	}
	
	public void delete(int id)
	{
		Contact c = getById(id);
		sessionFactory.getCurrentSession().delete(c);
	}

}
