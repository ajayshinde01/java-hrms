package com.avisys.empmgmt.dto;

import java.time.LocalDate;
import java.time.LocalDateTime;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class EmployeeDto {

	private Long Id;
	
	@NotNull(message="employee code must not be null")
	@NotBlank(message="employee code must not be blank")
	@Size(min=2, max=8, message="Id should be in between 2 to 8 character")
	private String employeeCode;
	
	@NotNull(message="Name must not be null")
	@NotBlank(message="Name must not be blank")
	private String firstName;
	
	@NotNull(message="Name must not be null")
	@NotBlank(message="Name must not be blank")
	private String middleName;
	
	@NotNull(message="Name must not be null")
	@NotBlank(message="Name must not be blank")
	private String lastName;
	
	@NotNull(message="Date must not be null")
//	@NotBlank(message="Name must not be blank")
	private LocalDate dateOfBirth;
	
	@NotNull(message="Gender must not be null")
	@NotBlank(message="Gender must not be blank")
	private String gender;
	
	@NotNull(message="Date must not be null")
//	@NotBlank(message="Name must not be blank")
	private LocalDate dateOfJoining;

	@NotNull(message="Age must not be null")
	@NotBlank(message="Age must not be blank")
	private String age;
	
	@NotNull(message="Status must not be null")
	@NotBlank(message="Status must not be blank")
	private String status;
	
	@NotNull(message="Division must not be null")
	@NotBlank(message="Division must not be blank")
	private String division;
	
	private String userId;
	
	@NotBlank(message = "Organisation Code should not be blank")
	@NotNull(message = "Organisation Code should not be null")
	private String orgCode;
	
	private boolean isDeleted;

	private LocalDateTime createdAt;
	
	private LocalDateTime updatedAt;
	
	private String createdBy;

	private String updatedBy;

	public Long getId() {
		return Id;
	}

	public void setId(Long id) {
		Id = id;
	}

	public String getEmployeeCode() {
		return employeeCode;
	}

	public void setEmployeeCode(String employeeCode) {
		this.employeeCode = employeeCode;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getMiddleName() {
		return middleName;
	}

	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public LocalDate getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(LocalDate dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public LocalDate getDateOfJoining() {
		return dateOfJoining;
	}

	public void setDateOfJoining(LocalDate dateOfJoining) {
		this.dateOfJoining = dateOfJoining;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getDivision() {
		return division;
	}

	public void setDivision(String division) {
		this.division = division;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
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
	

	protected EmployeeDto() {
		super();
	}

	protected EmployeeDto(Long id,
			@NotNull(message = "employee code must not be null") @NotBlank(message = "employee code must not be blank") @Size(min = 2, max = 8, message = "Id should be in between 2 to 8 character") String employeeCode,
			@NotNull(message = "Name must not be null") @NotBlank(message = "Name must not be blank") String firstName,
			@NotNull(message = "Name must not be null") @NotBlank(message = "Name must not be blank") String middleName,
			@NotNull(message = "Name must not be null") @NotBlank(message = "Name must not be blank") String lastName,
			@NotNull(message = "Date must not be null") LocalDate dateOfBirth,
			@NotNull(message = "Gender must not be null") @NotBlank(message = "Gender must not be blank") String gender,
			@NotNull(message = "Date must not be null") LocalDate dateOfJoining,
			@NotNull(message = "Age must not be null") @NotBlank(message = "Age must not be blank") String age,
			@NotNull(message = "Status must not be null") @NotBlank(message = "Status must not be blank") String status,
			@NotNull(message = "Division must not be null") @NotBlank(message = "Division must not be blank") String division,
			String userId,
			@NotBlank(message = "Organisation Code should not be blank") @NotNull(message = "Organisation Code should not be null") String orgCode,
			boolean isDeleted, LocalDateTime createdAt, LocalDateTime updatedAt, String createdBy, String updatedBy) {
		super();
		Id = id;
		this.employeeCode = employeeCode;
		this.firstName = firstName;
		this.middleName = middleName;
		this.lastName = lastName;
		this.dateOfBirth = dateOfBirth;
		this.gender = gender;
		this.dateOfJoining = dateOfJoining;
		this.age = age;
		this.status = status;
		this.division = division;
		this.userId = userId;
		this.orgCode = orgCode;
		this.isDeleted = isDeleted;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
		this.createdBy = createdBy;
		this.updatedBy = updatedBy;
	}

	

}
