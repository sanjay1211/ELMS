package com.virtusa.lms.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.springframework.format.annotation.DateTimeFormat;

@SuppressWarnings("serial")
@Entity
@Table(name = "employee")
public class Employee implements Serializable {

	@Id
	@GeneratedValue
	@Column(name = "empId")
	private int empId;

	@Column(name = "empName", nullable = false, length = 45)
	private String empName;

	@Column(name = "empMail", nullable = false, length = 45)
	private String empMail;

	@Column(name = "empMob", length = 15)
	private String empMob;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Column(name = "empDob")
	@Temporal(TemporalType.DATE)
	private Date empDob;
	@Column(name = "gender")
	private String gender;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Column(name = "empDoj")
	@Temporal(TemporalType.DATE)
	private Date empDoj;
	@OneToOne(mappedBy = "employee", fetch = FetchType.EAGER)
	private User user;
	@Column(name = "managerId")
	private int managerId;
	@OneToMany(mappedBy = "employee", fetch = FetchType.EAGER)
	@Fetch(FetchMode.SELECT)
	private List<Leave> leaves = new ArrayList<>();
	@OneToMany(mappedBy = "emp", fetch = FetchType.EAGER)
	@Fetch(FetchMode.SELECT)
	private List<LeaveBalance> leaveBalances = new ArrayList<>();

	public Employee() {
		super();
	}

	public int getEmpId() {
		return empId;
	}

	public void setEmpId(int empId) {
		this.empId = empId;
	}

	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	public String getEmpMail() {
		return empMail;
	}

	public void setEmpMail(String empMail) {
		this.empMail = empMail;
	}

	public String getEmpMob() {
		return empMob;
	}

	public void setEmpMob(String empMob) {
		this.empMob = empMob;
	}

	public Date getEmpDob() {
		return empDob;
	}

	public void setEmpDob(Date empDob) {
		this.empDob = empDob;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public Date getEmpDoj() {
		return empDoj;
	}

	public void setEmpDoj(Date empDoj) {
		this.empDoj = empDoj;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public int getManagerId() {
		return managerId;
	}

	public void setManagerId(int managerId) {
		this.managerId = managerId;
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
