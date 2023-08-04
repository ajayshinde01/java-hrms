package com.avisys.empmgmt.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.avisys.empmgmt.dto.EducationalQualificationDto;
import com.avisys.empmgmt.entity.EducationalQualification;
import com.avisys.empmgmt.entity.Employee;
import com.avisys.empmgmt.exception.AddressException;
import com.avisys.empmgmt.exception.EducationalQualificationException;
import com.avisys.empmgmt.exception.EmployeeException;
import com.avisys.empmgmt.repository.EducationalQualificationRepo;
import com.avisys.empmgmt.repository.EmployeeRepo;

import jakarta.validation.Valid;

@Service
public class EducationalQualificationService {
	
	@Autowired
	private EducationalQualificationRepo educationalRepository;
	
	@Autowired
	private ModelMapper modelMapper;
	
	@Autowired
	private EmployeeRepo employeeRepository;
	
	public String addEducationalQualification(@Valid EducationalQualificationDto educationalQualificationDto, Long employeeId) {
		
		Employee employee=this.employeeRepository.findByIdAndIsDeletedFalse(employeeId).orElseThrow(()-> new EmployeeException("Employee not found"));
		
		List<EducationalQualification> qualificationList = educationalRepository.findByEmployee(employee);

		for (EducationalQualification qualification : qualificationList) {
		    if (qualification.getEducationalQualification().equals(educationalQualificationDto.getEducationalQualification())) {
		        throw new AddressException("EducationalQualification already filled");
		    }
		}
		EducationalQualification education = this.modelMapper.map(educationalQualificationDto, EducationalQualification.class);
		education.setCreatedAt(LocalDateTime.now());
		education.setDeleted(false);
		education.setEmployee(employee);
		educationalRepository.save(education);
		
		return "EducationalQualification Created Successfully";
	}


	public List<EducationalQualificationDto> getEducationalQualificationByEmployee(Long employeeId) {
		Employee employee = employeeRepository.findByIdAndIsDeletedFalse(employeeId).orElseThrow(()->new EmployeeException("Employee not found"));	
		
		List<EducationalQualification> education=this.educationalRepository.findByEmployeeAndIsDeletedFalse(employee);
		if (education.isEmpty()) {
			throw new EducationalQualificationException("Array is empty");
		}
		List<EducationalQualificationDto> educationalQualificationDto = education.stream().map((educations)-> this.modelMapper.map(educations,EducationalQualificationDto.class)).collect(Collectors.toList());
		
		return educationalQualificationDto;
	}

	
	public String updateEducationalQualification(EducationalQualificationDto educationalQualificationDto, Long employeeId) {
		Employee employee=employeeRepository.findByIdAndIsDeletedFalse(employeeId).orElseThrow(()->new EmployeeException("Employee not found"));
		
		EducationalQualification educationObj = educationalRepository.findByIdAndIsDeletedFalse(educationalQualificationDto.getId()).orElseThrow(()->new EducationalQualificationException("educational qualification not found"));
	    if(employee==educationObj.getEmployee()) {
	        modelMapper.map(educationalQualificationDto, educationObj);

	        educationObj.setUpdatedAt(LocalDateTime.now());
	        educationObj.setUpdatedBy(educationalQualificationDto.getUpdatedBy());
	        educationObj.setDeleted(false);

	        educationalRepository.save(educationObj);
	 
	    return "Qualification Updated Successfully";
	    } else throw new EducationalQualificationException("EmployeeId doesn't have this QualificationId");
	}


	public String deleteEducationalQualification(Long employeeId, Long qualificationId) {
		Employee employee=this.employeeRepository.findByIdAndIsDeletedFalse(employeeId).orElseThrow(()->new EmployeeException("Employee not found"));
		EducationalQualification education = this.educationalRepository.findByIdAndIsDeletedFalse(qualificationId).orElseThrow(()->new EducationalQualificationException("educational qualification not found"));
			
		if(employee==education.getEmployee()) {
			education.setDeleted(true);
			educationalRepository.save(education); 
			return "Qualification deleted successfully";
		}else throw new EducationalQualificationException("EmployeeId doesn't match with QualificationId");
	}


	public Page<EducationalQualificationDto> searchEducationalQualification(Pageable pageable, String keyword,
			Long employeeId) {
		  Employee employee = this.employeeRepository.findByIdAndIsDeletedFalse(employeeId)
	                .orElseThrow(() -> new EmployeeException("Employee not found"));

	        List<EducationalQualification> educationalQualification = educationalRepository.findByEmployeeAndIsDeletedFalse(employee);
	        if (educationalQualification.isEmpty()) {
	            throw new EducationalQualificationException("Array is empty");
	        }

	        keyword = keyword.toLowerCase();
	        Page<EducationalQualification> qualification = educationalRepository.searchByEducationalQualificationAndEmployeeId(keyword, pageable, employeeId);

	        Page<EducationalQualificationDto> educationalQualificationDto = qualification.map(education ->
	                this.modelMapper.map(education, EducationalQualificationDto.class));

	        if (educationalQualificationDto.isEmpty()) {
	            throw new EducationalQualificationException("Array is empty");
	        } else {
	            return educationalQualificationDto;
	        }
	}
}
