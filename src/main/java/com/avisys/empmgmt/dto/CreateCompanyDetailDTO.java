package com.avisys.empmgmt.dto;

import jakarta.persistence.Column;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class CreateCompanyDetailDTO {

	@NotBlank(message = "Company Email should not be blank")
	@NotNull(message = "Company Email should not be null")
	private String companyEmail;
	

	@NotNull(message = "Client Email should not be null")
	private String clientEmail;
	

	@NotBlank(message = "billable should not be blank")
	@NotNull(message = "billable should not be null")
	private String billable;


	@NotBlank(message = "shift should not be blank")
	@NotNull(message = "shift should not be null")
	private String shift;

	@NotBlank(message = "reviewer_manager should not be blank")
	@NotNull(message = "reviewer_manager should not be null")
	private String reviewerManager;
	
	@NotBlank(message = "reporting_manager should not be blank")
	@NotNull(message = "reporting_manager should not be null")
	private String reportingManager;
	
	@NotNull(message = "probation should not be null")
	private int probation;
	
	protected String createdBy;
	
	protected String orgCode;

	public CreateCompanyDetailDTO() {
		super();
	}



	public CreateCompanyDetailDTO(
			@NotBlank(message = "Company Email should not be blank") @NotNull(message = "Company Email should not be null") String companyEmail,
			@NotNull(message = "Client Email should not be null") String clientEmail,
			@NotBlank(message = "billable should not be blank") @NotNull(message = "billable should not be null") String billable,
			@NotBlank(message = "shift should not be blank") @NotNull(message = "shift should not be null") String shift,
			@NotBlank(message = "reviewer_manager should not be blank") @NotNull(message = "reviewer_manager should not be null") String reviewerManager,
			@NotBlank(message = "reporting_manager should not be blank") @NotNull(message = "reporting_manager should not be null") String reportingManager,
			@NotNull(message = "probation should not be null") int probation, String createdBy, String orgCode) {
		super();
		this.companyEmail = companyEmail;
		this.clientEmail = clientEmail;
		this.billable = billable;
		this.shift = shift;
		this.reviewerManager = reviewerManager;
		this.reportingManager = reportingManager;
		this.probation = probation;
		this.createdBy = createdBy;
		this.orgCode = orgCode;
	}



	public String getCompanyEmail() {
		return companyEmail;
	}

	public void setCompanyEmail(String companyEmail) {
		this.companyEmail = companyEmail;
	}

	public String getClientEmail() {
		return clientEmail;
	}

	public void setClientEmail(String clientEmail) {
		this.clientEmail = clientEmail;
	}

	public String getBillable() {
		return billable;
	}

	public void setBillable(String billable) {
		this.billable = billable;
	}

	public String getShift() {
		return shift;
	}

	public void setShift(String shift) {
		this.shift = shift;
	}

	public String getReviewerManager() {
		return reviewerManager;
	}

	public void setReviewerManager(String reviewerManager) {
		this.reviewerManager = reviewerManager;
	}

	public String getReportingManager() {
		return reportingManager;
	}

	public void setReportingManager(String reportingManager) {
		this.reportingManager = reportingManager;
	}

	public int getProbation() {
		return probation;
	}

	public void setProbation(int probation) {
		this.probation = probation;
	}

	public String getCreatedBy() {
		return createdBy;
	}
	
	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public String getOrgCode() {
		return orgCode;
	}

	public void setOrgCode(String orgCode) {
		this.orgCode = orgCode;
	}
	
	
	
	
	
	
}
