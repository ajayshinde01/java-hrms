package com.avisys.empmgmt.util;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.stereotype.Component;

import com.avisys.empmgmt.dto.DesignationDto;
import com.avisys.empmgmt.dto.DivisionDto;
import com.avisys.empmgmt.dto.GETResponse;
import com.avisys.empmgmt.entity.Designation;
import com.avisys.empmgmt.entity.Division;
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

	public List<DivisionDto> getAllDivisionsDto(List<Division> divisions) {

		List<DivisionDto> divisionsDto = divisions.stream()
				.map((division) -> new DivisionDto(division.getId(), division.getDivisionId(),
						division.getdivisionName(), division.getdivisionDescription(), division.getOrgCode(),
						division.isDeleted(), division.getCreatedAt(), division.getUpdatedAt(), division.getCreatedBy(),
						division.getUpdatedBy()))
				.toList();
		return divisionsDto;
	}

	public Division getDivision(DivisionDto updatedDivisionDto) {

		return new Division(updatedDivisionDto.getId(), updatedDivisionDto.getDivisionId(),
				updatedDivisionDto.getDivisionName(), updatedDivisionDto.getDivisionDescription(),
				updatedDivisionDto.getOrgCode(), false, updatedDivisionDto.getCreatedAt(),
				updatedDivisionDto.getUpdatedAt(), updatedDivisionDto.getCreatedBy(),
				updatedDivisionDto.getUpdatedBy());
	}

	public DivisionDto getDivisionDto(Division division) {
		return new DivisionDto(division.getId(), division.getDivisionId(), division.getdivisionName(),
				division.getdivisionDescription(), division.getOrgCode(), division.isDeleted(), division.getCreatedAt(),
				division.getUpdatedAt(), division.getCreatedBy(), division.getUpdatedBy());
	}

}
