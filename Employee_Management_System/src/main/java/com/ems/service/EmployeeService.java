package com.ems.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ems.dao.DepartmentDao;
import com.ems.dao.EmployeeDao;
import com.ems.dto.Department;
import com.ems.dto.Employee;
import com.ems.dto.EmployeeRequest;
import com.ems.exceptions.DepartmentNotFoundException;
import com.ems.exceptions.EmployeeAlreadyExistsException;
import com.ems.exceptions.EmployeeNotFoundException;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeDao employeeDao;
    @Autowired
    private DepartmentDao departmentDao;

    public Employee findEmployeeById(String id) {
        Optional<Employee> employee = employeeDao.findEmployeeById(id);

        if (employee.isPresent()) {
            return employee.get();
        }

        throw new EmployeeNotFoundException("Employee not found");
    }

    
    
    public Employee addEmployee(EmployeeRequest request) {

        Department department = departmentDao.findDepartmentById(request.getDepartmentId())
                .orElseThrow(() -> new DepartmentNotFoundException("Department not found"));

        Employee employee = new Employee();
        employee.setId(request.getId());
        employee.setName(request.getName());
        employee.setEmail(request.getEmail());
        employee.setSalary(request.getSalary());
        employee.setDesignation(request.getDesignation());
        employee.setJoiningDate(request.getJoiningDate());
        employee.setDepartment(department);

        return employeeDao.addEmployee(employee);
    }

    
    
    public List<Employee> findAllEmployees() {
        return employeeDao.findAllEmployees();
    }

    
    
    
    public Employee updateEmployee(String id, Employee employee) {
        Optional<Employee> existingEmployee = employeeDao.findEmployeeById(id);

        if (existingEmployee.isPresent()) {
            return employeeDao.updateEmployee(id, employee);
        }

        throw new EmployeeNotFoundException("Employee not found");
    }

    
    
    public Employee deleteEmployee(String id) {
        Optional<Employee> employee = employeeDao.findEmployeeById(id);

        if (employee.isPresent()) {
            Employee emp = employee.get();
            employeeDao.deleteEmployee(emp);
            return emp;
        }

        throw new EmployeeNotFoundException("Employee not found");
    }
    
    public List<Employee> findEmployeesByDepartment(String departmentName){
        return employeeDao.findByDepartmentName(departmentName);
    }
}
