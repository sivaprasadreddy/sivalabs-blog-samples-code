package com.sivalabs.tweeter.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sivalabs.tweeter.entities.Message;
import com.sivalabs.tweeter.repositories.MessageRepository;
import com.sivalabs.tweeter.repositories.UserRepository;

/**
 * @author Siva
 * 
 */
@Service
@Transactional
public class MessageService
{
	@Autowired
	private UserRepository userRepository;

	@Autowired
	private MessageRepository messageRepository;

	public List<Message> getAllMessages()
	{
		return messageRepository.findAll(new Sort(Sort.Direction.DESC, "createdOn"));
	}

	public List<Message> getAllMessages(int size)
	{
		return getAllMessages(1, size);
	}

	public List<Message> getAllMessages(int page, int size)
	{
		Pageable pageable = new PageRequest(page, size, new Sort(Sort.Direction.DESC, "createdOn"));
		return messageRepository.findAll(pageable).getContent();
	}

	public void createMessage(Message msg)
	{
		messageRepository.save(msg);
	}

	public List<Message> getMessagesByUser(int userId)
	{
		return messageRepository.findByPostedById(userId);
	}

}
