package com.example.projectemployee.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.projectemployee.entity.Employee;

import jakarta.transaction.Transactional;

@Repository
public interface EmployeeRepo extends JpaRepository<Employee, Long> {
	
	List<Employee> findByProjectsProTitle(String pTitle);
	
//	@Modifying
//	@Query(value="DELETE FROM employee WHERE emp_name=?1", nativeQuery = true)
//	@Query("delete Employee e where e.empName=?1")
	
	@Transactional
	void deleteByEmpName(String name);
	
	@Transactional
    @Modifying
    @Query("UPDATE Employee e SET e.empName = :newName WHERE e.empId = :id")
    void updateEmployeeEmpNameByEmpId(Long id, String newName);
	
}
