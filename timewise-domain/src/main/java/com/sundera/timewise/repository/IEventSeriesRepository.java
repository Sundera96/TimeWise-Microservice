package com.sundera.timewise.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sundera.timewise.domain.EventSeries;

@Repository
public interface IEventSeriesRepository extends JpaRepository<EventSeries,UUID> {

}
