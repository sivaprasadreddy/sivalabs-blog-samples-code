package com.sivalabs.forum.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sivalabs.forum.entities.Role;

/**
 * @author Siva
 * 
 */
public interface RoleRepository extends JpaRepository<Role, Integer>
{

}
