package com.example.projectemployee.service;

import java.util.List;

import com.example.projectemployee.entity.Employee;

public interface EmployeeService {

	public List<Employee> getAllEmployees();
	
	public Employee addEmployee(Employee emp);
	
	public Employee  assignProjectToEmployee(Long eId, Long... pId);
	
	public List<Employee> employeeByProjectName(String name);
	
	public void deleteByEmpName(String name);
	
	public void updateEmpName(Long id, String name);
	
	public void removeProjectFromEmployee(Long projectId, Long EmployeeId);
}
