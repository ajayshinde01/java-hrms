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

import com.avisys.empmgmt.dto.EducationalQualificationDto;
import com.avisys.empmgmt.service.EducationalQualificationService;
import com.avisys.empmgmt.util.ApiResponse;

import jakarta.validation.Valid;

@CrossOrigin("*")
@RestController
@RequestMapping("education")
public class EducationalQualificationController {

	@Autowired
	private EducationalQualificationService educationalQualificationService;
	
	@PostMapping("/{employee-id}/add")
	public ResponseEntity<?> addEducationalQualification(@Valid @RequestBody EducationalQualificationDto educationalQualificationDto, @PathVariable("employee-id") Long employeeId) {
		String createEducationalQualification = educationalQualificationService.addEducationalQualification(educationalQualificationDto,employeeId);
		return new ResponseEntity<>(new ApiResponse(createEducationalQualification,LocalDateTime.now()), HttpStatus.CREATED);
	}
	
	@GetMapping("/{employee-id}/get-all")
	public ResponseEntity<List<EducationalQualificationDto>> getEducationalQualificationByEmployeeId(@PathVariable("employee-id") Long employeeId){
		List<EducationalQualificationDto> getEducationalQualification = this.educationalQualificationService.getEducationalQualificationByEmployee(employeeId);
		return new ResponseEntity<List<EducationalQualificationDto>>(getEducationalQualification,HttpStatus.OK);
	}
	
	@DeleteMapping("/{employee-id}/{education-id}")
	public ResponseEntity<?> deleteEducationalQualification(@PathVariable("employee-id") Long employeeId, @PathVariable("education-id") Long educationId ){
		String deletedEducationalQualification = this.educationalQualificationService.deleteEducationalQualification(employeeId,educationId);
		return new ResponseEntity<>(new ApiResponse(deletedEducationalQualification,LocalDateTime.now()), HttpStatus.OK);
	}
	
	@PutMapping("/{employee-id}/update")
	public ResponseEntity<?> updateEducationalQualification(@Valid @RequestBody EducationalQualificationDto educationalQualificationDto, @PathVariable("employee-id") Long employeeId ) {
		String updateEducationalQualification = this.educationalQualificationService.updateEducationalQualification(educationalQualificationDto,employeeId);
		return new ResponseEntity<>(new ApiResponse(updateEducationalQualification,LocalDateTime.now()), HttpStatus.OK);
	}
}
