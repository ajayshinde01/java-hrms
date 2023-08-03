package com.avisys.empmgmt.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.avisys.empmgmt.entity.EducationalQualification;
import com.avisys.empmgmt.entity.Employee;

@Repository
public interface EducationalQualificationRepo extends JpaRepository<EducationalQualification, Long> {

	List<EducationalQualification> findByEmployeeAndIsDeletedFalse(Employee employee);

	Optional<EducationalQualification> findByIdAndIsDeletedFalse(Long id);

	List<EducationalQualification> findByEmployee(Employee employee);
	
}
