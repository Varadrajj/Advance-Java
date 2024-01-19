package com.demo.dao;

import java.util.List;

import com.demo.model.Employee;

public interface EmployeeDao {

	List<Employee> displayAllEmployees();

	void insertEmployee(Employee e);

	Employee getById(int eid);

	void updateEmployee(Employee e);

	void deleteById(int eid);

	

}
