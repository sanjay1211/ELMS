package com.virtusa.lms.repository;

import java.util.List;
import com.virtusa.lms.entity.Role;
import com.virtusa.lms.entity.User;

public interface UserDaoInterface {
	public int saveUser(User user);
	public User checkUser(String username);
	public List<Role> getAllRoles();
	public User validateUser(String username, String password);
}
