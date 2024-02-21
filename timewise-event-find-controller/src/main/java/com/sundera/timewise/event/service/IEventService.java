package com.sundera.timewise.event.service;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

import com.sundera.timewise.event.dto.EventDto;
import com.sundera.timewise.event_view.dto.EventViewDto;
import com.sundera.timewise.exceptions.ResourceNotFoundException;

public interface IEventService {
	EventDto getEvent(String userId, UUID eventId) throws ResourceNotFoundException;
	List<EventViewDto> getEvents(String userId,LocalDate start, LocalDate end);
}
