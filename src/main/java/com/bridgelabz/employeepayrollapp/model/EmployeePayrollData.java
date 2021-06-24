package com.bridgelabz.employeepayrollapp.model;

import com.bridgelabz.employeepayrollapp.dto.EmployeePayrollDTO;

public class EmployeePayrollData {
	private int employeeId;
	private String name;
	private long salary;
	public EmployeePayrollData() {
	}
	public EmployeePayrollData(int employeeId, String name, long salary) {
		super();
		this.employeeId = employeeId;
		this.name = name;
		this.salary = salary;
	}
	public EmployeePayrollData(int i, EmployeePayrollDTO employeePayrollDTO) {
		// TODO Auto-generated constructor stub
	}
	public int getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public long getSalary() {
		return salary;
	}
	public void setSalary(long salary) {
		this.salary = salary;
	}
	@Override
	public String toString() {
		return "EmployeePayrollData [employeeId=" + employeeId + ", name=" + name + ", salary=" + salary
				+ ", getEmployeeId()=" + getEmployeeId() + ", getName()=" + getName() + ", getSalary()=" + getSalary()
				+ ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()=" + super.toString()
				+ "]";
	}
	
	
	
	
	
}
