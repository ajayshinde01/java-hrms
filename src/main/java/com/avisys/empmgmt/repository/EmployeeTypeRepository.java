package com.avisys.empmgmt.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.avisys.empmgmt.entity.EmployeeType;

@Repository
public interface EmployeeTypeRepository extends JpaRepository<EmployeeType, Long> {

	Optional<EmployeeType> findByIdAndDeleted(Long id, boolean deleted);

	Optional<EmployeeType> getByIdAndDeleted(Long id, boolean deleted);

	Page<EmployeeType> findAllByDeleted(Pageable pageable, boolean deleted);

	Page<EmployeeType> findByTypeIsContainingAndDeleted(String type, Pageable pageable, boolean deleted);

	List<EmployeeType> findAllByDeleted(boolean deleted);
}
