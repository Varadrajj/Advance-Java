package com.demo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.demo.model.Employee;
import com.mysql.cj.protocol.Resultset;

public class EmpDaoImpl implements EmpDao{
	static Connection conn;
	static PreparedStatement selemp,insemp,selbyid,upbyid,delbyid;
	static {
		conn = DBUtil.getMyConnection();
		try {
			selemp = conn.prepareStatement("Select * from employee1");
			insemp = conn.prepareStatement("insert into employee1 values(?,?,?)");
			selbyid = conn.prepareStatement("select * from employee1 where Id = ?");
			upbyid = conn.prepareStatement("update employee1 set Ename=?, Salary=? where Id=?");
			delbyid=conn.prepareStatement("delete from employee1 where Id=?");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public List<Employee> getAll(){
		List<Employee> elist = new ArrayList<>();
		try {
			ResultSet rs = selemp.executeQuery();
			while(rs.next()) {
				Employee e = new Employee(rs.getInt(1), rs.getString(2), rs.getDouble(3));
				elist.add(e);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return elist;
	}

	@Override
	public void insertNew(Employee e) {
		try {
			insemp.setInt(1, e.getEmpid());
			insemp.setString(2, e.getEname());
			insemp.setDouble(3, e.getSal());
			insemp.executeUpdate();
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		
	}

	@Override
	public Employee findById(int empid) {
		try {
			selbyid.setInt(1, empid);
			ResultSet rs = selbyid.executeQuery();
			if(rs.next()) {
				return new Employee(rs.getInt(1), rs.getString(2), rs.getDouble(3));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public void updateById(Employee e) {
		try {
			upbyid.setString(1, e.getEname());
			upbyid.setDouble(2, e.getSal());
			upbyid.setInt(3,  e.getEmpid());
			upbyid.executeUpdate();
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		
	}

	@Override
	public void removeById(int empid) {
		try {
			delbyid.setInt(1, empid);
			delbyid.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
}
