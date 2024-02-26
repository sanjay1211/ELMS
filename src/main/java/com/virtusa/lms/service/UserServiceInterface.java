package com.virtusa.lms.service;

import com.virtusa.lms.entity.Role;
import com.virtusa.lms.entity.User;

public interface UserServiceInterface {
	public String saveUser(User user);
	public User getUser(String username, String password);
	public User getUser(String username);
	public Role getRole(String roleName);
	public String encryptPassword(String password);
}
