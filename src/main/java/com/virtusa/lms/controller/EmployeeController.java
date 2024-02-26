package com.virtusa.lms.controller;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.virtusa.lms.entity.Leave;
import com.virtusa.lms.entity.LeaveBalance;
import com.virtusa.lms.service.AdminService;
import com.virtusa.lms.service.ManagerService;

@Controller
public class EmployeeController {
	static final Logger logger = Logger.getLogger(EmployeeController.class);
	@Autowired
	private AdminService adminService;

	@Autowired
	private ManagerService managerService;

	EmployeeController() {
		logger.info("Employee Controller");
	}

	public AdminService getAdminService() {
		return adminService;
	}

	public void setAdminService(AdminService adminService) {
		this.adminService = adminService;
	}

	public ManagerService getManagerService() {
		return managerService;
	}

	public void setManagerService(ManagerService managerService) {
		this.managerService = managerService;
	}

	@GetMapping("/empleavebalance")
	public ModelAndView empleaveBalance() {
		ModelAndView modelview = new ModelAndView("empleavebalance");
		List<LeaveBalance> leaveBalaces = adminService.getLeaveBalances();
		modelview.addObject("lvbList", leaveBalaces);
		return modelview;
	}

	@GetMapping("/empleavestatus")
	public ModelAndView getLeaves() {
		ModelAndView modelview = new ModelAndView("empleavestatus");
		List<Leave> leaves = managerService.getLeaveRequest();
		modelview.addObject("leaveLst", leaves);
		return modelview;
	}
	@GetMapping("/cancelempLve")
	public ModelAndView cancelLvRequest(@RequestParam("lvId") int lvId) {
		managerService.cancelLeave(lvId);
		return getLeaves();
	}
}
