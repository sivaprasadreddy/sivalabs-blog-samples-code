package sivalabs.dashboard.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import sivalabs.dashboard.entities.User;

/**
 * @author Siva
 * 
 */
public interface UserRepository extends JpaRepository<User, Integer>
{

	User findByEmail(String email);

	User findByEmailAndPassword(String email, String password);

	@Query("SELECT u FROM User u WHERE u.name LIKE %:query% or u.email LIKE %:query%")
	List<User> searchUsers(@Param("query") String query);

}
