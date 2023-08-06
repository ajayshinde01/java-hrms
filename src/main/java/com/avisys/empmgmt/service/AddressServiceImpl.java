package com.avisys.empmgmt.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.avisys.empmgmt.dto.AddressDto;
import com.avisys.empmgmt.entity.Address;
import com.avisys.empmgmt.entity.Employee;
import com.avisys.empmgmt.exception.AddressException;
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
	public String createAddress(@Valid AddressDto addressDto, Long employeeId){
		
		Employee employee=this.employeeRepository.findByIdAndIsDeletedFalse(employeeId).orElseThrow(()-> new EmployeeException("Employee not found"));
		
		List<Address> addressList = addressRepository.findByEmployee(employee);

		for (Address address : addressList) {
		    if (address.getAddressType().equals(addressDto.getAddressType())) {
		        throw new AddressException("Address Type already filled");
		    }
		}
		Address address = this.modelMapper.map(addressDto, Address.class);
		address.setCreatedAt(LocalDateTime.now());
		address.setDeleted(false);
		address.setEmployee(employee);
		addressRepository.save(address);
		
		return "Address Created Successfully";
	}
	
	@Override
	public List<AddressDto> getAddressByEmployee(Long employeeId){
		Employee employee = employeeRepository.findByIdAndIsDeletedFalse(employeeId).orElseThrow(()->new EmployeeException("Employee not found"));	
		List<Address> addresses=this.addressRepository.findByEmployeeAndIsDeletedFalse(employee);
		List<AddressDto> addressDto= addresses.stream().map((address)-> this.modelMapper.map(address,AddressDto.class)).collect(Collectors.toList());
		return addressDto;
	}

	@Override
	public String updateAddress( AddressDto addressDto,Long employeeId) {
		Employee employee=employeeRepository.findByIdAndIsDeletedFalse(employeeId).orElseThrow(()->new EmployeeException("Employee not found"));

	    Address addressObj = addressRepository.findByIdAndIsDeletedFalse(addressDto.getId()).orElseThrow(()->new AddressException("Address not found"));
	    if(employee==addressObj.getEmployee()) {
	        modelMapper.map(addressDto, addressObj);

	      
	        addressObj.setUpdatedAt(LocalDateTime.now());
	        addressObj.setUpdatedBy(addressDto.getUpdatedBy());
	        addressObj.setDeleted(false);

	        addressRepository.save(addressObj);
	 
	    return "Address Updated Successfully";
	    } else throw new AddressException("EmployeeId doesn't have this addressId");
	}

	@Override
	public String deleteAddress(Long employeeId, Long addressId) {
		Employee employee=this.employeeRepository.findByIdAndIsDeletedFalse(employeeId).orElseThrow(()->new EmployeeException("Employee not found"));
		Address address = addressRepository.findByIdAndIsDeletedFalse(addressId).orElseThrow(()->new AddressException("Address not found"));
			
		if(employee==address.getEmployee()) {
			address.setDeleted(true);
			addressRepository.save(address); 
			return "Address deleted successfully";
		}else throw new AddressException("employeeId doesn't match with AddressId");
	}

}
