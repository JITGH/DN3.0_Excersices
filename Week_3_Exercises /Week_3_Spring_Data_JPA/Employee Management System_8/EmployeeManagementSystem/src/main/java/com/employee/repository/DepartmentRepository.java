package com.employee.repository;



import com.employee.projection.DepartmentNameDTO;
import com.employee.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, Long> {

	// Ensure the fully qualified class name matches the actual package
    @Query("SELECT new com.employee.projection.DepartmentNameDTO(d.name) FROM Department d")
    List<DepartmentNameDTO> findDepartmentNames();
}
