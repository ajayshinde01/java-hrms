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

import com.avisys.empmgmt.dto.AddressDto;
import com.avisys.empmgmt.dto.CommonMasterDto;
import com.avisys.empmgmt.dto.EmployeeDto;
import com.avisys.empmgmt.service.CommonMasterService;
import com.avisys.empmgmt.util.ApiResponse;

import jakarta.validation.Valid;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("common-master")
public class CommonMasterController {

	@Autowired
	private CommonMasterService commonMasterService;
	
	@PostMapping("/create")
	public ResponseEntity<CommonMasterDto>  createCommonMaster(@Valid @RequestBody CommonMasterDto commonMasterDto){
		CommonMasterDto createmaster = this.commonMasterService.createCommonMaster(commonMasterDto);
		return new ResponseEntity<CommonMasterDto>(createmaster, HttpStatus.OK);
	}
	
	@GetMapping("/{master-name}/childs")
	public ResponseEntity<Page<CommonMasterDto>> getByMasterName(@PageableDefault Pageable pageable, @PathVariable("master-name") String masterName) {
		Page<CommonMasterDto> getMasters = this.commonMasterService.getByMasterName(pageable,masterName);
		return new ResponseEntity<Page<CommonMasterDto>>(getMasters, HttpStatus.OK);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> deleteCommonMaster(@PathVariable("id") Long id, @RequestParam(value = "updatedBy") String updatedBy){
		String deletedMaster=this.commonMasterService.deleteCommonMaster(id, updatedBy);
		return new ResponseEntity<>(new ApiResponse(deletedMaster,LocalDateTime.now()), HttpStatus.OK);
	}
	
	@PutMapping("/update")
	public ResponseEntity<CommonMasterDto> updateEmployeeAddress(@Valid @RequestBody CommonMasterDto CommonMasterDto) {
		CommonMasterDto updateCommonMaster = this.commonMasterService.updateCommonMaster(CommonMasterDto);
		return new ResponseEntity<>(updateCommonMaster, HttpStatus.OK);
	}
	
	@GetMapping("/parents")
	public ResponseEntity<Page<CommonMasterDto>> searchCommonMaster(@PageableDefault Pageable pageable,
			@RequestParam(value = "keyword", defaultValue = "", required = false) String keyword) {
		Page<CommonMasterDto> result = this.commonMasterService.searchParentCommonMaster(pageable, keyword);
		return new ResponseEntity<Page<CommonMasterDto>>(result, HttpStatus.OK);
	}
}
