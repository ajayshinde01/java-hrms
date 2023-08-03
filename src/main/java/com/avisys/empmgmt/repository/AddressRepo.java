package com.avisys.empmgmt.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.avisys.empmgmt.entity.Address;
import com.avisys.empmgmt.entity.Employee;

@Repository
public interface AddressRepo extends JpaRepository<Address, Long>{


	Optional<Address> findByEmployeeId(Long employeeId);

	Optional<Address> findByIdAndIsDeletedFalse(Long addressId);

	List<Address> findByEmployeeAndIsDeletedFalse(Employee employee);

	List<Address> findByaddressTypeAndIsDeletedFalse(String addressType);

	List<Address> findByEmployee(Employee employee);

}
