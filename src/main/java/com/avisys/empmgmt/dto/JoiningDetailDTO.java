package com.avisys.empmgmt.dto;

import java.time.LocalDate;
import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class JoiningDetailDTO {
	
    private Long id;
    
	@NotNull(message = "confirmation date is required")
	private LocalDate confirmationDate;

	private int noticePeriod;

	@NotNull(message = "resignation date is required")
	private LocalDate resignationDate;
	
	private LocalDate relievingDate;
	
	@NotBlank(message = "Organisation Code should not be blank")
	@NotNull(message = "Organisation Code should not be null")
	protected String orgCode;

	protected boolean isDeleted ;

	protected LocalDateTime createdAt;

	protected LocalDateTime updatedAt;

	protected String createdBy;

	protected String updatedBy;

	public JoiningDetailDTO() {
		super();
	}

	public JoiningDetailDTO(LocalDate confirmationDate,int noticePeriod,LocalDate resignationDate, LocalDate relievingDate, String orgCode,
			boolean isDeleted, LocalDateTime createdAt, LocalDateTime updatedAt, String createdBy, String updatedBy) {
		super();
		this.id = id;
		this.confirmationDate = confirmationDate;
		this.noticePeriod = noticePeriod;
		this.resignationDate = resignationDate;
		this.relievingDate = relievingDate;
		this.orgCode = orgCode;
		this.isDeleted = isDeleted;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
		this.createdBy = createdBy;
		this.updatedBy = updatedBy;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public LocalDate getConfirmationDate() {
		return confirmationDate;
	}

	public void setConfirmationDate(LocalDate confirmationDate) {
		this.confirmationDate = confirmationDate;
	}

	public int getNoticePeriod() {
		return noticePeriod;
	}

	public void setNoticePeriod(int noticePeriod) {
		this.noticePeriod = noticePeriod;
	}

	public LocalDate getResignationDate() {
		return resignationDate;
	}

	public void setResignationDate(LocalDate resignationDate) {
		this.resignationDate = resignationDate;
	}

	public LocalDate getRelievingDate() {
		return relievingDate;
	}

	public void setRelievingDate(LocalDate relievingDate) {
		this.relievingDate = relievingDate;
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
	
	

}
