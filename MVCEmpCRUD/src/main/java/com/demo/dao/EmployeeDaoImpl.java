package com.demo.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.demo.model.Employee;

@Repository
public class EmployeeDaoImpl implements EmployeeDao {
	@Autowired 
	private JdbcTemplate jdTemplate;

	@Override
	public List<Employee> displayAllEmployees() {
		return jdTemplate.query("select * from employee",(rs,num)->{
			Employee e=new Employee();
			e.setEid(rs.getInt(1));
			e.setEname(rs.getString(2));
			e.setSal(rs.getDouble(3));
			e.setDept(rs.getString(4));
			return e;
		});
	}

	@Override
	public void insertEmployee(Employee e) {
		String str="insert into employee values(?,?,?,?)";
		jdTemplate.update(str,new Object[] {e.getEid(),e.getEname(),e.getSal(),e.getDept()});
		
	}

	@Override
	public Employee getById(int eid) {
		try {
			return jdTemplate.queryForObject("select * from employee where eid=?",new Object[] {eid},BeanPropertyRowMapper.newInstance(Employee.class));
		}catch(EmptyResultDataAccessException e) {
			return null;
		}
	}

	@Override
	public void updateEmployee(Employee e) {
		jdTemplate.update("update employee set ename=?, sal=?, dept=? where eid=?",new Object[] {e.getEname(),e.getSal(),e.getDept(),e.getEid()});
		
	}

	@Override
	public void deleteById(int eid) {
		jdTemplate.update("delete from employee where eid=?",new Object[] {eid});
		
	}


}
