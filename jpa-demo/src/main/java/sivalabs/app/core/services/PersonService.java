/**
 * 
 */
package sivalabs.app.core.services;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import sivalabs.app.core.entities.Person;

/**
 * @author Siva
 *
 */
@Service
@Transactional
public class PersonService
{
	@PersistenceContext
	private EntityManager em;

	public List<Person> findAll()
	{
		TypedQuery<Person> query = em.createQuery("select p from Person p", Person.class);
		return query.getResultList();
	}

	public Person findById(int id)
	{
		try
		{
			TypedQuery<Person> query = em.createQuery("select p from Person p where p.id=?1", Person.class);
			query.setParameter(1, id);
			return query.getSingleResult();
		}
		catch (NoResultException  e)
		{
			return null;
		}
	}
	
	public Person create(Person person)
	{
		em.persist(person);
		return person;
	}
	
	
	
}
