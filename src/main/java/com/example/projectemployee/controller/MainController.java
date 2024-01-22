package com.example.projectemployee.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.projectemployee.entity.Employee;
import com.example.projectemployee.entity.Project;
import com.example.projectemployee.service.EmployeeService;
import com.example.projectemployee.service.ProjectService;

@RestController
public class MainController {

	@Autowired
	private EmployeeService employeeService;
	
	@Autowired
	private ProjectService projectService;
	
	@GetMapping("/getEmployees")
	public List<Employee> getAllEmp(){
		return employeeService.getAllEmployees();
	}
	
	@GetMapping("/getProjects")
	public List<Project> getAllproj(){
		return projectService.getAllProjects();
	}
	
	@PostMapping("/addEmployee")
	public Employee saveEmployee(@RequestBody Employee emp) {
		return employeeService.addEmployee(emp);
	}
	
	@PostMapping("/addProject")
	public Project saveProject(@RequestBody Project pro) {
		return projectService.addProject(pro);
	}
	
	@PutMapping("/assignProjects")
	public Employee addProjectsToEmployee(@RequestParam("eId") Long eId, @RequestParam("pId") Long... pIds) {
		return employeeService.assignProjectToEmployee(eId, pIds);
	}
	
	@GetMapping("/employeeByProject")
	public List<Employee> getEmployeeByProjectName(@RequestParam("title") String name){
		return employeeService.employeeByProjectName(name);
	}
	
	@DeleteMapping("/delete")
	public String delEmpByName(@RequestParam String name) {
		employeeService.deleteByEmpName(name);
		return "Successfully Deleted " + name;
	}
	
	@PutMapping("/updateName")
	public String updateEmployeeName(@RequestParam("id") Long id, @RequestParam("newName") String name){
		employeeService.updateEmpName(id, name);
		return "Successfully updated...";
	}
	
	@PutMapping("/removeProject")
	public String removeProjectFromEmployee(@RequestParam("eId") Long eId, @RequestParam("pId") Long pId) {
		employeeService.removeProjectFromEmployee(eId, pId);
		return "Project Removed From Employee";
	}
}
