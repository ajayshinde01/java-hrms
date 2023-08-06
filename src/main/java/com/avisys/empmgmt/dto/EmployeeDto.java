package com.avisys.empmgmt.dto;

import java.time.LocalDate;

import com.avisys.empmgmt.entity.Division;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public class EmployeeDto {

	private Long Id;
	
	@NotNull(message="employee code must not be null")
	@NotBlank(message="employee code must not be blank")
	@Size(min=2, max=8, message="Id should be in between 2 to 8 character")
	private String employeeCode;
	
	private String profile_image;
	
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
	private LocalDate dateOfBirth;
	
	@NotNull(message="Gender must not be null")
	@NotBlank(message="Gender must not be blank")
	private String gender;
	
	@NotNull(message="Date must not be null")
	private LocalDate dateOfJoining;

	@NotNull(message="Age must not be null")
	@NotBlank(message="Age must not be blank")
	private String age;
	
	@NotNull(message="Status must not be null")
	@NotBlank(message="Status must not be blank")
	private String status;
	
	private Division division;
	
	private String userId;
	
	@NotNull(message="Mobile number must not be null")
	@NotBlank(message="Mobile number must not be blank")
	private String mobile;
	
	private String phone;
	
	@NotNull(message="Email Id must not be null")
	@NotBlank(message="Email Id must not be blank")
	private String email;
	
	@NotBlank(message = "Organisation Code should not be blank")
	@NotNull(message = "Organisation Code should not be null")
	@Pattern(regexp = "^[a-zA-Z-_]{1,10}$",message = "Organization code can't contain white spaces & special characters")
	private String orgCode;

	private String createdBy;

	private String updatedBy;

	public EmployeeDto() {
		super();
	}
	

	public EmployeeDto(Long id,
			@NotNull(message = "employee code must not be null") @NotBlank(message = "employee code must not be blank") @Size(min = 2, max = 8, message = "Id should be in between 2 to 8 character") String employeeCode,
			String profile_image,
			@NotNull(message = "Name must not be null") @NotBlank(message = "Name must not be blank") String firstName,
			@NotNull(message = "Name must not be null") @NotBlank(message = "Name must not be blank") String middleName,
			@NotNull(message = "Name must not be null") @NotBlank(message = "Name must not be blank") String lastName,
			@NotNull(message = "Date must not be null") LocalDate dateOfBirth,
			@NotNull(message = "Gender must not be null") @NotBlank(message = "Gender must not be blank") String gender,
			@NotNull(message = "Date must not be null") LocalDate dateOfJoining,
			@NotNull(message = "Age must not be null") @NotBlank(message = "Age must not be blank") String age,
			@NotNull(message = "Status must not be null") @NotBlank(message = "Status must not be blank") String status,
			Division division, String userId,
			@NotNull(message = "Mobile number must not be null") @NotBlank(message = "Mobile number must not be blank") String mobile,
			String phone,
			@NotNull(message = "Email Id must not be null") @NotBlank(message = "Email Id must not be blank") String email,
			@NotBlank(message = "Organisation Code should not be blank") @NotNull(message = "Organisation Code should not be null") String orgCode,
            String createdBy, String updatedBy) {
		super();
		Id = id;
		this.employeeCode = employeeCode;
		this.profile_image = profile_image;
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
		this.mobile = mobile;
		this.phone = phone;
		this.email = email;
		this.orgCode = orgCode;
		this.createdBy = createdBy;
		this.updatedBy = updatedBy;
	}


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


	public String getUserId() {
		return userId;
	}


	public void setUserId(String userId) {
		this.userId = userId;
	}


	public String getMobile() {
		return mobile;
	}


	public void setMobile(String mobile) {
		this.mobile = mobile;
	}


	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getOrgCode() {
		return orgCode;
	}

	public void setOrgCode(String orgCode) {
		this.orgCode = orgCode;
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

	public String getProfile_image() {
		return profile_image;
	}

	public void setProfile_image(String profile_image) {
		this.profile_image = profile_image;
	}

	public Division getDivision() {
		return division;
	}

	public void setDivision(Division division) {
		this.division = division;
	}	

}