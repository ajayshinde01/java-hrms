package com.avisys.empmgmt.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

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
	@Pattern(regexp = "^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$", message = "Please enter a valid email address.")
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
	
	@ManyToOne
	@JoinColumn(name="designation_id")
	private Designation designation;

	@ManyToOne
	@JoinColumn(name="department_id)")
	private Department department;

	@ManyToOne
	@JoinColumn(name="grade_id")
	private Grade grade;
	
	@ManyToOne
	@JoinColumn(name="role_id")
	private Role role;
	
	@ManyToOne
	@JoinColumn(name="employee_type_id")
	private EmployeeType employeeType;
	
	public CompanyDetail() {
		super();
	}

	public CompanyDetail(String orgCode,boolean isDeleted, LocalDateTime createdAt, LocalDateTime updatedAt, String createdBy, 
			String updatedBy,String companyEmail, String clientEmail,String billable,String shift,String reviewerManager,
			String reportingManager,int probation, Employee employee,
			Designation designation, Department department, Grade grade, Role role, EmployeeType employeeType) {
		super(orgCode, isDeleted, createdAt, updatedAt, createdBy, updatedBy);
		this.companyEmail = companyEmail;
		this.clientEmail = clientEmail;
		this.billable = billable;
		this.shift = shift;
		this.reviewerManager = reviewerManager;
		this.reportingManager = reportingManager;
		this.probation = probation;
		this.employee = employee;
		this.designation = designation;
		this.department = department;
		this.grade = grade;
		this.role = role;
		this.employeeType = employeeType;
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

	public Designation getDesignation() {
		return designation;
	}

	public void setDesignation(Designation designation) {
		this.designation = designation;
	}

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}



	public Grade getGrade() {
		return grade;
	}



	public void setGrade(Grade grade) {
		this.grade = grade;
	}


	public Role getRole() {
		return role;
	}


	public void setRole(Role role) {
		this.role = role;
	}

	public EmployeeType getEmployeeType() {
		return employeeType;
	}

	public void setEmployeeType(EmployeeType employeeType) {
		this.employeeType = employeeType;
	}

	
}
