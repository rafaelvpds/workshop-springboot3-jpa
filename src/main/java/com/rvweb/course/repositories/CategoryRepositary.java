package com.rvweb.course.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rvweb.course.entities.Category;

public interface CategoryRepositary extends JpaRepository<Category, Long> {

}
