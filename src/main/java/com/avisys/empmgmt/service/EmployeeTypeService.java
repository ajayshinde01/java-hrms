package com.avisys.empmgmt.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import com.avisys.empmgmt.dto.EmployeeTypeDTO;
import com.avisys.empmgmt.entity.Division;
import com.avisys.empmgmt.entity.EmployeeType;
import com.avisys.empmgmt.exception.ResourceNotFoundException;
import com.avisys.empmgmt.exception.DataAlreadyPresentException;
import com.avisys.empmgmt.repository.EmployeeTypeRepository;
import com.avisys.empmgmt.util.ApiResponse;

@Service
public class EmployeeTypeService {
	@Autowired
	public EmployeeTypeRepository employeeTypeRepository;

	@Autowired
	public ModelMapper mapper;

	/************* Show All ******************/
	
	public List<EmployeeTypeDTO> list() throws ResourceNotFoundException {

		List<EmployeeType> list = null;

		list = employeeTypeRepository.findAllByIsDeleted(false);
		if (list.isEmpty()) {
			throw new ResourceNotFoundException("Sorry... No Record Found");
		}
		else {
		List<EmployeeTypeDTO> empDTO = list.stream().map(e -> mapper.map(e, EmployeeTypeDTO.class))
				.collect(Collectors.toList());
		return empDTO;
		}
	}

	/************* Create Record ******************/
	
	public EmployeeTypeDTO CreateorSaveEmployeeType(EmployeeTypeDTO employeeTypeDTO) {
		EmployeeType employeeType = mapper.map(employeeTypeDTO, EmployeeType.class);
		Optional<EmployeeType> e = this.employeeTypeRepository.findByEmployeeTypeIdAndIsDeleted(employeeTypeDTO.getEmployeeTypeId(), false);
		System.out.println(e.get());
		if (e.isPresent()) {
			throw new DataAlreadyPresentException();
		}
		else {
		employeeType.setCreatedAt(LocalDateTime.now());
		employeeType.setUpdatedAt(LocalDateTime.now());
		employeeType.setDeleted(false);
		EmployeeType employee = employeeTypeRepository.save(employeeType);
		EmployeeTypeDTO empDTO = mapper.map(employee, EmployeeTypeDTO.class);
		return empDTO;
		}
	}

	/************* Get-ById ******************/
	
	public EmployeeTypeDTO getByEmpId(String employeeTypeId) throws ResourceNotFoundException {
		Optional<EmployeeType> findByIdAndDeleted = employeeTypeRepository.findByEmployeeTypeIdAndIsDeleted(employeeTypeId, false);
		if (findByIdAndDeleted.isEmpty()) {
			throw new ResourceNotFoundException("Record with Id " + employeeTypeId + " " + "does not exist");
		}
		EmployeeType employeeType = findByIdAndDeleted.get();
		EmployeeTypeDTO employeeTypeDTO = mapper.map(employeeType, EmployeeTypeDTO.class);
		return employeeTypeDTO;

	}

	/************* Delete-ById ******************/
	
	public ResponseEntity<?> delete(String employeeTypeId) {
		Optional<EmployeeType> findByIdAndDeleted = employeeTypeRepository.findByEmployeeTypeIdAndIsDeleted(employeeTypeId, false);

		if (findByIdAndDeleted.isPresent()) {
			EmployeeType employee = findByIdAndDeleted.get();
			employee.setDeleted(true);
			employeeTypeRepository.save(employee);

			return ResponseEntity.ok(new ApiResponse("Record Deleted Successfully"));
		} else {
			throw new ResourceNotFoundException("Record with Id " + employeeTypeId + " Not Found...");
		}

	}

	/************* Update-ById ******************/
	
	public EmployeeTypeDTO update(EmployeeTypeDTO employeeTypeDTO, Long id) {
		Optional<EmployeeType> updateEmpId = employeeTypeRepository.findById(id);
		if (!updateEmpId.isPresent()||updateEmpId.get().isDeleted()) {
			throw new ResourceNotFoundException("Updatation Fails with Id:- " + id);
		}
		else {
			Optional<EmployeeType> employeeTypeByEmpTypeId = employeeTypeRepository
					.findByEmployeeTypeId(employeeTypeDTO.getEmployeeTypeId());
			if(employeeTypeByEmpTypeId.isEmpty() || employeeTypeDTO.getId().equals(updateEmpId.get().getEmployeeTypeId())
					&& employeeTypeDTO.getEmployeeTypeId().equals(updateEmpId.get().getEmployeeTypeId())) {
				EmployeeType updateEmpType = updateEmpId.get();
				updateEmpType.setType(employeeTypeDTO.getType());
				updateEmpType.setOrgCode(employeeTypeDTO.getOrgCode());
//				updateEmpType.setUpdatedAt(employeeTypeDTO.getUpdatedAt());
				updateEmpType.setUpdatedBy(employeeTypeDTO.getUpdatedBy());
				EmployeeType type = employeeTypeRepository.save(updateEmpType);
				EmployeeTypeDTO empDTO = mapper.map(type, EmployeeTypeDTO.class);
				System.out.println(empDTO.toString());
				empDTO.setUpdatedAt(LocalDateTime.now());
				System.out.println(type.getUpdatedAt());
				return empDTO;
			}
			else {
				throw new ResourceNotFoundException("Employee Type Id Is Already Present");
			}
		}
	}

	/************* Pagination-Search,Sort,Page,Size ******************/

	public Page<EmployeeTypeDTO> search(String searchValue, Pageable pageable) {
		Page<EmployeeType> employeeType;
		if (searchValue.isEmpty()) {
			employeeType = employeeTypeRepository.findAllByIsDeleted(pageable, false);
		} else {
			employeeType = employeeTypeRepository.searchEmployeeType(searchValue.toLowerCase(),pageable).get();
		}
		return employeeType.map(this::convertToDTO);
	}

	public EmployeeTypeDTO convertToDTO(EmployeeType employeeType) {
		EmployeeTypeDTO employeeTypeDTO = new EmployeeTypeDTO();
		employeeTypeDTO.setId(employeeType.getId());
		employeeTypeDTO.setType(employeeType.getType());
		employeeTypeDTO.setOrgCode(employeeType.getOrgCode());
		employeeTypeDTO.setCreatedAt(employeeType.getCreatedAt());
		employeeTypeDTO.setCreatedBy(employeeType.getCreatedBy());
		employeeTypeDTO.setUpdatedAt(employeeType.getUpdatedAt());
		employeeTypeDTO.setUpdatedBy(employeeType.getUpdatedBy());
		return employeeTypeDTO;
	}
}
