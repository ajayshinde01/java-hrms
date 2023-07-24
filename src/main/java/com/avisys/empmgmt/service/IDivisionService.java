package com.avisys.empmgmt.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import com.avisys.empmgmt.dto.CreateDivisionDto;
import com.avisys.empmgmt.dto.DivisionDto;
import com.avisys.empmgmt.entity.Division;

public interface IDivisionService {
   List<DivisionDto> getAllDivision();

   String saveDivision(CreateDivisionDto division);

   String deleteDivisionById(String divisionId);

   DivisionDto getDivisionById(String divisionId);

   String updateDivision(DivisionDto division);

   Page<Division> searchDivision(String searchValue,Pageable pageable);
   
   
}
