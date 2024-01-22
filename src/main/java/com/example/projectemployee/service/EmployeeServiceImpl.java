package com.example.projectemployee.service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.projectemployee.entity.Employee;
import com.example.projectemployee.entity.Project;
import com.example.projectemployee.repository.EmployeeRepo;
import com.example.projectemployee.repository.ProjectRepo;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeRepo employeeRepo;
	
	@Autowired
	private ProjectRepo projectRepo;
	
	@Override
	public List<Employee> getAllEmployees() {
		return employeeRepo.findAll();
	}

	@Override
	public Employee addEmployee(Employee emp) {
		return employeeRepo.save(emp);
	}

	@Override
	public Employee assignProjectToEmployee(Long eId, Long... pId) {
		
		Employee emp = employeeRepo.findById(eId).get();
		
		Set<Project> projects = new HashSet<>();
		
		for(Long id: pId) {
			Project p = projectRepo.findById(id).get();
			projects.add(p);
		}
		emp.setProjects(projects);
		return employeeRepo.save(emp);
	}

	@Override
	public List<Employee> employeeByProjectName(String name) {
		return employeeRepo.findByProjectsProTitle(name);
	}

	@Override
	public void deleteByEmpName(String name) {
		employeeRepo.deleteByEmpName(name);
		
	}

	@Override
	public void updateEmpName(Long id, String name) {
		employeeRepo.updateEmployeeEmpNameByEmpId(id, name);
	}

	@Override 
	public void removeProjectFromEmployee(Long employeeId, Long projectId) {
		Employee byId = employeeRepo.findById(employeeId).get();
		Set<Project> projects = byId.getProjects();
		
		Project p = projectRepo.findById(projectId).get();
		projects.remove(p);
		byId.setProjects(projects);
		employeeRepo.save(byId);
	}
	
}
