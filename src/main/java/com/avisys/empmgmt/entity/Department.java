package com.avisys.empmgmt.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;


@Entity
@Table(name="departments")
public class Department extends Status{
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "department_id_squenece_generator")
	@SequenceGenerator(name="department_id_squenece_generator", initialValue = 1, allocationSize = 1)
	@Column(name="id")
	private Long id;
	
	@Column(name="department_id", unique=true)
	@NotNull(message="Id must not be null")
	@NotBlank(message="Id must not be blank")
	@Pattern(regexp="^[A-Za-z0-9-]{1,50}$",message="Department Id should not contain any special character except from hyphen with size 50")
	private String departmentId;
	
	@Column(name="department_name")
	@NotNull(message="Name must not be null")
	@NotBlank(message="Name must not be blank")
	@Pattern(regexp="^[A-Za-z _ -.]{1,100}$",message="Department Name should not contain any special character except from hyphen,underscore,space,dot with size 100")
	private String departmentName;
	
	@Column(name="description")
	@NotNull(message="Description should not be null")
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