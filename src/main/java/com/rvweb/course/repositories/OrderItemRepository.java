package com.rvweb.course.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rvweb.course.entities.OrderItem;

public interface OrderItemRepository extends JpaRepository<OrderItem, Long> {

//Spring Data JPA ja tem uma implementação padrao para essa interface
}
