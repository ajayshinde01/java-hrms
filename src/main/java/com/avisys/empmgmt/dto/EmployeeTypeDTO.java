package com.avisys.empmgmt.dto;

import java.time.LocalDateTime;
import jakarta.persistence.Column;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public class EmployeeTypeDTO {
	private Long id;
	@NotBlank(message = "Type Should not be blank")
	@NotNull(message = "Type Should not be null")
	@Pattern(regexp="^[A-Za-z _ -]{1,50}$",message="Employee Type should not contain any special character except from hyphen,underscore,space with size 50")
	private String type;

	@Column(name = "employee_type_id")
	@NotNull(message = "Employee Type Id should not be null")
	@NotBlank(message = "Employee Type Id should not be blank")
    @Pattern(regexp="^[A-Za-z0-9-]{1,50}$",message="Employee Type Id must starts with alphabets , followed numbers & should not contain any special character except from hyphen with size 50")
	private String employeeTypeId;

	@NotBlank(message = "Org code Should not be blank")
	@NotNull(message = "Org code Should not be null")
	@Pattern(regexp = "^[a-zA-Z0-9-_]{1,50}$",message = "Organization code should not contain any special characters except hypen,underscore")
	private String orgCode;

	private LocalDateTime createdAt;

	private LocalDateTime updatedAt;
	
	private String message;

	@NotBlank(message = "Created by Should not be blank")
	@NotNull(message = "Created by code Should not be null")
	@Size(min = 3, max = 15, message = "created by size min = 3 & max = 15")
	private String createdBy;

	@Size(min = 3, max = 15, message = "updated by size min = 3 & max = 15")
	@Column(name = "Updated_By")
	private String updatedBy;

	public EmployeeTypeDTO() {
		super();
	}

	public EmployeeTypeDTO(Long id, String type, String employeeTypeId, String orgCode,LocalDateTime createdAt, LocalDateTime updatedAt, String createdBy, String updatedBy) {
		super();
		this.id = id;
		this.type = type;
		this.employeeTypeId = employeeTypeId;
		this.orgCode = orgCode;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
		this.createdBy = createdBy;
		this.updatedBy = updatedBy;
	}

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

	public String getOrgCode() {
		return orgCode;
	}

	public void setOrgCode(String orgCode) {
		this.orgCode = orgCode;
	}

	public LocalDateTime getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(LocalDateTime createdAt) {
		this.createdAt = createdAt;
	}

	public LocalDateTime getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(LocalDateTime updatedAt) {
		this.updatedAt = updatedAt;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public String getUpdatedBy() {
		return updatedBy;
	}

	public void setUpdatedBy(String updatedBy) {
		this.updatedBy = updatedBy;
	}
	
	

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	@Override
	public String toString() {
		return "EmployeeTypeDTO [id=" + id + ", type=" + type + ", employeeTypeId=" + employeeTypeId + ", orgCode="
				+ orgCode + ", createdAt=" + createdAt + ", updatedAt=" + updatedAt + ", createdBy=" + createdBy
				+ ", updatedBy=" + updatedBy + "]";
	}
	

}
