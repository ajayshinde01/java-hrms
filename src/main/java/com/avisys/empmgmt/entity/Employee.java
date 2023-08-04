package com.avisys.empmgmt.entity;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
@Table(name="employee_info")
public class Employee extends Status{
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "employee_info_id_squenece_generator")
	@SequenceGenerator(name="employee_info_id_squenece_generator", initialValue = 1, allocationSize = 1)
	@Column(name="ID")
	private Long id;
	
	private String profile_image;
	
	@Column(name="employee_code", unique=true)
	@NotNull(message="employee code must not be null")
	@NotBlank(message="employee code must not be blank")
	@Size(min=2, max=8, message="Id should be in between 2 to 8 character")
	private String employeeCode;
	
	@Column(name="first_name")
	@NotNull(message="Name must not be null")
	@NotBlank(message="Name must not be blank")
	private String firstName;
	
	@Column(name="middle_name")
	@NotNull(message="Name must not be null")
	@NotBlank(message="Name must not be blank")
	private String middleName;
	
	@Column(name="last_name")
	@NotNull(message="Name must not be null")
	@NotBlank(message="Name must not be blank")
	private String lastName;
	
	@Column(name="date_of_birth")
	@NotNull(message="Date must not be null")
	private LocalDate dateOfBirth;
	
	@Column(name="gender")
	@NotNull(message="Gender must not be null")
	@NotBlank(message="Gender must not be blank")
	private String gender;
	
	@Column(name="date_of_joining")
	@NotNull(message="Date must not be null")
	private LocalDate dateOfJoining;

	@Column(name="age")
	@NotNull(message="Age must not be null")
	@NotBlank(message="Age must not be blank")
	private String age;
	
	@Column(name="status")
	@NotNull(message="Status must not be null")
	@NotBlank(message="Status must not be blank")
	private String status;
	
	@ManyToOne
	@JoinColumn(name="divion_id_fk")
	private Division division;
	
	@Column(name="user_id")
	private String userId;
	
	@Column(name="mobile_no")
	private String mobile;
	
	@Column(name="phone_no")
	private String phone;
	
	@Column(name="email")
	private String email;
	
	@OneToMany(mappedBy = "employee", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private List<Address> addressList=new ArrayList<>();
	
	@OneToOne(mappedBy = "employee",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
	private CompanyDetail companyDetail;

	@OneToOne(mappedBy = "employee",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    private PersonalDetails personalDetails;

	@OneToOne(mappedBy = "employee",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
	private JoiningDetail joiningDetail;

	@OneToMany(mappedBy = "employee", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private List<WorkExperience> workExperience=new ArrayList<>();
	
	@OneToMany(mappedBy = "employee", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private List<EmergencyContacts> emergencyContacts=new ArrayList<>();
	
	@OneToMany(mappedBy = "employee", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private List<Visa> visa=new ArrayList<>();

	public Employee() {
		super();
	}


	public Employee(
			@NotBlank(message = "Organisation Code should not be blank") @NotNull(message = "Organisation Code should not be null") String orgCode,
			boolean isDeleted, LocalDateTime createdAt, LocalDateTime updatedAt, String createdBy, String updatedBy,
			String profile_image,
			@NotNull(message = "employee code must not be null") @NotBlank(message = "employee code must not be blank") @Size(min = 2, max = 8, message = "Id should be in between 2 to 8 character") String employeeCode,
			@NotNull(message = "Name must not be null") @NotBlank(message = "Name must not be blank") String firstName,
			@NotNull(message = "Name must not be null") @NotBlank(message = "Name must not be blank") String middleName,
			@NotNull(message = "Name must not be null") @NotBlank(message = "Name must not be blank") String lastName,
			@NotNull(message = "Date must not be null") LocalDate dateOfBirth,
			@NotNull(message = "Gender must not be null") @NotBlank(message = "Gender must not be blank") String gender,
			@NotNull(message = "Date must not be null") LocalDate dateOfJoining,
			@NotNull(message = "Age must not be null") @NotBlank(message = "Age must not be blank") String age,
			@NotNull(message = "Status must not be null") @NotBlank(message = "Status must not be blank") String status,
			Division division, String userId, String mobile, String phone, String email, List<Address> addressList,
			CompanyDetail companyDetail, PersonalDetails personalDetails, JoiningDetail joiningDetail,
			List<WorkExperience> workExperience, List<EmergencyContacts> emergencyContacts, List<Visa> visa) {
		super(orgCode, isDeleted, createdAt, updatedAt, createdBy, updatedBy);
		this.profile_image = profile_image;
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
		this.mobile = mobile;
		this.phone = phone;
		this.email = email;
		this.addressList = addressList;
		this.companyDetail = companyDetail;
		this.personalDetails = personalDetails;
		this.joiningDetail = joiningDetail;
		this.workExperience = workExperience;
		this.emergencyContacts = emergencyContacts;
		this.visa = visa;
	}



	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
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


	public List<Address> getAddressList() {
		return addressList;
	}


	public void setAddressList(List<Address> addressList) {
		this.addressList = addressList;
	}


	public CompanyDetail getCompanyDetail() {
		return companyDetail;
	}


	public void setCompanyDetail(CompanyDetail companyDetail) {
		this.companyDetail = companyDetail;
	}

	public PersonalDetails getPersonalDetails() {
		return personalDetails;
	}

	public void setPersonalDetails(PersonalDetails personalDetails) {
		this.personalDetails = personalDetails;
	}

	public JoiningDetail getJoiningDetail() {
		return joiningDetail;
	}

	public void setJoiningDetail(JoiningDetail joiningDetail) {
		this.joiningDetail = joiningDetail;
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

	public List<EmergencyContacts> getEmergencyContacts() {
		return emergencyContacts;
	}

	public void setEmergencyContacts(List<EmergencyContacts> emergencyContacts) {
		this.emergencyContacts = emergencyContacts;
	}


	public List<WorkExperience> getWorkExperience() {
		return workExperience;
	}


	public void setWorkExperience(List<WorkExperience> workExperience) {
		this.workExperience = workExperience;
	}


	public List<Visa> getVisa() {
		return visa;
	}


	public void setVisa(List<Visa> visa) {
		this.visa = visa;
	}
	
	

}
