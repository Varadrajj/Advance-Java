package com.demo.dao;

import java.util.List;

import com.demo.beans.Product;

public interface ProductDao {

	void save(Product p);

	void closeMyConnection();

	boolean removeById(int id);

	boolean updateById(Product p);

	List<Product> getAll();

	Product getById(int id);

	List<Product> getSorted();

}
