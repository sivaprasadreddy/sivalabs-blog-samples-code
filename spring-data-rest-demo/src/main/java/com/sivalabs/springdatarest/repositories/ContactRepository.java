package com.sivalabs.springdatarest.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sivalabs.springdatarest.entities.Contact;

/**
 * @author Siva
 * 
 */
public interface ContactRepository extends JpaRepository<Contact, Integer>
{

}
