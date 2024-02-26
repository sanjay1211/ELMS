package com.virtusa.lms.service;

import java.util.List;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.virtusa.lms.entity.Employee;
import com.virtusa.lms.entity.Leave;
import com.virtusa.lms.entity.LeaveBalance;
import com.virtusa.lms.repository.EmployeeDao;
import com.virtusa.lms.repository.LeaveDao;

@Service
public class ManagerService implements ManagerServiceInterface {
	static final Logger logger = Logger.getLogger(ManagerService.class);
	@Autowired
	private LeaveDao leaveDao;
	@Autowired
	private EmployeeDao employeeDao;

	public EmployeeDao getEmployeeDao() {
		return employeeDao;
	}

	public void setEmployeeDao(EmployeeDao employeeDao) {
		this.employeeDao = employeeDao;
	}

	public LeaveDao getLeaveDao() {
		return leaveDao;
	}

	public void setLeaveDao(LeaveDao leaveDao) {
		this.leaveDao = leaveDao;
	}

	public ManagerService() {
		super();
	}

	@SuppressWarnings("deprecation")
	public String applyLeave(Leave leave, int empId, String lvmName) {
		List<LeaveBalance> lvbs = leaveDao.getLeaveBalances();
		List<Leave> leaves = leaveDao.getLeaves();
		LeaveBalance lvb = lvbs.stream().filter(
				name -> (name.getEmp().getEmpId() == empId) && (name.getLeaveMaster().getLvmName().equals(lvmName)))
				.findAny().orElse(null);
		long diff = leave.getToDate().getTime() - leave.getFromDate().getTime();
		double noOfDays = (diff / (24 * 60 * 60 * 1000) + 1);
		double balance = 0;
		if (lvb != null) {
			balance = lvb.getBalance();
			if (noOfDays <= balance) {
				lvb.setBalance((balance - noOfDays));
				leave.setEmployee(lvb.getEmp());
				leave.setLeaveMaster(lvb.getLeaveMaster());
				leave.setNoOfDays(noOfDays);
				Leave leaveExsist = leaveExsist(leaves, leave, empId);
				if (leaveExsist != null) {
					if (((leave.getFromDate().getDate() < leaveExsist.getFromDate().getDate())
							&& (leave.getToDate().getDate() < leaveExsist.getFromDate().getDate()))
							|| ((leave.getFromDate().getDate() > leaveExsist.getToDate().getDate())
									&& (leave.getToDate().getDate() > leaveExsist.getToDate().getDate()))) {
						leaveDao.updateLvb(lvb);
						int num = leaveDao.applyLeave(leave);
						return check(num);
					}
					return "Leave already applied on that date";
				} else {
					leaveDao.updateLvb(lvb);
					int num = leaveDao.applyLeave(leave);
					return check(num);
				}
			}
		}
		return "Applied days are more than the balance";
	}

	@SuppressWarnings("deprecation")
	public Leave leaveExsist(List<Leave> leaves, Leave leave, int empId) {
		return leaves.stream()
				.filter(name -> (name.getEmployee().getEmpId() == empId)
						&& ((name.getStatus().equals("approved")) || (name.getStatus().equals("pending")))
						&& (name.getFromDate().getDate() >= leave.getFromDate().getDate()))
				.findAny().orElse(null);

	}

	public String check(int num) {
		if (num > 0) {
			return "Applied Successfully";
		}
		return "failed to apply";
	}

	public List<Leave> getLeaveRequest() {
		return leaveDao.getLeaves();
	}

	public void approveLeave(int lvId, int empId) {
		Employee emp = employeeDao.getEmp(empId);
		Leave leave = leaveDao.getLeave(lvId);
		leave.setActionBy(emp.getEmpName());
		leave.setStatus("approved");
		leaveDao.updateLeave(leave);
	}

	public void rejectLeave(int lvId, int empId) {
		List<LeaveBalance> lvbs = leaveDao.getLeaveBalances();
		Leave leave = leaveDao.getLeave(lvId);
		LeaveBalance lvb = lvbs.stream()
				.filter(name -> (name.getEmp().getEmpId() == leave.getEmployee().getEmpId())
						&& (name.getLeaveMaster().getLvmName().equals(leave.getLeaveMaster().getLvmName())))
				.findAny().orElse(null);
		Employee emp = employeeDao.getEmp(empId);
		leave.setActionBy(emp.getEmpName());
		leave.setStatus("rejected");
		if (lvb != null) {
			lvb.setBalance((leave.getNoOfDays() + lvb.getBalance()));
		}
		leaveDao.updateLvb(lvb);
		leaveDao.updateLeave(leave);
	}

	public void cancelLeave(int lvId) {
		Leave leave = leaveDao.getLeave(lvId);
		List<LeaveBalance> lvbs = leaveDao.getLeaveBalances();
		LeaveBalance lvb = lvbs.stream()
				.filter(name -> (name.getEmp().getEmpId() == leave.getEmployee().getEmpId())
						&& (name.getLeaveMaster().getLvmName().equals(leave.getLeaveMaster().getLvmName())))
				.findAny().orElse(null);

		if (lvb != null) {
			lvb.setBalance((leave.getNoOfDays() + lvb.getBalance()));
		}
		leaveDao.updateLvb(lvb);
		leaveDao.deleteLeave(leave);
	}
}
