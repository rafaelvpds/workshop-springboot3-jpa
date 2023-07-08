package com.rvweb.course.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rvweb.course.entities.Product;

public interface ProductRepositary extends JpaRepository<Product, Long> {

}
