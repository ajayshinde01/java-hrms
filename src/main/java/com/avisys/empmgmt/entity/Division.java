package com.avisys.empmgmt.entity;

import java.time.LocalDateTime;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "division")
public class Division extends Status{
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "divisionId_generator")
	@SequenceGenerator(name="divisionId_generator", sequenceName = "division_seq", initialValue = 1, allocationSize = 1)
	private Long id;
	
	@Column(name = "division_id")
	@NotNull(message="Division Id should not be null")
	@NotBlank(message="Division Id should not be blank")
	@Size(min = 3,message = "Division Id must be of 3 character")
	private String divisionId;
	
	@NotNull(message="Division Id should not be null")
	@NotBlank(message="Division Id should not be blank")
	@Size(min = 3,message = "Division Id must be of 3 character")
	@Column(name = "name")
	private String divisionName;
	
	@NotNull(message="Division Id should not be null")
	@Column(name = "description")
	private String divisionDescription;
	
    public Division() {
		super();
	}
    

	public Division(String divisionId, String divisionName, String divisionDescription, String orgCode,
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
	
	public Division(Long id,String divisionId, String divisionName, String divisionDescription, String orgCode,
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
	

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDivisionId() {
		return divisionId;
	}

	public void setdivisionId(String divisionId) {
		this.divisionId = divisionId;
	}

	public String getdivisionName() {
		return divisionName;
	}

	public void setdivisionName(String divisionName) {
		this.divisionName = divisionName;
	}

	public String getdivisionDescription() {
		return divisionDescription;
	}

	public void setdivisionDescription(String divisionDescription) {
		this.divisionDescription = divisionDescription;
	}
    
    
}
