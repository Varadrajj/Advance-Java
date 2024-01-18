package com.demo.service;

import java.util.List;
import java.util.Scanner;

import com.demo.beans.Product;
import com.demo.dao.ProductDao;
import com.demo.dao.ProductDaoImpl;

public class ProductServiceImpl implements ProductService {
	private ProductDao edao;
	Scanner sc=new Scanner(System.in);
	public ProductServiceImpl() {
		edao= new ProductDaoImpl();
	}

	@Override
	public void addNewProduct() {
		
		System.out.println("Enter Id= ");
		int id=sc.nextInt();
		System.out.println("Enter Name= ");
		String name=sc.next();
		sc.nextLine();
		System.out.println("Enter Description= ");
		String desc=sc.next();
		sc.nextLine();
		System.out.println("Enter Price= ");
		
		double price=sc.nextDouble();
		Product p=new Product(id,name,desc,price);
		edao.save(p);
		
	}

	@Override
	public void closeMyConnection() {
		edao.closeMyConnection();
		
	}

	@Override
	public boolean deleteById(int id) {
		return edao.removeById(id);
	}

	@Override
	public boolean updateById(int id) {
		System.out.println("Enter Name: ");
		String name=sc.next();
		System.out.println("Enter Description: ");
		String desc=sc.next();
		System.out.println("Enter price: ");
		double price=sc.nextDouble();
		Product p=new Product(id,name,desc,price);
		return edao.updateById(p);
	}

	@Override
	public List<Product> displayAll() {
		return edao.getAll();
	}

	@Override
	public Product getById(int id) {
		return edao.getById(id);
	}

	@Override
	public List<Product> displaySorted() {
		return edao.getSorted();
	}

}
