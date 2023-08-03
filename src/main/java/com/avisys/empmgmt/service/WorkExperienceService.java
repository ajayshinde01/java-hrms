package com.avisys.empmgmt.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.avisys.empmgmt.dto.WorkExperienceDto;
import com.avisys.empmgmt.entity.Employee;
import com.avisys.empmgmt.entity.WorkExperience;
import com.avisys.empmgmt.exception.EmergencyContactsException;
import com.avisys.empmgmt.exception.EmployeeException;
import com.avisys.empmgmt.exception.WorkExperienceException;
import com.avisys.empmgmt.repository.EmployeeRepo;
import com.avisys.empmgmt.repository.WorkExperienceRepository;

import jakarta.validation.Valid;

@Service
public class WorkExperienceService {
	@Autowired
	private WorkExperienceRepository workExperienceRepository;
	
	@Autowired
	private ModelMapper modelMapper;
	
	@Autowired
	private EmployeeRepo employeeRepository;

	public String addWorkExperience(@Valid WorkExperienceDto workExperienceDto, Long employeeId) {
		
		Employee employee=this.employeeRepository.findByIdAndIsDeletedFalse(employeeId).orElseThrow(()-> new EmployeeException("Employee not found"));
		
		WorkExperience workExperience = this.modelMapper.map(workExperienceDto, WorkExperience.class);
		workExperience.setCreatedAt(LocalDateTime.now());
		workExperience.setDeleted(false);
		workExperience.setEmployee(employee);
		workExperienceRepository.save(workExperience);
		
		return "Work Experience added Successfully";

}

	public List<WorkExperienceDto> getWorkExperienceByEmployee(Long employeeId) {
		Employee employee = employeeRepository.findByIdAndIsDeletedFalse(employeeId).orElseThrow(()->new EmployeeException("Employee not found"));
		
		
		List<WorkExperience> workExperience=workExperienceRepository.findByEmployeeAndIsDeletedFalse(employee);
		if (workExperience.isEmpty()) {
			throw new WorkExperienceException("Array is empty");
		}
		List<WorkExperienceDto> workExperienceDto = workExperience.stream().map((experience)-> this.modelMapper.map(experience,WorkExperienceDto.class)).collect(Collectors.toList());
		
		return workExperienceDto;
	}


	public String updateWorkExperience(WorkExperienceDto workExperienceDto, Long employeeId) {
		Employee employee=employeeRepository.findByIdAndIsDeletedFalse(employeeId).orElseThrow(()->new EmployeeException("Employee not found"));

		WorkExperience workExperience = workExperienceRepository.findByIdAndIsDeletedFalse(workExperienceDto.getId()).orElseThrow(()->new WorkExperienceException("WorkExperience not found"));
	    if(employee==workExperience.getEmployee()) {
	        modelMapper.map(workExperienceDto, workExperience);
	        
	        workExperience.setUpdatedAt(LocalDateTime.now());
	        workExperience.setUpdatedBy(workExperienceDto.getUpdatedBy());
	        workExperience.setDeleted(false);

	        workExperienceRepository.save(workExperience);
	 
	    return "WorkExperience Updated Successfully";
	    } else throw new EmergencyContactsException("EmployeeId doesn't have this WorkExperience Id");
	}

	public String deleteWorkExperience(Long employeeId, Long workExperienceId) {
		Employee employee=this.employeeRepository.findByIdAndIsDeletedFalse(employeeId).orElseThrow(()->new EmployeeException("Employee not found"));
		WorkExperience workExperience = this.workExperienceRepository.findByIdAndIsDeletedFalse(workExperienceId).orElseThrow(()->new WorkExperienceException("WorkExperience not found"));
			
		if(employee==workExperience.getEmployee()) {
			workExperience.setDeleted(true);
			workExperienceRepository.save(workExperience); 
			return "Work experience deleted successfully";
		}else throw new EmergencyContactsException("EmployeeId doesn't match with WorkExperienceId");
	}
	
}
