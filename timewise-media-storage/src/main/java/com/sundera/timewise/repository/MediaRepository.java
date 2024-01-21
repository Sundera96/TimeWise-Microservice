package com.sundera.timewise.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sundera.timewise.mediadomain.MediaFileDomain;

public interface MediaRepository extends JpaRepository<MediaFileDomain,Long> {
	
}
