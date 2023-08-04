package com.avisys.empmgmt.controller;

import java.time.LocalDateTime;

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

import com.avisys.empmgmt.dto.CompanyDetailDTO;
import com.avisys.empmgmt.dto.CreateCompanyDetailDTO;
import com.avisys.empmgmt.service.CompanyDetailService;
import com.avisys.empmgmt.util.ApiResponse;
import jakarta.validation.Valid;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("company-detail")
public class CompanyDetailController {
	
	@Autowired
	private CompanyDetailService companyDetailService;

	public CompanyDetailController() {
		
	}
	
	@PostMapping("/create/{employee-id}")
	public ResponseEntity<?> createCompanyDetail(@Valid @RequestBody CreateCompanyDetailDTO companyDetailDto,@PathVariable("employee-id") Long employeeId){
        String message = companyDetailService.createCompanyDetail(companyDetailDto,employeeId);
		return new ResponseEntity<>(new ApiResponse(message, LocalDateTime.now()),HttpStatus.CREATED);	
	}
	
	@DeleteMapping("/{employee-id}")
	public ResponseEntity<?> deleteCompanyDetailById(@PathVariable("employee-id") Long employeeId){
		String message = companyDetailService.deleteCompanyDetailByEmployeeId(employeeId);
		return new ResponseEntity<>(new ApiResponse(message, LocalDateTime.now()),HttpStatus.OK);
	}

	@PutMapping("/update/{employee-id}")
	public ResponseEntity<?> updateCompanyDetail(@Valid @RequestBody CompanyDetailDTO companyDetailDto,@PathVariable("employee-id") Long employeeId){
		String message = companyDetailService.updateCompanyDetail(companyDetailDto,employeeId);
		return new ResponseEntity<>(new ApiResponse(message, LocalDateTime.now()),HttpStatus.OK);
	}
	
	@GetMapping("/{employee-id}")
	public ResponseEntity<?> getCompanyDetailById(@PathVariable("employee-id") Long employeeId){
		return new ResponseEntity<>( companyDetailService.getCompanyDetailById(employeeId),HttpStatus.OK);
	}
}
