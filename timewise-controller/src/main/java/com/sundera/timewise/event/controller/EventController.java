package com.sundera.timewise.event.controller;

import java.util.UUID;
import java.time.LocalDate;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
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
	public void createEvent(@RequestHeader(value="userId") String userId,@RequestBody String eventJson) {
		Gson gson = GsonFactory.createGson();
		EventDto eventDto = gson.fromJson(eventJson,EventDto.class);
		eventDto.setUserId(userId);
		eventService.addEvent(eventDto);
	}
	
	@GetMapping("/{eventId}")
	public String getProduct(@RequestHeader(value="userId") String userId,@PathVariable String eventId) throws Exception {
		try {
			Gson gson = GsonFactory.createGson();
			return gson.toJson(eventService.getEvent(userId,UUID.fromString(eventId)));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			throw new Exception("Invalid String Id");
		}
	}
	
	@GetMapping("/events/{startDate}/{endDate}")
	public String getEvents(@RequestHeader(value="userId") String userId,@PathVariable String startDate,@PathVariable String endDate) throws Exception{
		Gson gson = GsonFactory.createGson();
		try {
			List<EventViewDto> dtos =  eventService.getAllEvents(userId,gson.fromJson(startDate,LocalDate.class), gson.fromJson(endDate,LocalDate.class));
			return gson.toJson(dtos);
		}catch(Exception e) {
			throw new Exception("Invalid arguments passed in getEvents()");
		}
	}
	
	
}