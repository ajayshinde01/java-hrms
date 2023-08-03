package com.avisys.empmgmt.dto;

import java.time.LocalDate;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class EducationalQualificationDto {
	
	private Long id;
	
	@NotNull(message="Qualification must not be null")
	@NotBlank(message="Qualification must not be blank")
	private String educationalQualification;
	
	@NotNull(message="Name must not be null")
	@NotBlank(message="Name must not be blank")
	private String instituteName;
	
	@NotNull(message="Name must not be null")
	@NotBlank(message="Name must not be blank")
	private String qualificationLevel;
	
	@NotNull(message="year must not be null")
	private LocalDate passingYear;
	
	@NotBlank(message = "Organisation Code should not be blank")
	@NotNull(message = "Organisation Code should not be null")
	private String orgCode;

	private boolean isDeleted;
	
	private String createdBy;

	private String updatedBy;

	public EducationalQualificationDto() {
		super();
	}

	public EducationalQualificationDto(
			@NotNull(message = "Qualification must not be null") @NotBlank(message = "Qualification must not be blank") String educationalQualification,
			@NotNull(message = "Name must not be null") @NotBlank(message = "Name must not be blank") String instituteName,
			@NotNull(message = "Name must not be null") @NotBlank(message = "Name must not be blank") String qualificationLevel,
			@NotNull(message = "year must not be null") LocalDate passingYear,
			@NotBlank(message = "Organisation Code should not be blank") @NotNull(message = "Organisation Code should not be null") String orgCode,
			boolean isDeleted, String createdBy, String updatedBy) {
		super();
		this.educationalQualification = educationalQualification;
		this.instituteName = instituteName;
		this.qualificationLevel = qualificationLevel;
		this.passingYear = passingYear;
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

	public String getEducationalQualification() {
		return educationalQualification;
	}

	public void setEducationalQualification(String educationalQualification) {
		this.educationalQualification = educationalQualification;
	}

	public String getInstituteName() {
		return instituteName;
	}

	public void setInstituteName(String instituteName) {
		this.instituteName = instituteName;
	}

	public String getQualificationLevel() {
		return qualificationLevel;
	}

	public void setQualificationLevel(String qualificationLevel) {
		this.qualificationLevel = qualificationLevel;
	}

	public LocalDate getPassingYear() {
		return passingYear;
	}

	public void setPassingYear(LocalDate passingYear) {
		this.passingYear = passingYear;
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