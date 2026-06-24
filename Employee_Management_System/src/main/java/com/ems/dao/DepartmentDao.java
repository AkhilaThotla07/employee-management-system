package com.ems.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ems.dto.Department;
import com.ems.repository.DepartmentRepository;

@Repository
public class DepartmentDao {
	@Autowired
	private DepartmentRepository repository;
	public Optional<Department> findDepartmentById(Long id){
		return repository.findById(id);
	}
	public Department addDepartment(Department dept) {
		return repository.save(dept);
	}
	
	public Department updateDepartment(Long id, Department department) {
	    Department existingDepartment = repository.findById(id)
	            .orElseThrow(() -> new RuntimeException("Department not found"));

	    existingDepartment.setDepartmentName(department.getDepartmentName());
	    existingDepartment.setManagerName(department.getManagerName());
	    existingDepartment.setLocation(department.getLocation());

	    return repository.save(existingDepartment);
	}
	public List<Department> findAllDepartments(){
		return repository.findAll();
		
	}
	public void deleteDepartment(Department dept) {
		repository.delete(dept);
	}
	
	public Optional<Department> findByDepartmentName(String departmentName){
	    return repository.findByDepartmentName(departmentName);
	}
	
	
	
	
	
	
	
	

}
