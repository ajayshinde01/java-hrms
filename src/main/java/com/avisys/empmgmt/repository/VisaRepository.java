package com.avisys.empmgmt.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.avisys.empmgmt.entity.Employee;
import com.avisys.empmgmt.entity.Visa;

@Repository
public interface VisaRepository extends JpaRepository<Visa, Long>{

	Optional<Visa> findByVisaNumberAndIsDeletedFalse(String visaNumber);

	List<Visa> findByEmployeeAndIsDeletedFalse(Employee employee);

	Optional<Visa> findByIdAndIsDeletedFalse(Long id);

		
}
