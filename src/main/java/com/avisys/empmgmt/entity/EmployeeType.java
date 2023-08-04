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
@Table(name = "employeetype")
public class EmployeeType extends Status {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "emptype_generator")
	@SequenceGenerator(name = "emptype_generator", sequenceName = "emptype_seq", allocationSize = 1)
	@Column(name = "Id")
	private Long id;
	
	@Column(name = "employee_type_id")
	@NotNull(message="Employee Type Id should not be null")
	@NotBlank(message="Employee Type Id should not be blank")
	@Pattern(regexp = "^(?!.*s)[A-Za-z]{1,50}$",message = "ID must starts with alphabets followed numbers & cannot contain special character")
	private String employeeTypeId;

	@NotBlank(message = "Type Should not be blank")
	@NotNull(message = "Type Should not be null")
	@Pattern(regexp = "^[A-Za-z _ \\-]{1,50}$",message = "Type should only contain _ & - as special character")
	@Column(name = "Type", nullable = false)
	private String type;

	public Long getId() {
		return id;
	}

	public String getEmployeeTypeId() {
		return employeeTypeId;
	}

	public void setEmployeeTypeId(String employeeTypeId) {
		this.employeeTypeId = employeeTypeId;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

}
