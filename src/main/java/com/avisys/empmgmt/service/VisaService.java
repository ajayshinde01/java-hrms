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
import com.avisys.empmgmt.dto.VisaDto;
import com.avisys.empmgmt.entity.Employee;
import com.avisys.empmgmt.entity.Visa;
import com.avisys.empmgmt.exception.EmployeeException;
import com.avisys.empmgmt.exception.VisaException;
import com.avisys.empmgmt.repository.EmployeeRepo;
import com.avisys.empmgmt.repository.VisaRepository;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;

@Service
@Transactional
public class VisaService {
	
		@Autowired
		private VisaRepository visaRepository;
		
		@Autowired
		private ModelMapper modelMapper;
		
		@Autowired
		private EmployeeRepo employeeRepository;

		public VisaDto createVisa(@Valid VisaDto visaDto, Long employeeId){
			
			Employee employee=this.employeeRepository.findByIdAndIsDeletedFalse(employeeId).orElseThrow(()-> new EmployeeException("Employee not found"));
			
			Optional<Visa> visaObj = visaRepository.findByVisaNumberAndIsDeletedFalse(visaDto.getVisaNumber());
			    if (!visaObj.isPresent()) {
			    	Visa visa = this.modelMapper.map(visaDto, Visa.class);
			    	visa.setCreatedAt(LocalDateTime.now());
			    	visa.setDeleted(false);
			    	visa.setEmployee(employee);
			    	visaRepository.save(visa);					
			return this.modelMapper.map(visa, VisaDto.class);
			       
			    } else
			    	 throw new VisaException("Visa Number is already filled");
		}
		
		public List<VisaDto> getVisaByEmployeeId(Long employeeId){
			Employee employee = employeeRepository.findByIdAndIsDeletedFalse(employeeId).orElseThrow(()->new EmployeeException("Employee not found"));
					
			List<Visa> visaDetails=this.visaRepository.findByEmployeeAndIsDeletedFalse(employee);
			List<VisaDto> visaDto= visaDetails.stream().map((visa)-> this.modelMapper.map(visa,VisaDto.class)).collect(Collectors.toList());
			
			return visaDto;
		}

		public VisaDto updateVisa( VisaDto visaDto,Long employeeId) {
			Employee employee=employeeRepository.findByIdAndIsDeletedFalse(employeeId).orElseThrow(()->new EmployeeException("Employee not found"));
			    
		    Visa visaDetails = visaRepository.findByIdAndIsDeletedFalse(visaDto.getId()).orElseThrow(()->new VisaException("visa not found"));
		    if(employee==visaDetails.getEmployee()) {
		        modelMapper.map(visaDto, visaDetails);

		        visaDetails.setUpdatedAt(LocalDateTime.now());
		        visaDetails.setUpdatedBy(visaDto.getUpdatedBy());
		        visaDetails.setDeleted(false);

		        visaRepository.save(visaDetails);
		    return this.modelMapper.map(visaDetails, VisaDto.class);
		    } else 
		    	throw new VisaException("Employee doesn't have this VisaId");
		}

		public String deleteVisa(Long employeeId, Long visaId,String updatedBy) {
			Employee employee=this.employeeRepository.findByIdAndIsDeletedFalse(employeeId).orElseThrow(()->new EmployeeException("Employee not found"));
			Visa visa = visaRepository.findByIdAndIsDeletedFalse(visaId).orElseThrow(()->new VisaException("Visa not found"));
				
			if(employee==visa.getEmployee()) {
				visa.setDeleted(true);
				visa.setUpdatedAt(LocalDateTime.now());
				visa.setUpdatedBy(updatedBy);
				visaRepository.save(visa); 
				return "Address deleted successfully";
			}else throw new VisaException("employee doesn't match with VisaId");
		}

		public Page<VisaDto> searchVisa(Pageable pageable, String keyword, Long employeeId) {
			Employee employee = this.employeeRepository.findByIdAndIsDeletedFalse(employeeId)
	                .orElseThrow(() -> new EmployeeException("Employee not found"));

	        List<Visa> visa = visaRepository.findByEmployeeAndIsDeletedFalse(employee);
	        if (visa.isEmpty()) {
	            throw new VisaException("Array is empty");
	        }

	        keyword = keyword.toLowerCase();
	        Page<Visa> pageableVisa = visaRepository.searchByVisaAndEmployeeId(keyword, pageable, employeeId);

	        Page<VisaDto> visaDto = pageableVisa.map(visaObj ->
	                this.modelMapper.map(visaObj, VisaDto.class));

	            return visaDto;

		}

	}
