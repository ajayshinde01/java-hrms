package com.avisys.empmgmt.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.avisys.empmgmt.entity.Grade;

@Repository
public interface GradeRepository extends JpaRepository<Grade, Long> {
	Optional<Grade> findByGradeId(String gradeId);

	Optional<Grade> findByGradeIdAndIsDeletedFalse(String gradeId);

	Optional<List<Grade>> findByIsDeletedFalse();

	@Query("SELECT g FROM Grade g WHERE g.isDeleted = false AND"
			+ "LOWER(g.gradeId) LIKE %:searchTerm% OR LOWER(g.gradeName) LIKE %:searchTerm% "
			+ "OR LOWER(g.gradeType) LIKE %:searchTerm% OR LOWER(g.orgCode) LIKE %:searchTerm%)")
	Page<Grade> getGradeWithPagingAndSearch(Pageable pageable, String searchTerm);
}
