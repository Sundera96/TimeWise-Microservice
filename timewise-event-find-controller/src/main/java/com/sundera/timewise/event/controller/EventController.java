package com.sundera.timewise.event.controller;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;
import com.sundera.timewise.event.dto.EventDto;
import com.sundera.timewise.event.service.IEventService;
import com.sundera.timewise.event.util.GsonFactory;
import com.sundera.timewise.event_view.dto.EventViewDto;

@RestController
@RequestMapping("event/get")
public class EventController {
	
	@Autowired
	private IEventService eventService;
	
	@GetMapping("/{eventId}")
	public ResponseEntity<EventDto> getEvent(@RequestHeader(value="userId") String userId,@PathVariable String eventId) throws Exception {
		try {
			EventDto event = eventService.getEvent(userId,UUID.fromString(eventId));
			return ResponseEntity.status(HttpStatus.OK).body(event);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
		}
	}
	
	@GetMapping("/events/{startDate}/{endDate}")
	public String getEvents(@RequestHeader(value="userId") String userId,@PathVariable String startDate,@PathVariable String endDate) throws Exception{
		Gson gson = GsonFactory.createGson();
		try {
			List<EventViewDto> dtos =  eventService.getEvents(userId,gson.fromJson(startDate,LocalDate.class), gson.fromJson(endDate,LocalDate.class));
			return gson.toJson(dtos);
		}catch(Exception e) {
			throw new Exception("Invalid arguments passed in getEvents()");
		}
	}
}
