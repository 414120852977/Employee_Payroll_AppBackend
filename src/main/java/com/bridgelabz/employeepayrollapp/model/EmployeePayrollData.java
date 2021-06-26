package com.bridgelabz.employeepayrollapp.model;

import java.time.LocalDate;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Table;

import com.bridgelabz.employeepayrollapp.dto.EmployeePayrollDTO;

import lombok.Data;
@Entity
@Table(name = "employee_payroll")
public @Data class EmployeePayrollData {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int employeeId;
	@Column(name = "name")
	private String name;
	private long salary;
	private String gender;
	public LocalDate startDate;
	public String note;
	public String profilePic;
	
	//@ElementCollection
	@CollectionTable(name = "employee_department", joinColumns = @JoinColumn(name = "id"))
	@Column(name = "department")
	public String department;
	public EmployeePayrollData() {
	}
	public EmployeePayrollData(int empId, EmployeePayrollDTO employeePayrollDTO) {
		super();
		this.employeeId = empId;
		this.updateEmployeePayrollData(employeePayrollDTO);
		
	}
	
	public EmployeePayrollData(EmployeePayrollDTO employeePayrollDTO) {
		// TODO Auto-generated constructor stub
	}
	public void updateEmployeePayrollData(EmployeePayrollDTO employeePayrollDTO) {
		this.name = employeePayrollDTO.name;
		this.salary = employeePayrollDTO.salary;
		this.gender = employeePayrollDTO.gender;
		this.startDate = employeePayrollDTO.startDate;
		this.note = employeePayrollDTO.note;
		this.profilePic = employeePayrollDTO.profilePic;
		this.department = employeePayrollDTO.department;
	}
	
	
	
	
	
	
	
}
