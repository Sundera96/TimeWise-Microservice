package com.sundera.timeswise.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sundera.timeswise.entity.UserCredential;

public interface UserCredentialRepository extends JpaRepository<UserCredential, Long>{
	
}
