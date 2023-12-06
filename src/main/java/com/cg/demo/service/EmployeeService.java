package com.cg.demo.service;

import java.util.List;

import com.cg.demo.entities.Employee;

public interface EmployeeService {
	boolean addEmployee(Employee e);
	boolean updateEmployee(Employee e);
	boolean deleteEmployee(int id);
	Employee getEmployee(int id);
	List<Employee> getAllEmployees();
}
