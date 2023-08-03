package com.avisys.empmgmt.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class WorkExperienceDto {
	
	private Long id;
	
	@NotNull(message="companyName must not be null")
	@NotBlank(message="companyName must not be blank")
	private String companyName;
	
	@NotNull(message="Designation must not be null")
	@NotBlank(message="Designation must not be blank")
	private String Designation;
	
	@NotNull(message="StartDate must not be null")
	private String fromDate;
	
	@NotNull(message="EndDate must not be null")
	private String toDate;
	
	@NotNull(message="address must not be null")
	@NotBlank(message="address must not be blank")
	private String address;
	
	@NotBlank(message = "Organisation Code should not be blank")
	@NotNull(message = "Organisation Code should not be null")
	private String orgCode;
	
	private boolean isDeleted;
	
	private String createdBy;

	private String updatedBy;

	public WorkExperienceDto() {
		super();
	}

	public WorkExperienceDto(
			@NotNull(message = "companyName must not be null") @NotBlank(message = "companyName must not be blank") String companyName,
			@NotNull(message = "Designation must not be null") @NotBlank(message = "Designation must not be blank") String designation,
			@NotNull(message = "StartDate must not be null") String fromDate,
			@NotNull(message = "EndDate must not be null") String toDate,
			@NotNull(message = "address must not be null") @NotBlank(message = "address must not be blank") String address,
			@NotBlank(message = "Organisation Code should not be blank") @NotNull(message = "Organisation Code should not be null") String orgCode,
			boolean isDeleted, String createdBy, String updatedBy) {
		super();
		this.companyName = companyName;
		Designation = designation;
		this.fromDate = fromDate;
		this.toDate = toDate;
		this.address = address;
		this.orgCode = orgCode;
		this.isDeleted = isDeleted;
		this.createdBy = createdBy;
		this.updatedBy = updatedBy;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public String getDesignation() {
		return Designation;
	}

	public void setDesignation(String designation) {
		Designation = designation;
	}

	public String getFromDate() {
		return fromDate;
	}

	public void setFromDate(String fromDate) {
		this.fromDate = fromDate;
	}

	public String getToDate() {
		return toDate;
	}

	public void setToDate(String toDate) {
		this.toDate = toDate;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getOrgCode() {
		return orgCode;
	}

	public void setOrgCode(String orgCode) {
		this.orgCode = orgCode;
	}

	public boolean isDeleted() {
		return isDeleted;
	}

	public void setDeleted(boolean isDeleted) {
		this.isDeleted = isDeleted;
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
