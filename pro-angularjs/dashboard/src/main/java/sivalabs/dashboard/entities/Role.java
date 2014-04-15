/**
 * 
 */
package sivalabs.dashboard.entities;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * @author Siva
 *
 */
@Entity
@Table(name = "ROLES")
@JsonIgnoreProperties({"users"})
public class Role implements Serializable
{
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "role_id")
	private Integer id;
	@Column(name="role_name",nullable=false)
	private String roleName;
	
	@ManyToMany(cascade=CascadeType.ALL)
    @JoinTable(name = "USERS_ROLES",
    joinColumns = {@JoinColumn(name = "ROLE_ID", referencedColumnName = "ROLE_ID")}, 
    inverseJoinColumns = {@JoinColumn(name = "USER_ID", referencedColumnName = "USER_ID")})  
	private Set<User> users;
	
	public Role() {
	}
	
	public Role(String roleName) {
		this.roleName = roleName;
	}
	public Role(Integer id, String roleName) {
		this.id = id;
		this.roleName = roleName;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getRoleName() {
		return roleName;
	}
	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public Set<User> getUsers() {
		if(users == null){
			users = new HashSet<>();
		}
		return users;
	}

	public void setUsers(Set<User> users) {
		this.users = users;
	}

}
