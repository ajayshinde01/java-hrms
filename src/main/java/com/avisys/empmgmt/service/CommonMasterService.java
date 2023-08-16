package com.avisys.empmgmt.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.avisys.empmgmt.dto.CommonMasterDto;
import com.avisys.empmgmt.dto.DepartmentDto;
import com.avisys.empmgmt.entity.CommonMaster;
import com.avisys.empmgmt.entity.Department;
import com.avisys.empmgmt.repository.CommonMastersRepo;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;

@Service
@Transactional
public class CommonMasterService {
	
	@Autowired
	private ModelMapper modelMapper;
	
	@Autowired
	private CommonMastersRepo masterRepository;
	
	public CommonMasterDto createCommonMaster(@Valid CommonMasterDto masterDto) {
		CommonMaster commonMasters=this.modelMapper.map(masterDto, CommonMaster.class);
		commonMasters.setCreatedAt(LocalDateTime.now());
		commonMasters.setCreatedBy(masterDto.getCreatedBy());
		commonMasters.setUpdatedBy(null);
		commonMasters.setDeleted(false);
		
	CommonMaster commonMaster=masterRepository.save(commonMasters);		
		return this.modelMapper.map(commonMaster, CommonMasterDto.class);
		
	}
	
	public List<CommonMasterDto> getAllCommonMaters() {
		List<CommonMaster> commonMaters = this.masterRepository.findByIsDeletedFalse();
		List<CommonMasterDto> commonMaterDto = commonMaters.stream()
				.map((masters) -> this.modelMapper.map(masters, CommonMasterDto.class))
				.collect(Collectors.toList());
			return commonMaterDto;
	}
	
}
