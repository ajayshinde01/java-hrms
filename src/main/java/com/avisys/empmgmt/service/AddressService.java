package com.avisys.empmgmt.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.avisys.empmgmt.dto.AddressDto;

import jakarta.validation.Valid;

@Service
public interface AddressService {

	String createAddress(@Valid AddressDto addressDto, Long employeeId);

	List<AddressDto> getAddressByEmployee(Long employeeId);

	String updateAddress(AddressDto addressDto, Long employeeId);

	String deleteAddress(Long employeeId, Long addressId);

}