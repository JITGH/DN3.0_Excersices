package com.employee.repository;

import org.springframework.data.domain.Pageable;

import java.util.List;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.data.repository.query.Param;

import com.employee.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
	 // Execute named query to find an employee by email
    List<Employee> findByEmail(@Param("email") String email);

    // Execute named query to find employees by department name
    List<Employee> findAllByDepartmentName(@Param("departmentName") String departmentName);

    
    Page<Employee> findAll(Pageable pageable);
    List<Employee> findAll(Sort sort);
}
