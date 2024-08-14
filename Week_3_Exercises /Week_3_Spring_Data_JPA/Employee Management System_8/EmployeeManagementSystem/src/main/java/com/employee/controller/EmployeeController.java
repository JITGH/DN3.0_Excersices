package com.employee.controller;

import com.employee.projection.EmployeeNameDTO;
import com.employee.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/employees")
public class EmployeeController {

    @Autowired
    private EmployeeRepository employeeRepository;

    // Get employees by department ID using interface-based projection
    @GetMapping("/department/{departmentId}/names")
    public ResponseEntity<List<EmployeeNameDTO>> getEmployeeNamesByDepartment(@PathVariable Long departmentId) {
        List<EmployeeNameDTO> employeeNames = employeeRepository.findByDepartmentId(departmentId);
        return ResponseEntity.ok(employeeNames);
    }
}
