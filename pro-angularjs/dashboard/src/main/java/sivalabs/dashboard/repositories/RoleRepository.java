package sivalabs.dashboard.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import sivalabs.dashboard.entities.Role;

/**
 * @author Siva
 * 
 */
public interface RoleRepository extends JpaRepository<Role, Integer>
{

}
