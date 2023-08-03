package com.avisys.empmgmt.controller;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.avisys.empmgmt.dto.WorkExperienceDto;
import com.avisys.empmgmt.service.WorkExperienceService;
import com.avisys.empmgmt.util.ApiResponse;

import jakarta.validation.Valid;

@CrossOrigin("*")
@RestController
@RequestMapping("work-experience")
public class WorkExperienceController {
	
	@Autowired
	private WorkExperienceService workExperienceService;
	
	@PostMapping("/{employee-id}/add")
	public ResponseEntity<?> addWorkExperience(@Valid @RequestBody WorkExperienceDto workExperienceDto, @PathVariable("employee-id") Long employeeId) {
		String experience = workExperienceService.addWorkExperience(workExperienceDto,employeeId);
		return new ResponseEntity<>(new ApiResponse(experience,LocalDateTime.now()), HttpStatus.CREATED);
	}
	
	@GetMapping("/{employee-id}/get-all")
	public ResponseEntity<List<WorkExperienceDto>> getWorkExperienceByEmployeeId(@PathVariable("employee-id") Long employeeId){
		List<WorkExperienceDto> getExperiences = this.workExperienceService.getWorkExperienceByEmployee(employeeId);
		return new ResponseEntity<List<WorkExperienceDto>>(getExperiences,HttpStatus.OK);
	}
	
	@DeleteMapping("/{employee-id}/{work-experience-id}")
	public ResponseEntity<?> deleteEmployeeWorkExperience(@PathVariable("employee-id") Long employeeId, @PathVariable("work-experience-id") Long workExperienceId ){
		String deletedWorkExperience = this.workExperienceService.deleteWorkExperience(employeeId,workExperienceId);
		return new ResponseEntity<>(new ApiResponse(deletedWorkExperience,LocalDateTime.now()), HttpStatus.OK);
	}
	
	@PutMapping("/{employee-id}/update")
	public ResponseEntity<?> updateEmployeeWorkExperience(@Valid @RequestBody WorkExperienceDto workExperienceDto, @PathVariable("employee-id") Long employeeId ) {
		String updateWorkExperienceDto = this.workExperienceService.updateWorkExperience(workExperienceDto,employeeId);
		return new ResponseEntity<>(new ApiResponse(updateWorkExperienceDto,LocalDateTime.now()), HttpStatus.OK);
	}
	
}
