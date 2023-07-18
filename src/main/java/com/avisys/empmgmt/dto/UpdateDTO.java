package com.avisys.empmgmt.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateDTO {

	@NotNull(message = "Id cant be NULL")
	private long id;

	@NotNull(message = "Role Id field is required")
	@NotBlank(message = "Role Id cant be blank")
	@Pattern(regexp = "^[a-zA-Z]+[-][a-zA-Z0-9]+$", message = "Role Id cant contain special characters")
	private String roleId;

	@NotNull
	@NotBlank(message = "Role Name cant be blank")
	@Pattern(regexp = "^[a-zA-Z ]*$", message = "Role name should not contain digit or special characters")
	private String name;

	@NotNull
	@NotBlank(message = "Organization Code  cant be blank")
	@Pattern(regexp = "[^0-9][a-zA-Z0-9]*", message = "Org code cant start with digit")
	private String org_code;

	@NotBlank(message = "Updaed  by field is required")
	@NotNull(message = "Updaed  by cant be null")
	@Pattern(regexp = "^[a-zA-Z ]*$", message = "Updated By name should not contain digit or special characters")
	private String updated_by;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getUpdated_by() {
		return updated_by;
	}

	public void setUpdated_by(String updated_by) {
		this.updated_by = updated_by;
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

	public void setName(String name) {
		this.name = name;
	}

	public String getOrg_code() {
		return org_code;
	}

	public void setOrg_code(String org_code) {
		this.org_code = org_code;
	}

}
