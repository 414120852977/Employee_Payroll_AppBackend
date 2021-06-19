package com.bridgelabz.employeepayrollapp.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.bridgelabz.employeepayrollapp.model.EmployeePayrollData;
import com.bridgelabz.employeepayrollappdto.EmployeePayrollDTO;

@Service
public class EmployeePayrollService  implements IEmployeePayrollService{

	private List<EmployeePayrollData> employeePayrollList = new ArrayList<>();
	
	@Override
	public List<EmployeePayrollData> getEmployeePayrollData() {
		
		return employeePayrollList;
	}

	@Override
	public EmployeePayrollData getEmployeePayrollDataById(int empId) {
		return employeePayrollList.get(empId-1);
	}

	@Override
	public EmployeePayrollData createEmployeePayrollData(EmployeePayrollDTO employeePayrollDTO) {
		// TODO Auto-generated method stub
		EmployeePayrollData  employeePayrollData = null;
		employeePayrollData = new EmployeePayrollData(employeePayrollList.size()+1, employeePayrollDTO);
		employeePayrollList.add(employeePayrollData);
		return employeePayrollData;
	}

	@Override
	public EmployeePayrollData updateEmployeePayrollData(int empId, EmployeePayrollDTO employeePayrollDTO) {
		EmployeePayrollData employeePayrollData = this.getEmployeePayrollDataById(empId);
		employeePayrollData.setName(employeePayrollDTO.name);
		employeePayrollData.setSalary(employeePayrollDTO.salary);
		employeePayrollList.set(empId-1,  employeePayrollData);
		return employeePayrollData;
	}

	@Override
	public void deleteEmployeePayrollData(int empId) {
		// TODO Auto-generated method stub
		employeePayrollList.remove(empId-1);
	}

}
