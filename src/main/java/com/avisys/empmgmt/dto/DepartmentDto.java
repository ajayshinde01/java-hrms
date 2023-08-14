package com.avisys.empmgmt.dto;

import java.time.LocalDateTime;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;


public class DepartmentDto {
	
	private Long id;
	
	@NotNull(message="Id must not be null")
	@NotBlank(message="Id must not be blank")
	@Pattern(regexp="^[A-Za-z\\d][A-Za-z\\d-]*[A-Za-z\\d]$",message="Department Id should not contain any special character except from hyphen and should start with character or digit")
	private String departmentId;
	
	@NotNull(message="Name must not be null")
	@NotBlank(message="Name must not be blank")
    @Pattern(regexp="^[A-Za-z\\d][A-Za-z\\d _.-]*[A-Za-z\\d]$|^$",message="Department Name should not contain any special character except from hyphen,underscore,space,dot but not at starting and ending position")
	private String departmentName;
	
	@NotNull(message="Description should not be null")
	private String departmentDescription;
	
	@NotEmpty(message="OrgCode must not be null")
	@NotBlank(message="OrgCode must not be blank")
    @Pattern(regexp = "^[A-Za-z\\d][A-Za-z\\d-_]*[A-Za-z\\d]$",message = "Organization code should not contain any special characters except hypen,underscore but should not at starting and ending position")
	private String orgCode;
	
	private String createdBy;

	private String updatedBy;
	
	private LocalDateTime createdAt;
	
	private LocalDateTime updatedAt;
	
	public DepartmentDto() {
		super();
	}
	
	public DepartmentDto(Long id, String departmentId, String departmentName, String departmentDescription, String orgCode, String createdBy, String updatedBy, LocalDateTime createdAt,LocalDateTime updatedAt) {
		super();
		this.id = id;
		this.departmentId = departmentId;
		this.departmentName = departmentName;
		this.departmentDescription = departmentDescription;
		this.orgCode = orgCode;
		this.createdBy = createdBy;
		this.updatedBy = updatedBy;
		this.createdAt=createdAt;
		this.updatedAt=updatedAt;
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

	public String getOrgCode() {
		return orgCode;
	}

	public void setOrgCode(String orgCode) {
		this.orgCode = orgCode;
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
	
}
