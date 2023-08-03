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
	@Size(min = 2, message = " Grade Id Min size 2")
	@Size(max = 20, message = " Grade Id Mix size 20")
	private String gradeId;

	@NotNull(message = "Grade Name  is not null")
	@NotBlank(message = "Grade Name is required")
	@Size(min = 2, message = " Grade Id Min size 2")
	@Size(max = 20, message = "Grade Id Mix size 20")
    @Pattern(regexp = "^[a-zA-Z]+[a-zA-Z0-9 ]+$",message = "Name must starts with alphabets")
	private String gradeName;

	@NotNull(message = "Grade Name is not null")
	@NotBlank(message = "Grade Name is required")
	@Size(min = 2, message = "Grade Id Min size 2")
	@Size(max = 20, message = "Grade Id Mix size 20")
	private String gradeType;
	private String orgCode;

	public GradeDTO() {
		super();
	}

	public GradeDTO(Long id, String gradeId, String gradeName, String gradeType, String orgCode) {
		super();
		this.id = id;
		this.gradeId = gradeId;
		this.gradeName = gradeName;
		this.gradeType = gradeType;
		this.orgCode = orgCode;
	}

	public GradeDTO(Grade gradeObject) {
		this.id = gradeObject.getId();
		this.gradeId = gradeObject.getGradeId();
		this.gradeName = gradeObject.getGradeName();
		this.gradeType = gradeObject.getGradeType();
		this.orgCode = gradeObject.getOrgCode();
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

}
