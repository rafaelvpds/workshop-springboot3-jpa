package com.rvweb.course.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rvweb.course.entities.User;

public interface UserRepository extends JpaRepository<User, Long> {

//Spring Data JPA ja tem uma implementação padrao para essa interface
}
