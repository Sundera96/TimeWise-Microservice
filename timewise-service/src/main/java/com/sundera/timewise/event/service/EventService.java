package com.sundera.timewise.event.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sundera.timewise.domain.Event;
import com.sundera.timewise.domain.EventSeries;
import com.sundera.timewise.domain.IEventExporter;
import com.sundera.timewise.domain.IEventSeriesFactory;
import com.sundera.timewise.event.dto.EventDto;
import com.sundera.timewise.event.dto.IEventImporter;
import com.sundera.timewise.event.view.dto.EventViewDto;
import com.sundera.timewise.repository.IEventRepository;
import com.sundera.timewise.repository.IEventSeriesRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class EventService implements IEventService {
	
	@Autowired
	private IEventRepository eventRepository;
	
	@Autowired
	private IEventSeriesRepository eventSeriesRepository;
	
	@Autowired
	private IEventSeriesFactory eventSeriesFactory;
	
	@Autowired
	private IEventExporter<EventDto> eventExporter;
	
	@Autowired
	private IEventExporter<EventViewDto> eventViewExporter;
	
	@Autowired
	private IEventImporter<Event> eventImporter;
	

	@Override
	public void addEvent(EventDto eventDto) {
		List<Event> events = eventDto.eventImporter(eventImporter);
		EventSeries eventSeries = eventSeriesFactory.createEventSeries();
		for(Event event:events) {
			event.setSeries(eventSeries);
			eventRepository.save(event);
		}
		eventSeries.setEvents(events);
		eventSeriesRepository.save(eventSeries);
	}

	@Override
	public EventDto getEvent(String userId,UUID eventId) throws Exception {
		System.out.println("User Id : "+ userId);
		System.out.println("Event Id : "+ eventId);
		Optional<Event> optionalEvent = eventRepository.findById(eventId);
		if(optionalEvent==null) {
			throw new Exception("Event of the id does not exist");
		}
		return optionalEvent.get().export(eventExporter);
	}

	@Override
	public List<EventViewDto> getAllEvents(String userId, LocalDate startDate, LocalDate endDate) {
		List<EventViewDto> listOfEventViewDto = new ArrayList<>();
		List<Event> listOfEvents = eventRepository.findByUserIdAndAssignedDateBetween(userId,startDate,endDate);
		for(Event event:listOfEvents) {
			listOfEventViewDto.add(event.export(eventViewExporter));
		}
		return listOfEventViewDto;
	}
}
