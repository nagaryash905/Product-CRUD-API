package com.product.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.product.entity.Product;
import com.product.service.ProductService;

@RestController
public class ProductController {

	@Autowired
	private ProductService service;

	// to save one product details
	@PostMapping("/addProduct")
	public Product addProduct(@RequestBody Product product) {
		return service.addProduct(product);
	}

	// to save one product Multiple Product details
	@PostMapping("/addProducts")
	public List<Product> addProducts(@RequestBody List<Product> products) {
		return service.saveProducts(products);
	}

	// to fetch all the data from the database
	@GetMapping("/Products")
	public List<Product> findAllProducts() {
		return service.getDetails();
	}

	// to fetch all the data from the database based on id
	@GetMapping("/ProductById/{id}")
	public Product findProductById(@PathVariable int id) {
		return service.getDetailById(id);
	}
	
	//to delete the data based on the id
	@DeleteMapping("/deleteById/{id}")
	public String deleteProduct(@PathVariable int id)
	{
		return service.deleteProduct(id);
	}
	
	//to update the details present in the database
	@PutMapping("/update")
	public Product updateProduct(@RequestBody Product product)
	{
		return service.updateProduct(product);
	}

}
