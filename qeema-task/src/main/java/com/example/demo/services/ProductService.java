package com.example.demo.services;

import java.util.List;

import com.example.demo.domain.Product;

public interface ProductService {
	
	public List<Product> findAllProduct();
	
	public Product findProductById(Long id) throws Exception;
	
	public Product saveProduct(Product product);
	
	public void deleteProductById(Long id) throws Exception;
	
	public Product editProduct(Long id,Product product) throws Exception;

}
