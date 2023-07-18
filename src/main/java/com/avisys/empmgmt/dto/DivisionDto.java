package com.avisys.empmgmt.dto;

import java.time.LocalDateTime;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class DivisionDto {
	@NotNull(message = "Id should not be null")
    private Long id;
    
    @NotBlank(message = "Division Id should not be blank")
    @NotNull(message = "Division Id should not be null")
    @Size(min = 3,message = "Division Id must be of 3 character")
    @Size(max = 6,message = "Division Id must be of 6 character")
	private String divisionId;
    
    @NotBlank(message = "Division Name should not be blank" )
    @NotNull(message = "Division Id should not be null")
    @Size(min = 3,message = "divisionName must be of 3 character")
    @Size(max = 20,message = "divisionName must be of 20 character")
	private String divisionName;
    
    @NotBlank(message = "Division Description should not be blank" )
    @Size(max = 30,message = "Division Description must be of 30 character")
	private String divisionDescription;
    
    private String orgCode;
    private boolean isDeleted;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private String createdBy;
    private String updatedBy;
    
    public DivisionDto() {
		super();
	}

	public DivisionDto(Long id,
			@NotBlank(message = "Division Id should not be blank") @NotNull(message = "Division Id should not be null") @Size(min = 3, message = "Division Id must be of 3 character") String divisionId,
			@NotBlank(message = "Division Name should not be blank") @NotNull(message = "Division Id should not be null") @Size(min = 3, message = "divisionName must be of 3 character") String divisionName,
			@NotBlank(message = "Division Description should not be blank") String divisionDescription, String orgCode,
			boolean isDeleted, LocalDateTime createdAt, LocalDateTime updatedAt, String createdBy, String updatedBy) {
		super();
		this.id = id;
		this.divisionId = divisionId;
		this.divisionName = divisionName;
		this.divisionDescription = divisionDescription;
		this.orgCode = orgCode;
		this.isDeleted = isDeleted;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
		this.createdBy = createdBy;
		this.updatedBy = updatedBy;
	}

	public DivisionDto(
			@NotBlank(message = "Division Id should not be blank") @NotNull(message = "Division Id should not be null") @Size(min = 3, message = "Division Id must be of 3 character") String divisionId,
			@NotBlank(message = "Division Name should not be blank") @NotNull(message = "Division Id should not be null") @Size(min = 3, message = "divisionName must be of 3 character") String divisionName,
			@NotBlank(message = "Division Description should not be blank") String divisionDescription, String orgCode,
			boolean isDeleted, LocalDateTime createdAt, LocalDateTime updatedAt, String createdBy, String updatedBy) {
		super();
		this.divisionId = divisionId;
		this.divisionName = divisionName;
		this.divisionDescription = divisionDescription;
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

	public String getDivisionId() {
		return divisionId;
	}

	public void setDivisionId(String divisionId) {
		this.divisionId = divisionId;
	}

	public String getDivisionName() {
		return divisionName;
	}

	public void setDivisionName(String divisionName) {
		this.divisionName = divisionName;
	}

	public String getDivisionDescription() {
		return divisionDescription;
	}

	public void setDivisionDescription(String divisionDescription) {
		this.divisionDescription = divisionDescription;
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
