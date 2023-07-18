package com.avisys.empmgmt.dto;


import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

public class CreateDTO {

	@NotNull(message = "")
	@NotBlank(message = "Role Id field cant be blank")
	@Pattern(regexp="^[a-zA-Z]+[-][a-zA-Z0-9]+$", message = "Role Id cant contain special characters")
	private String roleId;
	
	@NotNull
	@NotBlank(message = "Role Name field cant be blank")
	@Pattern(regexp="^[a-zA-Z ]*$", message = "Role name should not contain digit or special characters")
	private String name;
	
	@NotNull
	@NotBlank(message = "Organization Code field cant be blank")
	@Pattern(regexp="[^0-9][a-zA-Z0-9]*",message = "Org code cant start with digit")
	private String org_code;
	
	@NotNull
	@Pattern(regexp="^[a-zA-Z ]+$", message = "Created By name should not contain digit or special characters")
	@NotBlank(message = "Created by field  cant be null")
	private String created_by;
	
	
	public CreateDTO(String roleId, String rname, String org_code, String created_by) {
		super();
		this.roleId=roleId;
		this.name = rname;
		this.org_code = org_code;
		this.created_by = created_by;
	}
	
	public String getRoleId() {
		return roleId;
	}

	public void setRoleId(String roleId) {
		this.roleId = roleId;
	}

	public String getName() {
		return name;
	}
	public void setName(String rname) {
		this.name = rname;
	}
	public String getOrg_code() {
		return org_code;
	}
	public void setOrg_code(String org_code) {
		this.org_code = org_code;
	}
	public String getCreated_by() {
		return created_by;
	}
	public void setCreated_by(String created_by) {
		this.created_by = created_by;
	}
	
	
	
	
	
}
