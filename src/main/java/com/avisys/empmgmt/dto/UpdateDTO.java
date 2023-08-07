package com.avisys.empmgmt.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
public class UpdateDTO {

	@NotNull(message = "Id cant be NULL")
	private long id;

	@NotNull(message = "Role Id field is required")
	@NotBlank(message = "Role Id cant be blank")
	@Pattern(regexp="^[A-Za-z0-9-]{1,50}$",message="Role Id should not contain any special character except from hyphen with size 50")
	private String roleId;

	@NotNull
	@NotBlank(message = "Role Name cant be blank")
	@Pattern(regexp="^[A-Za-z _ -.]{1,100}$",message="Role Name should not contain any special character except from hyphen,underscore,space,dot with size 100")
	private String roleName;

	@NotNull
	@NotBlank(message = "Organization Code  cant be blank")
	@Pattern(regexp = "^[a-zA-Z0-9-_]{1,50}$",message = "Organization code should not contain any special characters except hypen,underscore")
	private String orgCode;

	
	private String updatedBy;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}


	public String getRoleId() {
		return roleId;
	}

	public void setRoleId(String roleId) {
		this.roleId = roleId;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public String getOrgCode() {
		return orgCode;
	}

	public void setOrgCode(String orgCode) {
		this.orgCode = orgCode;
	}

	public String getUpdatedBy() {
		return updatedBy;
	}

	public void setUpdatedBy(String updatedBy) {
		this.updatedBy = updatedBy;
	}

	public UpdateDTO(
			@NotNull(message = "Role Id field is required") @NotBlank(message = "Role Id cant be blank") @Pattern(regexp = "^[a-zA-Z0-9]{1,50}$", message = "ID must starts with alphabets followed numbers & cannot contain special character") String roleId,
			@NotNull @NotBlank(message = "Role Name cant be blank") @Pattern(regexp = "^[a-zA-Z-_ ]{1,100}$", message = "Name must starts with alphabets") String roleName,
			@NotNull @NotBlank(message = "Organization Code  cant be blank") @Pattern(regexp = "^[a-zA-Z-_]{1,10}$", message = "Organization code can't contain white spaces & special characters") String orgCode,
			@NotBlank(message = "Updaed  by field is required") @NotNull(message = "Updaed  by cant be null") String updatedBy) {
		super();
		this.roleId = roleId;
		this.roleName = roleName;
		this.orgCode = orgCode;
		this.updatedBy = updatedBy;
	}

	public UpdateDTO() {
		super();
	}


}
