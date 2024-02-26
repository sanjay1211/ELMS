package com.virtusa.lms.repository;

import java.util.List;

import com.virtusa.lms.entity.Leave;
import com.virtusa.lms.entity.LeaveBalance;
import com.virtusa.lms.entity.LeaveMaster;

public interface LeaveDaoInterface {
	public int saveLeaveMaster(LeaveMaster leaveMaster);
	public void deleteLvm(int lvmId);
	public void deleteLvb(int lvbId);
	public List<LeaveMaster> getLeaveMasters();
	public List<Leave> getLeaves();
	public LeaveMaster getLvm(int lvmId);
	public LeaveBalance findExsisting(int empId, int lvmId);
	public List<LeaveBalance> getLeaveBalances();
	public LeaveMaster getLvm(String lvmName);
	public LeaveMaster checkLvm(String lvmName, String lvmAbbr);
	public Leave getLeave(int lvId);
	public void updateLeave(LeaveMaster leave);
	public int saveLvb(LeaveBalance leaveBalance);
	public void updateLvb(LeaveBalance leaveBalance);
	public int applyLeave(Leave leave);
	public void updateLeave(Leave leave);
	public void deleteLeave(Leave leave);
}
