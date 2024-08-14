package com.employee.controller;

import com.employee.projection.DepartmentNameDTO;
import com.employee.repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/departments")
public class DepartmentController {

    @Autowired
    private DepartmentRepository departmentRepository;

    // Get department names using class-based projection
    @GetMapping("/names")
    public ResponseEntity<List<DepartmentNameDTO>> getDepartmentNames() {
        List<DepartmentNameDTO> departmentNames = departmentRepository.findDepartmentNames();
        return ResponseEntity.ok(departmentNames);
    }
}
