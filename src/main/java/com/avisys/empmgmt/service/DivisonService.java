package com.avisys.empmgmt.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.avisys.empmgmt.dto.CreateDivisionDto;
import com.avisys.empmgmt.dto.DivisionDto;
import com.avisys.empmgmt.entity.Division;
import com.avisys.empmgmt.exception.DivisionNotFound;
import com.avisys.empmgmt.repository.DivisonRepository;
import com.avisys.empmgmt.util.Utils;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class DivisonService implements IDivisonService {

	@Autowired
	private DivisonRepository divisonRepository;

	@Autowired
	private Utils util;

	@Override
	public List<DivisionDto> getAllDivison() {
		List<Division> divisions = divisonRepository.findByIsDeletedFalse().get();
		if (divisions.isEmpty()) {
			throw new DivisionNotFound("Divisions Not Found");
		} else {
			return util.getAllDivisionsDto(divisions);
		}
	}

	@Override
	public String saveDivision(CreateDivisionDto divisionDto) {
		if (divisonRepository.findByDivisionId(divisionDto.getDivisionId()).isPresent()) {
			throw new DivisionNotFound("Division already exist");
		} else {
			Division division = new Division(divisionDto.getDivisionId(), divisionDto.getDivisionName(),
					divisionDto.getDivisionDescription(), divisionDto.getOrgCode(), false, LocalDateTime.now(),
					LocalDateTime.now(), divisionDto.getCreatedBy(), divisionDto.getUpdatedBy());
			divisonRepository.save(division);
			return "Division added successfully.";
		}
	}

	@Override
	public String deleteDivisionById(String divisionId) {

		Division division = divisonRepository.findByDivisionIdAndIsDeletedFalse(divisionId)
				.orElseThrow(() -> new DivisionNotFound("Division Does Not Exist"));
		division.setDeleted(true);
		divisonRepository.save(division);
		return "Division deleted successfully";
	}

	@Override
	public DivisionDto getDivisionById(String divisionId) {

		Division division = divisonRepository.findByDivisionIdAndIsDeletedFalse(divisionId)
				.orElseThrow(() -> new DivisionNotFound("Division Not Found"));
		DivisionDto divisionDto = util.getDivisionDto(division);
		return divisionDto;
	}

	@Override
	public String updateDivision(DivisionDto updatedDivisionDto) {
		Division division = divisonRepository.findById(updatedDivisionDto.getId())
				.orElseThrow(() -> new DivisionNotFound("Division Not Found"));
		if (division.isDeleted() == true) {
			throw new DivisionNotFound("Division Does Not Exist");
		} else {
			Optional<Division> divisionByDivisionId = divisonRepository
					.findByDivisionId(updatedDivisionDto.getDivisionId());
			if (divisionByDivisionId.isEmpty() || updatedDivisionDto.getId().equals(division.getId())
					&& updatedDivisionDto.getDivisionId().equals(division.getDivisionId())) {
				updatedDivisionDto.setUpdatedAt(LocalDateTime.now());
				Division updatedDivision = util.getDivision(updatedDivisionDto);
				divisonRepository.save(updatedDivision);
				return "Division is updated";
			} else {
				throw new DivisionNotFound("DivisionId already Exist");
			}
		}
	}

	@Override
	public Page<Division> searchDivision(String searchValue, Pageable pageable) {
		Page<Division> divisions = divisonRepository.searchDivision(searchValue, pageable)
				.orElseThrow(() -> new DivisionNotFound("Division Not Found"));
		if (divisions.isEmpty()) {
			throw new DivisionNotFound("No Entry Found");
		} else {
			return divisions;
		}
	}

}
