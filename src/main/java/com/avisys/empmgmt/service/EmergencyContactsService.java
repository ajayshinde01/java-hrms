package com.avisys.empmgmt.service;

import java.util.List;

import org.springframework.stereotype.Service;
import com.avisys.empmgmt.dto.EmergencyContactsDto;

import jakarta.validation.Valid;

@Service
public interface EmergencyContactsService {
	String createEmergencyContact(@Valid EmergencyContactsDto emergencyContactsDto, Long employeeId);

	List<EmergencyContactsDto> getEmergencyContactsByEmployee(Long employeeId);

	String updateEmergencyContacts(EmergencyContactsDto emergencyContactsDto, Long employeeId);

	String deleteEmergencyContacts(Long employeeId, Long emergencyContactsId);
	
}