package com.avisys.empmgmt.entity;

import java.time.LocalDateTime;

import com.avisys.empmgmt.dto.GradeDTO;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;

@Entity
@Getter
public class Grade {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "Id_sequence_generator")
	@SequenceGenerator(name = "Id_sequence_generator", initialValue = 1, allocationSize = 1)
	private Long id;

	@NotBlank(message = "Grade Id is required")
	@NotNull(message = "Grade Id is not null")
	@Column(name = "grade_id", unique = true)
	private String gradeId;

	@NotBlank(message = "Grade Name is required")
	@NotNull(message = "Grade Name  is not null")
	@Column(name = "name")
	private String gradeName;

	@NotBlank(message = "Grade Type is required")
	@NotNull(message = "Grade Type  is not null")
	@Column(name = "type")
	private String gradeType;

	@Column(name = "org_code")
	private String orgCode;
	@Column(name = "is_deleted")
	private boolean isDeleted;

	@Column(name = "created_by")
	private String createdBy;
	@Column(name = "created_at")
	private LocalDateTime createdAt;

	@Column(name = "updated_at")
	private LocalDateTime updatedAt;
	@Column(name = "updated_by")
	private String updatedBy;

	public Grade() {
		super();
	}

	public Grade(Long id, String gradeId, String gradeName, String gradeType, String orgCode, boolean isDeleted,
			LocalDateTime createdAt, LocalDateTime updatedAt, String createdBy, String updatedBy) {
		super();
		this.id = id;
		this.gradeId = gradeId;
		this.gradeName = gradeName;
		this.gradeType = gradeType;
		this.orgCode = orgCode;
		this.isDeleted = isDeleted;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
		this.createdBy = createdBy;
		this.updatedBy = updatedBy;
	}

	public Grade(GradeDTO gradeDtoObject) {
		this.id = gradeDtoObject.getId();
		this.gradeId = gradeDtoObject.getGradeId();
		this.gradeName = gradeDtoObject.getGradeName();
		this.gradeType = gradeDtoObject.getGradeType();
		this.orgCode = gradeDtoObject.getOrgCode();

	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getGradeId() {
		return gradeId;
	}

	public void setGradeId(String gradeId) {
		this.gradeId = gradeId;
	}

	public String getGradeName() {
		return gradeName;
	}

	public void setGradeName(String gradeName) {
		this.gradeName = gradeName;
	}

	public String getGradeType() {
		return gradeType;
	}

	public void setGradeType(String gradeType) {
		this.gradeType = gradeType;
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
