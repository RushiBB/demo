package com.cg.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cg.demo.entities.Employee;

public interface EmployeeDao extends JpaRepository<Employee, Integer>{

}
