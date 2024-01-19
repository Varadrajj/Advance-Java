package com.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.dao.EmployeeDao;
import com.demo.model.Employee;

@Service
public class EmployeeServiceImpl implements EmployeeService {
	@Autowired
	private EmployeeDao edao;

	@Override
	public List<Employee> getEmployees() {
		return edao.displayAllEmployees();
	}

	@Override
	public void addemployee(Employee e) {
		edao.insertEmployee(e);
		
	}

	@Override
	public Employee getById(int eid) {
		return edao.getById(eid);
	}

	@Override
	public void modifyEmployee(Employee e) {
		edao.updateEmployee(e);
		
	}

	@Override
	public void deleteById(int eid) {
		edao.deleteById(eid);
		
	}

	
		
}
