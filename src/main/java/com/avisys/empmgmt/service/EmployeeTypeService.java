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
import com.avisys.empmgmt.entity.EmployeeType;
import com.avisys.empmgmt.exception.ResourceNotFoundException;
import com.avisys.empmgmt.exception.EmployeeException;
import com.avisys.empmgmt.exception.NoEmployeeFoundException;
import com.avisys.empmgmt.repository.EmployeeTypeRepository;
import com.avisys.empmgmt.util.ApiResponse;
import com.avisys.empmgmt.util.Utils;

 

import jakarta.validation.Valid;

 

@Service
public class EmployeeTypeService {
    @Autowired
    public EmployeeTypeRepository employeeTypeRepository;

 

    @Autowired
    private Utils util;
    @Autowired
    public ModelMapper mapper;

 

    /************* Show All ******************/

 

    public List<EmployeeTypeDTO> list() throws ResourceNotFoundException {

 

        List<EmployeeType> list = null;

 

        list = employeeTypeRepository.findAllByIsDeleted(false);
        if (list.isEmpty()) {
            throw new ResourceNotFoundException("Sorry... No Record Found");
        } else {
            List<EmployeeTypeDTO> empDTO = list.stream().map(e -> mapper.map(e, EmployeeTypeDTO.class))
                    .collect(Collectors.toList());
            return empDTO;
        }
    }



 

    /************* Create Record ******************/

 

    public EmployeeTypeDTO createEmployeeType(@Valid EmployeeTypeDTO employeeTypeDTO) {
        Optional<EmployeeType> optionalEmployeeType = employeeTypeRepository
                .findByEmployeeTypeIdAndIsDeleted(employeeTypeDTO.getEmployeeTypeId(), false);
        if (optionalEmployeeType.isPresent()) {
            throw new EmployeeException("Employee Type code should not be duplicate");
        }

 

        EmployeeType employeeType = this.mapper.map(employeeTypeDTO, EmployeeType.class);
        employeeType.setCreatedAt(LocalDateTime.now());
        employeeType.setCreatedBy(employeeTypeDTO.getCreatedBy());
        employeeType.setUpdatedAt(LocalDateTime.now());
        employeeType.setDeleted(false);
        employeeTypeRepository.save(employeeType);

 

        return this.mapper.map(employeeType, EmployeeTypeDTO.class);
    }

 

    /************* Get-ById ******************/

 

    public EmployeeTypeDTO getByEmpId(String employeeTypeId) throws ResourceNotFoundException {
        Optional<EmployeeType> findByIdAndDeleted = employeeTypeRepository
                .findByEmployeeTypeIdAndIsDeleted(employeeTypeId, false);
        if (findByIdAndDeleted.isEmpty()) {
            throw new ResourceNotFoundException("Record with Id " + employeeTypeId + " " + "does not exist");
        }
        EmployeeType employeeType = findByIdAndDeleted.get();
        EmployeeTypeDTO employeeTypeDTO = mapper.map(employeeType, EmployeeTypeDTO.class);
        return employeeTypeDTO;

 

    }

 

    /************* Delete-ById ******************/

 

    public ResponseEntity<?> delete(String employeeTypeId,String updatedBy) {
        Optional<EmployeeType> findByIdAndDeleted = employeeTypeRepository
                .findByEmployeeTypeIdAndIsDeleted(employeeTypeId, false);

 

        if (findByIdAndDeleted.isPresent()) {
            EmployeeType employee = findByIdAndDeleted.get();
            employee.setDeleted(true);
            employee.setUpdatedAt(LocalDateTime.now());
            employee.setUpdatedBy(updatedBy);
            employeeTypeRepository.save(employee);
            LocalDateTime dateTime = employee.getCreatedAt();
            return ResponseEntity.ok(new ApiResponse("Record Deleted Successfully",dateTime.now()));
        } else {
            throw new ResourceNotFoundException("Record with Id " + employeeTypeId + " Not Found...");
        }

 

    }

 

    /************* Update-ById ******************/

 

    public EmployeeTypeDTO updateEmployeeType(EmployeeTypeDTO employeeTypeDTO) {
        EmployeeType employeeType = employeeTypeRepository.findById(employeeTypeDTO.getId())
                .orElseThrow(() -> new NoEmployeeFoundException("EmployeeType Not Found"));
        if (employeeType.isDeleted() == true) {
            throw new NoEmployeeFoundException("EmployeeType Does Not Exist");
        } else {
            Optional<EmployeeType> employeeTypeByEmployeeTypeId = employeeTypeRepository
                    .findByEmployeeTypeId(employeeTypeDTO.getEmployeeTypeId());
            if (employeeTypeByEmployeeTypeId.isEmpty() || employeeTypeDTO.getId().equals(employeeType.getId())
&& employeeTypeDTO.getEmployeeTypeId().equals(employeeType.getEmployeeTypeId())) {
                employeeTypeDTO.setUpdatedAt(LocalDateTime.now());
                EmployeeType empType = util.getEmployeeType(employeeTypeDTO);
                empType.setType(employeeTypeDTO.getType());
                employeeTypeRepository.save(empType);
                return this.mapper.map(empType, EmployeeTypeDTO.class);
            } else {
                throw new NoEmployeeFoundException("EmployeeType already Exist");
            }
        }
    }

    /************* Pagination-Search,Sort,Page,Size ******************/

 

    public Optional<Page<EmployeeType>> searchingSortingPagination(String key, Pageable pageable) {
        Optional<Page<EmployeeType>> foundedPages = this.employeeTypeRepository.searchEmployeeType(key.toLowerCase(),
                pageable);
        return foundedPages;
    }
}