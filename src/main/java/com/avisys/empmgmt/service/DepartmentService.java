package com.avisys.empmgmt.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.avisys.empmgmt.dto.DepartmentDto;
import com.avisys.empmgmt.exception.DepartmentException;

@Service
public interface DepartmentService {

	DepartmentDto createDepartment(DepartmentDto department) throws DepartmentException;

	DepartmentDto updateDepartment(DepartmentDto departmentDto) throws DepartmentException;

	List<DepartmentDto> getAllDepartments() throws DepartmentException;

	String deleteDepartment(String Id,String updatedBy) throws DepartmentException;

	Page<DepartmentDto> searchDepartment(Pageable pageable, String keyword) throws DepartmentException;

	DepartmentDto getByIdDepartments(String departmentId) throws DepartmentException;
}
