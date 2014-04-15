package com.sivalabs.jacksondemo.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sivalabs.jacksondemo.entities.Contact;

/**
 * @author Siva
 * 
 */
public interface ContactRepository extends JpaRepository<Contact, Integer>
{

	List<Contact> findByUserId(Integer userId);

}
