package com.demo.beans;

public class Product {
	private int pid;
	private String name;
	private String desc;
	private double price;
	
	public Product() {
		super();
	}
	
	public Product(int id,String name,String desc,double price) {
		this.pid=id;
		this.name=name;
		this.desc=desc;
		this.price=price;
		
	}

	public int getPid() {
		return pid;
	}

	public void setPid(int pid) {
		this.pid = pid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "Product [pid=" + pid + ", name=" + name + ", desc=" + desc + ", price=" + price + "]";
	}
	
	
	

}
