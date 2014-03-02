package com.sivalabs.springdatarest.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sivalabs.springdatarest.entities.Role;

/**
 * @author Siva
 * 
 */
public interface RoleRepository extends JpaRepository<Role, Integer>
{

}
