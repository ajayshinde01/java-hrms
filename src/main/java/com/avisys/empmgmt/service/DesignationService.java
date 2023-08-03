package com.avisys.empmgmt.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.avisys.empmgmt.dto.CreateDesignationDto;
import com.avisys.empmgmt.dto.DesignationDto;
import com.avisys.empmgmt.entity.Designation;
import com.avisys.empmgmt.exception.DesignationNotFound;
import com.avisys.empmgmt.repository.DesignationRepo;
import com.avisys.empmgmt.util.Utils;

@Service
@Transactional
public class DesignationService implements IDesignationService {

	@Autowired
	private DesignationRepo designationRepo;

	@Autowired
	private Utils designationUtils;


	@Override
	public List<DesignationDto> getAllDesignation() {
		List<Designation> designationList = designationRepo.findByIsDeletedFalse()
				.orElseThrow(() -> new DesignationNotFound("Designation List is Empty"));
		List<DesignationDto> designationDtoList = designationList.stream()
				.map(d -> designationUtils.designationToDesignationDto(d)).collect(Collectors.toList());
		if (designationDtoList.isEmpty())
			throw new DesignationNotFound();
		return designationDtoList;
	}


	@Override
	public DesignationDto createDesignation(CreateDesignationDto designationDto) {	
		if(designationRepo.findByDesignationId(designationDto.getDesignationId()).isPresent()) {
			throw new DesignationNotFound("Designation Id already present");
		}else {
		Designation designationToCreate=new Designation(designationDto.getDesignationId().toUpperCase(), designationDto.getDesignationName(), designationDto.getDesignationDesc(), designationDto.getOrgCode(), false, LocalDateTime.now(), LocalDateTime.now(), designationDto.getCreatedBy(),null);
		Designation designationCreated= designationRepo.save(designationToCreate);	
		return designationUtils.designationToDesignationDto(designationCreated);
			}
		}


	@Override
	public DesignationDto getDesignationById(String designationId) {
		Designation designation = designationRepo.findByDesignationIdAndIsDeletedFalse(designationId.toUpperCase())
				.orElseThrow(() -> new DesignationNotFound("Designation Not found for id " + designationId));
		return designationUtils.designationToDesignationDto(designation);
	}


	@Override
	public DesignationDto updateDesignation(DesignationDto designationDto) {
		Designation designationToUpdate = designationRepo.findById(designationDto.getId())
				.orElseThrow(() -> new DesignationNotFound("Designation Not found to update"));
		
		if (designationToUpdate.isDeleted())
			throw new DesignationNotFound("This Designation is deleted, can't be update!");
		
		else {
            Optional<Designation> designation= designationRepo.findByDesignationId(designationDto.getDesignationId());
        if(designation.isEmpty()|| designationDto.getId().equals(designationToUpdate.getId())&&designationToUpdate.getDesignationId().equals(designationDto.getDesignationId()))
        {	
		designationDto.setUpdatedAt(LocalDateTime.now());
		Designation designationUpdated = designationRepo.save(new Designation(designationDto.getId(),
				designationDto.getDesignationId().toUpperCase(), designationDto.getDesignationName(),
				designationDto.getDesignationDesc(), designationDto.getOrgCode(), false, designationDto.getCreatedAt(),
				LocalDateTime.now(), designationDto.getCreatedBy(), designationDto.getUpdatedBy()));
		return new DesignationDto(designationUpdated.getId(), designationUpdated.getDesignationId(),
				designationUpdated.getDesignationName(), designationUpdated.getDesignationDesc(),
				designationUpdated.getOrgCode(), designationUpdated.isDeleted(), designationUpdated.getCreatedAt(),
				designationUpdated.getUpdatedAt(), designationUpdated.getCreatedBy(),
				designationUpdated.getUpdatedBy());
        }else {
            throw new DesignationNotFound("Designation Id already Exist");
            }
		}
	}


	@Override
	public String deleteDesignationById(String designationId) {
		Designation designationToDelete = designationRepo
				.findByDesignationIdAndIsDeletedFalse(designationId.toUpperCase())
				.orElseThrow(() -> new DesignationNotFound("Designation Not found to delete with id " + designationId));
		designationToDelete.setDeleted(true);
		designationRepo.save(designationToDelete);
		return "Designation Deleted";
	}


	@Override
	public Page<DesignationDto> searchDesignation(String designationKey, Pageable pageable) {
		Page<Designation> designationPage = designationRepo.searchDesignation(designationKey.toLowerCase(), pageable)
				.orElseThrow(() -> new DesignationNotFound("Designation Not found for key"));
		Page<DesignationDto> designationDtoPage = designationPage
				.map((d) -> designationUtils.designationToDesignationDto(d));
		if (designationDtoPage.isEmpty())
			throw new DesignationNotFound("Designation Not found for key");
		return designationDtoPage;
	}

}
