package com.avisys.empmgmt.dto;

import java.time.LocalDate;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

public class CreateJoiningDetailDTO {
	
	@NotNull(message = "confirmation date is required")
	private LocalDate confirmationDate;
	
	private int noticePeriod;
	
	@NotNull(message = "resignation date is required")
	private LocalDate resignationDate;
	
	private LocalDate relievingDate;
    
	private String createdBy;
     
	@NotBlank(message = "Organisation Code should not be blank")
	@NotNull(message = "Organisation Code should not be null")
	@Pattern(regexp = "^[a-zA-Z-_]{1,10}$",message = "Organization code can't contain white spaces & special characters")
	protected String orgCode;
    
	public CreateJoiningDetailDTO() {
		super();
	}

	public CreateJoiningDetailDTO(LocalDate confirmationDate,int noticePeriod,LocalDate resignationDate, LocalDate relievingDate,String createdBy) {
		super();
		this.confirmationDate = confirmationDate;
		this.noticePeriod = noticePeriod;
		this.resignationDate = resignationDate;
		this.relievingDate = relievingDate;
		this.createdBy = createdBy;
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
