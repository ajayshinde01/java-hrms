package com.avisys.empmgmt.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@Entity
public class EmergencyContacts extends Status {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "address_id_squenece_generator")
	@SequenceGenerator(name="contact_id_squenece_generator", initialValue = 1, allocationSize = 1)
	@Column(name="id")
	private Long id;
	
	@Column(name="emergency_contact_name")
	private String emergencyContactName;
	
	@Column(name="emergency_contact_number")
	private String emergencyContactNumber;
	
	@Column(name="relation")
	private String relation;
	
	@ManyToOne
	@JoinColumn(name = "employee_id_fk")
	private Employee employee;

	public EmergencyContacts() {
		super();
	}

	public EmergencyContacts(
			@NotBlank(message = "Organisation Code should not be blank") @NotNull(message = "Organisation Code should not be null") String orgCode,
			boolean isDeleted, LocalDateTime createdAt, LocalDateTime updatedAt, String createdBy, String updatedBy,
			String emergencyContactName, String emergencyContactNumber, String relation, Employee employee) {
		super(orgCode, isDeleted, createdAt, updatedAt, createdBy, updatedBy);
		this.emergencyContactName = emergencyContactName;
		this.emergencyContactNumber = emergencyContactNumber;
		this.relation = relation;
		this.employee = employee;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getEmergencyContactName() {
		return emergencyContactName;
	}

	public void setEmergencyContactName(String emergencyContactName) {
		this.emergencyContactName = emergencyContactName;
	}

	public String getEmergencyContactNumber() {
		return emergencyContactNumber;
	}

	public void setEmergencyContactNumber(String emergencyContactNumber) {
		this.emergencyContactNumber = emergencyContactNumber;
	}

	public String getRelation() {
		return relation;
	}

	public void setRelation(String relation) {
		this.relation = relation;
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}
	
}
