package com.avisys.empmgmt.entity;

import java.time.LocalDateTime;

import org.hibernate.annotations.GeneratorType;
import org.hibernate.validator.constraints.UniqueElements;

import jakarta.annotation.Generated;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "Role")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Role {

	@Id
	@Column(name = "ID")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "role_seq")
	@SequenceGenerator(sequenceName = "role_seq", name = "role_seq", initialValue = 1000, allocationSize = 1)
	private long id;

	@NotBlank
	@NotNull

	@Column(name = "role_id")
	private String roleId;

	@NotBlank
	@NotNull
	@Column(name = "name")
	private String roleName;

	// Fields For Logging Purpose

	@Column(name = "Org_code")
	private String orgCode;

	@Column(name = "is_Deleted")
	private boolean isDeleted;

	@Column(name = "Created_at")
	private LocalDateTime createdAt;

	@Column(name = "Updated_at")
	private LocalDateTime updatedAt;

	@Column(name = "Created_by")
	private String createdBy;

	@Column(name = "Updated_by")
	private String updatedBy;

	public Role(String roleId, String roleName, String orgCode, boolean isDeleted, LocalDateTime createdAt,
			LocalDateTime updatedAt, String createdBy, String updatedBy) {
		super();
		this.roleId = roleId;
		this.roleName = roleName;
		this.orgCode = orgCode;
		this.isDeleted = isDeleted;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
		this.createdBy = createdBy;
		this.updatedBy = updatedBy;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public String getRoleId() {
		return roleId;
	}

	public void setRoleId(String roleId) {
		this.roleId = roleId;
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
