package com.virtusa.lms.entity;

import java.io.Serializable;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@SuppressWarnings("serial")
@Entity
@Table(name = "leavebalance")
public class LeaveBalance implements Serializable {
	@Id
	@GeneratedValue
	@Column(name = "lvbId")
	private int lvbId;
	@Column(name = "balance")
	private double balance;

	@ManyToOne(cascade = { CascadeType.MERGE, CascadeType.PERSIST })
	@JoinColumn(name = "lvmId")
	private LeaveMaster leaveMaster;

	@ManyToOne(cascade = { CascadeType.MERGE, CascadeType.PERSIST })
	@JoinColumn(name = "empId")
	private Employee emp;

	public int getLvbId() {
		return lvbId;
	}

	public void setLvbId(int lvbId) {
		this.lvbId = lvbId;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public LeaveMaster getLeaveMaster() {
		return leaveMaster;
	}

	public void setLeaveMaster(LeaveMaster leaveMaster) {
		this.leaveMaster = leaveMaster;
	}

	public Employee getEmp() {
		return emp;
	}

	public void setEmp(Employee emp) {
		this.emp = emp;
	}

}
