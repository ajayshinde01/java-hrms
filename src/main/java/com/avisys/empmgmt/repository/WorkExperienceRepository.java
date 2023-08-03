package com.avisys.empmgmt.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.avisys.empmgmt.entity.Employee;
import com.avisys.empmgmt.entity.WorkExperience;

@Repository
public interface WorkExperienceRepository extends JpaRepository<WorkExperience, Long>{

	List<WorkExperience> findByEmployeeAndIsDeletedFalse(Employee employee);

	Optional<WorkExperience> findByIdAndIsDeletedFalse(Long workExperienceId);
	

}
