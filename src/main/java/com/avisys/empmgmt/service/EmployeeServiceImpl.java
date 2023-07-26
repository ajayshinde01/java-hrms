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

import com.avisys.empmgmt.dto.DepartmentDto;
import com.avisys.empmgmt.dto.EmployeeDto;
import com.avisys.empmgmt.entity.Department;
import com.avisys.empmgmt.entity.Employee;
import com.avisys.empmgmt.exception.DepartmentException;
import com.avisys.empmgmt.exception.EmployeeException;
import com.avisys.empmgmt.repository.EmployeeRepo;

import jakarta.validation.Valid;

@Service
public class EmployeeServiceImpl implements EmployeeService {
	
	@Autowired
	private EmployeeRepo employeeRepository;
	
	@Autowired
	private ModelMapper modelMapper;

	public List<EmployeeDto> getAllEmployee() throws EmployeeException{
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
	public String createEmployee(@Valid EmployeeDto employeeDto) throws EmployeeException {
		Optional<Employee> optionalEmployee = employeeRepository.findByEmployeeCode(employeeDto.getEmployeeCode());
		if (optionalEmployee.isPresent()) {
			throw new EmployeeException("Employee code should not be duplicate");
		}
		Employee employee = this.modelMapper.map(employeeDto, Employee.class);
		employee.setCreatedAt(LocalDateTime.now());
		employee.setCreatedBy(employeeDto.getCreatedBy());
		employee.setDeleted(false);
		employeeRepository.save(employee);
		return "Employee Created Successfully";
	}

	@Override
	public EmployeeDto getByEmployee(String employeeCode) throws EmployeeException {
		Optional<Employee> employee = employeeRepository.findByEmployeeCode(employeeCode);
		if (employee.isPresent() && !employee.get().isDeleted()) {
			return this.modelMapper.map(employee, EmployeeDto.class);
		} else {
			throw new EmployeeException("Employee not found");
		}
	}

	@Override
	public String deleteEmployee(String employeeCode) throws EmployeeException {
		Optional<Employee> optionalEmployee = this.employeeRepository.findByEmployeeCode(employeeCode);
		if (optionalEmployee.isPresent() &&  !optionalEmployee.get().isDeleted()) {
			Employee employee = optionalEmployee.get();
			employee.setDeleted(true); // Set isDeleted flag to true
			employeeRepository.save(employee); // Update the department entity
			return "Employee deleted successfully";
		} else {
			throw new EmployeeException("Employee not found");
		}
	}
	
	@Override
	public Page<EmployeeDto> searchEmployee(Pageable pageable, String keyword) throws EmployeeException {
			keyword = keyword.toLowerCase();
		Page<Employee> Employee = employeeRepository.searchByEmployee(pageable,keyword);
		Page<EmployeeDto> employeeDto = (Page<EmployeeDto>) Employee
				.map((employee) -> this.modelMapper.map(employee, EmployeeDto.class));
		if (employeeDto.isEmpty()) {
			throw new EmployeeException("Array is empty");
		} else
			return employeeDto;
	}

//	@Override
//	public String updateEmployee(@Valid EmployeeDto employeeDto) throws EmployeeException {
//		if (employeeDto.getId() == null) {
//            throw new EmployeeException("Id Should Not be null");
//        }
//        Optional<Employee> employeeOptionalObj = employeeRepository.findById(employeeDto.getId());
//        
//        if (employeeOptionalObj.isEmpty() || employeeOptionalObj.get().isDeleted() == true) {
//            String message = "No Department Present in the Database";
//            throw new EmployeeException(message);
//        }
//        
//        Employee  employeeObj =  employeeOptionalObj.get();
//        Optional<Employee> employeeIdObj = employeeRepository.findByEmployeeCode(employeeDto.getEmployeeCode());
//        if (employeeIdObj.isEmpty()|| employeeDto.getEmployeeCode().equals(employeeObj.getEmployeeCode())) {
//        	Employee employee = employeeOptionalObj.get();
//        	employee.setEmployeeCode(employeeDto.getEmployeeCode());
//        	employee.setFirstName(employeeDto.getFirstName());
//        	employee.setMiddleName(employeeDto.getMiddleName());
//        	employee.setLastName(employeeDto.getLastName());
//        	employee.setDateOfBirth(employeeDto.getDateOfBirth());
//        	employee.setLastName(employeeDto.getLastName());
//        	employee.setGender(employeeDto.getGender());
//        	employee.setDateOfJoining(employeeDto.getDateOfJoining());
//        	employee.setAge(employeeDto.getAge());
//        	employee.setDivision(employeeDto.getDivision());
//        	employee.setUserId(employeeDto.getUserId());
//            employee.setOrgCode(employeeDto.getOrgCode());
//            employee.setUpdatedBy(employeeDto.getUpdatedBy());
//            employee.setUpdatedAt(LocalDateTime.now());
//            employeeRepository.save(employee);
//        } else {
//            throw new EmployeeException("Invalid employeeId ");
//        }
//        return "employee Updated Successfully";
//	}
	
	@Override
	public String updateEmployee(@Valid EmployeeDto employeeDto) throws EmployeeException {
	    if (employeeDto.getId() == null) {
	        throw new EmployeeException("Id Should Not be null");
	    }
	    Optional<Employee> employeeOptionalObj = employeeRepository.findById(employeeDto.getId());

	    if (employeeOptionalObj.isEmpty() || employeeOptionalObj.get().isDeleted()) {
	        throw new EmployeeException("No Employee Present in the Database");
	    }

	    Employee employeeObj = employeeOptionalObj.get();
	    Optional<Employee> employeeIdObj = employeeRepository.findByEmployeeCode(employeeDto.getEmployeeCode());

	    if (employeeIdObj.isEmpty() || employeeDto.getEmployeeCode().equals(employeeObj.getEmployeeCode())) {
	        // Map the fields from EmployeeDto to Employee using ModelMapper
	        modelMapper.map(employeeDto, employeeObj);

	        // Set other fields that are not mapped automatically
	        employeeObj.setUpdatedAt(LocalDateTime.now());
	        employeeObj.setUpdatedBy(employeeDto.getUpdatedBy());
	        employeeObj.setDeleted(false);

	        employeeRepository.save(employeeObj);
	    } else {
	        throw new EmployeeException("Invalid employeeId");
	    }
	    return "Employee Updated Successfully";
	}
	
}