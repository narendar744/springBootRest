package com.example.demo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="employee")
public class Employee {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	@Column(name="first_name")
	private String firstname;
	@Column(name="last_name")
	private String lasstName;
	@Column(name="email")
	private String emial;
	public Employee() {}
	public Employee(String firstname, String lasstName, String emial) {
		super();
		this.firstname = firstname;
		this.lasstName = lasstName;
		this.emial = emial;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getLasstName() {
		return lasstName;
	}
	public void setLasstName(String lasstName) {
		this.lasstName = lasstName;
	}
	public String getEmial() {
		return emial;
	}
	public void setEmial(String emial) {
		this.emial = emial;
	}
	@Override
	public String toString() {
		return "Employee [id=" + id + ", firstname=" + firstname + ", lasstName=" + lasstName + ", emial=" + emial
				+ "]";
	}
	

}
