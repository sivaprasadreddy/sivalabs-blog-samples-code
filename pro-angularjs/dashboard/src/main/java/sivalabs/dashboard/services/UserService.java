/**
 * 
 */
package sivalabs.dashboard.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import sivalabs.dashboard.entities.User;
import sivalabs.dashboard.repositories.RoleRepository;
import sivalabs.dashboard.repositories.UserRepository;

/**
 * @author Siva
 *
 */
@Service
@Transactional
public class UserService {
	
	@Autowired UserRepository userRepository;
	@Autowired RoleRepository roleRepository;
	

	public User createUser(User user)
	{
		if(checkEmailExists(user.getEmail())){
			throw new RuntimeException("Email ["+user.getEmail()+"] already exist");
		}
		return userRepository.save(user);
	}

	public User findUserById(Integer userId)
	{
		return userRepository.findOne(userId);
	}

	public List<User> findAllUsers()
	{
		return userRepository.findAll();
	}

	public boolean checkEmailExists(String email)
	{
		return userRepository.findByEmail(email) != null;
	}

	public User updateUser(User user)
	{
		return userRepository.save(user);
	}
	
	public void deleteUser(int userId) {
		userRepository.delete(userId);
	}

	public List<User> searchUsers(String query) {
		return userRepository.searchUsers(query);
	}

}
