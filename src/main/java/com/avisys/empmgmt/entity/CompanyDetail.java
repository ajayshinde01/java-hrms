package com.avisys.empmgmt.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name="company_details")
public class CompanyDetail extends Status{
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "comapny_detail_generator")
	@SequenceGenerator(name="company_detail_generator", sequenceName = "company_detail_seq", initialValue = 1, allocationSize = 1)
	private Long id;
	
	@Column(name="company_email")
	@NotBlank(message = "Company Email should not be blank")
	@NotNull(message = "Company Email should not be null")
	private String companyEmail;
	
	@Column(name="client_email")
	@NotNull(message = "Client Email should not be null")
	private String clientEmail;
	
	@Column(name="billable")
	@NotBlank(message = "billable should not be blank")
	@NotNull(message = "billable should not be null")
	private String billable;

	@Column(name="shift")
	@NotBlank(message = "shift should not be blank")
	@NotNull(message = "shift should not be null")
	private String shift;
	
	@Column(name="reviewer_manager")
	@NotBlank(message = "reviewer_manager should not be blank")
	@NotNull(message = "reviewer_manager should not be null")
	private String reviewerManager;
	
	@Column(name="reporting_manager")
	@NotBlank(message = "reporting_manager should not be blank")
	@NotNull(message = "reporting_manager should not be null")
	private String reportingManager;
	
	@Column(name="probation")
	@NotNull(message = "probation should not be null")
	private int probation;
	
	@OneToOne
	@JoinColumn(name="employee_id_fk")
	private Employee employee;

	public CompanyDetail() {
		super();
	}

	public CompanyDetail(
			@NotBlank(message = "Organisation Code should not be blank") @NotNull(message = "Organisation Code should not be null") String orgCode,
			boolean isDeleted, LocalDateTime createdAt, LocalDateTime updatedAt, String createdBy, String updatedBy,
			@NotBlank(message = "Company Email should not be blank") @NotNull(message = "Company Email should not be null") String companyEmail,
			@NotNull(message = "Client Email should not be null") String clientEmail,
			@NotBlank(message = "billable should not be blank") @NotNull(message = "billable should not be null") String billable,
			@NotBlank(message = "shift should not be blank") @NotNull(message = "shift should not be null") String shift,
			@NotBlank(message = "reviewer_manager should not be blank") @NotNull(message = "reviewer_manager should not be null") String reviewerManager,
			@NotBlank(message = "reporting_manager should not be blank") @NotNull(message = "reporting_manager should not be null") String reportingManager,
			@NotNull(message = "probation should not be null") int probation, Employee employee) {
		super(orgCode, isDeleted, createdAt, updatedAt, createdBy, updatedBy);
		this.companyEmail = companyEmail;
		this.clientEmail = clientEmail;
		this.billable = billable;
		this.shift = shift;
		this.reviewerManager = reviewerManager;
		this.reportingManager = reportingManager;
		this.probation = probation;
		this.employee = employee;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCompanyEmail() {
		return companyEmail;
	}

	public void setCompanyEmail(String companyEmail) {
		this.companyEmail = companyEmail;
	}

	public String getClientEmail() {
		return clientEmail;
	}

	public void setClientEmail(String clientEmail) {
		this.clientEmail = clientEmail;
	}

	public String getBillable() {
		return billable;
	}

	public void setBillable(String billable) {
		this.billable = billable;
	}

	public String getShift() {
		return shift;
	}

	public void setShift(String shift) {
		this.shift = shift;
	}

	public String getReviewerManager() {
		return reviewerManager;
	}

	public void setReviewerManager(String reviewerManager) {
		this.reviewerManager = reviewerManager;
	}

	public String getReportingManager() {
		return reportingManager;
	}

	public void setReportingManager(String reportingManager) {
		this.reportingManager = reportingManager;
	}

	public int getProbation() {
		return probation;
	}

	public void setProbation(int probation) {
		this.probation = probation;
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

}
