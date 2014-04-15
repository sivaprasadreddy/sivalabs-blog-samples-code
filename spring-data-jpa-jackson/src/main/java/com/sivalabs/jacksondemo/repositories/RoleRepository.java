package com.sivalabs.jacksondemo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sivalabs.jacksondemo.entities.Role;

/**
 * @author Siva
 * 
 */
public interface RoleRepository extends JpaRepository<Role, Integer>
{

}
