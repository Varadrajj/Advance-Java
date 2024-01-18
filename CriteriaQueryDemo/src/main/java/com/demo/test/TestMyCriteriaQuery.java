package com.demo.test;



import java.util.List;

import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.LogicalExpression;
import org.hibernate.criterion.Restrictions;

import com.demo.model.Product;

public class TestMyCriteriaQuery {

	public static void main(String[] args) {
		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		Session session = sf.openSession();
		Transaction tr = session.beginTransaction();
		Criteria cr = session.createCriteria(Product.class);
		List<Product> plist = cr.list();
		plist.forEach(System.out::println);
		System.out.println("*************************************");
//		
//		Criterion pricegt= Restrictions.gt("price", 500.00);
//		Criterion qtylt= Restrictions.lt("qty",10);
//		Criteria cr1=session.createCriteria(Product.class);
//		LogicalExpression expr=Restrictions.and	(pricegt,qtylt);
//		cr1.add(expr);	
//		plist=cr1.list();
//		plist.forEach(System.out::println);
//		System.out.println("*************************************");
//		
//		//To find only first two records:
//		cr.setFirstResult(0);
//		cr.setMaxResults(1);
//		plist = cr.list();
//		plist.forEach(System.out::print);
//		System.out.println("*************************************");
//		
//		//To find from first record
//		cr.setFirstResult(1);
//		cr.setMaxResults(3);
//		plist = cr.list();
//		plist.forEach(System.out::println);
//		System.out.println("*************************************");
		
		//Using JPQL
		CriteriaBuilder cb = session.getCriteriaBuilder();
		CriteriaQuery<Product> cr2 = cb.createQuery(Product.class);
		Root<Product> rt = cr2.from(Product.class);
		Query q = session.createQuery(cr2.select(rt));
		plist = q.getResultList();
		plist.forEach(System.out::println);
	}

}
