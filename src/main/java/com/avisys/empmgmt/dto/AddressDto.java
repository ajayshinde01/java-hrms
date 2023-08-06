package com.avisys.empmgmt.dto;


import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;


public class AddressDto {
	
	private Long id;
	
	@NotNull(message="Id must not be null")
	@NotBlank(message="Id must not be blank")
	@Size(min=2, max=15, message="AddressType should be in between 2 to 15 character")	
	private String addressType;

	@NotNull(message="address1 field must not be null")
	@NotBlank(message="address1 field must not be blank")
	private String address1;

	private String address2;

	private String landmark;

	private String addressTenure;
	
	@NotNull(message="city must not be null")
	@NotBlank(message="city must not be blank")
	private String city;
	
	@NotNull(message="state must not be null")
	@NotBlank(message="state must not be blank")
	private String state;

	@NotNull(message="country must not be null")
	@NotBlank(message="country must not be blank")
	private String country;

	@NotNull(message="postcode must not be null")
	@NotBlank(message="postcode must not be blank")
	private String postcode;
	

	private String ownershipStatus;
	
	@NotBlank(message = "Organisation Code should not be blank")
	@NotNull(message = "Organisation Code should not be null")
	@Pattern(regexp = "^[a-zA-Z0-9-_]{1,50}$",message = "Organization code should not contain any special characters except hypen,underscore")
	private String orgCode;

	private String createdBy;

	private String updatedBy;

	public AddressDto() {
		super();
	}
	
	
	public AddressDto(
			@NotNull(message = "AddressType must not be null") @NotBlank(message = "AddressType must not be blank") @Size(min = 2, max = 15, message = "AddressType should be in between 2 to 15 character") String addressType,
			@NotNull(message = "address1 field must not be null") @NotBlank(message = "address1 field must not be blank") String address1,
			String address2, String landmark, String addressTenure,
			@NotNull(message = "city must not be null") @NotBlank(message = "city must not be blank") String city,
			@NotNull(message = "state must not be null") @NotBlank(message = "state must not be blank") String state,
			@NotNull(message = "country must not be null") @NotBlank(message = "country must not be blank") String country,
			@NotNull(message = "postcode must not be null") @NotBlank(message = "postcode must not be blank") String postcode,
			String ownershipStatus,
			@NotBlank(message = "Organisation Code should not be blank") @NotNull(message = "Organisation Code should not be null") String orgCode, String createdBy, String updatedBy) {
		super();
		this.addressType = addressType;
		this.address1 = address1;
		this.address2 = address2;
		this.landmark = landmark;
		this.addressTenure = addressTenure;
		this.city = city;
		this.state = state;
		this.country = country;
		this.postcode = postcode;
		this.ownershipStatus = ownershipStatus;
		this.orgCode = orgCode;
		this.createdBy = createdBy;
		this.updatedBy = updatedBy;
	}


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	public String getAddressType() {
		return addressType;
	}

	public void setAddressType(String addressType) {
		this.addressType = addressType;
	}

	public String getAddress1() {
		return address1;
	}

	public void setAddress1(String address1) {
		this.address1 = address1;
	}

	public String getAddress2() {
		return address2;
	}

	public void setAddress2(String address2) {
		this.address2 = address2;
	}

	public String getLandmark() {
		return landmark;
	}

	public void setLandmark(String landmark) {
		this.landmark = landmark;
	}

	public String getAddressTenure() {
		return addressTenure;
	}

	public void setAddressTenure(String addressTenure) {
		this.addressTenure = addressTenure;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getPostcode() {
		return postcode;
	}

	public void setPostcode(String postcode) {
		this.postcode = postcode;
	}

	public String getOwnershipStatus() {
		return ownershipStatus;
	}

	public void setOwnershipStatus(String ownershipStatus) {
		this.ownershipStatus = ownershipStatus;
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