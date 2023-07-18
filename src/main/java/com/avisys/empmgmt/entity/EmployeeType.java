package com.avisys.empmgmt.entity;

import java.util.Date;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "employeetype")
public class EmployeeType {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "emptype_generator")
	@SequenceGenerator(name = "emptype_generator", sequenceName = "emptype_seq", allocationSize = 1)
	@Column(name = "Id")
	private Long id;

	@NotBlank(message = "Type Should not be blank")
	@NotNull(message = "Type Should not be null")
	@Size(min = 3, max = 15, message = "type size min = 3 & max = 15")
	@Column(name = "Type", nullable = false)
	private String type;

	@NotBlank(message = "Org code Should not be blank")
	@NotNull(message = "Org code Should not be null")
	@Size(min = 3, max = 15, message = "org code size min = 3 & max = 15")
	@Column(name = "Org_Code")
	private String orgCode;

	@Column(name = "Deleted")
	private boolean deleted = Boolean.FALSE;

	@Temporal(TemporalType.TIMESTAMP)
	@CreationTimestamp()
	@Column(name = "Created_On")
	private Date createdAt;

	@Temporal(TemporalType.TIMESTAMP)
	@UpdateTimestamp
	@Column(name = "Updated_On")
	private Date updatedAt;

	@NotBlank(message = "Created by Should not be blank")
	@NotNull(message = "Created by code Should not be null")
	@Size(min = 3, max = 15, message = "created by Size min = 3 & max = 15")
	@Column(name = "Created_By")
	private String createdBy;

	@Size(min = 3, max = 15, message = "updated by Size min = 3 & max = 15")
	@Column(name = "Updated_By")
	private String updatedBy;

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
		return "EmployeeType [id=" + id + ", type=" + type + ", orgCode=" + orgCode + ", deleted=" + deleted
				+ ", createdAt=" + createdAt + ", updatedAt=" + updatedAt + ", createdBy=" + createdBy + ", updatedBy="
				+ updatedBy + "]";
	}

}
