package com.bridgelabz.employeepayrollapp.controller;

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

import com.bridgelabz.employeepayrollapp.model.EmployeePayrollData;
import com.bridgelabz.employeepayrollappdto.EmployeePayrollDTO;
import com.bridgelabz.employeepayrollappdto.ResponseDTO;

@RestController
@RequestMapping("/employeepayrollservice")
public class EmployeePayrollController {
	
	@RequestMapping(value = {"","/", "/get"})
	public ResponseEntity<ResponseDTO> getEmployeeData() {
//		return new ResponseEntity<String>("Get  Success", HttpStatus.OK);
	EmployeePayrollData employeePayrollData = null;
	employeePayrollData = new EmployeePayrollData(1, new EmployeePayrollDTO("Pankaj",3000));
	ResponseDTO resDTO = new ResponseDTO("Get Call Success",employeePayrollData );
	return new ResponseEntity<ResponseDTO>(resDTO, HttpStatus.OK);
	}
	
	@GetMapping("/get/{empId}")
	public ResponseEntity<ResponseDTO> getEmployeePayrollData(@PathVariable("empId") int empId) {
		EmployeePayrollData employeePayrollData = null;
		employeePayrollData = new EmployeePayrollData(1, new EmployeePayrollDTO("Pankaj",3000));
		ResponseDTO resDTO = new ResponseDTO("Get Call for id successfull",employeePayrollData );
		return new ResponseEntity<ResponseDTO>(resDTO, HttpStatus.OK);
	}
	
	@PostMapping("/create")
	public ResponseEntity<ResponseDTO> addEmployeePayrollData(
								@RequestBody EmployeePayrollDTO empPayrollDTO ) {
		EmployeePayrollData employeePayrollData = null;
		employeePayrollData = new EmployeePayrollData(1,  empPayrollDTO);
		ResponseDTO resDTO = new ResponseDTO("created Employee Payroll Data  Successfully",employeePayrollData );
		return new ResponseEntity<ResponseDTO>(resDTO, HttpStatus.OK);
	}
	
	@PutMapping("/update/{empId}")
	public ResponseEntity<ResponseDTO> updateEmployeePayrollData(
			@PathVariable("empId") int empId,
			@RequestBody EmployeePayrollDTO empPayrollDTO ) {
		EmployeePayrollData employeePayrollData = null;
		employeePayrollData = new EmployeePayrollData(1,  empPayrollDTO);
		ResponseDTO resDTO = new ResponseDTO("updated Employee Payroll Data  Successfully",employeePayrollData );
		return new ResponseEntity<ResponseDTO>(resDTO, HttpStatus.OK);
} 
	@DeleteMapping("/delete/{empId}")
	public ResponseEntity<ResponseDTO> deleteEmployeePayrollData(
			@PathVariable("empId") int empId) {
		
		ResponseDTO resDTO = new ResponseDTO("deleted  Successfully","Deleted Id:" +empId );
		return new ResponseEntity<ResponseDTO>(resDTO, HttpStatus.OK);
			
}  
	
}
