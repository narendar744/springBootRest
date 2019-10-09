package com.example.demo;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Employee;
import com.example.demo.service.EmployeeService;

@RestController
@RequestMapping("/api")
public class EmployeeController {
	private EmployeeService service;
	public EmployeeController(EmployeeService service) {
		this.service = service;
	}
	@GetMapping("/employees")
	public List<Employee> getEmployees(){
		return service.employeeList();	
	}
	@GetMapping("/employees/{employeeId}")
	public Employee getEmployee(@PathVariable("employeeId")int id) {
		Employee employee = service.finrdById(id);
		if(employee==null) {
			 throw new RuntimeException("employee not found");
		}
	return employee;
	}
	@PostMapping("/employees")
	public Employee addEmployee(@RequestBody Employee thEmployee) {
		thEmployee.setId(0);
		service.save(thEmployee);
		return thEmployee;	
	}
	@PutMapping("/employees")
	public Employee updateEmployee(@RequestBody Employee thEmployee) {
		service.save(thEmployee);
		return thEmployee;
		
	}
	@DeleteMapping("/employees/{employeeId}")
	public String deleteEmployee(@PathVariable("employeeId") int theId) {
		Employee employee=service.finrdById(theId);
		if(employee==null) {
			throw new RuntimeException("employee not exist with the id of "+theId);
		}
		service.deleteById(theId);
		return "employee deleted with id of "+theId;
	}

}
