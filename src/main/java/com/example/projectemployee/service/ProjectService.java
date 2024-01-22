package com.example.projectemployee.service;

import java.util.List;

import com.example.projectemployee.entity.Project;

public interface ProjectService {

	public List<Project> getAllProjects();
	
	public Project addProject(Project project);

}
