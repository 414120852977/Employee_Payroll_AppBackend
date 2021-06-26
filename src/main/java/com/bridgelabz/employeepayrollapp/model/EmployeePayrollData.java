package com.bridgelabz.employeepayrollapp.model;

import java.time.LocalDate;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

import com.bridgelabz.employeepayrollapp.dto.EmployeePayrollDTO;

import lombok.Data;

public @Data class EmployeePayrollData {

	@GeneratedValue(strategy = GenerationType.AUTO)
	private int employeeId;
	private String name;
	private long salary;
	private String gender;
	public LocalDate startDate;
	public String note;
	public String profilePic;
	public String department;
	public EmployeePayrollData() {
	}
	public EmployeePayrollData(int empId, EmployeePayrollDTO employeePayrollDTO) {
		super();
		this.employeeId = empId;
		this.updateEmployeePayrollData(employeePayrollDTO);
		
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
