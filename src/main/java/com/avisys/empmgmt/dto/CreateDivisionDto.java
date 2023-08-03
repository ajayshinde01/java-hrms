package com.avisys.empmgmt.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public class CreateDivisionDto {
	@NotNull(message="Division Id should not be null")
	@NotBlank(message="Division Id should not be blank")
	@Size(min = 3,message = "Division Id must be of 3 character")
	@Size(max = 6,message = "Division Id must be of 6 character")
    @Pattern(regexp = "^(?!.*\s)[A-Za-z0-9]{1,50}$",message = "ID must starts with alphabets followed numbers")
	private String divisionId;
    
	@NotNull(message="divisionName should not be null")
	@NotBlank(message="divisionName should not be blank")
	@Size(min = 3,message = "divisionName must be of 3 character")
    @Size(max = 20,message = "divisionName must be of 20 character")
    @Pattern(regexp = "^[a-zA-Z]+[a-zA-Z0-9 ]+$",message = "Name must starts with alphabets")
	private String divisionName;
    
    @NotBlank(message = "Division Description should not be blank" )
    @Size(max = 30,message = "Division Description must be of 30 character")
	private String divisionDescription;
    
    @NotNull(message="Orgcode should not be null")
	@NotBlank(message="Orgcode should not be blank")
	@Size(min = 3,message = "Orgcode must be of 3 character")
    private String orgCode;
    
    private String createdBy;
    
    private String updatedBy;
    
	public CreateDivisionDto() {
         super();
	}

	public CreateDivisionDto(
			@NotNull(message = "Division Id should not be null") @NotBlank(message = "Division Id should not be blank") @Size(min = 3, message = "Division Id must be of 3 character") String divisionId,
			@NotNull(message = "divisionName should not be null") @NotBlank(message = "divisionNameshould not be blank") @Size(min = 3, message = "divisionName must be of 3 character") String divisionName,
			@NotNull(message = "divisionDescription should not be null") String divisionDescription,
			@NotNull(message = "Orgcode should not be null") @NotBlank(message = "Orgcode should not be blank") @Size(min = 3, message = "Orgcode must be of 3 character") String orgCode,
			String createdBy, String updatedBy) {
		super();
		this.divisionId = divisionId;
		this.divisionName = divisionName;
		this.divisionDescription = divisionDescription;
		this.orgCode = orgCode;
		this.createdBy = createdBy;
		this.updatedBy = updatedBy;
	}



	public String getDivisionId() {
		return divisionId;
	}

	public void setDivisionId(String divisionId) {
		this.divisionId = divisionId;
	}

	public String getDivisionName() {
		return divisionName;
	}

	public void setDivisionName(String divisionName) {
		this.divisionName = divisionName;
	}

	public String getDivisionDescription() {
		return divisionDescription;
	}

	public void setDivisionDescription(String divisionDescription) {
		this.divisionDescription = divisionDescription;
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
	
	
	
}
