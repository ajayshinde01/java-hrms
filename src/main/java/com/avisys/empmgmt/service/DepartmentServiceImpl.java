package com.avisys.empmgmt.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.avisys.empmgmt.dto.DepartmentDto;
import com.avisys.empmgmt.entity.Department;
import com.avisys.empmgmt.exception.DepartmentException;
import com.avisys.empmgmt.repository.DepartmentRepo;

@Service
public class DepartmentServiceImpl implements DepartmentService {

	Logger logger = LoggerFactory.getLogger(DepartmentServiceImpl.class);

	@Autowired
	private DepartmentRepo departmentRepository;

	@Autowired
	private ModelMapper modelMapper;

	@Override
	public List<DepartmentDto> getAllDepartments() throws DepartmentException {
		List<Department> departmentData = this.departmentRepository.findByIsDeletedFalse();
		List<DepartmentDto> departmentDtos = departmentData.stream()
				.map((Department) -> this.modelMapper.map(Department, DepartmentDto.class))
				.collect(Collectors.toList());
		if (departmentDtos.isEmpty()) {
			throw new DepartmentException("Array is empty");
		} else
			return departmentDtos;
	}

	@Override
	public String createDepartment(DepartmentDto departmentDto) throws DepartmentException {
		Optional<Department> optionalDepartment = departmentRepository.findByDepartmentId(departmentDto.getDepartmentId());
		if (optionalDepartment.isPresent()) {
			throw new DepartmentException("Department Id should not be duplicate");
		}
		Department department = this.modelMapper.map(departmentDto, Department.class);
		department.setCreatedAt(LocalDateTime.now());
		department.setCreatedBy("Akshay");
		department.setIsDeleted(false);
		departmentRepository.save(department);
		return "Department created successfully";
	}

	@Override
	public String deleteDepartment(String departmentId) throws DepartmentException {
		Optional<Department> optionalDepartment = this.departmentRepository.findByDepartmentId(departmentId);
		if (optionalDepartment.isPresent() &&  !optionalDepartment.get().getIsDeleted()) {
			Department department = optionalDepartment.get();
			department.setIsDeleted(true); // Set isDeleted flag to true
			departmentRepository.save(department); // Update the department entity
			return "Department deleted successfully";
		} else {
			throw new DepartmentException("Department not found");
		}
	}

	@Override
	public DepartmentDto getByIdDepartments(String departmentId) throws DepartmentException {
		Optional<Department> department = departmentRepository.findByDepartmentId(departmentId);
		if (department.isPresent() && !department.get().getIsDeleted()) {
			return this.modelMapper.map(department, DepartmentDto.class);
		} else {
			throw new DepartmentException("Department not found");
		}
	}

	
	@Override
	public String updateDepartment(DepartmentDto departmentDto) throws DepartmentException {
        if (departmentDto.getId() == null) {
            throw new DepartmentException("Id Should Not be null");
        }
        Optional<Department> departmentOptionalObj = departmentRepository.findById(departmentDto.getId());
        
        if (departmentOptionalObj.isEmpty() || departmentOptionalObj.get().getIsDeleted() == true) {
            String message = "No Department Present in the Database";
            throw new DepartmentException(message);
        }
        
        Department departmentObj = departmentOptionalObj.get();
        Optional<Department> departmentIdObj = departmentRepository.findByDepartmentId(departmentDto.getDepartmentId());
        if (departmentIdObj.isEmpty()|| departmentDto.getDepartmentId().equals(departmentObj.getDepartmentId())) {
            Department department = departmentOptionalObj.get();
            department.setDepartmentId(departmentDto.getDepartmentId());
            department.setDepartmentName(departmentDto.getDepartmentName());
            department.setDepartmentDescription(departmentDto.getDepartmentDescription());
            department.setOrgCode(departmentDto.getOrgCode());
            department.setUpdatedBy("Ajay");
            department.setUpdatedAt(LocalDateTime.now());
            departmentRepository.save(department);
        } else {
            throw new DepartmentException("Invalid DepartmentId ");
        }
        return "Department Updated Successfully";
    }

	@Override
	public Page<DepartmentDto> searchDepartment(Pageable pageable, String keyword) throws DepartmentException {
			keyword = keyword.toLowerCase();
		Page<Department> Department = departmentRepository.searchByDepartment(pageable,keyword);
		Page<DepartmentDto> departmentDto = (Page<DepartmentDto>) Department
				.map((department) -> this.modelMapper.map(department, DepartmentDto.class));
		if (departmentDto.isEmpty()) {
			throw new DepartmentException("Array is empty");
		} else
			return departmentDto;
	}
}