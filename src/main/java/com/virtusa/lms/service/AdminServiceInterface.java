package com.virtusa.lms.service;

import java.util.List;
import com.virtusa.lms.entity.Employee;
import com.virtusa.lms.entity.LeaveBalance;
import com.virtusa.lms.entity.LeaveMaster;
import com.virtusa.lms.entity.User;

public interface AdminServiceInterface {
	
	public void deleteEmp(int empId);
	public void deleteLvb(int lvbId);
	public void deleteLvm(int lvmId);
	public String saveLeave(LeaveMaster leaveMaster);
	public Employee getEmp(int empId);
	public void updateUser(User user);
	public LeaveMaster getLvm(int lvmId);
	public void updateLeave(LeaveMaster lvm);
	public String assignMng(List<String> empNames, String mngName);
	public String saveLvb(List<String> empNames, String lvmName, LeaveBalance lvb);
	public String saveUser(User user);
	
}
