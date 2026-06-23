package com.ems.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ems.dao.EmployeeDao;
import com.ems.dto.Employee;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeDao employeeDao;

    public Employee addEmployee(Employee employee) {
        Optional<Employee> existingEmployee = employeeDao.findEmployeeById(employee.getId());

        if (existingEmployee.isPresent()) {
            throw new RuntimeException("Employee already exists");
        }

        return employeeDao.addEmployee(employee);
    }

    public Employee findEmployeeById(String id) {
        Optional<Employee> employee = employeeDao.findEmployeeById(id);

        if (employee.isPresent()) {
            return employee.get();
        }

        throw new RuntimeException("Employee not found");
    }

    public List<Employee> findAllEmployees() {
        return employeeDao.findAllEmployees();
    }

    public Employee updateEmployee(String id, Employee employee) {
        Optional<Employee> existingEmployee = employeeDao.findEmployeeById(id);

        if (existingEmployee.isPresent()) {
            return employeeDao.updateEmployee(id, employee);
        }

        throw new RuntimeException("Employee not found");
    }

    public Employee deleteEmployee(String id) {
        Optional<Employee> employee = employeeDao.findEmployeeById(id);

        if (employee.isPresent()) {
            Employee emp = employee.get();
            employeeDao.deleteEmployee(emp);
            return emp;
        }

        throw new RuntimeException("Employee not found");
    }
}