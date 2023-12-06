package com.cg.demo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.demo.entities.Employee;
import com.cg.demo.service.EmployeeService;

@RestController
@RequestMapping("employees")
public class Controller {
	@Autowired
	EmployeeService service;
	
	@GetMapping
	public ResponseEntity<?> getALLEmployees() {
		List<Employee> emps = service.getAllEmployees();
		if(emps.isEmpty()) return new ResponseEntity<String>("NO data found", HttpStatus.NOT_FOUND);
		return new ResponseEntity<List<Employee>>(emps, HttpStatus.OK);
	}
	@GetMapping("{id}")
	public ResponseEntity<?> getEmployees(@PathVariable int id) {
		Employee emp= service.getEmployee(id);
		if(emp == null) return new ResponseEntity<String>("NO data found", HttpStatus.NOT_FOUND);
		return new ResponseEntity<Employee>(emp, HttpStatus.OK);
	}
	@PostMapping
	public ResponseEntity<?> addEmployee(@RequestBody Employee e) {
		boolean isSaved = service.addEmployee(e);
		if(isSaved) return new ResponseEntity<String>("successfully saved", HttpStatus.OK);
		return new ResponseEntity<String>("already exists", HttpStatus.CONFLICT);
	}
	@PutMapping
	public ResponseEntity<?> updateEmployee(@RequestBody Employee e) {
		boolean isSaved = service.updateEmployee(e);
		if(isSaved) return new ResponseEntity<String>("successfully saved", HttpStatus.OK);
		return new ResponseEntity<String>("Not found", HttpStatus.CONFLICT);
	}
	@DeleteMapping("{id}")
	public ResponseEntity<?> deleteEmployee(@PathVariable int id) {
		boolean isDeleted = service.deleteEmployee(id);
		if(isDeleted) return new ResponseEntity<String>("successfully deleted", HttpStatus.OK);
		return new ResponseEntity<String>("Not found", HttpStatus.CONFLICT);
	}
}
