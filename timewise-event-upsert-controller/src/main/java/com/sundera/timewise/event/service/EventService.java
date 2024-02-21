package com.sundera.timewise.event.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sundera.timewise.domain.Event;
import com.sundera.timewise.domain.EventSeries;
import com.sundera.timewise.domain.IEventSeriesFactory;
import com.sundera.timewise.event.dto.EventDto;
import com.sundera.timewise.import_events.IEventImporter;
import com.sundera.timewise.repository.IEventRepository;
import com.sundera.timewise.repository.IEventSeriesRepository;

import jakarta.transaction.Transactional;

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
	

	@Transactional
	@Override
	public void addEvent(EventDto eventDto) {
		List<Event> events = eventDto.eventImporter(eventImporter);
		EventSeries eventSeries = eventSeriesFactory.createEventSeries();
		for(Event event:events) {
			event.setSeries(eventSeries);
		}
		eventSeries.setEvents(events);
		eventRepository.saveAll(events);
		eventSeriesRepository.save(eventSeries);
	}

}
