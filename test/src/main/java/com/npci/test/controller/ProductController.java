package com.npci.test.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.npci.test.Product;
import com.npci.test.service.ProductService;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/products")
public class ProductController {

	@Autowired
	private ProductService productService;

	@PostMapping("/add")
	public ResponseEntity<String> addProduct(@RequestBody Product product) {
		productService.addProduct(product);
		return ResponseEntity.status(HttpStatus.OK).body("Product added successfully");
	}

	@GetMapping("/findAll")
	public ResponseEntity<List<Product>> findAllProducts() {
		List<Product> products = productService.getProducts();
		return ResponseEntity.status(HttpStatus.OK).body(products);
	}

	@GetMapping("/checkout")
	public ResponseEntity<Map<String, Object>> checkout() {
		Map<String, Object> billDetails = productService.generateBills();
		return ResponseEntity.status(HttpStatus.OK).body(billDetails);
	}
}
