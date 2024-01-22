package com.example.projectemployee.entity;

import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "project")
public class Project {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long proId;
	
	private String proTitle;
	
	private int proModule;
	
	private String proDesc;
	
	@ManyToMany(mappedBy = "projects", fetch = FetchType.LAZY)
	@JsonIgnore
	private Set<Employee> employeees;

	public long getProId() {
		return proId;
	}

	public void setProId(long proId) {
		this.proId = proId;
	}

	public String getProTitle() {
		return proTitle;
	}

	public void setProTitle(String proTitle) {
		this.proTitle = proTitle;
	}

	public int getProModule() {
		return proModule;
	}

	public void setProModule(int proModule) {
		this.proModule = proModule;
	}

	public String getProDesc() {
		return proDesc;
	}

	public void setProDesc(String proDesc) {
		this.proDesc = proDesc;
	}
	
	

	@Override
	public String toString() {
		return "Project [proId=" + proId + ", proTitle=" + proTitle + ", proModule=" + proModule + ", proDesc="
				+ proDesc + "]";
	}

	public Set<Employee> getEmployeees() {
		return employeees;
	}

	public void setEmployeees(Set<Employee> employeees) {
		this.employeees = employeees;
	}
	
	
}
