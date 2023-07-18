package com.avisys.empmgmt.util;

import java.time.LocalDateTime;

import org.springframework.stereotype.Component;

import com.avisys.empmgmt.dto.DesignationDto;
import com.avisys.empmgmt.dto.GETResponse;
import com.avisys.empmgmt.entity.Designation;
import com.avisys.empmgmt.entity.Role;

@Component
public class Utils {

	// Helper Method to convert Role POJO into Role DTO
	public GETResponse roleToDTO(Role role) {
		return new GETResponse(role.getId(), role.getRoleName(), role.getRoleId(), role.getOrgCode(),
				role.getCreatedBy(), role.getCreatedAt(), role.getUpdatedBy(), role.getUpdatedAt());
	}

	public DesignationDto designationToDesignationDto(Designation designation) {
		return new DesignationDto(designation.getId(), designation.getDesignationId(), designation.getDesignationName(),
				designation.getDesignationDesc(), designation.getOrgCode(), designation.isDeleted(),
				designation.getCreatedAt(), designation.getUpdatedAt(), designation.getCreatedBy(),
				designation.getUpdatedBy());
	}

	public Designation designationDtoToDesignation(DesignationDto designationDto) {
		return new Designation(designationDto.getDesignationId(), designationDto.getDesignationName(),
				designationDto.getDesignationDesc(), designationDto.getOrgCode(), designationDto.isDeleted(),
				LocalDateTime.now(), LocalDateTime.now(), designationDto.getCreatedBy(), designationDto.getUpdatedBy());
	}

	// Helper method to check Valid input Fields
	/*
	 * public int checkInvalidFields(CreateDTO role) { int errorFields=0;
	 * if(role.getRoleId().isBlank()) errorFields++; // Name Validations -Should Not
	 * Blank, No Digit and No Special character
	 * 
	 * if(role.getName().isBlank()||role.getName().matches(".*[^a-zA-Z0-9]\\s.*")||
	 * role.getName().matches(".*\\d+.*")) errorFields++;
	 * 
	 * // Organization Code Validations -should not start with a number
	 * if(role.getOrg_code().matches("^\\d.*")) errorFields++;
	 * 
	 * // Created By Validations -Should Not Blank, No Digit and No Special
	 * character if(role.getCreated_by().isBlank()||role.getCreated_by().matches(
	 * ".*[^a-zA-Z0-9]\\s.*")|| role.getCreated_by().matches(".*\\d+.*"))
	 * errorFields++; return errorFields;
	 * 
	 * }
	 */
}
