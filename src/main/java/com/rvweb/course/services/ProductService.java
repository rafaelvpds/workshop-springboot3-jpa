package com.rvweb.course.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rvweb.course.entities.Product;
import com.rvweb.course.repositories.ProductRepositary;

@Service
public class ProductService {

	@Autowired
	private ProductRepositary productRepository;

	public List<Product> findAll() {
		return productRepository.findAll();
	}

	public Product findById(Long id) {
		Optional<Product> obj = productRepository.findById(id);

		return obj.get();
	}

}
