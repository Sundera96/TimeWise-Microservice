package com.sundera.timewise.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.sundera.timewise.entity.Media;


@Repository
public interface MediaRepository extends JpaRepository<Media,Integer> {
	Media findByUserIdAndName(String userId, String name);
}
