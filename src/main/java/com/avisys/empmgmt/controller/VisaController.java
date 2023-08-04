package com.avisys.empmgmt.controller;

import java.time.LocalDateTime;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.avisys.empmgmt.dto.VisaDto;
import com.avisys.empmgmt.service.VisaService;
import com.avisys.empmgmt.util.ApiResponse;

import jakarta.validation.Valid;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("visa")
public class VisaController {
	
	@Autowired
	private VisaService visaService;
	
	@PostMapping("/{employee-id}/add")
	public ResponseEntity<?> addVisa(@Valid @RequestBody VisaDto visa, @PathVariable("employee-id") Long employeeId) {
		String createVisa= visaService.createVisa(visa,employeeId);
		return new ResponseEntity<>(new ApiResponse(createVisa,LocalDateTime.now()), HttpStatus.CREATED);
	}
	
	@GetMapping("/{employee-id}/get-all")
	public ResponseEntity<List<VisaDto>> getAddressByEmployeeId(@PathVariable("employee-id") Long employeeId){
		List<VisaDto> getVisa = this.visaService.getVisaByEmployeeId(employeeId);
		return new ResponseEntity<List<VisaDto>>(getVisa,HttpStatus.OK);
	}
	
	@DeleteMapping("/{employee-id}/{visa-id}")
	public ResponseEntity<?> deleteEmployeeVisa(@PathVariable("employee-id") Long employeeId, @PathVariable("visa-id") Long visaId ){
		String deletedVisa = this.visaService.deleteVisa(employeeId,visaId);
		return new ResponseEntity<>(new ApiResponse(deletedVisa,LocalDateTime.now()), HttpStatus.OK);
	}
	
	@PutMapping("/{employee-id}/update")
	public ResponseEntity<?> updateEmployeeVisa(@Valid @RequestBody VisaDto visaDto, @PathVariable("employee-id") Long employeeId ) {
		String updateEmployeeVisa = this.visaService.updateVisa(visaDto,employeeId);
		return new ResponseEntity<>(new ApiResponse(updateEmployeeVisa,LocalDateTime.now()), HttpStatus.OK);
	}
	
	@GetMapping("/{employee-id}/search")
	public ResponseEntity<Page<VisaDto>> searchVisa(
	        @PageableDefault Pageable pageable,
	        @PathVariable("employee-id") Long employeeId,
	        @RequestParam(value = "keyword", defaultValue = "") String keyword
	) {
	    Page<VisaDto> result = this.visaService.searchVisa(pageable, keyword, employeeId);
	    return new ResponseEntity<>(result, HttpStatus.OK);
	}
}
