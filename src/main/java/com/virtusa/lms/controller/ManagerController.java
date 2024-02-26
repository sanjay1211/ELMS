package com.virtusa.lms.controller;


import java.util.Date;
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

import com.virtusa.lms.entity.Leave;
import com.virtusa.lms.entity.LeaveBalance;
import com.virtusa.lms.service.AdminService;
import com.virtusa.lms.service.ManagerService;

@Controller
public class ManagerController {
	static final Logger logger = Logger.getLogger(ManagerController.class);
	@Autowired
	private AdminService adminService;

	@Autowired
	private ManagerService managerService;

	public ManagerService getManagerService() {
		return managerService;
	}

	public void setManagerService(ManagerService managerService) {
		this.managerService = managerService;
	}

	ManagerController() {
		logger.info("Manager Controller");
	}

	public AdminService getAdminService() {
		return adminService;
	}

	public void setAdminService(AdminService adminService) {
		this.adminService = adminService;
	}

	@GetMapping("/mngleavebalance")
	public ModelAndView mngleaveBalance() {
		ModelAndView modelview = new ModelAndView("mngrleavebalance");
		List<LeaveBalance> leaveBalaces = adminService.getLeaveBalances();
		modelview.addObject("lvbList", leaveBalaces);
		return modelview;
	}

	@GetMapping("/applylvm")
	public ModelAndView applylvm() {
		ModelAndView modelview = new ModelAndView("applyleave");
		List<LeaveBalance> leaveBalaces = adminService.getLeaveBalances();
		modelview.addObject("lvbList", leaveBalaces);
		return modelview;
	}

	@GetMapping("/lverequest")
	public ModelAndView getLeaveRequest() {
		ModelAndView modelview = new ModelAndView("mngleaveRequest");
		List<Leave> leaves = managerService.getLeaveRequest();
		modelview.addObject("leaveLst", leaves);
		return modelview;
	}

	@GetMapping("/leavestatus")
	public ModelAndView getLeaves() {
		ModelAndView modelview = new ModelAndView("leavestatus");
		List<Leave> leaves = managerService.getLeaveRequest();
		modelview.addObject("leaveLst", leaves);
		return modelview;
	}

	@SuppressWarnings("deprecation")
	@PostMapping("/applylve")
	public ModelAndView applyLeave(@ModelAttribute Leave leave, @RequestParam("empId") int empId,
			@RequestParam("lvmName") String lvmName, Model model) {
		if ((leave.getFromDate().getDate() >= new Date().getDate())
				&& (leave.getToDate().getDate() >= new Date().getDate())) {

			String message = managerService.applyLeave(leave, empId, lvmName);
			model.addAttribute("error", message);
		} else {
			String msg = "Date should not be less than today's date";
			model.addAttribute("error", msg);
		}
		return applylvm();
	}

	@GetMapping("/approveLve")
	public ModelAndView approveLvRequest(@RequestParam("lvId") int lvId, @RequestParam("empId") int empId) {
		managerService.approveLeave(lvId, empId);
		return getLeaveRequest();
	}

	@GetMapping("/rejectLve")
	public ModelAndView rejectLvRequest(@RequestParam("lvId") int lvId, @RequestParam("empId") int empId) {
		managerService.rejectLeave(lvId, empId);
		return getLeaveRequest();
	}

	@GetMapping("/cancelLve")
	public ModelAndView cancelLvRequest(@RequestParam("lvId") int lvId) {
		managerService.cancelLeave(lvId);
		return getLeaves();
	}

}
