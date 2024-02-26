package com.virtusa.lms.service;

import java.util.List;

import com.virtusa.lms.entity.Leave;

public interface ManagerServiceInterface {
	public String applyLeave(Leave leave, int empId, String lvmName);
	public List<Leave> getLeaveRequest();
	public void approveLeave(int lvId, int empId);
	public void rejectLeave(int lvId, int empId);
	public void cancelLeave(int lvId);
	
}
