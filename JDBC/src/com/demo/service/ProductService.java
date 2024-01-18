package com.demo.service;

import java.util.List;

import com.demo.beans.Product;

public interface ProductService {

	void addNewProduct();

	void closeMyConnection();

	boolean deleteById(int id);

	boolean updateById(int id);

	List<Product> displayAll();

	Product getById(int id);

	List<Product> displaySorted();

}
