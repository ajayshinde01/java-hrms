package com.avisys.empmgmt.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

public class EmergencyContactsDto {

	private Long id;
	
	@NotBlank(message = "ContactName should not be blank")
	@NotNull(message = "ContactName should not be null")
	private String emergencyContactName;
	
	@NotBlank(message = "ContactNumber should not be blank")
	@NotNull(message = "ContactNumber should not be null")
	private String emergencyContactNumber;
	
	@NotBlank(message = "relation should not be blank")
	@NotNull(message = "relation should not be null")
	private String relation;
	
	@NotBlank(message = "Organisation Code should not be blank")
	@NotNull(message = "Organisation Code should not be null")
	@Pattern(regexp = "^[a-zA-Z-_]{1,10}$",message = "Organization code can't contain white spaces & special characters")
	private String orgCode;

	private String createdBy;

	private String updatedBy;

	
	public EmergencyContactsDto() {
		super();
	}


	public EmergencyContactsDto(
			@NotBlank(message = "ContactName should not be blank") @NotNull(message = "ContactName should not be null") String emergencyContactName,
			@NotBlank(message = "ContactNumber should not be blank") @NotNull(message = "ContactNumber should not be null") String emergencyContactNumber,
			@NotBlank(message = "relation should not be blank") @NotNull(message = "relation should not be null") String relation,
			@NotBlank(message = "Organisation Code should not be blank") @NotNull(message = "Organisation Code should not be null") String orgCode,
	        String createdBy, String updatedBy) {
		super();
		this.emergencyContactName = emergencyContactName;
		this.emergencyContactNumber = emergencyContactNumber;
		this.relation = relation;
		this.orgCode = orgCode;
		this.createdBy = createdBy;
		this.updatedBy = updatedBy;
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getEmergencyContactName() {
		return emergencyContactName;
	}


	public void setEmergencyContactName(String emergencyContactName) {
		this.emergencyContactName = emergencyContactName;
	}


	public String getEmergencyContactNumber() {
		return emergencyContactNumber;
	}


	public void setEmergencyContactNumber(String emergencyContactNumber) {
		this.emergencyContactNumber = emergencyContactNumber;
	}


	public String getRelation() {
		return relation;
	}


	public void setRelation(String relation) {
		this.relation = relation;
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
