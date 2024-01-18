package com.demo.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.demo.model.Product;

public class TestAnnotationProduct {

	public static void main(String[] args) {
		Product p1 = new Product("Chair", 35, 2550);
		Product p2 = new Product("Table", 40, 5600);
		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		Session session = sf.openSession();
		Transaction tr = session.beginTransaction();
		session.save(p1);
		session.save(p2);
		tr.commit();
		session.close();
		sf.close();
	}

}
