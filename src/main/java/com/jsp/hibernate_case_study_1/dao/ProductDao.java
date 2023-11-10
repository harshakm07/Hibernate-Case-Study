package com.jsp.hibernate_case_study_1.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import com.jsp.hibernate_case_study_1.entity.Product;

public class ProductDao {

	Configuration cfg = new Configuration().configure().addAnnotatedClass(Product.class);
	SessionFactory factory = cfg.buildSessionFactory();

	public String addProduct(Product product) {

		Session session = factory.openSession();
		Transaction transaction = session.beginTransaction();
		session.save(product);
		transaction.commit();
		session.close();

		return "Product successfully added";
	}

	public Product getProductById(int id) {

		Session session = factory.openSession();
		Transaction transaction = session.beginTransaction();
		Product product = session.get(Product.class, id);
		transaction.commit();
		session.close();
		return product;
	}

	public List<Product> getAllProducts() {

		Session session = factory.openSession();
		Transaction transaction = session.beginTransaction();
		Query query = session.createQuery("From  Product");
		List<Product> products = query.getResultList();
		transaction.commit();
		session.close();

		return products;
	}

	public String updateProducts(Product product) {
		Session session = factory.openSession();
		Transaction transaction = session.beginTransaction();
		session.update(product);
		transaction.commit();
		session.close();

		return "Product successfully updated";
	}

	public String deleteProduct(Product product) {
		Session session = factory.openSession();
		Transaction transaction = session.beginTransaction();
		session.delete(product);
		transaction.commit();
		session.close();

		return "Product successfully deleted";
	}


}
