package com.rvweb.course.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rvweb.course.entities.Category;
import com.rvweb.course.repositories.CategoryRepositary;


@Service
public class CategoryService {
	@Autowired
	private CategoryRepositary categoryRepository;

	public List<Category> findAll() {
		return categoryRepository.findAll();
	}

	public Category findById(Long id) {
		Optional<Category> obj = categoryRepository.findById(id);
		return obj.get();
	}

}
