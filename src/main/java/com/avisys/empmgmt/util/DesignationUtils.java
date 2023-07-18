package com.avisys.empmgmt.util;

import java.time.LocalDateTime;

import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Component;

import com.avisys.empmgmt.dto.DesignationDto;
import com.avisys.empmgmt.entity.Designation;

@Component
public class DesignationUtils {

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

}
