package com.avisys.empmgmt.entity;

import java.time.LocalDate;
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
import jakarta.validation.constraints.Pattern;

@Entity
public class WorkExperience extends Status {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "work_experience_squenece_generator")
	@SequenceGenerator(name="work_experience_squenece_generator", initialValue = 1, allocationSize = 1)
	@Column(name="id")
	private Long id;
	
	@Column(name="company_name")
	private String companyName;
	
	@Column(name="designation")
	private String Designation;
	
	@Column(name="from_date")
	private LocalDate fromDate;
	
	@Column(name="to_date")
	private LocalDate toDate;
	
	@Column(name="Address")
	private String address;
	
	@ManyToOne
	@JoinColumn(name = "employee_id_fk")
	private Employee employee;

	public WorkExperience() {
		super();
	}

	public WorkExperience(
			@NotBlank(message = "Organisation Code should not be blank") @NotNull(message = "Organisation Code should not be null") String orgCode,
			boolean isDeleted, LocalDateTime createdAt, LocalDateTime updatedAt, String createdBy, String updatedBy,
			String companyName, String designation, LocalDate fromDate, LocalDate toDate, String address,
			Employee employee) {
		super(orgCode, isDeleted, createdAt, updatedAt, createdBy, updatedBy);
		this.companyName = companyName;
		Designation = designation;
		this.fromDate = fromDate;
		this.toDate = toDate;
		this.address = address;
		this.employee = employee;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public String getDesignation() {
		return Designation;
	}

	public void setDesignation(String designation) {
		Designation = designation;
	}

	public LocalDate getFromDate() {
		return fromDate;
	}

	public void setFromDate(LocalDate fromDate) {
		this.fromDate = fromDate;
	}

	public LocalDate getToDate() {
		return toDate;
	}

	public void setToDate(LocalDate toDate) {
		this.toDate = toDate;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}
	
}
