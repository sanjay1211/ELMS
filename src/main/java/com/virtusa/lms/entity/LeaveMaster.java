package com.virtusa.lms.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

@SuppressWarnings("serial")
@Entity
@Table(name = "leavemaster")
public class LeaveMaster implements Serializable {
	@Id
	@GeneratedValue
	@Column(name = "lvmId")
	private int lvmId;
	@Column(name = "lvmName", unique = true)
	private String lvmName;
	@Column(name = "lvmAbbr", unique = true)
	private String lvmAbbr;
	@Column(name = "maxBalance")
	private double maxBalance;
	@OneToMany(mappedBy = "leaveMaster", fetch = FetchType.EAGER)
	@Fetch(FetchMode.SELECT)
	private List<Leave> leaves;
	@Fetch(FetchMode.SELECT)
	@OneToMany(mappedBy = "leaveMaster", fetch = FetchType.EAGER)
	private List<LeaveBalance> leaveBalances;

	public int getLvmId() {
		return lvmId;
	}

	public double getMaxBalance() {
		return maxBalance;
	}

	public void setMaxBalance(double maxBalance) {
		this.maxBalance = maxBalance;
	}

	public void setLvmId(int lvmId) {
		this.lvmId = lvmId;
	}

	public String getLvmName() {
		return lvmName;
	}

	public void setLvmName(String lvmName) {
		this.lvmName = lvmName;
	}

	public String getLvmAbbr() {
		return lvmAbbr;
	}

	public void setLvmAbbr(String lvmAbbr) {
		this.lvmAbbr = lvmAbbr;
	}

	public List<Leave> getLeaves() {
		return leaves;
	}

	public void setLeaves(List<Leave> leaves) {
		this.leaves = leaves;
	}

	public List<LeaveBalance> getLeaveBalances() {
		return leaveBalances;
	}

	public void setLeaveBalances(List<LeaveBalance> leaveBalances) {
		this.leaveBalances = leaveBalances;
	}

	public void addLeave(Leave leave) {
		this.leaves.add(leave);
	}

	public void addLeaveBalance(LeaveBalance leaveBalance) {
		this.leaveBalances.add(leaveBalance);
	}

}
