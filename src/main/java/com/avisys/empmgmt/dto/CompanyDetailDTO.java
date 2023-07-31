package com.avisys.empmgmt.dto;

import java.time.LocalDateTime;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class CompanyDetailDTO {

	private Long id;
	
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
	
	private boolean isDeleted ;
	private LocalDateTime createdAt;
	private LocalDateTime updatedAt;
	private String createdBy;
	private String updatedBy;
	
	@NotBlank(message = "Organisation Code should not be blank")
	@NotNull(message = "Organisation Code should not be null")
	private String orgCode;
	
	public CompanyDetailDTO() {
		super();
	}

	public CompanyDetailDTO(Long id,
			@NotBlank(message = "Company Email should not be blank") @NotNull(message = "Company Email should not be null") String companyEmail,
			@NotNull(message = "Client Email should not be null") String clientEmail,
			@NotBlank(message = "billable should not be blank") @NotNull(message = "billable should not be null") String billable,
			@NotBlank(message = "shift should not be blank") @NotNull(message = "shift should not be null") String shift,
			@NotBlank(message = "reviewer_manager should not be blank") @NotNull(message = "reviewer_manager should not be null") String reviewerManager,
			@NotBlank(message = "reporting_manager should not be blank") @NotNull(message = "reporting_manager should not be null") String reportingManager,
			@NotNull(message = "probation should not be null") int probation, boolean isDeleted,
			LocalDateTime createdAt, LocalDateTime updatedAt, String createdBy, String updatedBy,
			@NotBlank(message = "Organisation Code should not be blank") @NotNull(message = "Organisation Code should not be null") String orgCode) {
		super();
		this.id = id;
		this.companyEmail = companyEmail;
		this.clientEmail = clientEmail;
		this.billable = billable;
		this.shift = shift;
		this.reviewerManager = reviewerManager;
		this.reportingManager = reportingManager;
		this.probation = probation;
		this.isDeleted = isDeleted;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
		this.createdBy = createdBy;
		this.updatedBy = updatedBy;
		this.orgCode = orgCode;
	}







	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public boolean isDeleted() {
		return isDeleted;
	}

	public void setDeleted(boolean isDeleted) {
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

	public String getOrgCode() {
		return orgCode;
	}

	public void setOrgCode(String orgCode) {
		this.orgCode = orgCode;
	}
	
	
	
	
	


}
