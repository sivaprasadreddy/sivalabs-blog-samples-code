package com.sivalabs.phonebook.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sivalabs.phonebook.entities.Contact;

/**
 * @author Siva
 * 
 */
public interface ContactRepository extends JpaRepository<Contact, Integer>
{

}
