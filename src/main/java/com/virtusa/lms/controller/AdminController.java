package com.virtusa.lms.controller;

import java.util.List;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import com.virtusa.lms.entity.Employee;
import com.virtusa.lms.entity.Leave;
import com.virtusa.lms.entity.LeaveBalance;
import com.virtusa.lms.entity.LeaveMaster;
import com.virtusa.lms.entity.Role;
import com.virtusa.lms.entity.User;
import com.virtusa.lms.service.AdminService;
import com.virtusa.lms.service.ManagerService;
import com.virtusa.lms.service.UserService;

@Controller
public class AdminController {
	static final Logger logger = Logger.getLogger(AdminController.class);
	@Autowired
	private AdminService adminService;
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private ManagerService managerService;
	
	public UserService getUserService() {
		return userService;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	public ManagerService getManagerService() {
		return managerService;
	}

	public void setManagerService(ManagerService managerService) {
		this.managerService = managerService;
	}

	public AdminService getAdminService() {
		return adminService;
	}

	public void setAdminService(AdminService adminService) {
		this.adminService = adminService;
	}

	public AdminController() {
		logger.info("Admin Controller");
	}
	
	@GetMapping("/addemployee")
	public String addEmp() {
		return "addemployee";
	}
	@GetMapping("/addleave")
	public String addLvm() {
		return "addleave";
	}
	@GetMapping("/viewemployees")
	public ModelAndView viewEmp() {
		ModelAndView modelview=new ModelAndView("viewemployees");
		List<Employee> employees=adminService.getAllEmployees();
		modelview.addObject("empList",employees);
		return modelview;
	}
	
	
	@GetMapping("/viewleaves")
	public ModelAndView viewLvms() {
		ModelAndView modelview=new ModelAndView("viewleaves");
		List<LeaveMaster> leaveMasters=adminService.getLeaveMasters();
		modelview.addObject("lvmList",leaveMasters);
		return modelview;
	}
	@GetMapping("/viewleavbalances")
	public ModelAndView viewlvbs() {
		ModelAndView modelview=new ModelAndView("viewleavbalances");
		List<LeaveBalance> leaveBalaces=adminService.getLeaveBalances();
		modelview.addObject("lvbList",leaveBalaces);
		return modelview;
	}
	
	@PostMapping("/saveemp")
	public String registerProcess(@ModelAttribute User user, @ModelAttribute Employee employee,
			@RequestParam("roleName") String roleName, Model model) {
		Role role = userService.getRole(roleName);
		role.addUser(user);
		String encryptedPassword=userService.encryptPassword(user.getPassword()); 
		user.setPassword(encryptedPassword);
		user.setRole(role);
		user.setEmployee(employee);
		String message = adminService.saveUser(user);
		model.addAttribute("message", message);
		return "addemployee";
	}
	
	@PostMapping("/saveleave")
	public String addLeave(@ModelAttribute LeaveMaster leaveMaster, Model model) {
		String message = adminService.saveLeave(leaveMaster);
		model.addAttribute("message", message);
		return "addleave";
	}
	
	@GetMapping("/deleteEmp")
	public ModelAndView deleteEmp(@RequestParam("empId") int empId) {
		adminService.deleteEmp(empId);
		return viewEmp();
	}

	@GetMapping("/deletelvm")
	public ModelAndView deleteLvm(@RequestParam("lvmId") int lvmId) {
		adminService.deleteLvm(lvmId);
		return viewLvms();
	}
	
	@GetMapping("/editEmp")
	public String editEmp(@RequestParam("empId") int empId, Model model) {
		Employee employee=adminService.getEmp(empId);
		model.addAttribute("emp",employee);
		return "editemployee";
	}
	
	@GetMapping("/myProfile")
	public String profile(@RequestParam("empId") int empId, Model model) {
		Employee employee=adminService.getEmp(empId);
		model.addAttribute("emp",employee);
		return "profile";
	}
	
	@PostMapping("/updateEmp")
	public ModelAndView updateEmp(@ModelAttribute Employee employee,
			@RequestParam("roleName") String roleName,@RequestParam("username") String username) {
		Role role = userService.getRole(roleName);
		User user=userService.getUser(username);
		int mngId=user.getEmployee().getManagerId();
		employee.setManagerId(mngId);
		role.addUser(employee.getUser());
		user.setRole(role);
		user.setEmployee(employee);
		adminService.updateUser(user);
		return viewEmp();
	}
	@GetMapping("/empsundermng")
	public ModelAndView empsUderMng() {
		ModelAndView modelview = new ModelAndView("empsundermng");
		List<Employee> employees = adminService.getAllEmployees();
		modelview.addObject("empList", employees);
		return modelview;
	}
	
	@PostMapping("/updateProfile")
	public ModelAndView updateProfile(@ModelAttribute Employee employee,@RequestParam("username") String username,@RequestParam("roleName") String roleName) {
		Role role = userService.getRole(roleName);
		User user=userService.getUser(username);
		int mngId=user.getEmployee().getManagerId();
		employee.setManagerId(mngId);
		role.addUser(employee.getUser());
		user.setRole(role);
		user.setEmployee(employee);
		adminService.updateUser(user);
		if(user.getRole().getRoleId()==2) {
			return empsUderMng();
		}
		return viewEmp();
	}
	
	@GetMapping("/editlvm")
	public String editLvm(@RequestParam("lvmId") int lvmId, Model model) {
		LeaveMaster lvm=adminService.getLvm(lvmId);
		model.addAttribute("lvm",lvm);
		return "editlvm";
	}
	
	@PostMapping("/updatelvm")
	public ModelAndView updateLeave(@ModelAttribute LeaveMaster leaveMaster) {
		adminService.updateLeave(leaveMaster);
		return viewLvms();
		
	}
	
	@GetMapping("/assignmng")
	public ModelAndView assignmanager() {
		ModelAndView modelview=new ModelAndView("assignmanager");
		List<Employee> employees=adminService.getAllEmployees();
		modelview.addObject("emplist",employees);
		return modelview;
	}
	
	@PostMapping("/updateasign")
	public ModelAndView assignMng(@RequestParam("names") List<String> empNames,@RequestParam("manager") String managerName) {
		String message=adminService.assignMng(empNames,managerName);
		ModelAndView modelview=new ModelAndView("assignmanager");
		List<Employee> employees=adminService.getAllEmployees();
		modelview.addObject("emplist",employees);
		modelview.addObject("error",message);
		return modelview;
		
	}
	
	@GetMapping("/addbalance")
	public ModelAndView addBalance() {
		ModelAndView modelNview=new ModelAndView("addleavebalance");
		List<Employee> empList=adminService.getAllEmployees();
		List<LeaveMaster> lvmList=adminService.getLeaveMasters();
		modelNview.addObject("empyList",empList);
		modelNview.addObject("lvmList",lvmList);
		return modelNview;
	}
	
	@PostMapping(path = "/savelvb")
	public ModelAndView uppdateLvb(@RequestParam("names") List<String> empNames,@RequestParam("lvm") String lvmName,@ModelAttribute LeaveBalance leaveBalance,Model model) {
		String message=adminService.saveLvb(empNames, lvmName, leaveBalance);
		model.addAttribute("error",message);
		return addBalance();
		
	}
	@GetMapping("/deleteLvb")
	public ModelAndView deleteLvb(@RequestParam("lvbId") int lvbId) {
		adminService.deleteLvb(lvbId);
		return viewlvbs();
	}
	
	@GetMapping("/adminlverequest")
	public ModelAndView getLeaveRequest() {
		ModelAndView modelview = new ModelAndView("viewleaverequest");
		List<Leave> leaves = managerService.getLeaveRequest();
		List<Employee> empList=adminService.getAllEmployees();
		modelview.addObject("leaveLst", leaves);
		modelview.addObject("empyList",empList);
		return modelview;
	}
}
