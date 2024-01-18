package com.demo.model;

public class Employee {
	private int id;
	private String ename;
	private String city;
	public Employee() {
		super();
	}
	public Employee(int id, String ename, String city) {
		super();
		this.id = id;
		this.ename = ename;
		this.city = city;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getEname() {
		return ename;
	}
	public void setEname(String ename) {
		this.ename = ename;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	@Override
	public String toString() {
		return "Employee [id=" + id + ", ename=" + ename + ", city=" + city + "]";
	}
	
	

}
