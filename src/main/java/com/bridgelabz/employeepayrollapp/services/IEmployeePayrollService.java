package com.bridgelabz.employeepayrollapp.services;

import java.util.List;

import com.bridgelabz.employeepayrollapp.model.EmployeePayrollData;
import com.bridgelabz.employeepayrollappdto.EmployeePayrollDTO;

public interface IEmployeePayrollService {
	
	List<EmployeePayrollData> getEmployeePayrollData();
	
	EmployeePayrollData getEmployeePayrollDataById(int empId);
	
	EmployeePayrollData createEmployeePayrollData(EmployeePayrollDTO 
			
			employeePayrollDTO);
	
EmployeePayrollData updateEmployeePayrollData( int empId, EmployeePayrollDTO 
			
			employeePayrollDTO);

void deleteEmployeePayrollData(int empId);

}
