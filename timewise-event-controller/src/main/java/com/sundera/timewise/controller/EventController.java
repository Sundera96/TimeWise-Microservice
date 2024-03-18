package com.sundera.timewise.controller;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

import com.sundera.timewise.event_view.dto.EventViewDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.IanaLinkRelations;
import org.springframework.hateoas.Link;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.google.gson.Gson;
import com.sundera.timewise.event.dto.EventDto;
import com.sundera.timewise.event.util.GsonFactory;
import com.sundera.timewise.service.IEventService;

@RestController
@RequestMapping("event/")
public class EventController {
	
	@Autowired
	private IEventService eventService;
	
	@PostMapping
	public void createEvent(@RequestHeader String userId,@RequestBody String eventJson) {
		Gson gson = GsonFactory.createGson();
		EventDto eventDto = gson.fromJson(eventJson,EventDto.class);
		eventDto.setUserId(userId);
		eventService.addEvent(eventDto);
	}
	
	@GetMapping("/{eventId}")
	public ResponseEntity<EventDto> getEvent(@RequestHeader(value="userId") String userId,@PathVariable String eventId) throws Exception {
		try {
			EventDto event = eventService.getEvent(userId,UUID.fromString(eventId));
			StringBuilder str = new StringBuilder("http://localhost:8080/event/");
			event.add(Link.of(str.toString(),"update"));
			str.append(event.getEventId());
			event.add(Link.of(str.toString(),"delete"));
			return ResponseEntity.status(HttpStatus.OK).body(event);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
		}
	}
	
	@GetMapping("/delete/{eventId}")
	public ResponseEntity<String> deleteEvent(@RequestHeader(value="userId") String userId,@PathVariable String eventId) throws Exception {
		try {
			eventService.deleteEvent(userId,UUID.fromString(eventId));
			return ResponseEntity.status(HttpStatus.OK).body("Success!");
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
		}
	}
	
	@GetMapping("/{startDate}/{endDate}")
	public List<EventViewDto> getEvents(@RequestHeader(value="userId") String userId, @PathVariable String startDate, @PathVariable String endDate) throws Exception{
		Gson gson = GsonFactory.createGson();
		try {
			List<EventViewDto> dtos =  eventService.getEvents(userId,gson.fromJson(startDate,LocalDate.class), gson.fromJson(endDate,LocalDate.class));
			StringBuilder str = new StringBuilder("http://localhost:8080/event/");
			for(EventViewDto dto:dtos) {
				str.append(dto.getEventId());
				dto.add(Link.of(str.toString(), IanaLinkRelations.SELF));
				str.delete(0, str.length());
				System.out.println(dto.getLinks());
			}
			return dtos;
		}catch(Exception e) {
			throw new Exception("Invalid arguments passed in getEvents()");
		}
	}
}