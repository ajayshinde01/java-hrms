package com.avisys.empmgmt.dto;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public class DesignationDto {
	private Long Id;
	
	@NotBlank(message = "Designation ID should not be blank")
	@NotNull(message = "Designation ID should not be null")
	@Size(min = 3,message = "Designation ID must be of 3 character" )
	@Size(max = 10 ,message = "Designation ID must be of less than 10 character")
    @Pattern(regexp = "^(?!.*\s)[A-Za-z0-9]{1,50}$",message = "ID must starts with alphabets followed numbers")
	private String designationId;
	
	
	@NotBlank(message = "Designation Name should not be blank")
	@NotNull(message = "Designation Name should not be null")
	@Size(min = 3,message = "Designation Name must be of 3 character")
	@Size(max = 20 ,message = "Designation Name must be of less than 20 character")
    @Pattern(regexp = "^[a-zA-Z]+[a-zA-Z0-9 ]+$",message = "Name must starts with alphabets")
	private String designationName;

	@NotBlank(message = "Designation Description should not be blank")
	@NotNull(message = "Designation Description should not be null")
	@Size(min = 3,message = "Designation Description must be of 3 character")
	@Size(max = 20 ,message = "Designation Description must be of less than 20 character")
	private String designationDesc;
	

	@NotBlank(message = "Organisation Code should not be blank")
	@NotNull(message = "Organisation Code should not be null")
	private String orgCode;
	
	private boolean isDeleted ;
	private LocalDateTime createdAt;
	private LocalDateTime updatedAt;
	private String createdBy;
	private String updatedBy;
	
	public DesignationDto() {
		// TODO Auto-generated constructor stub
	}

	public DesignationDto(Long id, String designationId, String designationName, String designationDesc,
			String orgCode, boolean isDeleted, LocalDateTime createdAt, LocalDateTime updatedAt, String createdBy,
			String updatedBy) {
		super();
		Id = id;
		this.designationId = designationId;
		this.designationName = designationName;
		this.designationDesc = designationDesc;
		this.orgCode = orgCode;
		this.isDeleted = isDeleted;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
		this.createdBy = createdBy;
		this.updatedBy = updatedBy;
	}

	public Long getId() {
		return Id;
	}

	public void setId(Long id) {
		Id = id;
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
