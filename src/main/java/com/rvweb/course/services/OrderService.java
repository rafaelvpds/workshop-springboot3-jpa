package com.rvweb.course.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rvweb.course.entities.Order;
import com.rvweb.course.repositories.OrderRepositary;

@Service
public class OrderService {

	@Autowired
	private OrderRepositary orderRepositary;

	public List<Order> findAll() {

		return orderRepositary.findAll();
	}

	public Order findById(Long id) {
		Optional<Order> obj = orderRepositary.findById(id);

		return obj.get();
	}

}
