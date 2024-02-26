package com.virtusa.lms.controller;

import javax.servlet.http.HttpSession;
import java.util.Date;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.virtusa.lms.entity.Employee;
import com.virtusa.lms.entity.Role;
import com.virtusa.lms.entity.User;
import com.virtusa.lms.service.UserService;

@Controller
public class LoginController {
	static final Logger logger = Logger.getLogger(LoginController.class);
	@Autowired
	private UserService userService;

	public LoginController() {
		logger.info("Login Controller");
	}

	public UserService getUserInfoService() {
		return userService;
	}

	public void setUserInfoService(UserService userService) {
		this.userService = userService;
	}

	@GetMapping("/login")
	public String login() {
		return "login";
	}
	@GetMapping("/")
	public String welcome() {
		return "login";
	}
	@GetMapping("/register")
	public String register() {
		return "register";
	}

	@SuppressWarnings("deprecation")
	@PostMapping("/registerprocess")
	public String registerProcess(@ModelAttribute User user, @ModelAttribute Employee employee,
			@RequestParam("roleName") String roleName, Model model) {
		if (employee.getEmpDob().getDate() < new Date().getDate()) {
			Role role = userService.getRole(roleName);
			role.addUser(user);
			String encryptedPassword = userService.encryptPassword(user.getPassword());
			user.setPassword(encryptedPassword);
			user.setRole(role);
			user.setEmployee(employee);
			String message = userService.saveUser(user);
			model.addAttribute("message", message);
		} else {
			String msg = "Date of birth should be less than today's date";
			model.addAttribute("message", msg);
		}
		return "register";
	}

	@PostMapping("/home")
	public String home(@RequestParam("username") String userName, @RequestParam("password") String passWord,
			HttpSession session, Model model) {
		String encryptedPassword = userService.encryptPassword(passWord);
		User user = userService.getUser(userName, encryptedPassword);
		if (user != null) {
			session.setAttribute("user", user);
			session.setMaxInactiveInterval(23 * 60);
			model.addAttribute("user", user);
			if (user.getRole().getRoleId() == 1) {
				return "adminhome";
			} else if (user.getRole().getRoleId() == 2) {

				return "managerhome";
			}
			return "emphome";

		} else {
			String message = "Invalid username or password";
			model.addAttribute("error", message);
		}
		return login();
	}
}
