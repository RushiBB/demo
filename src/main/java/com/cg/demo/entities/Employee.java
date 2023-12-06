package com.cg.demo.entities;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Employee {

	@Id
	private int empid;
	private String name;
	private String department;
	private LocalDate doj;
	private int salary;
	public Employee() {
		super();
	}
	public Employee(int empid, String name, String department, LocalDate doj, int salary) {
		super();
		this.empid = empid;
		this.name = name;
		this.department = department;
		this.doj = doj;
		this.salary = salary;
	}
	public int getEmpid() {
		return empid;
	}
	public void setEmpid(int empid) {
		this.empid = empid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	public LocalDate getDoj() {
		return doj;
	}
	public void setDoj(LocalDate doj) {
		this.doj = doj;
	}
	public int getSalary() {
		return salary;
	}
	public void setSalary(int salary) {
		this.salary = salary;
	}
	
	
	
}
