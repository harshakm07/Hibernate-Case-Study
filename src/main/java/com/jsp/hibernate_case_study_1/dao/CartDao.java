package com.jsp.hibernate_case_study_1.dao;

import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.jsp.hibernate_case_study_1.entity.Cart;
import com.jsp.hibernate_case_study_1.entity.Product;

public class CartDao {

	Scanner s = new Scanner(System.in);
	Configuration cfg = new Configuration().configure().addAnnotatedClass(Cart.class).addAnnotatedClass(Product.class);
	SessionFactory factory = cfg.buildSessionFactory();

	public String addCart(Cart cart) {
		Session session = factory.openSession();
		Transaction transaction = session.beginTransaction();
		session.save(cart);
		transaction.commit();
		session.close();
		return "One cart added.CartId: " + cart.getCartId();
	}

	public String addProductToCart(int cartId, int productId) {
		Session session = factory.openSession();
		Transaction transaction = session.beginTransaction();

		Cart cart = session.find(Cart.class, cartId);
		Product product = session.find(Product.class, productId);

		cart.getListProducts().add(product);

		session.save(cart);
		transaction.commit();
		session.close();

		return "Product added to the Cart";
	}

	public String removeProductFromCart(int cartId, int productId) {

		Session session = factory.openSession();
		Transaction transaction = session.beginTransaction();

		Cart cart = session.find(Cart.class, cartId);
		Product product = session.find(Product.class, productId);

		cart.getListProducts().remove(product);
		session.merge(cart);

		transaction.commit();
		session.close();

		return "Product Removed";

	}
}
