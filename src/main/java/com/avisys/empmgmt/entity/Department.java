package com.avisys.empmgmt.entity;


import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;


@Entity
@Table(name="DEPARTMENTS")
public class Department extends Status{
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "Id_squenece_generator")
	@SequenceGenerator(name="Id_squenece_generator", initialValue = 1, allocationSize = 1)
	@Column(name="ID")
	private Long id;
	
	@Column(name="DEPARTMENT_ID", unique=true)
	private String departmentId;
	
	@Column(name="NAME")
	private String departmentName;
	
	@Column(name="DESCRIPTION")
	private String departmentDescription;
	
	public Department() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDepartmentId() {
		return departmentId;
	}

	public void setDepartmentId(String departmentId) {
		this.departmentId = departmentId;
	}

	public String getDepartmentName() {
		return departmentName;
	}

	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}

	public String getDepartmentDescription() {
		return departmentDescription;
	}

	public void setDepartmentDescription(String departmentDescription) {
		this.departmentDescription = departmentDescription;
	}
}