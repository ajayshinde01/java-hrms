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

@Entity
@Table(name="common_maters")
public class CommonMaster extends Status{
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "common_master_id_squenece_generator")
	@SequenceGenerator(name="common_master_id_squenece_generator", initialValue = 1, allocationSize = 1)
	private Long id;
	
	@NotNull(message="Master Name must not be null")
	@NotBlank(message="Master Name must not be blank")
	@Column(name="master_name")
	private String masterName;
	
	@NotNull(message="Code must not be null")
	@NotBlank(message="Code must not be blank")
	private String code;
	
	private int priority;
	
	@NotNull(message="Value must not be null")
	@NotBlank(message="Value must not be blank")
	private String value;
	
	@Column(name="is_mst")
	@NotNull(message="isMaster must not be null")
	@NotBlank(message="isMaster must not be blank")
	private boolean isMaster;
	
	@Column(name="foreign_key")
	private String foreignKey;
	
	@Column(name="additional_value")
	private String additionalValue;

	public CommonMaster(String orgCode, boolean isDeleted, LocalDateTime createdAt, LocalDateTime updatedAt,
			String createdBy, String updatedBy, Long id, String masterName, String code, int priority, String value,
			boolean isMaster, String foreignKey, String additionalValue) {
		super(orgCode, isDeleted, createdAt, updatedAt, createdBy, updatedBy);
		this.id = id;
		this.masterName = masterName;
		this.code = code;
		this.priority = priority;
		this.value = value;
		this.isMaster = isMaster;
		this.foreignKey = foreignKey;
		this.additionalValue = additionalValue;
	}

	public CommonMaster() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getMasterName() {
		return masterName;
	}

	public void setMasterName(String masterName) {
		this.masterName = masterName;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public int getPriority() {
		return priority;
	}

	public void setPriority(int priority) {
		this.priority = priority;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public boolean getIsMaster() {
		return isMaster;
	}

	public void setIsMaster(boolean isMaster) {
		this.isMaster = isMaster;
	}

	public String getForeignKey() {
		return foreignKey;
	}

	public void setForeignKey(String foreignKey) {
		this.foreignKey = foreignKey;
	}

	public String getAdditionalValue() {
		return additionalValue;
	}

	public void setAdditionalValue(String additionalValue) {
		this.additionalValue = additionalValue;
	}
}
