package com.sivalabs.ssdemo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sivalabs.ssdemo.entities.Role;

/**
 * @author Siva
 * 
 */
public interface RoleRepository extends JpaRepository<Role, Integer>
{

}
