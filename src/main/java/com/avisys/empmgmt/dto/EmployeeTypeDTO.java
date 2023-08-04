package com.avisys.empmgmt.dto;

import java.time.LocalDateTime;
import jakarta.persistence.Column;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public class EmployeeTypeDTO {
	private Long id;
	@NotBlank(message = "Type Should not be blank")
	@NotNull(message = "Type Should not be null")
	@Pattern(regexp = "^[A-Za-z _ \\-]{1,50}$",message = "Type should only contain _ & - as special character")
	private String type;
	
	@Column(name = "employee_type_id")
	@NotNull(message="Employee Type Id should not be null")
	@NotBlank(message="Employee Type Id should not be blank")
    @Pattern(regexp = "^(?!.*s)[A-Za-z]{1,50}$",message = "ID must starts with alphabets followed numbers & cannot contain special character")
	private String employeeTypeId;

	@NotBlank(message = "Org code Should not be blank")
	@NotNull(message = "Org code Should not be null")
	@Pattern(regexp = "^[a-zA-Z-_]{1,10}$",message = "Organization code can't contain white spaces & special characters")
	private String orgCode;

	private boolean deleted = Boolean.FALSE;

	private LocalDateTime createdAt;

	private LocalDateTime updatedAt;

	@NotBlank(message = "Created by Should not be blank")
	@NotNull(message = "Created by code Should not be null")
	@Size(min = 3, max = 15, message = "created by size min = 3 & max = 15")
	private String createdBy;

	@Size(min = 3, max = 15, message = "updated by size min = 3 & max = 15")
	@Column(name = "Updated_By")
	private String updatedBy;

	public Long getId() {
		return id;
	}

	public String getEmployeeTypeId() {
		return employeeTypeId;
	}

	public void setEmployeeTypeId(String employeeTypeId) {
		this.employeeTypeId = employeeTypeId;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getOrgCode() {
		return orgCode;
	}

	public void setOrgCode(String orgCode) {
		this.orgCode = orgCode;
	}

	public boolean isDeleted() {
		return deleted;
	}

	public void setDeleted(boolean deleted) {
		this.deleted = deleted;
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

	@Override
	public String toString() {
		return "EmployeeTypeDTO [id=" + id + ", type=" + type + ", orgCode=" + orgCode + ", deleted=" + deleted
				+ ", createdAt=" + createdAt + ", updatedAt=" + updatedAt + ", createdBy=" + createdBy + ", updatedBy="
				+ updatedBy + "]";
	}

}
