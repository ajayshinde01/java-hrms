package com.avisys.empmgmt.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import com.avisys.empmgmt.dto.EmployeeDto;
import com.avisys.empmgmt.entity.Employee;
import com.avisys.empmgmt.exception.EmployeeException;
import com.avisys.empmgmt.repository.EmployeeRepo;

import jakarta.validation.Valid;

@Service
public class EmployeeServiceImpl implements EmployeeService {
	
	@Autowired
	private EmployeeRepo employeeRepository;
	
	@Autowired
	private ModelMapper modelMapper;

	public List<EmployeeDto> getAllEmployee(){
		List<Employee> employeeInfo=this.employeeRepository.findByIsDeletedFalse();
		List<EmployeeDto> employeeDtos = employeeInfo.stream()
				.map((Employee) -> this.modelMapper.map(Employee, EmployeeDto.class))
				.collect(Collectors.toList()).stream()
				.map((Employee) -> this.modelMapper.map(Employee, EmployeeDto.class))
				.collect(Collectors.toList());
		if (employeeDtos.isEmpty()) {
			throw new EmployeeException("Array is empty");
		} else
			return employeeDtos;
	}

	@Override
	public EmployeeDto createEmployee(@Valid EmployeeDto employeeDto){
		Optional<Employee> optionalEmployee = employeeRepository.findByEmployeeCode(employeeDto.getEmployeeCode());
        if (optionalEmployee.isPresent()) {
            throw new EmployeeException("Employee code should not be duplicate");
        }
		Employee employee = this.modelMapper.map(employeeDto, Employee.class);
		employee.setCreatedAt(LocalDateTime.now());
		employee.setCreatedBy(employeeDto.getCreatedBy());
		employee.setDeleted(false);
		employeeRepository.save(employee);
		return this.modelMapper.map(employee, EmployeeDto.class);
	}

	@Override
	public EmployeeDto getByEmployee(Long employeeId){
		Employee employee = employeeRepository.findByIdAndIsDeletedFalse(employeeId).orElseThrow(()-> new EmployeeException("Employee not found"));
			return this.modelMapper.map(employee, EmployeeDto.class);	
	}

	@Override
	public String deleteEmployee(Long employeeId) {
		Employee employee = this.employeeRepository.findByIdAndIsDeletedFalse(employeeId).orElseThrow(()-> new EmployeeException("Employee not found"));
			employee.setDeleted(true); // Set isDeleted flag to true
			employeeRepository.save(employee); // Update the department entity
			return "Employee deleted successfully";
	}
	
	@Override
	public Page<EmployeeDto> searchEmployee(Pageable pageable, String keyword){
			keyword = keyword.toLowerCase();
		Page<Employee> Employee = employeeRepository.searchByEmployee(pageable,keyword);
		Page<EmployeeDto> employeeDto = (Page<EmployeeDto>) Employee
				.map((employee) -> this.modelMapper.map(employee, EmployeeDto.class));
		if (employeeDto.isEmpty()) {
			throw new EmployeeException("Array is empty");
		} else
			return employeeDto;
	}
	
	@Override
	public EmployeeDto updateEmployee(@Valid EmployeeDto employeeDto){
		Optional<Employee> optionalEmployee = employeeRepository.findByEmployeeCode(employeeDto.getEmployeeCode());
        if (optionalEmployee.isPresent()) {
            throw new EmployeeException("Employee code should not be duplicate");
        }
	    if (employeeDto.getId() == null) {
	        throw new EmployeeException("Id Should Not be null");
	    }
	    Employee employeeObj = employeeRepository.findByIdAndIsDeletedFalse(employeeDto.getId()).orElseThrow(()-> new EmployeeException("No Employee Present in the Database"));

	        // Map the fields from EmployeeDto to Employee using ModelMapper
	        modelMapper.map(employeeDto, employeeObj);

	        // Set other fields that are not mapped automatically
	        employeeObj.setUpdatedAt(LocalDateTime.now());
	        employeeObj.setUpdatedBy(employeeDto.getUpdatedBy());
	        employeeObj.setDeleted(false);

	        employeeRepository.save(employeeObj);
	
	    return this.modelMapper.map(employeeObj, EmployeeDto.class);
	}
	
}