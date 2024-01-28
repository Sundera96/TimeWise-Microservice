package com.sundera.timewise.event.service;
import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

import com.sundera.timewise.event.dto.EventDto;
import com.sundera.timewise.event.view.dto.EventViewDto;


public interface IEventService {
	
	
	/**
	 * To add event of any kind to database
	 * @param eventDto
	 */
	void addEvent(EventDto eventDto);
	
	/**
	 * To retrieve event from database
	 * @param eventId
	 * @return
	 * @throws Exception 
	 */
	EventDto getEvent(String userId,UUID eventId) throws Exception;
	
	List<EventViewDto> getAllEvents(String userId,LocalDate startDate,LocalDate LocalDate);

}
