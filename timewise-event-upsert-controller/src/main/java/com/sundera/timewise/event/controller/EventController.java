package com.sundera.timewise.event.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.google.gson.Gson;
import com.sundera.timewise.event.dto.EventDto;
import com.sundera.timewise.event.service.IEventService;
import com.sundera.timewise.event.util.GsonFactory;


@RestController
@RequestMapping("event/upsert")
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
	
}