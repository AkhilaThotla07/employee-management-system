package com.ems.dto;

import java.time.LocalDate;


import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

@Entity
@Table(name="employees")
public class Employee {
		@Id
	    @NotBlank(message = "Employee ID cannot be empty")
	    private String id;

	    @NotBlank(message = "Employee name cannot be empty")
	    private String name;

	    @Email(message = "Enter a valid email")
	    @NotBlank(message = "Email cannot be empty")
	    private String email;

	    @NotNull(message = "Salary cannot be null")
	    @Positive(message = "Salary must be greater than 0")
	    private Double salary;

	    @NotBlank(message = "Designation cannot be empty")
	    private String designation;

	    @NotNull(message = "Joining date cannot be empty")
	    private LocalDate joiningDate;

	    @ManyToOne
	    @JoinColumn(name="department_id")
	    @JsonBackReference
	    @NotNull(message = "Department must be assigned")
	    private Department department;

	
	
	public Employee() {
		super();
	}

	public Employee(String id, String name, String email, Double salary, String designation, LocalDate joiningDate,
			Department department) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.salary = salary;
		this.designation = designation;
		this.joiningDate = joiningDate;
		this.department = department;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Double getSalary() {
		return salary;
	}

	public void setSalary(Double salary) {
		this.salary = salary;
	}

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	public LocalDate getJoiningDate() {
		return joiningDate;
	}

	public void setJoiningDate(LocalDate joiningDate) {
		this.joiningDate = joiningDate;
	}

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}
	

}
