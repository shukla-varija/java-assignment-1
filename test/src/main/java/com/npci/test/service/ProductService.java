package com.npci.test.service;

import java.util.List;
import java.util.Map;

import com.npci.test.Product;

public interface ProductService {
	Product addProduct(Product product);

	void deleteProduct(String productId);

	List<Product> getProducts();

	Map<String, Object> generateBills();
}
