package com.avisys.empmgmt.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.avisys.empmgmt.dto.EmployeeDto;
import com.avisys.empmgmt.exception.EmployeeException;

import jakarta.validation.Valid;


@Service
public interface EmployeeService {

	public List<EmployeeDto> getAllEmployee() throws EmployeeException;

	public String createEmployee(@Valid EmployeeDto employee) throws EmployeeException;

	public EmployeeDto getByEmployee(String employeeCode) throws EmployeeException;

	public String deleteEmployee(String employeeCode) throws EmployeeException;

	Page<EmployeeDto> searchEmployee(Pageable pageable, String keyword) throws EmployeeException;

	public String updateEmployee(@Valid EmployeeDto employee) throws EmployeeException;
	
}
