package com.employee.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.employee.entity.Department;
import com.employee.repository.DepartmentRepository;

import java.util.List;

@RestController
@RequestMapping("/departments")
public class DepartmentController {

    @Autowired
    private DepartmentRepository departmentRepository;

    // Endpoint to get all departments
    @GetMapping
    public List<Department> getAllDepartments() {
        return departmentRepository.findAll();
    }

    // Endpoint to get a department by ID
    @GetMapping("/{id}")
    public Department getDepartmentById(@PathVariable Long id) {
        return departmentRepository.findById(id).orElse(null);
    }

    // Endpoint to create a new department
    @PostMapping
    public Department createDepartment(@RequestBody Department department) {
        return departmentRepository.save(department);
    }

    // Endpoint to update an existing department
    @PutMapping("/{id}")
    public Department updateDepartment(@PathVariable Long id, @RequestBody Department updatedDepartment) {
        return departmentRepository.findById(id)
            .map(department -> {
                department.setName(updatedDepartment.getName());
                return departmentRepository.save(department);
            })
            .orElseGet(() -> {
                updatedDepartment.setId(id);
                return departmentRepository.save(updatedDepartment);
            });
    }

    // Endpoint to delete a department
    @DeleteMapping("/{id}")
    public void deleteDepartment(@PathVariable Long id) {
        departmentRepository.deleteById(id);
    }
}