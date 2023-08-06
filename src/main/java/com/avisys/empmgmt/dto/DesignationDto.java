package com.avisys.empmgmt.dto;

import java.time.LocalDateTime;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

public class DesignationDto {
	private Long Id;
	
	@NotBlank(message = "Designation ID should not be blank")
	@NotNull(message = "Designation ID should not be null")
    @Pattern(regexp = "^[a-zA-Z0-9]{1,50}$",message = "ID must starts with alphabets followed numbers & cannot contain special character")
	private String designationId;
	
	
	@NotBlank(message = "Designation Name should not be blank")
	@NotNull(message = "Designation Name should not be null")
    @Pattern(regexp = "^[a-zA-Z-_ ]{1,100}$",message = "Name must starts with alphabets")
	private String designationName;

	@NotBlank(message = "Designation Description should not be blank")
	@NotNull(message = "Designation Description should not be null")
	@Pattern(regexp = "^[a-zA-Z0-9 ]{1,250}$",message="Special character are not allowed")
	private String designationDesc;
	

	@NotBlank(message = "Organisation Code should not be blank")
	@NotNull(message = "Organisation Code should not be null")
	@Pattern(regexp = "^[a-zA-Z-_]{1,10}$",message = "Organization code can't contain white spaces & special characters")
	private String orgCode;

	private LocalDateTime createdAt;
	private LocalDateTime updatedAt;
	private String createdBy;
	private String updatedBy;
	
	public DesignationDto() {
		// TODO Auto-generated constructor stub
	}

	public DesignationDto(Long id, String designationId, String designationName, String designationDesc,
			String orgCode, LocalDateTime createdAt, LocalDateTime updatedAt, String createdBy,
			String updatedBy) {
		super();
		Id = id;
		this.designationId = designationId;
		this.designationName = designationName;
		this.designationDesc = designationDesc;
		this.orgCode = orgCode;
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
