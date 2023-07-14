package com.rvweb.course.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.rvweb.course.entities.User;
import com.rvweb.course.repositories.UserRepository;
import com.rvweb.course.resources.exeptions.DatabaseExeption;
import com.rvweb.course.services.exeptions.ResourceNotFoundException;

import jakarta.persistence.EntityNotFoundException;

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
		return obj.orElseThrow(() -> new ResourceNotFoundException(id));
	}

	public User insert(User obj) {
		return userRepository.save(obj);
	}

	public void delete(Long id) {

		try {

			userRepository.deleteById(id);
		} catch (EmptyResultDataAccessException e) {
			throw new ResourceNotFoundException(id);
		} catch (DataIntegrityViolationException e1) {
			throw new DatabaseExeption(e1.getMessage());
		}
	}

	public User updade(Long id, User obj) {

		try {

			User entity = userRepository.getReferenceById(id);
			updateData(entity, obj);
			return userRepository.save(entity);
		} catch (EntityNotFoundException e) {
			throw new ResourceNotFoundException(id);
		}

	}

	private void updateData(User entity, User obj) {
		entity.setName(obj.getName());
		entity.setEmail(obj.getEmail());
		entity.setPhone(obj.getPhone());

	}

}
