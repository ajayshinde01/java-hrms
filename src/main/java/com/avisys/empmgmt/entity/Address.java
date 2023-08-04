package com.avisys.empmgmt.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
@Table(name="address")
public class Address extends Status{
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "address_id_squenece_generator")
	@SequenceGenerator(name="address_id_squenece_generator", initialValue = 1, allocationSize = 1)
	@Column(name="id")
	private Long id;
	
	@Column(name = "address_type", length = 25)
	@NotNull(message="Id must not be null")
	@NotBlank(message="Id must not be blank")
	@Size(min=2, max=15, message="AddressType should be in between 2 to 15 character")	
	private String addressType;

	@Column(name = "address_1", length = 45)
	@NotNull(message="address1 field must not be null")
	@NotBlank(message="address1 field must not be blank")
	private String address1;

	@Column(name = "address_2", length = 45)
	private String address2;

	@Column(length = 45)
	private String landmark;

	@Column(name="address_tenure",length = 45)
	private String addressTenure;
	
	@Column(length = 25)
	@NotNull(message="city must not be null")
	@NotBlank(message="city must not be blank")
	private String city;
	
	@Column(length = 25)
	@NotNull(message="state must not be null")
	@NotBlank(message="state must not be blank")
	private String state;

	@Column(length = 25)
	@NotNull(message="country must not be null")
	@NotBlank(message="country must not be blank")
	private String country;

	@Column(name="post_code", length=20)
	@NotNull(message="postcode must not be null")
	@NotBlank(message="postcode must not be blank")
	private String postcode;
	
	@Column(name="ownership_status")
	private String ownershipStatus;
	
	@ManyToOne
	@JoinColumn(name = "employee_id_fk")
	private Employee employee;
	

	public Address() {
		super();
	}

	
	public Address(
			@NotBlank(message = "Organisation Code should not be blank") @NotNull(message = "Organisation Code should not be null") String orgCode,
			boolean isDeleted, LocalDateTime createdAt, LocalDateTime updatedAt, String createdBy, String updatedBy,
			@NotNull(message = "Id must not be null") @NotBlank(message = "Id must not be blank") @Size(min = 2, max = 15, message = "AddressType should be in between 2 to 15 character") String addressType,
			@NotNull(message = "address1 field must not be null") @NotBlank(message = "address1 field must not be blank") String address1,
			String address2, String landmark, String addressTenure,
			@NotNull(message = "city must not be null") @NotBlank(message = "city must not be blank") String city,
			@NotNull(message = "state must not be null") @NotBlank(message = "state must not be blank") String state,
			@NotNull(message = "country must not be null") @NotBlank(message = "country must not be blank") String country,
			@NotNull(message = "postcode must not be null") @NotBlank(message = "postcode must not be blank") String postcode,
			String ownershipStatus, Employee employee) {
		super(orgCode, isDeleted, createdAt, updatedAt, createdBy, updatedBy);
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
		this.employee = employee;
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

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}
}