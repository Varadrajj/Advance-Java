package com.demo.service;

import java.util.List;

import com.demo.model.Employee;

public interface EmpService {
	
	public List<Employee> getAll();

	public void addnewemp(Employee e);

	public Employee getById(int empid);

	public void modifyemp(Employee e);

	public void deleteById(int empid);
	
}
