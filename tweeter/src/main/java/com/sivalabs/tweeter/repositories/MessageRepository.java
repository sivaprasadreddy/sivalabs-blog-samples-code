package com.sivalabs.tweeter.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sivalabs.tweeter.entities.Message;

/**
 * @author Siva
 * 
 */
public interface MessageRepository extends JpaRepository<Message, Integer>
{

	List<Message> findByPostedById(int userId);

}
