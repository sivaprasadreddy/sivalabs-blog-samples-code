package com.sivalabs.ssdemo.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sivalabs.ssdemo.entities.Message;

/**
 * @author Siva
 * 
 */
public interface MessageRepository extends JpaRepository<Message, Integer>
{

	List<Message> findByPostedById(int userId);

}
