package com.cg.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.demo.dao.EmployeeDao;
import com.cg.demo.entities.Employee;

@Service
public class EmployeeServiceImpl implements EmployeeService{
	@Autowired
	EmployeeDao empDao;
	
	@Override
	public boolean addEmployee(Employee e) {
		Optional<Employee> opt =empDao.findById(e.getEmpid());
		if(opt.isPresent()) return false;
		empDao.save(e);
		return true;
	}

	@Override
	public boolean updateEmployee(Employee e) {
		Optional<Employee> opt =empDao.findById(e.getEmpid());
		if(!opt.isPresent()) return false;
		empDao.save(e);
		return true;
	}

	@Override
	public boolean deleteEmployee(int id) {
		Optional<Employee> opt =empDao.findById(id);
		if(!opt.isPresent()) return false;
		empDao.deleteById(id);
		return true;
	}

	@Override
	public Employee getEmployee(int id) {
		Optional<Employee> opt =empDao.findById(id);
		if(!opt.isPresent()) return null;
		return opt.get();
	}

	@Override
	public List<Employee> getAllEmployees() {
		return empDao.findAll();
	}
	
}
