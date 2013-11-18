package com.sivalabs.pmt.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sivalabs.pmt.entities.User;
import com.sivalabs.pmt.mappers.UserMapper;

/**
 * @author Siva
 *
 */
@Service
@Transactional
public class UserService
{
	@Autowired JdbcTemplate jdbcTemplate;
	@Autowired UserMapper userMapper;
	
	public User login(String username, String password)
	{
		return userMapper.login(username, password);
	}
	
	public User findUser(int userId)
	{
		return userMapper.selectUser(userId);
	}
	
	public List<User> findAllUsers()
	{
		return userMapper.selectAllUsers();
	}
	
	public void createUser(final User user)
	{
		userMapper.createUser(user);
	}
	
	public void updateUser(User user)
	{
		//jdbcTemplate.update("update users set password=? where username=?", new Object[]{user.getPassword(), user.getUsername()});
		userMapper.updateUser(user);
		
	}
	
	public void deleteUser(int userId)
	{
		userMapper.deleteUser(userId);
		//jdbcTemplate.update("delete from users where id=?", new Object[]{userId});
	}
}
/*
class UserRowMapper implements RowMapper<User>
{

	@Override
	public User mapRow(ResultSet rs, int arg1) throws SQLException
	{
		return new User(rs.getInt("user_id"), 
						rs.getString("username"), 
						rs.getString("password"), 
						rs.getString("email")
						);
	}
	
}
*/