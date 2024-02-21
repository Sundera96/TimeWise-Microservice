package com.sundera.timewise.event.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.apache.catalina.connector.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.sundera.timewise.domain.Event;
import com.sundera.timewise.event.dto.EventDto;
import com.sundera.timewise.event_view.dto.EventViewDto;
import com.sundera.timewise.event_view.dto.IEventViewDtoFactory;
import com.sundera.timewise.exceptions.ResourceNotFoundException;
import com.sundera.timewise.export_events.IEventExporter;
import com.sundera.timewise.repository.IEventRepository;

@Service
public class EventService implements IEventService {

	
	@Autowired
	private IEventRepository eventRepo;
	
	@Autowired
	private IEventExporter<EventDto> eventDtoExporter;
	@Autowired
	private IEventExporter<EventViewDto> eventViewDtoExporter;
	
	@Override
	public EventDto getEvent(String userId, UUID eventId) throws ResourceNotFoundException{
		Event event = eventRepo.findByUserIdAndId(userId, eventId);
		if(event==null) {
			throw new ResourceNotFoundException("Event Not Found");
		}
		return event.export(eventDtoExporter);
	}

	@Override
	public List<EventViewDto> getEvents(String userId, LocalDate start, LocalDate end) {
		// TODO Auto-generated method stub
		List<Event> events = eventRepo.findByUserIdAndAssignedDateBetween(userId, start, end);
		List<EventViewDto> eventViewDtos = new ArrayList<>();
		for(Event event:events) {
			eventViewDtos.add(event.export(eventViewDtoExporter));
		}
		return eventViewDtos;
	}

	
}
