package com.sundera.timewise.repos;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sundera.timewise.entity.User;

public interface UserRepository extends JpaRepository<User, Integer> {
	Optional<User> findByUsername(String username);
} 
