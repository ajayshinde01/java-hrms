package com.avisys.empmgmt.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.avisys.empmgmt.dto.AddressDto;
import com.avisys.empmgmt.entity.Address;
import com.avisys.empmgmt.entity.Employee;
import com.avisys.empmgmt.exception.AddressException;
import com.avisys.empmgmt.exception.DepartmentException;
import com.avisys.empmgmt.exception.EmployeeException;
import com.avisys.empmgmt.repository.AddressRepo;
import com.avisys.empmgmt.repository.EmployeeRepo;

import jakarta.validation.Valid;

@Service
public class AddressServiceImpl implements AddressService {
	@Autowired
	private AddressRepo addressRepository;
	
	@Autowired
	private ModelMapper modelMapper;
	
	@Autowired
	private EmployeeRepo employeeRepository;

	@Override
	public String createAddress(@Valid AddressDto addressDto, String employeeCode) throws AddressException, EmployeeException {
		
		Employee employee=this.employeeRepository.findByEmployeeCodeAndIsDeletedFalse(employeeCode).orElseThrow(()-> new EmployeeException("Employee not found"));
		
		List<Address> addressList = addressRepository.findByaddressType(addressDto.getAddressType());
		for (Address address : addressList) {
		    if (address.getEmployee().equals(employee)) {
		        throw new AddressException("Address Type already filled");
		    }
		}
		Address address = this.modelMapper.map(addressDto, Address.class);
		address.setCreatedAt(LocalDateTime.now());
//		address.setCreatedBy(addressDto.getCreatedBy());
		address.setDeleted(false);
		address.setEmployee(employee);
		addressRepository.save(address);
		
		return "Address Created Successfully";
	}
	
	@Override
	public List<AddressDto> getAddressByEmployee(String employeeCode) throws AddressException, EmployeeException {
		Employee employee = employeeRepository.findByEmployeeCodeAndIsDeletedFalse(employeeCode).orElseThrow(()->new EmployeeException("Employee not found"));

		List<Address> addresses=this.addressRepository.findByEmployeeAndIsDeletedFalse(employee);
		if (addresses.isEmpty()) {
			throw new AddressException("Array is empty");
		}
		List<AddressDto> addressDto= addresses.stream().map((address)-> this.modelMapper.map(address,AddressDto.class)).collect(Collectors.toList());
		
		return addressDto;
	}

	@Override
	public String updateAddress( AddressDto addressDto,String employeeCode) throws AddressException, EmployeeException {
		Employee employee=employeeRepository.findByEmployeeCodeAndIsDeletedFalse(employeeCode).orElseThrow(()->new EmployeeException("Employee not found"));
		List<Address> addressList = addressRepository.findByaddressType(addressDto.getAddressType());
		for (Address address : addressList) {
		    if (address.getEmployee().equals(employee)) {
		        throw new AddressException("Address Type already filled");
		    }
		}
	    if (addressDto.getId() == null) {
	        throw new AddressException("Id Should Not be null");
	    }
	    Address addressObj = addressRepository.findByIdAndIsDeletedFalse(addressDto.getId()).orElseThrow(()->new AddressException("Address not found"));
	    if(employee==addressObj.getEmployee()) {
	        modelMapper.map(addressDto, addressObj);

	        // Set other fields that are not mapped automatically
	        addressObj.setUpdatedAt(LocalDateTime.now());
	        addressObj.setUpdatedBy(addressDto.getUpdatedBy());
	        addressObj.setDeleted(false);

	        addressRepository.save(addressObj);
	 
	    return "Address Updated Successfully";
	    } else throw new AddressException("EmployeeCode doesn't have this addressId");
	}

	@Override
	public String deleteAddress(String employeeCode, Long addressId) throws AddressException, EmployeeException {
		Employee employee=this.employeeRepository.findByEmployeeCodeAndIsDeletedFalse(employeeCode).orElseThrow(()->new EmployeeException("Employee not found"));
		Address address = addressRepository.findByIdAndIsDeletedFalse(addressId).orElseThrow(()->new AddressException("Address not found"));
			
		if(employee==address.getEmployee()) {
			address.setDeleted(true);
			addressRepository.save(address); 
			return "Address deleted successfully";
		}else throw new AddressException("employeeCode doesn't match with AddressId");
	}

}
