package com.sundera.timewise.repository;


import java.util.UUID;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sundera.timewise.domain.Event;

@Repository
public interface IEventRepository extends JpaRepository<Event,UUID> {
	List<Event> findByUserId(UUID userId);
}
