package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.Employee;

public interface EmployeeService {
	public List<Employee> employeeList();
	public Employee finrdById(int id);
	public void save(Employee employee);
	public void deleteById(int id);

}
