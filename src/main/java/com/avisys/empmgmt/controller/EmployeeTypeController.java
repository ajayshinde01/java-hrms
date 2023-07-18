package com.avisys.empmgmt.controller;

import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.avisys.empmgmt.dto.EmployeeTypeDTO;
import com.avisys.empmgmt.exception.ResourceNotFoundException;
import com.avisys.empmgmt.service.EmployeeTypeService;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/employee-type")
public class EmployeeTypeController {

	@Autowired
	EmployeeTypeService employeeTypeService;

	Logger logger = LoggerFactory.getLogger(EmployeeTypeController.class);

	/************** Save *******************/
	@PostMapping(value = "/save")
	public ResponseEntity<EmployeeTypeDTO> save(@Valid @RequestBody EmployeeTypeDTO employeeTypeDTO) {
		logger.info("Save Information Successfully...");
		EmployeeTypeDTO createorSaveEmployeeType = employeeTypeService.CreateorSaveEmployeeType(employeeTypeDTO);
		return new ResponseEntity<EmployeeTypeDTO>(createorSaveEmployeeType, HttpStatus.CREATED);
	}

	/************** Show-All *******************/
	@GetMapping("/show-all")
	public ResponseEntity<?> lists() throws ResourceNotFoundException {

		logger.info("Getting All Information Successfully...");
		List<EmployeeTypeDTO> list = employeeTypeService.list();
		return ResponseEntity.ok(list);

	}

	/************** Get-ById *******************/
	@GetMapping("/by-id/{id}")
	public ResponseEntity<EmployeeTypeDTO> findEmpId(@PathVariable Long id) {
		EmployeeTypeDTO employeeTypeDTO = employeeTypeService.getByEmpId(id);
		logger.info("Getting Information By Id Successfully...");
		return ResponseEntity.ok(employeeTypeDTO);
	}

	/************** Delete-ById *******************/
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> delete(@PathVariable Long id) {
		ResponseEntity<String> employeeDeleted = employeeTypeService.delete(id);
		logger.info("Delete Information By Id Successfully...");
		return employeeDeleted;
	}

	/************** Update-ById *******************/
	@PutMapping("/update/{id}")
	public ResponseEntity<EmployeeTypeDTO> update(@Valid @RequestBody EmployeeTypeDTO employeeTypeDTO,
			@PathVariable Long id) {
		logger.info("Update Information By Id Successfully...");
		EmployeeTypeDTO empDTO = employeeTypeService.update(employeeTypeDTO, id);
		return new ResponseEntity<EmployeeTypeDTO>(empDTO, HttpStatus.OK);
	}

	/************** Pagination *******************/

	@GetMapping("/search")
	public ResponseEntity<Page<EmployeeTypeDTO>> search(@RequestParam(defaultValue = "") String type,
			Pageable pageable) {
		Page<EmployeeTypeDTO> page = employeeTypeService.search(type, pageable);
		return ResponseEntity.ok(page);
	}

}