package com.jsp.hibernate_case_study_1.service;

import java.util.Scanner;

import com.jsp.hibernate_case_study_1.dao.CartDao;
import com.jsp.hibernate_case_study_1.entity.Cart;

public class CartService {

	Scanner s = new Scanner(System.in);
	CartDao cartdao = new CartDao();

	public void addCart() {
		System.out.println("Enter Cart ID");
		int id = s.nextInt();

		Cart cart = new Cart();
		cart.setCartId(id);

		String message = cartdao.addCart(cart);
		System.out.println(message);
	}

	public void addProductToCart() {
		System.out.println("Enter cartId for product insertion");
		int cartId = s.nextInt();
		
		System.out.println("Enter productId to be inserted into the cart");
		int productId = s.nextInt();
		
		String message = cartdao.addProductToCart(cartId, productId);
		System.out.println(message);
	}
	public void removeProductFromCart() {
		System.out.println("Enter cartId for product removal");
		int cartId = s.nextInt();
		
		System.out.println("Enter produtId for product removal");
		int productId = s.nextInt();
		
		String message = cartdao.removeProductFromCart(cartId, productId);
		System.out.println(message);
	}
}
