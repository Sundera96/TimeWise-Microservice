package com.sundera.timewise.event.controller;

import java.util.UUID;
import java.time.LocalDate;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.google.gson.Gson;
import com.sundera.timewise.event.dto.EventDto;
import com.sundera.timewise.event.service.IEventService;
import com.sundera.timewise.event.util.GsonFactory;
import com.sundera.timewise.event.view.dto.EventViewDto;


@RestController
@RequestMapping("api/event")
public class EventController {
	
	@Autowired
	private IEventService eventService;
	
	@PostMapping
	public void createEvent(@RequestBody String eventJson) {
		Gson gson = GsonFactory.createGson();
		EventDto eventDto = gson.fromJson(eventJson,EventDto.class);
		eventService.addEvent(eventDto);
	}
	
	@GetMapping("/{userId}/{eventId}")
	public EventDto getProduct(@PathVariable String eventId, @PathVariable String userId) throws Exception {
		try {
			return eventService.getEvent(UUID.fromString(eventId),UUID.fromString(userId));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			throw new Exception("Invalid String Id");
		}
	}
	
	@GetMapping("{userId}/events/{startDate}/{endDate}")
	public List<EventViewDto> getEvents(@PathVariable String userId,@PathVariable String startDate,@PathVariable String endDate,List<String> filter) throws Exception{
		Gson gson = GsonFactory.createGson();
		try {
			return eventService.getAllEvents(UUID.fromString(userId),gson.fromJson(startDate,LocalDate.class), gson.fromJson(startDate,LocalDate.class));
		}catch(Exception e) {
			throw new Exception("Invalid arguments passed in getEvents()");
		}
	}
	
	
}