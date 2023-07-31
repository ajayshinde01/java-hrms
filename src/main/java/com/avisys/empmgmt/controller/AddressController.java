package com.avisys.empmgmt.controller;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.avisys.empmgmt.dto.AddressDto;
import com.avisys.empmgmt.dto.EmployeeDto;
import com.avisys.empmgmt.exception.AddressException;
import com.avisys.empmgmt.exception.DepartmentException;
import com.avisys.empmgmt.exception.EmployeeException;
import com.avisys.empmgmt.service.AddressService;
import com.avisys.empmgmt.util.ApiResponse;
import jakarta.validation.Valid;

@RestController
@RequestMapping("employee")
public class AddressController {
	
	@Autowired
	private AddressService addressService;
	
	@PostMapping("/{employee-code}/address")
	public ResponseEntity<?> addAddress(@Valid @RequestBody AddressDto address, @PathVariable("employee-code") String employeeCode) throws AddressException, EmployeeException {
		String createAddress = addressService.createAddress(address,employeeCode);
		return new ResponseEntity<>(new ApiResponse(createAddress,LocalDateTime.now()), HttpStatus.CREATED);
	}
	
	@GetMapping("/{employee-code}/address")
	public ResponseEntity<List<AddressDto>> getAddressByEmployeeId(@PathVariable("employee-code") String employeeCode)
			throws AddressException, EmployeeException{
		List<AddressDto> getAddress = this.addressService.getAddressByEmployee(employeeCode);
		return new ResponseEntity<List<AddressDto>>(getAddress,HttpStatus.OK);
	}
	
	@DeleteMapping("/{employee-code}/address/{address-Id}")
	public ResponseEntity<?> deleteEmployeeAddress(@PathVariable("employee-code") String employeeCode, @PathVariable("address-Id") Long addressId )
			throws AddressException, EmployeeException {
		String deletedAddress = this.addressService.deleteAddress(employeeCode,addressId);
		return new ResponseEntity<>(new ApiResponse(deletedAddress,LocalDateTime.now()), HttpStatus.OK);
	}
	
	@PutMapping("/{employee-code}/address")
	public ResponseEntity<?> updateEmployeeAddress(@Valid @RequestBody AddressDto addressDto, @PathVariable("employee-code") String employeeCode ) throws AddressException, EmployeeException {
		String updateEmployeeAddress = this.addressService.updateAddress(addressDto,employeeCode);
		return new ResponseEntity<>(new ApiResponse(updateEmployeeAddress,LocalDateTime.now()), HttpStatus.OK);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
}
