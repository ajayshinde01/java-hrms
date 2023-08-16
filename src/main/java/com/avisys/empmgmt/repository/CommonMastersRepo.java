package com.avisys.empmgmt.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.avisys.empmgmt.entity.CommonMaster;

import jakarta.transaction.Transactional;

@Transactional
public interface CommonMastersRepo extends JpaRepository<CommonMaster, Long>{

	List<CommonMaster> findByIsDeletedFalse();

}
