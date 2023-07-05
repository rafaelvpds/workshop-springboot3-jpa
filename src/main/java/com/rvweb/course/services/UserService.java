package com.rvweb.course.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rvweb.course.entities.User;
import com.rvweb.course.repositories.UserRepository;

@Service
public class UserService {
	// para que o spring faça a injeção de dependencia de forma transparente
	@Autowired
	private UserRepository userRepository;

	public List<User> finAll() {

		return userRepository.findAll();

	}

	public User findById(Long id) {
		Optional<User> obj = userRepository.findById(id);
		return obj.get();
	}

}
