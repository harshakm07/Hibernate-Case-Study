package com.jsp.hibernate_case_study_1.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Cart {
	@Id
	private int cartId;
	@OneToMany
	private List<Product> listProducts = new ArrayList<Product>();

	public int getCartId() {
		return cartId;
	}

	public void setCartId(int cartId) {
		this.cartId = cartId;
	}

	public List<Product> getListProducts() {
		return listProducts;
	}

	public void setListProducts(List<Product> listProducts) {
		this.listProducts = listProducts;
	}

	@Override
	public String toString() {
		return "Cart [cartId=" + cartId + ", listProducts=" + listProducts + "]";
	}

}
