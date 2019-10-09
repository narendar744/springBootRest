package com.example.demo.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.example.demo.entity.Employee;

@Repository
public class EmployeeDaoJpaImpl implements EmployeeDao{
	
	private EntityManager entityManager;
	public EmployeeDaoJpaImpl(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	@Override
	public List<Employee> employeeList() {

		Query theQuery=entityManager.createQuery("from Employee", Employee.class);
		List<Employee> employees=theQuery.getResultList();		
		return employees;
	}

	@Override
	public Employee finrdById(int id) {
		Employee employee= entityManager.find(Employee.class, id);
		if(employee==null) {
			throw new RuntimeException("NO employee found with id of "+id);
		}
		return employee;
	}

	@Override
	public void save(Employee employee) {
	Employee theEmployee = entityManager.merge(employee);
	employee.setId(theEmployee.getId());
		
	}

	@Override
	public void deleteById(int id) {
		Query theQuery=entityManager.createQuery("delete from Employee where id=:employeeId");
		theQuery.setParameter("employeeId",id);
		theQuery.executeUpdate();
		
	}

}
