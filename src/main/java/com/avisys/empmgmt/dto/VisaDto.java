package com.avisys.empmgmt.dto;

import java.time.LocalDate;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

public class VisaDto {

	private Long id;

	@NotNull(message="countryCode field must not be null")
	@NotBlank(message="countryCode field must not be blank")
	private String countryCode;

	@NotNull(message="visaNumber field must not be null")
	@NotBlank(message="visaNumber field must not be blank")
	private String visaNumber;

	@NotNull(message="address1 field must not be null")
	private LocalDate validDate;
	
	private String visaFile;
	
	@NotBlank(message = "Organisation Code should not be blank")
	@NotNull(message = "Organisation Code should not be null")
	@Pattern(regexp = "^[a-zA-Z-_]{1,10}$",message = "Organization code can't contain white spaces & special characters")
	private String orgCode;

	private boolean isDeleted;
	
	private String createdBy;

	private String updatedBy;
	
	public VisaDto() {
		super();
	}

	public VisaDto(
			@NotNull(message = "countryCode field must not be null") @NotBlank(message = "countryCode field must not be blank") String countryCode,
			@NotNull(message = "visaNumber field must not be null") @NotBlank(message = "visaNumber field must not be blank") String visaNumber,
			@NotNull(message = "address1 field must not be null") LocalDate validDate, String visaFile,
			@NotBlank(message = "Organisation Code should not be blank") @NotNull(message = "Organisation Code should not be null") String orgCode,
			boolean isDeleted, String createdBy, String updatedBy) {
		super();
		this.countryCode = countryCode;
		this.visaNumber = visaNumber;
		this.validDate = validDate;
		this.visaFile = visaFile;
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

	public String getCountryCode() {
		return countryCode;
	}

	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}

	public String getVisaNumber() {
		return visaNumber;
	}

	public void setVisaNumber(String visaNumber) {
		this.visaNumber = visaNumber;
	}

	public LocalDate getValidDate() {
		return validDate;
	}

	public void setValidDate(LocalDate validDate) {
		this.validDate = validDate;
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

	public String getVisaFile() {
		return visaFile;
	}

	public void setVisaFile(String visaFile) {
		this.visaFile = visaFile;
	}
	
	
}
