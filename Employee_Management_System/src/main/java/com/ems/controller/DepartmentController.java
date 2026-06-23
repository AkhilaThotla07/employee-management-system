package com.ems.controller;


import com.ems.dto.Department;
import com.ems.service.DepartmentService;

import jakarta.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/departments")
public class DepartmentController {

    @Autowired
    private DepartmentService departmentService;

    // Add Department
    @PostMapping
    public Department addDepartment(@Valid @RequestBody Department department) {
        return departmentService.addDepartment(department);
    }

    // Get All Departments
    @GetMapping
    public List<Department> findAllDepartments() {
        return departmentService.findAllDepartments();
    }

    // Get Department By ID
    @GetMapping("/{id}")
    public Department findDepartmentById(@PathVariable Long id) {
        return departmentService.findDepartmentById(id);
    }

    // Update Department
    @PutMapping("/{id}")
    public Department updateDepartment(@PathVariable Long id,@RequestBody Department department) {
        return departmentService.updateDepartment(id, department);
    }

    // Delete Department
    @DeleteMapping("/{id}")
    public String deleteDepartment(@PathVariable Long id) {
        departmentService.deleteDepartment(id);
        return "Department deleted successfully";
    }
}
