package com.avisys.empmgmt.dto;

import java.time.LocalDate;
import java.time.LocalDateTime;


import jakarta.persistence.Column;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;


public class PersonalDetailsDTO{

	private Long id;

	@NotNull(message="marital status should not be null")
	@NotBlank(message="marital status should not be blank")
    private String maritalStatus;

	@NotNull(message="family background should not be null")
    private String familyBackground;
    
	@NotNull(message="health details should not be null")
    private String healthDetails;
    
	@NotNull(message="cpr number should not be null")
    private String cprNumber;
    
    @Column(name="gosi")
	@NotNull(message="gosi should not be null")
    private String gosi;

	@NotNull(message="aadhaar number should not be null")
	@NotBlank(message="aadhaar_number should not be blank")
	@Pattern(regexp = "\\d{12}", message = "Aadhaar number must be a 12-digit numeric value")
    private String aadhaarNumber;
    
	@NotNull(message="aadhaar name should not be null")
	@NotBlank(message="aadhaar name should not be blank")
    private String aadhaarName;
    
    private String aadhaarFile;
    
	@NotNull(message="passport number should not be null")
	@NotBlank(message="passport number should not be blank")
    @Size(min = 12,message = "passport number must contain 12 digits")
    @Size(max = 12,message = "passport number must contain 12 digits")
    private String passportNumber;
    
	@NotNull(message="passport name should not be null")
	@NotBlank(message="passport name should not be blank")
    private String passportName;
    
    private LocalDate passportIssueDate;
    
    private LocalDate passportValidity;

    private String passportFile;
    
    @Column(name="pan_card_number")
	@NotNull(message="pan card number should not be null")
	@NotBlank(message="pan card number should not be blank")
	@Pattern(regexp = "^[A-Z]{5}[0-9]{4}[A-Z]$", message = "PAN card number must be a 10-character alphanumeric value in the format ABCDE1234F")
    private String panCardNumber;
    
	@NotNull(message="pan card name should not be null")
	@NotBlank(message="pan card name should not be blank")
    private String panCardName;
	
    private String panCardFile;
    
	@NotNull(message="bank account number should not be null")
	@NotBlank(message="bank account number should not be blank")
    @Pattern (regexp = "^[0-9]{9,18}$",message = "bank account number should be a numeric value between 9 and 18 digits")
    private String bankAccountNumber;
    
	@NotNull(message="bank name should not be null")
	@NotBlank(message="bank name should not be blank")
    private String bankName;
    
	@NotNull(message="ifsc code should not be null")
	@NotBlank(message="ifsc code should not be blank")
    private String ifscCode;

	@NotNull(message="uan number should not be null")
	@NotBlank(message="uan number should not be blank")
    private String uanNumber;

	@NotNull(message="pf number should not be null")
    private String pfNumber;

	private LocalDateTime createdAt;

	private LocalDateTime updatedAt;
	
	private String createdBy;
	
	private String updatedBy;
	
	@Pattern(regexp = "^[a-zA-Z-_]{1,10}$",message = "Organization code can't contain white spaces & special characters")
	private String orgCode;
	
	public PersonalDetailsDTO(String orgCode, LocalDateTime createdAt, LocalDateTime updatedAt,
			String createdBy, String updatedBy,String maritalStatus,String familyBackground,String healthDetails,String cprNumber,String gosi,String aadhaarNumber,String aadhaarName,
			String aadhaarFile,String passportNumber, String passportName,LocalDate passportIssueDate, LocalDate passportValidity, String passportFile, String panCardNumber,String panCardName,
			String panCardFile,String bankAccountNumber,String bankName,String ifscCode, String uanNumber,String pfNumber) {
		this.orgCode = orgCode;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
		this.updatedBy = updatedBy;
		this.createdBy = createdBy;
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
	}
	
	public PersonalDetailsDTO() {
		super();
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

	public String getOrgCode() {
		return orgCode;
	}

	public void setOrgCode(String orgCode) {
		this.orgCode = orgCode;
	}
	
	

}
