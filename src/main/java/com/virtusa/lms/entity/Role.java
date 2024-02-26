package com.virtusa.lms.entity;


import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@SuppressWarnings("serial")
@Entity
@Table(name = "roles")
public class Role implements Serializable {

	@Id
	@GeneratedValue
	@Column(name = "roleId")
	private int roleId;
	@Column(name = "roleName",nullable = false,length = 20)
	private String roleName;
	@OneToMany(mappedBy = "role", fetch = FetchType.EAGER)
	private List<User> users=new ArrayList<>();
	
	public List<User> getUsers() {
		return users;
	}
	public Role() {
		
	}
	public void setUsers(List<User> users) {
		this.users = users;
	}

	public Role(int roleId, String roleName) {
		super();
		this.roleId = roleId;
		this.roleName = roleName;
	}

	public Role(String roleName) {
		super();
		this.roleName = roleName;
	}

	public Role(int roleId) {
		super();
		this.roleId = roleId;
	}

	public int getRoleId() {
		return roleId;
	}

	public void setRoleId(int roleId) {
		this.roleId = roleId;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}
	public void addUser(User user) {
		this.users.add(user);
	}
}
