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

import com.avisys.empmgmt.dto.AddressDto;
import com.avisys.empmgmt.service.AddressService;
import com.avisys.empmgmt.util.ApiResponse;

//import com.avisys.empmgmt.util.ApiResponse;
import jakarta.validation.Valid;

@CrossOrigin("*")
@RestController
@RequestMapping("address")
public class AddressController {
	
	@Autowired
	private AddressService addressService;
	
	@PostMapping("/{employee-id}/create")
	public ResponseEntity<?> addAddress(@Valid @RequestBody AddressDto address, @PathVariable("employee-id") Long employeeId) {
		String createAddress = addressService.createAddress(address,employeeId);
		return new ResponseEntity<>(new ApiResponse(createAddress,LocalDateTime.now()), HttpStatus.CREATED);
	}
	
	@GetMapping("/{employee-id}/get-all")
	public ResponseEntity<List<AddressDto>> getAddressByEmployeeId(@PathVariable("employee-id") Long employeeId){
		List<AddressDto> getAddress = this.addressService.getAddressByEmployee(employeeId);
		return new ResponseEntity<List<AddressDto>>(getAddress,HttpStatus.OK);
	}
	
	@DeleteMapping("/{employee-id}/{address-id}")
	public ResponseEntity<?> deleteEmployeeAddress(@PathVariable("employee-id") Long employeeId, @PathVariable("address-id") Long addressId ){
		String deletedAddress = this.addressService.deleteAddress(employeeId,addressId);
		return new ResponseEntity<>(new ApiResponse(deletedAddress,LocalDateTime.now()), HttpStatus.OK);
	}
	
	@PutMapping("/{employee-id}/update")
	public ResponseEntity<?> updateEmployeeAddress(@Valid @RequestBody AddressDto addressDto, @PathVariable("employee-id") Long employeeId ) {
		String updateEmployeeAddress = this.addressService.updateAddress(addressDto,employeeId);
		return new ResponseEntity<>(new ApiResponse(updateEmployeeAddress,LocalDateTime.now()), HttpStatus.OK);
	}
}
