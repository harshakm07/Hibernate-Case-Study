package com.jsp.hibernate_case_study_1;

import java.util.Scanner;

import com.jsp.hibernate_case_study_1.service.CartService;
import com.jsp.hibernate_case_study_1.service.ProductService;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.println(
				"1.addProduct \n 2.getProductById \n 3.getAllProducts \n 4.updateProduct \n 5.deleteProduct \n 6.addCart \n 7.addProductToCart \n 8.removeProductFromCart");

		int choice = input.nextInt();

		ProductService productService = new ProductService();
		CartService cartService = new CartService();
		switch (choice) {
		case 1:
			productService.addProduct();
			break;

		case 2:
			productService.getProductById();
			break;

		case 3:
			productService.getAllProducts();
			break;

		case 4:
			productService.updateProduct();
			break;

		case 5:
			productService.deleteProduct();
			break;

		case 6:
			cartService.addCart();
			break;
		case 7:
			cartService.addProductToCart();
			break;
		case 8:
			cartService.removeProductFromCart();
			break;
		case 0:
			System.out.println("Program Terminated");

		default:
			System.out.println("Invalid Choice");
			break;
		}

	}
}
