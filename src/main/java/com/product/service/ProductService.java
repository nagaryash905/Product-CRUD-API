package com.product.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;

import com.product.entity.Product;
import com.product.repository.ProductRepository;

@Service
public class ProductService {
	
	@Autowired
	private ProductRepository repository;
	
	// To save one product details
	public Product addProduct(Product product)
	{
		return repository.save(product);
	}
	
	// To save multiple product details
	public List<Product> saveProducts(List<Product> products)
	{
		return repository.saveAll(products);
	}
	
	// To fetch all the details from database
	public List<Product> getDetails()
	{
		return repository.findAll();
	}
	
	//to fetch the details of product basis on ID
	public Product getDetailById(int id)
	{
		return repository.findById(id).orElse(null);
	}
	
	//to delete the details of the product on the basis on the id
	public String deleteProduct(int id)
	{
		repository.deleteById(id);
		return "Details Provided !!" +id;
	}

	//to update the details of the product on the basis of the id
	public Product updateProduct(Product product)
	{
		Product existingProduct = repository.findById(product.getId()).orElse(null);
		existingProduct.setName(product.getName());
		existingProduct.setAddress(product.getAddress());
		existingProduct.setMobilenumber(product.getMobilenumber());
		return repository.save(existingProduct);
	}
}
