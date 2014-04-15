package com.sivalabs.discuzz.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sivalabs.discuzz.entities.Message;

/**
 * @author Siva
 * 
 */
public interface MessageRepository extends JpaRepository<Message, Integer>
{

	List<Message> findByPostedById(int userId);

}
