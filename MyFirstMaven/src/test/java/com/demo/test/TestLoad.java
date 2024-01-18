package com.demo.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.demo.model.Product;

public class TestLoad {

	public static void main(String[] args) {
		SessionFactory sf= new Configuration().configure().buildSessionFactory();
		Session session= sf.openSession();
		Transaction tr=session.beginTransaction();
		Product p1=session.load(Product.class, 1);
		System.out.println("Before");
		System.out.println(p1.getPname());
		System.out.println("After");

	}

}
