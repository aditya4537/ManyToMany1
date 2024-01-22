package com.example.projectemployee.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.projectemployee.entity.Project;
import com.example.projectemployee.repository.ProjectRepo;

@Service
public class ProjectSeviceImpl implements ProjectService {

	@Autowired
	private ProjectRepo projectRepo;
	
	@Override
	public List<Project> getAllProjects() {
		System.err.println(projectRepo.findByEmployeees_EmpName("Aditya"));
		return projectRepo.findAll();
	}

	@Override
	public Project addProject(Project project) {
		return projectRepo.save(project);
	}

}
