package com.avisys.empmgmt.controller;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.avisys.empmgmt.dto.EmergencyContactsDto;
import com.avisys.empmgmt.service.EmergencyContactsService;
import com.avisys.empmgmt.util.ApiResponse;

import jakarta.validation.Valid;

@CrossOrigin("*")
@RestController
@RequestMapping("contact")
public class EmergencyContactsController {

	@Autowired
	private EmergencyContactsService emergencyContactsService;
	
	@PostMapping("/{employee-id}/add")
	public ResponseEntity<?> addEmergencyContact(@Valid @RequestBody EmergencyContactsDto emergencyContactsDto, @PathVariable("employee-id") Long employeeId) {
		String createEmergencyContact = emergencyContactsService.createEmergencyContact(emergencyContactsDto,employeeId);
		return new ResponseEntity<>(new ApiResponse(createEmergencyContact,LocalDateTime.now()), HttpStatus.CREATED);
	}
	
	@GetMapping("/{employee-id}/get-all")
	public ResponseEntity<List<EmergencyContactsDto>> getEmergencyContactByEmployeeId(@PathVariable("employee-id") Long employeeId){
		List<EmergencyContactsDto> getEmergencyContacts = this.emergencyContactsService.getEmergencyContactsByEmployee(employeeId);
		return new ResponseEntity<List<EmergencyContactsDto>>(getEmergencyContacts,HttpStatus.OK);
	}
	
	@DeleteMapping("/{employee-id}/{contact-id}")
	public ResponseEntity<?> deleteEmergencyContacts(@PathVariable("employee-id") Long employeeId, @PathVariable("contact-id") Long contactId ){
		String deletedEmergencyContact = this.emergencyContactsService.deleteEmergencyContacts(employeeId,contactId);
		return new ResponseEntity<>(new ApiResponse(deletedEmergencyContact,LocalDateTime.now()), HttpStatus.OK);
	}
	
	@PutMapping("/{employee-id}/update")
	public ResponseEntity<?> updateEmergencyContact(@Valid @RequestBody EmergencyContactsDto emergencyContactsDto, @PathVariable("employee-id") Long employeeId ) {
		String updateEmergencyContacts = this.emergencyContactsService.updateEmergencyContacts(emergencyContactsDto,employeeId);
		return new ResponseEntity<>(new ApiResponse(updateEmergencyContacts,LocalDateTime.now()), HttpStatus.OK);
	}
}
