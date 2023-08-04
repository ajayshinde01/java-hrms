package com.avisys.empmgmt.dto;

import java.time.LocalDate;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public class CreatePersonalDetailsDTO {
	
		@NotNull(message="marital status should not be null")
		@NotBlank(message="marital status should not be blank")
	    private String maritalStatus;

		@NotNull(message="family background should not be null")
	    private String familyBackground;

		@NotNull(message="health details should not be null")
	    private String healthDetails;
	    
		@NotNull(message="cpr number should not be null")
	    private String cprNumber;
	    
		@NotNull(message="gosi should not be null")
	    private String gosi;
	    
		@NotNull(message="aadhaar number should not be null")
		@NotBlank(message="aadhaar_number should not be blank")
		@Pattern(regexp = "\\d{12}", message = "Aadhaar number must be a 12-digit numeric value")
	    private String aadhaarNumber;
	    
		@NotNull(message="aadhaar name should not be null")
		@NotBlank(message="aadhaar name should not be blank")
	    private String aadhaarName;

	    
		@NotNull(message="passport number should not be null")
		@NotBlank(message="passport number should not be blank")
	    @Size(min = 12,max=12,message = "passport number must contain 12 digits")
	    private String passportNumber;
	    
		@NotNull(message="passport name should not be null")
		@NotBlank(message="passport name should not be blank")
	    private String passportName;
	    
	    private LocalDate passportIssueDate;
	    
	    private LocalDate passportValidity;

		@NotNull(message="pan card number should not be null")
		@NotBlank(message="pan card number should not be blank")
		@Pattern(regexp = "^[A-Z]{5}[0-9]{4}[A-Z]$", message = "PAN card number must be a 10-character alphanumeric value in the format ABCDE1234F")
	    private String panCardNumber;
		
		@NotNull(message="pan card name should not be null")
		@NotBlank(message="pan card name should not be blank")
	    private String panCardName;

	    
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
		
		
		protected String createdBy;
		
		@Pattern(regexp = "^[a-zA-Z-_]{1,10}$",message = "Organization code can't contain white spaces & special characters")
		private String orgCode;

	    private String passportFile;
	    
	    private String aadhaarFile;
	    
	    private String panCardFile;
	    
	    

		public CreatePersonalDetailsDTO() {
			super();
		}

		public CreatePersonalDetailsDTO(String maritalStatus,String familyBackground, String healthDetails,String cprNumber,String gosi,String aadhaarNumber,String aadhaarName,String passportNumber,String passportName,
				LocalDate passportIssueDate, LocalDate passportValidity, String panCardNumber,String panCardName, String bankAccountNumber, String bankName,String ifscCode, String uanNumber,String pfNumber, String createdBy, String orgCode,
				String passportFile, String aadhaarFile, String panCardFile) {
			super();
			this.maritalStatus = maritalStatus;
			this.familyBackground = familyBackground;
			this.healthDetails = healthDetails;
			this.cprNumber = cprNumber;
			this.gosi = gosi;
			this.aadhaarNumber = aadhaarNumber;
			this.aadhaarName = aadhaarName;
			this.passportNumber = passportNumber;
			this.passportName = passportName;
			this.passportIssueDate = passportIssueDate;
			this.passportValidity = passportValidity;
			this.panCardNumber = panCardNumber;
			this.panCardName = panCardName;
			this.bankAccountNumber = bankAccountNumber;
			this.bankName = bankName;
			this.ifscCode = ifscCode;
			this.uanNumber = uanNumber;
			this.pfNumber = pfNumber;
			this.createdBy = createdBy;
			this.orgCode = orgCode;
			this.passportFile = passportFile;
			this.aadhaarFile = aadhaarFile;
			this.panCardFile = panCardFile;
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

		public String getCreatedBy() {
			return createdBy;
		}

		public void setCreatedBy(String createdBy) {
			this.createdBy = createdBy;
		}

		public String getOrgCode() {
			return orgCode;
		}

		public void setOrgCode(String orgCode) {
			this.orgCode = orgCode;
		}

		public String getPassportFile() {
			return passportFile;
		}

		public void setPassportFile(String passportFile) {
			this.passportFile = passportFile;
		}

		public String getAadhaarFile() {
			return aadhaarFile;
		}

		public void setAadhaarFile(String aadhaarFile) {
			this.aadhaarFile = aadhaarFile;
		}

		public String getPanCardFile() {
			return panCardFile;
		}

		public void setPanCardFile(String panCardFile) {
			this.panCardFile = panCardFile;
		}

	
}
