package com.avisys.empmgmt.controller;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.avisys.empmgmt.dto.DepartmentDto;
import com.avisys.empmgmt.exception.DepartmentException;
import com.avisys.empmgmt.service.DepartmentService;
import com.avisys.empmgmt.util.ApiResponse;

import jakarta.validation.Valid;

@CrossOrigin("*")
@RestController
@RequestMapping("departments")

public class DepartmentController {
	@Autowired
	private DepartmentService departmentService;

	@GetMapping("/allDepartments")
	public ResponseEntity<List<DepartmentDto>> getDepartments() throws DepartmentException {
		List<DepartmentDto> allDepartments = this.departmentService.getAllDepartments();
		return new ResponseEntity<List<DepartmentDto>>(allDepartments, HttpStatus.OK);
	}

	@GetMapping("/{department-Id}")
	public ResponseEntity<DepartmentDto> getByIdDepartments(@PathVariable("department-Id") String departmentId)
			throws DepartmentException {
		DepartmentDto getDesignations = this.departmentService.getByIdDepartments(departmentId);
		return new ResponseEntity<DepartmentDto>(getDesignations, HttpStatus.OK);
	}

	@PostMapping("/add-department")
	public ResponseEntity<?> addDepartment(@Valid @RequestBody DepartmentDto department) throws DepartmentException {
		String createDepartment = this.departmentService.createDepartment(department);
		return new ResponseEntity<>(new ApiResponse(createDepartment,LocalDateTime.now()), HttpStatus.CREATED);
	}

	@DeleteMapping("/{department-Id}")
	public ResponseEntity<?> deleteDepartment(@PathVariable("department-Id") String departmentId)
			throws DepartmentException {
		String deletedDepartment = this.departmentService.deleteDepartment(departmentId);
		return new ResponseEntity<>(new ApiResponse(deletedDepartment,LocalDateTime.now()), HttpStatus.OK);
	}

	@PutMapping
	public ResponseEntity<?> updateDepartment(@Valid @RequestBody DepartmentDto department) throws DepartmentException {
		String updateDepartment = this.departmentService.updateDepartment(department);
		return new ResponseEntity<>(new ApiResponse(updateDepartment,LocalDateTime.now()), HttpStatus.OK);
	}

	@GetMapping("/search")
	public ResponseEntity<Page<DepartmentDto>> searchDepartment(@PageableDefault Pageable pageable,
			@RequestParam(value = "keyword", defaultValue = "", required = false) String keyword)
			throws DepartmentException {
		Page<DepartmentDto> result = this.departmentService.searchDepartment(pageable, keyword);
		return new ResponseEntity<Page<DepartmentDto>>(result, HttpStatus.OK);
	}
}