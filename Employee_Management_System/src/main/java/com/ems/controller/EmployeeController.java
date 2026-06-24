package com.ems.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.ems.dto.Employee;
import com.ems.dto.EmployeeRequest;
import com.ems.service.EmployeeService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @PostMapping("/employees")
    public Employee addEmployee(@RequestBody EmployeeRequest request) {
        return employeeService.addEmployee(request);
    }

    @GetMapping("/{id}")
    public Employee findEmployeeById(@PathVariable String id) {
        return employeeService.findEmployeeById(id);
    }

    @GetMapping
    public List<Employee> findAllEmployees() {
        return employeeService.findAllEmployees();
    }

    @PutMapping("/{id}")
    public Employee updateEmployee(@PathVariable String id, @RequestBody Employee employee) {
        return employeeService.updateEmployee(id, employee);
    }

    @DeleteMapping("/{id}")
    public Employee deleteEmployee(@PathVariable String id) {
        return employeeService.deleteEmployee(id);
    }
    @GetMapping("/employees/departments/{departmentName}")
    public List<Employee> getByDepartment(@PathVariable String departmentName){
        return employeeService.findEmployeesByDepartment(departmentName);
    }
}