package com.avisys.empmgmt.service;

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
import com.avisys.empmgmt.entity.EmployeeType;
import com.avisys.empmgmt.exception.ResourceNotFoundException;
import com.avisys.empmgmt.exception.DataAlreadyPresentException;
import com.avisys.empmgmt.repository.EmployeeTypeRepository;

@Service
public class EmployeeTypeService {
	@Autowired
	public EmployeeTypeRepository employeeTypeRepository;

	@Autowired
	public ModelMapper mapper;

	/************* Show All ******************/
	
	public List<EmployeeTypeDTO> list() throws ResourceNotFoundException {

		List<EmployeeType> list = null;

		list = employeeTypeRepository.findAllByDeleted(false);
		if (list.isEmpty()) {
			throw new ResourceNotFoundException("Sorry... No Record Found");
		}

		List<EmployeeTypeDTO> empDTO = list.stream().map(e -> mapper.map(e, EmployeeTypeDTO.class))
				.collect(Collectors.toList());

		for (EmployeeTypeDTO employeeTypeDTO : empDTO) {
			employeeTypeDTO.setMessage("Records Shown Successfully...");
		}
		return empDTO;
	}

	/************* Create Record ******************/
	
	public EmployeeTypeDTO CreateorSaveEmployeeType(EmployeeTypeDTO employeeTypeDTO) {
		EmployeeType employeeType = mapper.map(employeeTypeDTO, EmployeeType.class);
		Optional<EmployeeType> e = this.employeeTypeRepository.findByIdAndDeleted(employeeType.getId(), false);
		if (e.isPresent()) {
			throw new DataAlreadyPresentException();
		}

		EmployeeType employee = employeeTypeRepository.save(employeeType);
		EmployeeTypeDTO empDTO = mapper.map(employee, EmployeeTypeDTO.class);
		String mesg = "Record Stored Successfully...";
		empDTO.setMessage(mesg);
		return empDTO;
	}

	/************* Get-ById ******************/
	
	public EmployeeTypeDTO getByEmpId(Long id) throws ResourceNotFoundException {
		Optional<EmployeeType> findByIdAndDeleted = employeeTypeRepository.findByIdAndDeleted(id, false);
		if (findByIdAndDeleted.isEmpty()) {
			throw new ResourceNotFoundException("Record with Id " + id + " " + "does not exist");
		}
		EmployeeType employeeType = findByIdAndDeleted.get();
		EmployeeTypeDTO employeeTypeDTO = mapper.map(employeeType, EmployeeTypeDTO.class);
		String mesg = "Record with ID" + " " + id + " " + "found Successfully...";
		employeeTypeDTO.setMessage(mesg);
		return employeeTypeDTO;

	}

	/************* Delete-ById ******************/
	
	public ResponseEntity<String> delete(Long id) {
		Optional<EmployeeType> findByIdAndDeleted = employeeTypeRepository.findByIdAndDeleted(id, false);

		if (findByIdAndDeleted.isPresent()) {
			EmployeeType employee = findByIdAndDeleted.get();
			employee.setDeleted(true);
			employeeTypeRepository.save(employee);

			String successMessage = "Record Deleted Successfully"; // Define the success message

			return ResponseEntity.ok(successMessage);
		} else {
			throw new ResourceNotFoundException("Record with Id " + id + " Not Found...");
		}

	}

	/************* Update-ById ******************/
	
	public EmployeeTypeDTO update(EmployeeTypeDTO employeeTypeDTO, Long id) {
		Optional<EmployeeType> updateEmpId = employeeTypeRepository.findById(id);
		if (!updateEmpId.isPresent()) {
			throw new ResourceNotFoundException("Updatation Fails with Id:- " + id);
		}
		EmployeeType updateEmpType = updateEmpId.get();
		updateEmpType.setType(employeeTypeDTO.getType());
		updateEmpType.setOrgCode(employeeTypeDTO.getOrgCode());
//		updateEmpType.setUpdatedAt(employeeTypeDTO.getUpdatedAt());
		updateEmpType.setUpdatedBy(employeeTypeDTO.getUpdatedBy());
		EmployeeType type = employeeTypeRepository.save(updateEmpType);
		EmployeeTypeDTO empDTO = mapper.map(type, EmployeeTypeDTO.class);
		System.out.println(empDTO.toString());
		empDTO.setUpdatedAt(type.getUpdatedAt());
		System.out.println(type.getUpdatedAt());
		empDTO.setMessage("Record Update Successfully...");
		return empDTO;
	}

	/************* Pagination-Search,Sort,Page,Size ******************/

	public Page<EmployeeTypeDTO> search(String type, Pageable pageable) {
		Page<EmployeeType> employeeType;
		if (type.isEmpty()) {
			employeeType = employeeTypeRepository.findAllByDeleted(pageable, false);
		} else {
			employeeType = employeeTypeRepository.findByTypeIsContainingAndDeleted(type, pageable, false);
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
		employeeTypeDTO.setMessage("Details Shown Successfully...");
		return employeeTypeDTO;
	}
}
