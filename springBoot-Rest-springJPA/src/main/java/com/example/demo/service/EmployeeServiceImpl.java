package com.example.demo.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.EmployeeRepository;
import com.example.demo.entity.Employee;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	private EmployeeRepository repository;
	
	@Autowired
	public EmployeeServiceImpl(EmployeeRepository repository) {
		this.repository = repository;
	}

	
	@Override
	public List<Employee> employeeList() {

		return repository.findAll();
	}

	@Override
	public Employee finrdById(int id) {
		return repository.findById(id).get();
	}

	@Override
	public void save(Employee employee) {
		repository.save(employee);

	}

	@Override
	@Transactional
	public void deleteById(int id) {
		repository.deleteById(id);

	}




}
