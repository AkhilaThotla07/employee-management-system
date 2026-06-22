package com.ems.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ems.dao.DepartmentDao;
import com.ems.dto.Department;
@Service
public class DepartmentService {
	@Autowired
	private DepartmentDao dao;
	
	public Department findDepartmentById(Long id) {
		Optional<Department> department=dao.findDepartmentById(id);
		if(department.isPresent()) {
			return department.get();
		}
		throw new RuntimeException("Department not found");
	}
	
//	public Department addDepartment(Department department) {
//		Optional<Department> dept=dao.findDepartmentById(department.getId());
//			if(dept.isPresent()) {
//				throw new RuntimeException("Department already exists");
//				
//			} 
//			return dao.addDepartment(department);
//	}
//	
	// if id is auto generated
	public Department addDepartment(Department department) {
	    department.setId(null);
	    return dao.addDepartment(department);
	}
	
	public Department updateDepartment(Long id, Department department) {
	    Optional<Department> dept = dao.findDepartmentById(id);
	    if(dept.isPresent()) {
	        department.setId(id);
	        return dao.updateDepartment(id, department);
	    }
	    throw new RuntimeException("Department not found");
	}
	
	public Department deleteDepartment(Long id) {
		Optional<Department> dept1=dao.findDepartmentById(id);
		if(dept1.isPresent()) {
			Department dept2=dept1.get();
			dao.deleteDepartment(dept2);
			return dept2;
		}
		throw new RuntimeException("Department not found");
	}
	
	public List<Department> findAllDepartments(){
		return dao.findAllDepartments();
	}
	
	
	
	
	

}
