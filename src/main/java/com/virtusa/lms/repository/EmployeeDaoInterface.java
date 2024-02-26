package com.virtusa.lms.repository;

import java.util.List;
import com.virtusa.lms.entity.Employee;
import com.virtusa.lms.entity.User;

public interface EmployeeDaoInterface {
	public void deleteEmp(int empId);
	public void updateEmp(Employee empolyee);
	public void updateUser(User user);
	public List<Employee> getAllEmployees();
	public Employee getEmp(int empId);
}
