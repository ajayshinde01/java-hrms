package com.avisys.empmgmt.controller;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
import com.avisys.empmgmt.dto.EmployeeDto;
import com.avisys.empmgmt.exception.DepartmentException;
import com.avisys.empmgmt.exception.EmployeeException;
import com.avisys.empmgmt.service.EmployeeService;
import com.avisys.empmgmt.util.ApiResponse;

import jakarta.validation.Valid;

@RestController
@RequestMapping("employee-info")
public class EmployeeController {	
	
	@Autowired
	private EmployeeService employeeService;

	@GetMapping("/get-all")
	public ResponseEntity<?> getAllEmployee() throws EmployeeException{
		List<EmployeeDto> allEmployeeInfo=this.employeeService.getAllEmployee();
		return new ResponseEntity<List<EmployeeDto>>(allEmployeeInfo, HttpStatus.OK);
	}
	
	@PostMapping("/add")
	public ResponseEntity<?> addEmployee(@Valid @RequestBody EmployeeDto employee) throws EmployeeException {
		String createEmployee = this.employeeService.createEmployee(employee);
		return new ResponseEntity<>(new ApiResponse(createEmployee,LocalDateTime.now()), HttpStatus.CREATED);
	}
	
	@GetMapping("/{employee-code}")
	public ResponseEntity<EmployeeDto> getByEmployeeCode(@PathVariable("employee-code") String employeeCode)
			throws DepartmentException, EmployeeException {
		EmployeeDto getEmployee = this.employeeService.getByEmployee(employeeCode);
		return new ResponseEntity<EmployeeDto>(getEmployee, HttpStatus.OK);
	}
	
	@DeleteMapping("/{employee-code}")
	public ResponseEntity<?> deleteEmployee(@PathVariable("employee-code") String employeeCode)
			throws DepartmentException, EmployeeException {
		String deletedEmployee = this.employeeService.deleteEmployee(employeeCode);
		return new ResponseEntity<>(new ApiResponse(deletedEmployee,LocalDateTime.now()), HttpStatus.OK);
	}
	
	@PutMapping
	public ResponseEntity<?> updateEmployee(@Valid @RequestBody EmployeeDto employee) throws EmployeeException {
		String updateEmployee = this.employeeService.updateEmployee(employee);
		return new ResponseEntity<>(new ApiResponse(updateEmployee,LocalDateTime.now()), HttpStatus.OK);
	}
	
	@GetMapping("/search")
	public ResponseEntity<Page<EmployeeDto>> searchEmployee(@PageableDefault Pageable pageable,
			@RequestParam(value = "keyword", defaultValue = "", required = false) String keyword)
			throws EmployeeException {
		Page<EmployeeDto> result = this.employeeService.searchEmployee(pageable, keyword);
		return new ResponseEntity<Page<EmployeeDto>>(result, HttpStatus.OK);
	}
	
}