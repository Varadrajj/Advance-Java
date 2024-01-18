package com.demo.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.demo.model.Product;

public class TestProduct {

	public static void main(String[] args) {
		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		Session session = sf.openSession();
		Transaction tr = session.beginTransaction();
		Product p1 = new Product(1, "Bread", 10, 520);
		Product p2 = new Product(2, "Jam", 5, 250);
		Product p3 = new Product(3, "Jim-Jam", 11, 110);
		Product p4 = new Product(4, "Donut", 15, 650);
		session.save(p1);
		session.save(p2);
		session.save(p3);
		session.save(p4);
		tr.commit();
		session.close();
		sf.close();
	}

}
