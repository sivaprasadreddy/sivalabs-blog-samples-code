package sivalabs.dashboard.web.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import sivalabs.dashboard.entities.Role;
import sivalabs.dashboard.repositories.RoleRepository;

/**
 * @author Siva
 * 
 */
@RestController
@RequestMapping(value="/roles", produces=MediaType.APPLICATION_JSON_VALUE)
public class RoleController
{
	@Autowired
	private RoleRepository roleRepository;

	@RequestMapping(value="/", method=RequestMethod.GET)
	public List<Role> findAll() {
		return this.roleRepository.findAll();
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public Role findRole(@PathVariable("id") int id) {
		return this.roleRepository.findOne(id);
	}
	
	@RequestMapping(value="/", method=RequestMethod.POST)
	public Role createRole(Role role) {
		return this.roleRepository.save(role);
	}
	
	@RequestMapping(value="/", method=RequestMethod.PUT)
	public Role updateRole(Role role) {
		return this.roleRepository.save(role);
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.DELETE)
	public void deleteRole(@PathVariable("id") int id) {
		this.roleRepository.delete(id);
	}
	
	
	
	
}
