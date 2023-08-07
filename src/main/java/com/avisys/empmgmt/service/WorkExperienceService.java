package com.avisys.empmgmt.service;


import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.data.domain.Pageable;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.avisys.empmgmt.dto.WorkExperienceDto;
import com.avisys.empmgmt.entity.Employee;
import com.avisys.empmgmt.entity.WorkExperience;
import com.avisys.empmgmt.exception.EmployeeException;
import com.avisys.empmgmt.exception.WorkExperienceException;
import com.avisys.empmgmt.repository.EmployeeRepo;
import com.avisys.empmgmt.repository.WorkExperienceRepository;

import jakarta.validation.Valid;

@Service
@Transactional
public class WorkExperienceService {
	@Autowired
	private WorkExperienceRepository workExperienceRepository;
	
	@Autowired
	private ModelMapper modelMapper;
	
	@Autowired
	private EmployeeRepo employeeRepository;

	public WorkExperienceDto addWorkExperience(@Valid WorkExperienceDto workExperienceDto, Long employeeId) {
		
		Employee employee=this.employeeRepository.findByIdAndIsDeletedFalse(employeeId).orElseThrow(()-> new EmployeeException("Employee not found"));
		
		WorkExperience workExperience = this.modelMapper.map(workExperienceDto, WorkExperience.class);
		workExperience.setCreatedAt(LocalDateTime.now());
		workExperience.setDeleted(false);
		workExperience.setEmployee(employee);
		workExperience.setUpdatedBy(null);
		WorkExperience workExperienceObject = workExperienceRepository.save(workExperience);
		
		return  this.modelMapper.map(workExperienceObject, WorkExperienceDto.class);

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


	public WorkExperienceDto updateWorkExperience(WorkExperienceDto workExperienceDto, Long employeeId) {
		Employee employee=employeeRepository.findByIdAndIsDeletedFalse(employeeId).orElseThrow(()->new EmployeeException("Employee not found"));

		WorkExperience workExperience = workExperienceRepository.findByIdAndIsDeletedFalse(workExperienceDto.getId()).orElseThrow(()->new WorkExperienceException("WorkExperience not found"));
	    if(employee==workExperience.getEmployee()) {
	        modelMapper.map(workExperienceDto, workExperience);
	        
	        workExperience.setUpdatedAt(LocalDateTime.now());
	        workExperience.setUpdatedBy(workExperienceDto.getUpdatedBy());
	        workExperience.setDeleted(false);

	        WorkExperience workExperienceObject = workExperienceRepository.save(workExperience);
	 
	    return  this.modelMapper.map(workExperienceObject, WorkExperienceDto.class);
	    } else throw new WorkExperienceException("EmployeeId doesn't have this WorkExperience Id");
	}

	public String deleteWorkExperience(Long employeeId, Long workExperienceId) {
		Employee employee=this.employeeRepository.findByIdAndIsDeletedFalse(employeeId).orElseThrow(()->new EmployeeException("Employee not found"));
		WorkExperience workExperience = this.workExperienceRepository.findByIdAndIsDeletedFalse(workExperienceId).orElseThrow(()->new WorkExperienceException("WorkExperience not found"));
			
		if(employee==workExperience.getEmployee()) {
			workExperience.setDeleted(true);
			workExperienceRepository.save(workExperience); 
			return "Work experience deleted successfully";
		}else throw new WorkExperienceException("EmployeeId doesn't match with WorkExperienceId");
	}
	
	public Page<WorkExperienceDto> searchWorkExperience(Pageable pageable, String keyword, Long employeeId) {
        Employee employee = this.employeeRepository.findByIdAndIsDeletedFalse(employeeId)
                .orElseThrow(() -> new EmployeeException("Employee not found"));

        List<WorkExperience> workExperiences = workExperienceRepository.findByEmployeeAndIsDeletedFalse(employee);
        if (workExperiences.isEmpty()) {
            throw new WorkExperienceException("Array is empty");
        }

        keyword = keyword.toLowerCase();
        Page<WorkExperience> workExperience = workExperienceRepository.searchByCompanyNameAndEmployeeId(keyword, pageable, employeeId);

        Page<WorkExperienceDto> workExperienceDto = workExperience.map(experience ->
                this.modelMapper.map(experience, WorkExperienceDto.class));

        if (workExperienceDto.isEmpty()) {
            throw new WorkExperienceException("Array is empty");
        } else {
            return workExperienceDto;
        }
    }
}
