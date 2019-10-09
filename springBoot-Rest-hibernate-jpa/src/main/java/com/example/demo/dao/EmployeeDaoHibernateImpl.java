package com.example.demo.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Employee;

@Repository
public class EmployeeDaoHibernateImpl implements EmployeeDao{
	private EntityManager  entityManager;
	
@Autowired
	public EmployeeDaoHibernateImpl(EntityManager entityManager) {
		this.entityManager = entityManager;
	}


	@Override
	public List<Employee> employeeList() {
		Session session=entityManager.unwrap(Session.class);
		Query theQuery= session.createQuery("from Employee", Employee.class);
		List employees = theQuery.getResultList();
		return employees;
	}


	@Override
	public Employee finrdById(int id) {
		Session session=entityManager.unwrap(Session.class);
		Employee employee=session.get(Employee.class, id);
		return employee;
	}


	@Override
	public void save(Employee employee) {
		Session session=entityManager.unwrap(Session.class);
		session.saveOrUpdate(employee);
		
	}


	@Override
	public void deleteById(int id) {
		Session session=entityManager.unwrap(Session.class);
		Query theQuery= session.createQuery("delete from Employee where id=:employeeId");
		theQuery.setParameter("employeeId", id);
		theQuery.executeUpdate();
		
	}

}
