package com.avisys.empmgmt.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.avisys.empmgmt.entity.CommonMaster;

import jakarta.transaction.Transactional;

@Transactional
public interface CommonMastersRepo extends JpaRepository<CommonMaster, Long>{

	Optional<CommonMaster> findByMasterNameAndIsMasterTrueAndIsDeletedFalse(String masterName);

	List<CommonMaster> findByMasterNameAndIsMasterFalseAndIsDeletedFalse(Pageable pageable, String masterName);

	CommonMaster findByCodeAndIsDeletedFalse(String code);

	@Query("SELECT c FROM CommonMaster c WHERE (LOWER(c.masterName) LIKE %:key% OR LOWER(c.code) LIKE %:key% OR LOWER(c.value) LIKE %:key% ) and c.isDeleted=false")
	Page<CommonMaster> searchByCommonMaster(Pageable pageable, String key);

	CommonMaster findByIdAndIsDeletedFalse(Long id);

}
