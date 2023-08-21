package com.avisys.empmgmt.service;

import java.time.LocalDateTime;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import com.avisys.empmgmt.dto.CommonMasterDto;
import com.avisys.empmgmt.entity.CommonMaster;
import com.avisys.empmgmt.exception.CommonMasterException;
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
		CommonMaster masters = masterRepository.findByCodeAndIsDeletedFalse(masterDto.getCode());
		if(masters==null) {
		CommonMaster commonMasters=this.modelMapper.map(masterDto, CommonMaster.class);
		commonMasters.setCreatedAt(LocalDateTime.now());
		commonMasters.setCreatedBy(masterDto.getCreatedBy());
		commonMasters.setUpdatedBy(null);
		commonMasters.setDeleted(false);
		
		CommonMaster commonMaster=masterRepository.save(commonMasters);		
		return this.modelMapper.map(commonMaster, CommonMasterDto.class);
		}
		else throw new CommonMasterException("Code should not be Duplicate");	
	}
	
	public Page<CommonMasterDto> getByMasterName(Pageable pageable, String masterName) {
		CommonMaster masters = masterRepository.findByMasterNameAndIsMasterTrueAndIsDeletedFalse(masterName).orElseThrow(()->new CommonMasterException("Master not found"));
		
		Page<CommonMaster> commonMasters=this.masterRepository.findByMasterNameAndIsMasterFalseAndIsDeletedFalse(pageable, masterName);
		Page<CommonMasterDto> commonMasterDto= (Page<CommonMasterDto>) commonMasters.map((master)-> this.modelMapper.map(master,CommonMasterDto.class));
		return commonMasterDto;
	}

	public String deleteCommonMaster(Long id, String updatedBy) {
		CommonMaster commonMaster=this.masterRepository.findByIdAndIsDeletedFalse(id);
		if(commonMaster!=null) {
		commonMaster.setDeleted(true);
		commonMaster.setUpdatedAt(LocalDateTime.now());
		commonMaster.setUpdatedBy(updatedBy);
		masterRepository.save(commonMaster);
		
		return "Common master deleted successfully";
	}
		else throw new CommonMasterException("common master code does not exist");
	
	}
	
	public CommonMasterDto updateCommonMaster( CommonMasterDto commonMasterDto) {
		CommonMaster commonMaster=masterRepository.findByIdAndIsDeletedFalse(commonMasterDto.getId());
   
		if(commonMaster!=null) { 
	       CommonMaster master= modelMapper.map(commonMasterDto, CommonMaster.class);
      
	       master.setUpdatedAt(LocalDateTime.now());
	       master.setUpdatedBy(commonMasterDto.getUpdatedBy());
	       master.setCreatedBy(commonMaster.getCreatedBy());
	       master.setCreatedAt(commonMaster.getCreatedAt());
	       master.setDeleted(false);

	        CommonMaster commonMasters = masterRepository.save(master);
	 
	    return  this.modelMapper.map(commonMasters, CommonMasterDto.class);
	    } else throw new CommonMasterException("Common Master Id doesn't exist for update");
	}
	
	public Page<CommonMasterDto> searchParentCommonMaster(Pageable pageable, String keyword){
			keyword = keyword.toLowerCase();
		Page<CommonMaster> commonMaster = masterRepository.searchByCommonMaster(pageable,keyword);
		Page<CommonMasterDto> commonMasterDto = (Page<CommonMasterDto>) commonMaster .map((master) -> this.modelMapper.map(master, CommonMasterDto.class));
		
			return commonMasterDto;
	}
}
