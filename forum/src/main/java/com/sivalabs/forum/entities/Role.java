/**
 * 
 */
package com.sivalabs.forum.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author Siva
 *
 */
@Entity
@Table(name = "ROLES")
public class Role implements Serializable
{
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "role_id")
	private Integer id;
	@Column(name="role_name",nullable=false)
	@Enumerated(EnumType.STRING)
	private RoleEnum roleName;
	
	public Role() {
	}
	public Role(String roleName) {
		this.roleName = RoleEnum.valueOf(roleName);
	}
	public Role(RoleEnum roleName) {
		this.roleName = roleName;
	}
	public Role(Integer id, RoleEnum roleName) {
		this.id = id;
		this.roleName = roleName;
	}
	public Role(Integer id, String roleName) {
		this.id = id;
		this.roleName = RoleEnum.valueOf(roleName);
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public RoleEnum getRoleName() {
		return roleName;
	}
	public String getRoleNameAsString() {
		return roleName.name();
	}
	public void setRoleName(RoleEnum roleName) {
		this.roleName = roleName;
	}

}
