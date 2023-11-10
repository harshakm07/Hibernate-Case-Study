package com.jsp.hibernate_case_study_1.service;

import java.util.List;
import java.util.Scanner;

import com.jsp.hibernate_case_study_1.dao.ProductDao;
import com.jsp.hibernate_case_study_1.entity.Product;

public class ProductService {

	ProductDao productdao = new ProductDao();
	Scanner input = new Scanner(System.in);

	public void addProduct() {
		System.out.println("Enter product Id: ");
		int id = input.nextInt();

		System.out.print("Enter product Name: ");
		String name = input.next();

		System.out.print("Enter product Price: ");
		double price = input.nextDouble();

		System.out.print("Enter product Quantity: ");
		int quantity = input.nextInt();

		Product product = new Product();
		product.setProductId(id);
		product.setProductName(name);
		product.setProductPrice(price);
		product.setProductQuantity(quantity);

		String message = productdao.addProduct(product);
		System.out.println(message);

	}

	public void getProductById() {
		System.out.println("Enter the product Id: ");
		int i = input.nextInt();

		Product product = productdao.getProductById(i);
		if (product != null) {
			System.out.println(
					product.getProductName() + "," + product.getProductPrice() + "," + product.getProductQuantity());
		} else {
			System.out.println("Invalid product Id");
		}
	}

	public void getAllProducts() {
		List<Product> products = productdao.getAllProducts();
		for (Product product : products) {
			System.out.println(
					product.getProductName() + "," + product.getProductPrice() + "," + product.getProductQuantity());
		}

	}

	public void updateProduct() {
		System.out.println("Enter the product Id to update: ");
		int id = input.nextInt();

		Product product = productdao.getProductById(id);
		if (product != null) {
			System.out.println(
					product.getProductName() + "," + product.getProductPrice() + "," + product.getProductQuantity());

			System.out.print("Enter product Name: ");
			String name = input.next();

			System.out.print("Enter product Price: ");
			double price = input.nextDouble();

			System.out.print("Enter product Quantity: ");
			int quantity = input.nextInt();

			product.setProductName(name);
			product.setProductPrice(price);
			product.setProductQuantity(quantity);

			String message = productdao.addProduct(product);
			System.out.println(message);
		} else {
			System.out.println("Product is not present");
		}
	}

	public void deleteProduct() {

		System.out.println("Enter the product to be deleted");
		int id = input.nextInt();
		Product product = productdao.getProductById(id);

		Product product1 = new Product();
		if (product != null) {
			String message = productdao.deleteProduct(product);
			System.out.println(message);
		} else {
			System.out.println("Product Id is not present");
		}

	}
}
