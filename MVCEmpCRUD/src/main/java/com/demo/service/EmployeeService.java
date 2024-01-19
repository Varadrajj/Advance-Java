package com.demo.service;

import java.util.List;

import com.demo.model.Employee;

public interface EmployeeService {

	List<Employee> getEmployees();

	void addemployee(Employee e);

	Employee getById(int eid);

	void modifyEmployee(Employee e);

	void deleteById(int eid);

	

}
