package com.virtusa.lms.service;

import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.virtusa.lms.entity.Role;
import com.virtusa.lms.entity.User;
import com.virtusa.lms.repository.UserDao;

@Service
public class UserService implements UserServiceInterface {
	static final  Logger logger = Logger.getLogger(UserService.class);
	@Autowired
	private UserDao userDao;

	public UserDao getUserInfoDao() {
		return userDao;
	}

	public void setUserInfoDao(UserDao userInfoDao) {
		this.userDao = userInfoDao;
	}

	public String saveUser(User user) {
		int num = 0;
		try {

			User exsistingUser = userDao.checkUser(user.getUsername());
			if (exsistingUser == null) {
				num = userDao.saveUser(user);
				if (num > 0) {
					return "Registered Successfully and now Login";
				} else {
					return "Registration UnSuccessfull..!";
				}
			}
			return "User Name already exsist..Register with different username";
		} catch (Exception ex) {
			return null;
		}
	}
	
	public User getUser(String username, String password) {
		try {
			User user = userDao.validateUser(username, password);
			if (user != null) {
				return user;
			}
		} catch (Exception ex) {
			logger.error(ex);
		}

		return null;
	}
	
	public User getUser(String username) {
		try {
			User user =userDao.checkUser(username);
			if (user != null) {
				return user;
			}
		} catch (Exception ex) {
			logger.error(ex);
		}

		return null;
	}

	public Role getRole(String roleName) {
		List<Role> roles = userDao.getAllRoles();
		return roles.stream().filter(name -> name.getRoleName().equals(roleName)).findAny().orElse(null);
	}

	public String encryptPassword(String password) {
		String encryptedPassword = "";
		try {
			MessageDigest messageDigest = MessageDigest.getInstance("SHA-256");
			byte[] hashBytes = messageDigest.digest(password.getBytes(StandardCharsets.UTF_8));
			BigInteger noHash = new BigInteger(1, hashBytes);
			encryptedPassword = noHash.toString(16);
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}

		return encryptedPassword;
	}

}
