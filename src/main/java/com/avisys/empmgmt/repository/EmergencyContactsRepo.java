package com.avisys.empmgmt.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import com.avisys.empmgmt.entity.EmergencyContacts;
import com.avisys.empmgmt.entity.Employee;

	public interface EmergencyContactsRepo extends JpaRepository<EmergencyContacts, Long>  {

		List<EmergencyContacts> findByEmployeeAndIsDeletedFalse(Employee employee);

		Optional<EmergencyContacts> findByIdAndIsDeletedFalse(Long emergencyContactsId);

		Optional<EmergencyContacts> findByEmergencyContactNumberAndIsDeletedFalse(String emergencyContactNumber);

		List<EmergencyContacts> findByEmployee(Employee employee);
	
}
