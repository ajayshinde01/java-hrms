package com.avisys.empmgmt.dto;

import java.util.Date;
import jakarta.persistence.Column;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class EmployeeTypeDTO {
	private Long id;
	@NotBlank(message = "Type Should not be blank")
	@NotNull(message = "Type Should not be null")
	@Size(min = 3, max = 15, message = "type size min = 3 & max = 15")
	private String type;

	@NotBlank(message = "Org code Should not be blank")
	@NotNull(message = "Org code Should not be null")
	@Size(min = 3, max = 15, message = "org code size min = 3 & max = 15")
	private String orgCode;

	private boolean deleted = Boolean.FALSE;

	private Date createdAt;

	private Date updatedAt;

	@NotBlank(message = "Created by Should not be blank")
	@NotNull(message = "Created by code Should not be null")
	@Size(min = 3, max = 15, message = "created by size min = 3 & max = 15")
	private String createdBy;

	@Size(min = 3, max = 15, message = "updated by size min = 3 & max = 15")
	@Column(name = "Updated_By")
	private String updatedBy;

	private String message;

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Long getId() {
		return id;
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

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public Date getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(Date updatedAt) {
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
				+ updatedBy + ", message=" + message + "]";
	}

}
