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
	@Size(min=2, max=8, message="Id should be in between 2 to 8 character")
    @Pattern(regexp = "^(?!.*\s)[A-Za-z0-9]{1,50}$",message = "ID must starts with alphabets followed numbers")
	private String departmentId;
	
	@NotNull(message="Name must not be null")
	@NotBlank(message="Name must not be blank")
	@Size(min=4, message="Name must be min of 4 character")
    @Pattern(regexp = "^[a-zA-Z]+[a-zA-Z0-9 ]+$",message = "Name must starts with alphabets")
	private String departmentName;
	
	@NotNull(message="Description should not be null")
	private String departmentDescription;
	
	@NotEmpty(message="OrgCode must not be null")
	@NotBlank(message="OrgCode must not be blank")
	private String orgCode;
	
	private boolean isDeleted;

	private LocalDateTime createdAt;
	
	private LocalDateTime updatedAt;
	
	private String createdBy;

	private String updatedBy;
	
	public DepartmentDto() {
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

	public String getOrgCode() {
		return orgCode;
	}

	public void setOrgCode(String orgCode) {
		this.orgCode = orgCode;
	}

	public Boolean getIsDeleted() {
		return isDeleted;
	}

	public void setIsDeleted(Boolean isDeleted) {
		this.isDeleted = isDeleted;
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
}
