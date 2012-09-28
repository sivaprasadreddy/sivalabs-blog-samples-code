#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
/**
 * 
 */
package ${package}.service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ${package}.LinkshareException;
import ${package}.entities.User;

/**
 * @author Siva
 *
 */
@Service
@Transactional
public class UserService
{
	@PersistenceContext
	private EntityManager em;
	
	public void createUser(User user)
	{
		TypedQuery<Long> query = em.createQuery("select count(u) from User u where u.userName=?1", Long.class);
		query.setParameter(1, user.getUserName());
		Long count = query.getSingleResult();
		if(count>0){
			throw new LinkshareException("UserName already in use.");
		}
		query = em.createQuery("select count(u) from User u where u.emailId=?1", Long.class);
		query.setParameter(1, user.getEmailId());
		count = query.getSingleResult();
		if(count>0){
			throw new LinkshareException("EmailId already in use.");
		}
		em.persist(user);
	}
	
	/**
	 * LoginId can be UserName or EmailId
	 */
	public User login(String loginId, String pwd)
	{
		TypedQuery<User> query = em.createQuery("select u from User u " +
								"where (u.userName=:loginId or u.emailId=:loginId) " +
								"		and u.password=:password", User.class);
		query.setParameter("loginId", loginId);
		query.setParameter("password", pwd);
		try
		{
			User user = query.getSingleResult();
			return user;
		} catch (Exception e)
		{
			return null;
		}
		
	}
	
	public User getUserById(Long userId)
	{
		TypedQuery<User> query = em.createQuery("select u from User u where u.userId=:userId ", User.class);
		query.setParameter("userId", userId);
		try
		{
			User user = query.getSingleResult();
			return user;
		} catch (Exception e)
		{
			return null;
		}
	}
	public User getUserByName(String userName)
	{
		TypedQuery<User> query = em.createQuery("select u from User u where u.userName=:userName ", User.class);
		query.setParameter("userName", userName);
		try
		{
			User user = query.getSingleResult();
			return user;
		} catch (Exception e)
		{
			return null;
		}
	}
	public User getUserByEmail(String emailId)
	{
		TypedQuery<User> query = em.createQuery("select u from User u where u.emailId=:emailId ", User.class);
		query.setParameter("emailId", emailId);
		try
		{
			User user = query.getSingleResult();
			return user;
		} catch (Exception e)
		{
			return null;
		}
	}
}
