package com.rvweb.course.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rvweb.course.entities.Order;

public interface OrderRepositary extends JpaRepository<Order, Long> {

}
