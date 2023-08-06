package com.avisys.empmgmt.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;


public class DepartmentDto {
	
	private Long id;
	
	@NotNull(message="Id must not be null")
	@NotBlank(message="Id must not be blank")
	@Pattern(regexp="^[A-Za-z-0-9]{1,50}$",message="Department Id should not contain any special character except from hyphen with size 50")
	private String departmentId;
	
	@NotNull(message="Name must not be null")
	@NotBlank(message="Name must not be blank")
	@Pattern(regexp="^[A-Za-z _ -.]{1,100}$",message="Department Name should not contain any special character except from hyphen,underscore,space,dot with size 100")
	private String departmentName;
	
	@NotNull(message="Description should not be null")
	@Pattern(regexp="^[A-Za-z !@&()_{}[\\]|;:\",.?0-9]{1,250}$",message="Department Description should not contain any special character except from letter,digit & !@&()_{}[]|;:\",.? with size 250")
	private String departmentDescription;
	
	@NotEmpty(message="OrgCode must not be null")
	@NotBlank(message="OrgCode must not be blank")
	@Pattern(regexp = "^[a-zA-Z0-9-_]{1,50}$",message = "Organization code should not contain any special characters except hypen,underscore")
	private String orgCode;
	
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
