/**
 * 
 */
package com.sivalabs.bo;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sivalabs.domain.User;

/**
 * @author Siva
 *
 */
@Service
@Transactional
public class UserBO 
{
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public User login(String userName, String password) 
	{
		String sql = "select * from users where username=? and password=?";
		try {
			return jdbcTemplate.queryForObject(sql, new Object[]{userName, password}, new UserRowMapper());
		} catch (EmptyResultDataAccessException e) {
			//e.printStackTrace();
			return null;
		}
	}
	
	public List<User> findAllUsers() {
		String sql = "select * from users";
		return jdbcTemplate.query(sql, new UserRowMapper());
	}
	
	public void createUser(User user) {
		
		if(checkUserNameExists(user.getUserName())){
			throw new RuntimeException("UserName [" + user.getUserName() + "] already exist");
		}
		if(checkEmailExists(user.getEmail()))
		{
			throw new RuntimeException("Email [" + user.getEmail() + "] already exist");
		}
		String sql = "insert into users(user_id, username, password, email, firstname, lastname, dob) values(?,?,?,?,?,?,?)";
		jdbcTemplate.update(sql, new Object[]{
				user.getId(),
				user.getUserName(),
				user.getPassword(),
				user.getEmail(),
				user.getFirstName(),
				user.getLastName(),
				user.getDob()!=null? new java.sql.Date(user.getDob().getTime()):null
		});
	}

	public boolean checkUserNameExists(String userName) {
		String sql = "select count(*) from users where username=?";
		int count = jdbcTemplate.queryForObject(sql, new Object[]{userName}, Integer.class);
		return (count > 0);
	}

	public boolean checkEmailExists(String email) {
		String sql = "select count(*) from users where email=?";
		int count = jdbcTemplate.queryForObject(sql, new Object[]{email}, Integer.class);
		return (count > 0);
	}
}

class UserRowMapper implements RowMapper<User>
{

	@Override
	public User mapRow(ResultSet rs, int arg1) throws SQLException {
		User user = new User();
		user.setId(rs.getInt("user_id"));
		user.setUserName(rs.getString("userName"));
		user.setPassword(rs.getString("password"));
		user.setEmail(rs.getString("email"));
		user.setFirstName(rs.getString("firstName"));
		user.setLastName(rs.getString("lastName"));
		user.setDob(rs.getDate("dob"));		
		
		return user;
	}
	
}
