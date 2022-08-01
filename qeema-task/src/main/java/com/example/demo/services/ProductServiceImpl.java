package com.example.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.domain.Product;
import com.example.demo.exceptions.ProductNotFoundException;
import com.example.demo.repositories.ProductRepository;

@Service
public class ProductServiceImpl implements ProductService {
	@Autowired
	private ProductRepository productRepository;

	@Override
	public List<Product> findAllProduct() {
		return productRepository.findAll();
	}

	@Override
	public Product findProductById(Long id) throws Exception {
		return productRepository.findById(id).orElseThrow(()-> new ProductNotFoundException("Product Not Found With Id : "+id));
	}

	@Override
	public Product saveProduct(Product product) {
		return productRepository.save(product);
	}

	@Override
	public void deleteProductById(Long id) throws Exception {
		productRepository.deleteById(this.findProductById(id).getId());
	}

	@Override
	public Product editProduct(Long id,Product product) throws Exception {
		Product oldProduct=this.findProductById(id);
		oldProduct.setName(product.getName());
		oldProduct.setPrice(product.getPrice());
		oldProduct.setDiscription(product.getDiscription());
		return productRepository.save(oldProduct);
	}

}
