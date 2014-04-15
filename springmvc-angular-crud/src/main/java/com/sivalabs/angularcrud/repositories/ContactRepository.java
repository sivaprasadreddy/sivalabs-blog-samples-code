package com.sivalabs.angularcrud.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sivalabs.angularcrud.entities.Contact;

/**
 * @author Siva
 * 
 */
public interface ContactRepository extends JpaRepository<Contact, Integer>
{

}
