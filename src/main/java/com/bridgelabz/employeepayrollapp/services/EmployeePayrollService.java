package com.bridgelabz.employeepayrollapp.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bridgelabz.employeepayrollapp.dto.EmployeePayrollDTO;
import com.bridgelabz.employeepayrollapp.exceptions.EmployeePayrollException;
import com.bridgelabz.employeepayrollapp.model.EmployeePayrollData;
import com.bridgelabz.employeepayrollapp.repository.EmployeePayrollRepository;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class EmployeePayrollService  implements IEmployeePayrollService{

		@Autowired
		private EmployeePayrollRepository employeeRepository;
	
	
	@Override
	public List<EmployeePayrollData> getEmployeePayrollData() {
		
		return employeeRepository.findAll();
	}

	@Override
	public EmployeePayrollData getEmployeePayrollDataById(int empId) {
		return employeeRepository
				.findById(empId)
				.orElseThrow(() -> new EmployeePayrollException("Employee with empId" + empId + "does not exist.."));
	}

	@Override
	public EmployeePayrollData createEmployeePayrollData(EmployeePayrollDTO employeePayrollDTO) {
		// TODO Auto-generated method stub
		EmployeePayrollData  employeePayrollData = null;
		employeePayrollData = new EmployeePayrollData(employeePayrollDTO);
		log.debug("Emp Data:"+employeePayrollData.toString());
		return employeeRepository.save(employeePayrollData);
	}

	@Override
	public EmployeePayrollData updateEmployeePayrollData(int empId, EmployeePayrollDTO employeePayrollDTO) {
		EmployeePayrollData employeePayrollData = this.getEmployeePayrollDataById(empId);
		employeePayrollData.updateEmployeePayrollData(employeePayrollDTO);
		return employeeRepository.save(employeePayrollData);
	}

	@Override
	public void deleteEmployeePayrollData(int empId) {
		EmployeePayrollData employeePayrollData = this.getEmployeePayrollDataById(empId);
		employeeRepository.delete(employeePayrollData);
	}

}
