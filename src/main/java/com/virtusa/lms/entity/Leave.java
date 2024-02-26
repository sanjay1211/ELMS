package com.virtusa.lms.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import org.springframework.format.annotation.DateTimeFormat;

@SuppressWarnings("serial")
@Entity
@Table(name = "leave")
public class Leave implements Serializable {
	@Id
	@GeneratedValue
	@Column(name = "lvId")
	private int lvId;
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Column(name = "fromDate")
	private Date fromDate;
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Column(name = "toDate")
	private Date toDate;
	@Column(name = "noOfDays")
	private Double noOfDays;
	@Column(name = "status")
	private String status;
	@Column(name = "reason")
	private String reason;
	@ManyToOne
	@JoinColumn(name = "lvmId")
	private LeaveMaster leaveMaster;
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "empId")
	private Employee employee;
	@Column(name = "actionBy")
	private String actionBy;

	public String getActionBy() {
		return actionBy;
	}

	public void setActionBy(String actionBy) {
		this.actionBy = actionBy;
	}

	public Leave() {
		// Constructor
	}

	public int getLvId() {
		return lvId;
	}

	public void setLvId(int lvId) {
		this.lvId = lvId;
	}

	public Date getFromDate() {
		return fromDate;
	}

	public void setFromDate(Date fromDate) {
		this.fromDate = fromDate;
	}

	public Date getToDate() {
		return toDate;
	}

	public void setToDate(Date toDate) {
		this.toDate = toDate;
	}

	public Double getNoOfDays() {
		return noOfDays;
	}

	public void setNoOfDays(Double noOfDays) {
		this.noOfDays = noOfDays;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}

	public LeaveMaster getLeaveMaster() {
		return leaveMaster;
	}

	public void setLeaveMaster(LeaveMaster leaveMaster) {
		this.leaveMaster = leaveMaster;
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

}
