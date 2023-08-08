package com.avisys.empmgmt.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public class CreateDesignationDto {

	@NotNull(message = "Designation ID should not be null")
	@NotBlank(message = "Designation ID should not be blank")
	@Pattern(regexp="^[A-Za-z\\d][A-Za-z\\d-]*[A-Za-z\\d]$",message="Designation Id should not contain any special character except from hyphen and should start with character or digit")
	private String designationId;
	
	@NotNull(message = "Designation Name should not be null")
	@NotBlank(message = "Designation Name should not be blank")
    @Pattern(regexp="^[A-Za-z\\d][A-Za-z\\d _.-]*[A-Za-z\\d]$|^$",message="Designation Name should not contain any special character except from hyphen,underscore,space,dot but not at starting and ending position")
	private String designationName;

	@NotNull(message = "Designation Description should not be null")
	@NotBlank(message = "Designation Description should not be blank")
	private String designationDesc;

	@NotNull(message = "Organisation Code should not be null")
	@NotBlank(message = "Organisation Code should not be blank")
    @Pattern(regexp = "^[A-Za-z\\d][A-Za-z\\d-_]*[A-Za-z\\d]$",message = "Organization code should not contain any special characters except hypen,underscore but should not at starting and ending position")
	private String orgCode;

	private String createdBy;

	public CreateDesignationDto(String designationId, String designationName, String designationDesc, String orgCode,
			String createdBy) {
		super();
		this.designationId = designationId;
		this.designationName = designationName;
		this.designationDesc = designationDesc;
		this.orgCode = orgCode;
		this.createdBy = createdBy;
	}

	public CreateDesignationDto() {
		// TODO Auto-generated constructor stub
	}

	public String getDesignationId() {
		return designationId;
	}

	public void setDesignationId(String designationId) {
		this.designationId = designationId;
	}

	public String getDesignationName() {
		return designationName;
	}

	public void setDesignationName(String designationName) {
		this.designationName = designationName;
	}

	public String getDesignationDesc() {
		return designationDesc;
	}

	public void setDesignationDesc(String designationDesc) {
		this.designationDesc = designationDesc;
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


}
