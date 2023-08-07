package com.avisys.empmgmt.service;

import java.time.LocalDateTime;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.avisys.empmgmt.dto.CompanyDetailDTO;
import com.avisys.empmgmt.dto.CreateCompanyDetailDTO;
import com.avisys.empmgmt.entity.CompanyDetail;
import com.avisys.empmgmt.entity.Employee;
import com.avisys.empmgmt.exception.CompanyDetailAlreadyPresent;
import com.avisys.empmgmt.exception.CompanyDetailNotFound;
import com.avisys.empmgmt.exception.EmployeeException;
import com.avisys.empmgmt.repository.CompanyDetailRepository;
import com.avisys.empmgmt.repository.EmployeeRepo;

import jakarta.transaction.Transactional;


@Service
@Transactional
public class CompanyDetailService {
	@Autowired
	private CompanyDetailRepository companyDetailRepository;
	
	@Autowired
	private ModelMapper modelMapper;
	
	@Autowired
	private EmployeeRepo employeeRepository;

	public CompanyDetailDTO createCompanyDetail(CreateCompanyDetailDTO companyDetailDto,Long employeeId) {
		
		Employee employee=employeeRepository.findByIdAndIsDeletedFalse(employeeId).orElseThrow(()->new EmployeeException("Employee Not Found"));
		
		if(companyDetailRepository.findByEmployeeAndIsDeletedFalse(employee).isPresent()) {
			throw new CompanyDetailAlreadyPresent("Company detail already present");
		}else {
		CompanyDetail companyDetail = this.modelMapper.map(companyDetailDto, CompanyDetail.class);
		companyDetail.setCreatedAt(LocalDateTime.now());
		companyDetail.setUpdatedBy(null);
		companyDetail.setDeleted(false);
		companyDetail.setEmployee(employee);
		CompanyDetail companyDetailObject=companyDetailRepository.save(companyDetail);	
		return this.modelMapper.map(companyDetailObject, CompanyDetailDTO.class);
	   }
	}

	public String deleteCompanyDetailByEmployeeId(Long employeeId) {
		Employee employee=employeeRepository.findByIdAndIsDeletedFalse(employeeId).orElseThrow(()->new EmployeeException("Employee Not Found"));
		CompanyDetail companyDetailToDelete = companyDetailRepository
				.findByIdAndIsDeletedFalse(employee.getCompanyDetail().getId())
				.orElseThrow(() -> new CompanyDetailNotFound("Company Detail Not found to delete for Employee Id " + employeeId));
		companyDetailToDelete.setDeleted(true);
		companyDetailRepository.save(companyDetailToDelete);
		return "Company Detail Deleted";
	}

	public CompanyDetailDTO updateCompanyDetail(CompanyDetailDTO companyDetailDto,Long employeeId) {
		Employee employee=employeeRepository.findByIdAndIsDeletedFalse(employeeId).orElseThrow(()->new EmployeeException("Employee Not Found"));
		CompanyDetail companyDetailToUpdate = companyDetailRepository.findById(companyDetailDto.getId())
				.orElseThrow(() -> new CompanyDetailNotFound("Company Detail Not found to update"));
		if (companyDetailToUpdate.isDeleted()) {
			throw new CompanyDetailNotFound("Company Details Not Found To Update");
		}
		else {
			companyDetailDto.setUpdatedAt(LocalDateTime.now());
			companyDetailDto.setCreatedBy(companyDetailToUpdate.getCreatedBy());
			companyDetailDto.setCreatedAt(companyDetailToUpdate.getCreatedAt());
			CompanyDetail companyDetail = this.modelMapper.map(companyDetailDto,CompanyDetail.class);
			companyDetail.setEmployee(employee);
			companyDetail.setDeleted(false);
			CompanyDetail companyDetailObj=companyDetailRepository.save(companyDetail);

		return this.modelMapper.map(companyDetailObj,CompanyDetailDTO.class);
		}
	}

	public CompanyDetailDTO getCompanyDetailById(Long employeeId) {
		Employee employee=employeeRepository.findByIdAndIsDeletedFalse(employeeId).orElseThrow(()->new EmployeeException("Employee Not Found"));
		CompanyDetail companyDetail = companyDetailRepository.findByEmployeeAndIsDeletedFalse(employee)
				.orElseThrow(() -> new CompanyDetailNotFound("Company Detail Not found for Employee Id "+employeeId));
		CompanyDetailDTO companyDetailDto = this.modelMapper.map(companyDetail, CompanyDetailDTO.class);
		return companyDetailDto;
	}
	
	

}
