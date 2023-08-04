package com.avisys.empmgmt.entity;

import java.time.LocalDate;
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
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

@Entity
@Table(name="personal_details")
public class PersonalDetails extends Status{

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "personal_details_generator")
	@SequenceGenerator(name="personal_details_generator", sequenceName = "personal_details_seq", initialValue = 1, allocationSize = 1)
    private Long id;
    
    @Column(name="marital_status")
	@NotNull(message="marital status should not be null")
	@NotBlank(message="marital status should not be blank")
    private String maritalStatus;

    @Column(name="family_background")
	@NotNull(message="family background should not be null")
    private String familyBackground;
    
    @Column(name="health_details")
	@NotNull(message="health details should not be null")
    private String healthDetails;
    
    @Column(name="cpr_number")
	@NotNull(message="cpr number should not be null")
    private String cprNumber;
    
    @Column(name="gosi")
	@NotNull(message="gosi should not be null")
    private String gosi;
    
    @Column(name="aadhaar_number")
	@NotNull(message="aadhaar number should not be null")
	@NotBlank(message="aadhaar number should not be blank")
    @Pattern(regexp = "\\d{12}", message = "Aadhaar number must be a 12-digit numeric value")
    private String aadhaarNumber;
    
    @Column(name="aadhaar_name")
	@NotNull(message="aadhaar name should not be null")
	@NotBlank(message="aadhaar name should not be blank")
    private String aadhaarName;
    
    private String aadhaarFile;
    
    @Column(name="passport_number")
	@NotNull(message="passport number should not be null")
	@NotBlank(message="passport number should not be blank")
    @Size(min = 12,max=12,message = "passport number must contain 12 digits")
    private String passportNumber;
    
    @Column(name="passport_name")
	@NotNull(message="passport name should not be null")
	@NotBlank(message="passport name should not be blank")
    private String passportName;
    
    private LocalDate passportIssueDate;
    
    private LocalDate passportValidity;

    private String passportFile;
    
    @Column(name="pan_card_number")
	@NotNull(message="pan card number should not be null")
	@NotBlank(message="pan card number should not be blank")
    @Size(min = 10,max=10,message = "pan card number must contain 10 digits")
    private String panCardNumber;
    
    @Column(name="pan_card_name")
	@NotNull(message="pan card name should not be null")
	@NotBlank(message="pan card name should not be blank")
    private String panCardName;
	
    private String panCardFile;
    
    @Column(name="bank_account_number")
	@NotNull(message="bank account number should not be null")
	@NotBlank(message="bank account number should not be blank")
    @Pattern (regexp = "^[0-9]{9,18}$",message = "bank account number should be a numeric value between 9 and 18 digits")
    private String bankAccountNumber;
    
    @Column(name = "bank_name")
	@NotNull(message="bank name should not be null")
	@NotBlank(message="bank name should not be blank")
    private String bankName;
    
    @Column(name = "ifsc_code")
	@NotNull(message="ifsc code should not be null")
	@NotBlank(message="ifsc code should not be blank")
    private String ifscCode;
    
    @Column(name = "uan_number")
	@NotNull(message="uan number should not be null")
	@NotBlank(message="uan number should not be blank")
    private String uanNumber;
    
    @Column(name="pf_number")
	@NotNull(message="pf number should not be null")
    private String pfNumber;
    
    @OneToOne
    @JoinColumn(name="employee_id")
    private Employee employee;

	public PersonalDetails() {
		super();
	}

	public PersonalDetails(String orgCode,
			boolean isDeleted, LocalDateTime createdAt, LocalDateTime updatedAt, String createdBy, String updatedBy, String maritalStatus,String familyBackground, String healthDetails,String cprNumber,String gosi, String aadhaarNumber, String aadhaarName,
			String aadhaarFile,String passportNumber,String passportName,LocalDate passportIssueDate, LocalDate passportValidity, String passportFile, String panCardNumber,String panCardName,String panCardFile,String bankAccountNumber,String bankName, String ifscCode,String uanNumber, String pfNumber, Employee employee) {
		super(orgCode, isDeleted, createdAt, updatedAt, createdBy, updatedBy);
		this.maritalStatus = maritalStatus;
		this.familyBackground = familyBackground;
		this.healthDetails = healthDetails;
		this.cprNumber = cprNumber;
		this.gosi = gosi;
		this.aadhaarNumber = aadhaarNumber;
		this.aadhaarName = aadhaarName;
		this.aadhaarFile = aadhaarFile;
		this.passportNumber = passportNumber;
		this.passportName = passportName;
		this.passportIssueDate = passportIssueDate;
		this.passportValidity = passportValidity;
		this.passportFile = passportFile;
		this.panCardNumber = panCardNumber;
		this.panCardName = panCardName;
		this.panCardFile = panCardFile;
		this.bankAccountNumber = bankAccountNumber;
		this.bankName = bankName;
		this.ifscCode = ifscCode;
		this.uanNumber = uanNumber;
		this.pfNumber = pfNumber;
		this.employee = employee;
	}



	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getMaritalStatus() {
		return maritalStatus;
	}

	public void setMaritalStatus(String maritalStatus) {
		this.maritalStatus = maritalStatus;
	}

	public String getFamilyBackground() {
		return familyBackground;
	}

	public void setFamilyBackground(String familyBackground) {
		this.familyBackground = familyBackground;
	}

	public String getHealthDetails() {
		return healthDetails;
	}

	public void setHealthDetails(String healthDetails) {
		this.healthDetails = healthDetails;
	}

	public String getCprNumber() {
		return cprNumber;
	}

	public void setCprNumber(String cprNumber) {
		this.cprNumber = cprNumber;
	}

	public String getGosi() {
		return gosi;
	}

	public void setGosi(String gosi) {
		this.gosi = gosi;
	}

	public String getAadhaarNumber() {
		return aadhaarNumber;
	}

	public void setAadhaarNumber(String aadhaarNumber) {
		this.aadhaarNumber = aadhaarNumber;
	}

	public String getAadhaarName() {
		return aadhaarName;
	}

	public void setAadhaarName(String aadhaarName) {
		this.aadhaarName = aadhaarName;
	}

	public String getAadhaarFile() {
		return aadhaarFile;
	}

	public void setAadhaarFile(String aadhaarFile) {
		this.aadhaarFile = aadhaarFile;
	}

	public String getPassportNumber() {
		return passportNumber;
	}

	public void setPassportNumber(String passportNumber) {
		this.passportNumber = passportNumber;
	}

	public String getPassportName() {
		return passportName;
	}

	public void setPassportName(String passportName) {
		this.passportName = passportName;
	}

	public LocalDate getPassportIssueDate() {
		return passportIssueDate;
	}

	public void setPassportIssueDate(LocalDate passportIssueDate) {
		this.passportIssueDate = passportIssueDate;
	}

	public LocalDate getPassportValidity() {
		return passportValidity;
	}

	public void setPassportValidity(LocalDate passportValidity) {
		this.passportValidity = passportValidity;
	}

	public String getPassportFile() {
		return passportFile;
	}

	public void setPassportFile(String passportFile) {
		this.passportFile = passportFile;
	}

	public String getPanCardNumber() {
		return panCardNumber;
	}

	public void setPanCardNumber(String panCardNumber) {
		this.panCardNumber = panCardNumber;
	}

	public String getPanCardName() {
		return panCardName;
	}

	public void setPanCardName(String panCardName) {
		this.panCardName = panCardName;
	}

	public String getPanCardFile() {
		return panCardFile;
	}

	public void setPanCardFile(String panCardFile) {
		this.panCardFile = panCardFile;
	}

	public String getBankAccountNumber() {
		return bankAccountNumber;
	}

	public void setBankAccountNumber(String bankAccountNumber) {
		this.bankAccountNumber = bankAccountNumber;
	}

	public String getBankName() {
		return bankName;
	}

	public void setBankName(String bankName) {
		this.bankName = bankName;
	}

	public String getIfscCode() {
		return ifscCode;
	}

	public void setIfscCode(String ifscCode) {
		this.ifscCode = ifscCode;
	}

	public String getUanNumber() {
		return uanNumber;
	}

	public void setUanNumber(String uanNumber) {
		this.uanNumber = uanNumber;
	}

	public String getPfNumber() {
		return pfNumber;
	}

	public void setPfNumber(String pfNumber) {
		this.pfNumber = pfNumber;
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}
    
}
