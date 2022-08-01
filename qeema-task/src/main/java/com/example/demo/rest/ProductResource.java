package com.example.demo.rest;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.example.demo.domain.Product;
import com.example.demo.exceptions.BadRequestException;
import com.example.demo.services.ProductServiceImpl;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("api/v1.0.0/products")
@Slf4j
public class ProductResource {

	@Autowired
	private ProductServiceImpl productServiceImpl;
	@GetMapping("/")
	public ResponseEntity<List<Product>> findAllProducts(Authentication authentication){
		 log.debug("REST request to get all Products ");
		return new ResponseEntity<List<Product>>(productServiceImpl.findAllProduct(),HttpStatus.OK);
	}
	@PostMapping("/")
	public ResponseEntity<Product> saveProduct(@Valid @RequestBody Product product) throws BadRequestException{
		log.debug("REST request to save product  ",product);
		if(product.getId() != null) {
			 throw new BadRequestException("A new Product cannot already have an ID");
		}
		return new ResponseEntity<Product>(productServiceImpl.saveProduct(product),HttpStatus.CREATED);
	}
	@GetMapping("/{id}")
	public ResponseEntity<Product> findProductById(@PathVariable Long id) throws Exception{
		log.debug("REST request to find product by ID ",id);
		return new ResponseEntity<Product>(productServiceImpl.findProductById(id),HttpStatus.OK);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteProduct(@PathVariable("id") Long id) throws Exception{
		log.debug("REST request to delete product by ID ",id);
		productServiceImpl.deleteProductById(id);
		return new ResponseEntity<String>("This Product Has Been Deleted",HttpStatus.OK);
	}
	@PutMapping("/{id}")
	public ResponseEntity<Product> editProduct(@PathVariable("id") Long id,@RequestBody Product product) throws Exception{
		log.debug("REST request to update product by ID ",id);
		return new ResponseEntity<Product>(productServiceImpl.editProduct(id, product),HttpStatus.OK);
	}
}
