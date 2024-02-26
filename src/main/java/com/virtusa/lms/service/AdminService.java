package com.virtusa.lms.service;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.virtusa.lms.entity.Employee;
import com.virtusa.lms.entity.LeaveBalance;
import com.virtusa.lms.entity.LeaveMaster;
import com.virtusa.lms.entity.User;
import com.virtusa.lms.repository.EmployeeDao;
import com.virtusa.lms.repository.LeaveDao;
import com.virtusa.lms.repository.UserDao;

@Service
public class AdminService implements AdminServiceInterface {
	static final  Logger logger = Logger.getLogger(AdminService.class);
	@Autowired
	private EmployeeDao employeeDao;

	@Autowired
	private LeaveDao leaveDao;

	@Autowired
	private UserDao userDao;

	public UserDao getUserDao() {
		return userDao;
	}

	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

	public LeaveDao getLeaveDao() {
		return leaveDao;
	}

	public void setLeaveDao(LeaveDao leaveDao) {
		this.leaveDao = leaveDao;
	}

	public EmployeeDao getEmployeeDao() {
		return employeeDao;
	}

	public void setEmployeeDao(EmployeeDao employeeDao) {
		this.employeeDao = employeeDao;
	}

	public List<Employee> getAllEmployees() {
		return employeeDao.getAllEmployees();
	}

	public List<LeaveMaster> getLeaveMasters() {
		return leaveDao.getLeaveMasters();
	}

	public void deleteEmp(int empId) {
		employeeDao.deleteEmp(empId);
	}

	public void deleteLvb(int lvbId) {
		leaveDao.deleteLvb(lvbId);
	}

	public void deleteLvm(int lvmId) {
		leaveDao.deleteLvm(lvmId);
	}

	public String saveLeave(LeaveMaster leaveMaster) {
		int num = 0;
		LeaveMaster exsistingLeaveMaster = null;
		try {
			exsistingLeaveMaster = leaveDao.checkLvm(leaveMaster.getLvmName(), leaveMaster.getLvmAbbr());
			if (exsistingLeaveMaster == null) {
				num = leaveDao.saveLeaveMaster(leaveMaster);
				if (num > 0) {
					return "Leave Addded Successfully";
				} else {
					return "UnSuccessful";
				}
			}
			return "Leave type already exsist";
		} catch (Exception ex) {
			logger.error(ex);
			return null;
		}
	}

	public Employee getEmp(int empId) {
		return employeeDao.getEmp(empId);
	}

	public void updateUser(User user) {
		employeeDao.updateUser(user);
	}

	public LeaveMaster getLvm(int lvmId) {
		return leaveDao.getLvm(lvmId);
	}

	public void updateLeave(LeaveMaster lvm) {
		leaveDao.updateLeave(lvm);
	}

	public String assignMng(List<String> empNames, String mngName) {
		List<Employee> employees = employeeDao.getAllEmployees();
		Employee emp;
		Employee manager = employees.stream().filter(name -> name.getEmpName().equals(mngName)).findAny().orElse(null);
		for (String empName : empNames) {

			emp = employees.stream().filter(name -> name.getEmpName().equals(empName)).findAny().orElse(null);
			if (emp != null && manager != null && manager.getEmpId() != emp.getEmpId()) {
				emp.setManagerId(manager.getEmpId());

			} else {
				return "Can't assign manager to himself";
			}
			employeeDao.updateEmp(emp);

		}
		return "Assigned Successfully";
	}

	public String saveLvb(List<String> empNames, String lvmName, LeaveBalance lvb) {
		int exe = 0;
		List<Employee> employees = employeeDao.getAllEmployees();
		List<LeaveBalance> lvbs = leaveDao.getLeaveBalances();
		LeaveMaster lvm = leaveDao.getLvm(lvmName);
		lvm.addLeaveBalance(lvb);
		if (lvb.getBalance() <= lvm.getMaxBalance()) {
			Employee emp;
			for (String empName : empNames) {

				emp = employees.stream().filter(name -> name.getEmpName().equals(empName)).findAny().orElse(null);
				LeaveBalance exsistLvb = lvbs.stream().filter(name -> (name.getEmp().getEmpName().equals(empName))
						&& (name.getLeaveMaster().getLvmName().equals(lvmName))).findAny().orElse(null);
				if (emp != null && exsistLvb == null) {
					emp.addLeaveBalance(lvb);
				} else {
					if (emp != null) {
						return "Selected leave type is already allocated with" + " " + emp.getEmpName();
					}
				}
				lvb.setEmp(emp);
				lvb.setLeaveMaster(lvm);

				exe = leaveDao.saveLvb(lvb);
			}
		} else {
			return "Maximum balance allowed for this leave is " + " " + lvm.getMaxBalance();
		}
		if (exe > 0) {
			return "Allocated Successfully";
		}
		return "Failed..!";
	}

	public String saveUser(User user) {
		int num = 0;
		try {

			User exsistingUser = userDao.checkUser(user.getUsername());
			if (exsistingUser == null) {
				num = userDao.saveUser(user);
				if (num > 0) {
					return "Employee added Successfully";
				} else {
					return "Failed to add employee..!";
				}
			}
			return "User Name already exsist..add employee with different username";
		} catch (Exception ex) {
			logger.error(ex);
			return null;
		}
	}

	public List<LeaveBalance> getLeaveBalances() {
		return leaveDao.getLeaveBalances();
	}
}
