package com.demo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.demo.beans.Product;

public class ProductDaoImpl implements ProductDao {
	static Connection conn;
	static PreparedStatement insprod, delbyid,upById,displayAll,selById, getSorted;
	static {
		try {
			conn=DBUtil.getMyConnection();
			insprod=conn.prepareStatement("insert into product1 values(?,?,?,?)");
			delbyid = conn.prepareStatement("delete from product1 where Id = ?");
			upById=conn.prepareStatement("update product1 set Title=?, Description=?,Price=? where Id=?");
			displayAll = conn.prepareStatement("select * from product1");
			selById=conn.prepareStatement("select * from product1 where Id=?");
			getSorted = conn.prepareStatement("select * from product1 order by Price");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	

	@Override
	public void save(Product p) {
		try {
			insprod.setInt(1, p.getPid());
			insprod.setString(2, p.getName());
			insprod.setString(3, p.getDesc());
			insprod.setDouble(4, p.getPrice());
			int n=insprod.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}


	@Override
	public void closeMyConnection() {
		DBUtil.closeMyConnection();
		
	}


	@Override
	public boolean removeById(int id) {
		try {
			delbyid.setInt(1, id);
			int n = delbyid.executeUpdate();
			if(n > 0) {
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}


	@Override
	public boolean updateById(Product p) {
		try {
			upById.setString(1, p.getName());
			upById.setString(2, p.getDesc());
			upById.setDouble(3, p.getPrice());
			upById.setInt(4, p.getPid());
			int n=upById.executeUpdate();
			if(n>0) {
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
		
	}


	@Override
	public List<Product> getAll() {
		List<Product> elist = new ArrayList<>();
		try {
			ResultSet rs =  displayAll.executeQuery();
			while(rs.next()) {
				elist.add(new Product(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getDouble(4)));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return elist;
	}


	@Override
	public Product getById(int id) {
		try {
			selById.setInt(1, id);
			ResultSet rs=selById.executeQuery();
			while(rs.next()) {
				Product p=new Product(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getDouble(4));
				return p;
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
		
	}


	@Override
	public List<Product> getSorted() {
		List<Product> elist = new ArrayList<>();
		try {
			ResultSet rs =  getSorted.executeQuery();
			while(rs.next()) {
				elist.add(new Product(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getDouble(4)));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return elist;
	}

}
