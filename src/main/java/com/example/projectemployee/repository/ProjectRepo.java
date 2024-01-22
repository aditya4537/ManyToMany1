package com.example.projectemployee.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.projectemployee.entity.Project;

@Repository
public interface ProjectRepo extends JpaRepository<Project, Long> {

	List<Project> findByEmployeees_EmpName(String empName);
}
