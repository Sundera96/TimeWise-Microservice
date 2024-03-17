package com.sundera.timewise.service;


import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.sundera.timewise.domain.Event;
import com.sundera.timewise.domain.EventSeries;
import com.sundera.timewise.domain.IEventSeriesFactory;
import com.sundera.timewise.event.dto.EventDto;
import com.sundera.timewise.event_view.dto.EventViewDto;
import com.sundera.timewise.exceptions.ResourceNotFoundException;
import com.sundera.timewise.export_events.IEventExporter;
import com.sundera.timewise.import_events.IEventImporter;
import com.sundera.timewise.repository.IEventRepository;
import com.sundera.timewise.repository.IEventSeriesRepository;

@Service
public class EventService implements IEventService{
	

	@Autowired
	private IEventRepository eventRepository;
	
	@Autowired
	private IEventSeriesRepository eventSeriesRepository;
	
	@Autowired
	private IEventSeriesFactory eventSeriesFactory;
	
	@Autowired
	private IEventImporter<Event> eventImporter;
	
	@Autowired
	private IEventExporter<EventDto> eventExporter;
	
	@Autowired
	private IEventExporter<EventViewDto> eventViewExporter;

	@Override
	public void addEvent(EventDto eventDto) {
		List<Event> events = eventDto.eventImporter(eventImporter);
		EventSeries eventSeries = eventSeriesFactory.createEventSeries();
		for(Event event:events) {
			event.setSeries(eventSeries);
		}
		eventSeries.setEvents(events);
		eventSeriesRepository.save(eventSeries);
		eventRepository.saveAll(events);
	}


	@Override
	public EventDto getEvent(String userId, UUID eventId) throws ResourceNotFoundException {
		System.out.println("Sunderaaaa");
		Event event = eventRepository.findEvent(userId, eventId);
		if(event==null) {
			throw new ResourceNotFoundException("Event Not Found");
		}
		System.out.println(event);
		return event.export(eventExporter);
	}
	
	@Override
	public void deleteEvent(String userId, UUID eventId) throws ResourceNotFoundException {
		Event event = eventRepository.findEvent(userId, eventId);
		if(event==null) {
			throw new ResourceNotFoundException("Event Not Found");
		}
		event.setDeletedDateTime(LocalDateTime.now());
		eventRepository.save(event);
	}


	@Override
	public List<EventViewDto> getEvents(String userId, LocalDate start, LocalDate end) {
		List<Event> events = eventRepository.findEventsBetweenDates(userId, start.atStartOfDay(), end.plusDays(1).atStartOfDay());
		List<EventViewDto> eventViewDtos = new ArrayList<>();
		for(Event event:events) {
			eventViewDtos.add(event.export(eventViewExporter));
		}
		return eventViewDtos;
	}
	

}