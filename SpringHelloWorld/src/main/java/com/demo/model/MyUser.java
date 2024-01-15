package com.demo.model;

public class MyUser {
	private int uid;
	private String uname;
	private int sal;
	public MyUser() {
		super();
		System.out.println("In Default of MyUser");
	}
	public MyUser(int uid, String uname) {
		super();
		this.uid = uid;
		this.uname = uname;
		System.out.println("In Para of MyUser");
	}
	public int getSal() {
		return sal;
	}
	public void setSal(int sal) {
		this.sal = sal;
	}
	public MyUser(int uid, String uname, int sal) {
		super();
		this.uid = uid;
		this.uname = uname;
		this.sal = sal;
	}
	public int getUid() {
		return uid;
	}
	public void setUid(int uid) {
		this.uid = uid;
	}
	public String getUname() {
		return uname;
	}
	public void setUname(String uname) {
		this.uname = uname;
	}
	@Override
	public String toString() {
		return "MyUser [uid=" + uid + ", uname=" + uname + ", sal=" + sal + "]";
	}

	
	

}
