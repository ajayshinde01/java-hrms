package com.avisys.empmgmt.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.avisys.empmgmt.dto.EmergencyContactsDto;
import com.avisys.empmgmt.entity.EmergencyContacts;
import com.avisys.empmgmt.entity.Employee;
import com.avisys.empmgmt.exception.AddressException;
import com.avisys.empmgmt.exception.EmergencyContactsException;
import com.avisys.empmgmt.exception.EmployeeException;
import com.avisys.empmgmt.repository.EmergencyContactsRepo;
import com.avisys.empmgmt.repository.EmployeeRepo;

import jakarta.validation.Valid;

@Service
public class EmergencyContactsServiceImpl implements EmergencyContactsService{

	@Autowired
	private EmergencyContactsRepo emergencyContactsRepository;
	
	@Autowired
	private ModelMapper modelMapper;
	
	@Autowired
	private EmployeeRepo employeeRepository;
	
	@Override
	public String createEmergencyContact(@Valid EmergencyContactsDto emergencyContactsDto, Long employeeId) {
		
		Employee employee=this.employeeRepository.findByIdAndIsDeletedFalse(employeeId).orElseThrow(()-> new EmployeeException("Employee not found"));
		
		Optional<EmergencyContacts> emergencyContactsObj = emergencyContactsRepository.findByEmergencyContactNumberAndIsDeletedFalse(emergencyContactsDto.getEmergencyContactNumber());
	    if (!emergencyContactsObj.isPresent()) {
		EmergencyContacts contacts = this.modelMapper.map(emergencyContactsDto, EmergencyContacts.class);
		contacts.setCreatedAt(LocalDateTime.now());
		contacts.setDeleted(false);
		contacts.setEmployee(employee);
		emergencyContactsRepository.save(contacts);
		
		return "Emegency contact added Successfully";
	} else
   	 throw new EmergencyContactsException("Contact Number is already filled");
}

	@Override
	public List<EmergencyContactsDto> getEmergencyContactsByEmployee(Long employeeId) {
		Employee employee = employeeRepository.findByIdAndIsDeletedFalse(employeeId).orElseThrow(()->new EmployeeException("Employee not found"));
		
		
		List<EmergencyContacts> contacts=this.emergencyContactsRepository.findByEmployeeAndIsDeletedFalse(employee);
		if (contacts.isEmpty()) {
			throw new AddressException("Array is empty");
		}
		List<EmergencyContactsDto> emergencyContactsDto = contacts.stream().map((contact)-> this.modelMapper.map(contact,EmergencyContactsDto.class)).collect(Collectors.toList());
		
		return emergencyContactsDto;
	}

	@Override
	public String updateEmergencyContacts(EmergencyContactsDto emergencyContactsDto, Long employeeId) {
		Employee employee=employeeRepository.findByIdAndIsDeletedFalse(employeeId).orElseThrow(()->new EmployeeException("Employee not found"));

	    EmergencyContacts contactObj = emergencyContactsRepository.findByIdAndIsDeletedFalse(emergencyContactsDto.getId()).orElseThrow(()->new EmergencyContactsException("Contact not found"));
	    if(employee==contactObj.getEmployee()) {
	        modelMapper.map(emergencyContactsDto, contactObj);
	        
	        contactObj.setUpdatedAt(LocalDateTime.now());
	        contactObj.setUpdatedBy(emergencyContactsDto.getUpdatedBy());
	        contactObj.setDeleted(false);

	        emergencyContactsRepository.save(contactObj);
	 
	    return "contact Updated Successfully";
	    } else throw new EmergencyContactsException("EmployeeId doesn't have this contactId");
	}

	@Override
	public String deleteEmergencyContacts(Long employeeId, Long emergencyContactsId) {
		Employee employee=this.employeeRepository.findByIdAndIsDeletedFalse(employeeId).orElseThrow(()->new EmployeeException("Employee not found"));
		EmergencyContacts contacts = this.emergencyContactsRepository.findByIdAndIsDeletedFalse(emergencyContactsId).orElseThrow(()->new EmergencyContactsException("Contact not found"));
			
		if(employee==contacts.getEmployee()) {
			contacts.setDeleted(true);
			emergencyContactsRepository.save(contacts); 
			return "contact deleted successfully";
		}else throw new EmergencyContactsException("EmployeeId doesn't match with EmergencyContactsId");
	}

}
