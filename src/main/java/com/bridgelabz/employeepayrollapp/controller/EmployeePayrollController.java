package com.bridgelabz.employeepayrollapp.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bridgelabz.employeepayrollapp.dto.EmployeePayrollDTO;
import com.bridgelabz.employeepayrollapp.dto.ResponseDTO;
import com.bridgelabz.employeepayrollapp.model.EmployeePayrollData;
import com.bridgelabz.employeepayrollapp.services.IEmployeePayrollService;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/employeepayrollservice")
@Slf4j
public class EmployeePayrollController {
	
	@Autowired
	private IEmployeePayrollService employeePayrollService;
	@RequestMapping(value = {"","/", "/get"})
	public ResponseEntity<ResponseDTO> getEmployeeData() {
//		return new ResponseEntity<String>("Get  Success", HttpStatus.OK);
	List<EmployeePayrollData> empDataList = null;
	empDataList = employeePayrollService.getEmployeePayrollData();
	ResponseDTO resDTO = new ResponseDTO("Get Call Success",empDataList );
	
	return new ResponseEntity<ResponseDTO>(resDTO, HttpStatus.OK);
	}
	
	@GetMapping("/get/{empId}")
	public ResponseEntity<ResponseDTO> getEmployeePayrollData(@PathVariable("empId") int empId) {
		
		EmployeePayrollData employeePayrollData = employeePayrollService.getEmployeePayrollDataById(empId);
		ResponseDTO resDTO = new ResponseDTO("Get Call for id successfull",employeePayrollData );
		return new ResponseEntity<ResponseDTO>(resDTO, HttpStatus.OK);
	}
	
	@GetMapping("/department/{department}")
public ResponseEntity<ResponseDTO> getEmployeePayrollData(@PathVariable("department") String department) {
		List<EmployeePayrollData> empDataList = null;
		empDataList = employeePayrollService.findEmployeesByDepartment(department);
		ResponseDTO resDTO = new ResponseDTO("Get Call for department successfull",empDataList );
		return new ResponseEntity<ResponseDTO>(resDTO, HttpStatus.OK);
	}
	
	
	@PostMapping("/create")
	public ResponseEntity<ResponseDTO> addEmployeePayrollData(
								@Valid @RequestBody EmployeePayrollDTO empPayrollDTO ) {
		log.debug("Employee DTO:"+empPayrollDTO.toString());
		EmployeePayrollData employeePayrollData = employeePayrollService.createEmployeePayrollData(empPayrollDTO);
		ResponseDTO resDTO = new ResponseDTO("created Employee Payroll Data  Successfully",employeePayrollData );
		return new ResponseEntity<ResponseDTO>(resDTO, HttpStatus.OK);
	}
	
	@PutMapping("/update/{empId}")
	public ResponseEntity<ResponseDTO> updateEmployeePayrollData(
			@PathVariable("empId") int empId,
			@RequestBody EmployeePayrollDTO empPayrollDTO ) {
		EmployeePayrollData employeePayrollData = employeePayrollService.updateEmployeePayrollData(empId, empPayrollDTO);
		ResponseDTO resDTO = new ResponseDTO("updated Employee Payroll Data  Successfully",employeePayrollData );
		return new ResponseEntity<ResponseDTO>(resDTO, HttpStatus.OK);
} 
	@DeleteMapping("/delete/{empId}")
	public ResponseEntity<ResponseDTO> deleteEmployeePayrollData(
			@PathVariable("empId") int empId) {
		employeePayrollService.deleteEmployeePayrollData(empId);
		ResponseDTO resDTO = new ResponseDTO("deleted  Successfully","Deleted Id:" +empId );
		return new ResponseEntity<ResponseDTO>(resDTO, HttpStatus.OK);
			
}  
	
	
}
