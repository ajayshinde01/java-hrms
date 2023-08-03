package com.avisys.empmgmt.entity;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import com.avisys.empmgmt.dto.PersonalDetailsDTO;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
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
	@Pattern(regexp = "^(?!.*\s)[A-Za-z0-9]{1,50}$",message = "ID must starts with alphabets followed numbers")
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
	
	@Column(name="division")
	@NotNull(message="Division must not be null")
	@NotBlank(message="Division must not be blank")
	private String division;
	
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
	private List<EmergencyContacts> emergencyContacts=new ArrayList<>();

	protected Employee() {
		super();
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

}
