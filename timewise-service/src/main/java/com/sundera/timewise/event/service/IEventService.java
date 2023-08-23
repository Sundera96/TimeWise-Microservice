package com.sundera.timewise.event.service;
import java.util.UUID;

import com.sundera.timewise.event.dto.EventDto;


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
	EventDto getEvent(UUID eventId) throws Exception;

}
