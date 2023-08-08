package com.avisys.empmgmt.dto;

import com.avisys.empmgmt.entity.Grade;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public class GradeDTO {

	private Long id;

	@NotNull(message = "Grade Id is not null")
	@NotBlank(message = "Grade Id is required")
	@Pattern(regexp="^[A-Za-z\\d][A-Za-z\\d-]*[A-Za-z\\d]$",message="Grade Id should not contain any special character except from hyphen and should start with character or digit")
	private String gradeId;

	@NotNull(message = "Grade Name  is not null")
	@NotBlank(message = "Grade Name is required")
    @Pattern(regexp="^[A-Za-z\\d][A-Za-z\\d _.-]*[A-Za-z\\d]$|^$",message="Grade Name should not contain any special character except from hyphen,underscore,space,dot but not at starting and ending position")
	private String gradeName;

	@NotNull(message = "Grade Name is not null")
	@NotBlank(message = "Grade Name is required")
	@Size(min = 2, message = "Grade Id Min size 2")
	@Size(max = 20, message = "Grade Id Mix size 20")
	private String gradeType;
	
    @Pattern(regexp = "^[A-Za-z\\d][A-Za-z\\d-_]*[A-Za-z\\d]$",message = "Organization code should not contain any special characters except hypen,underscore but should not at starting and ending position")
	private String orgCode;
	
	private String createdBy;

	private String updatedBy;

	public GradeDTO() {
		super();
	}

	public GradeDTO(Long id, String gradeId, String gradeName, String gradeType, String orgCode, String createdBy, String updatedBy) {
		super();
		this.id = id;
		this.gradeId = gradeId;
		this.gradeName = gradeName;
		this.gradeType = gradeType;
		this.orgCode = orgCode;
		this.createdBy=createdBy;
		this.updatedBy=updatedBy;
	}

	public GradeDTO(Grade gradeObject) {
		this.id = gradeObject.getId();
		this.gradeId = gradeObject.getGradeId();
		this.gradeName = gradeObject.getGradeName();
		this.gradeType = gradeObject.getGradeType();
		this.orgCode = gradeObject.getOrgCode();
		this.createdBy=gradeObject.getCreatedBy();
		this.updatedBy=gradeObject.getUpdatedBy();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getGradeId() {
		return gradeId;
	}

	public void setGradeId(String gradeId) {
		this.gradeId = gradeId;
	}

	public String getGradeName() {
		return gradeName;
	}

	public void setGradeName(String gradeName) {
		this.gradeName = gradeName;
	}

	public String getGradeType() {
		return gradeType;
	}

	public void setGradeType(String gradeType) {
		this.gradeType = gradeType;
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
