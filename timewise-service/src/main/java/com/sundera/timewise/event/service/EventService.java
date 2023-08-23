package com.sundera.timewise.event.service;

import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.sundera.timewise.domain.Event;
import com.sundera.timewise.domain.IEventFactory;
import com.sundera.timewise.domain.JournalEvent;
import com.sundera.timewise.domain.MeetingEvent;
import com.sundera.timewise.domain.ReminderEvent;
import com.sundera.timewise.domain.TaskEvent;
import com.sundera.timewise.event.dto.EventDto;
import com.sundera.timewise.event.dto.IEventDtoFactory;
import com.sundera.timewise.event.dto.JournalEventDto;
import com.sundera.timewise.event.dto.MeetingEventDto;
import com.sundera.timewise.event.dto.ReminderEventDto;
import com.sundera.timewise.event.dto.TaskEventDto;
import com.sundera.timewise.repository.IEventRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class EventService implements IEventService {
	
	@Autowired
	private IEventRepository eventRepository;
	
	@Autowired
	private IEventFactory eventFactory;
	
	@Autowired
	private IEventDtoFactory eventDtoFactory;

	@Override
	public void addEvent(EventDto eventDto) {
		// TODO Auto-generated method stub
		Event event = dtoToEvent(eventDto);
		eventRepository.save(event);
	}

	@Override
	public EventDto getEvent(UUID eventId) throws Exception {
		Optional<Event> optionalEvent = eventRepository.findById(eventId);
		if(optionalEvent==null) {
			throw new Exception("Event of the id does not exist");
		}
		return eventToDto(optionalEvent.get());
	}
	
	private Event dtoToEvent(EventDto eventDto) {
		if(eventDto instanceof ReminderEventDto) {
			ReminderEventDto dto = (ReminderEventDto)eventDto;
			ReminderEvent event = eventFactory.createReminderEvent();
			event.setUserId(dto.getUserId());
			event.setTitle(dto.getTitle());
			event.setTag(dto.getTag());
			event.setTextBody(dto.getTextBody());
			event.setPriority(dto.getPriority());
			event.setStartDate(dto.getStartDate());
			event.setEndDate(dto.getEndDate());
			event.setRemindTime(dto.getRemindTime());
			return event;
		}else if(eventDto instanceof MeetingEventDto) {
			MeetingEventDto dto = (MeetingEventDto)eventDto;
			MeetingEvent event = eventFactory.createMeetingEvent();
			event.setUserId(dto.getUserId());
			event.setTitle(dto.getTitle());
			event.setTag(dto.getTag());
			event.setTextBody(dto.getTextBody());
			event.setPriority(dto.getPriority());
			event.setDateOfMeeting(dto.getDateOfMeeting());
			event.setStartTime(dto.getStartTime());
			event.setEndTime(dto.getEndTime());
			return event;
		}else if(eventDto instanceof TaskEventDto) {
			TaskEventDto dto = (TaskEventDto)eventDto;
			TaskEvent event = eventFactory.createTaskEvent();
			event.setUserId(dto.getUserId());
			event.setTitle(dto.getTitle());
			event.setTag(dto.getTag());
			event.setTextBody(dto.getTextBody());
			event.setPriority(dto.getPriority());
			event.setDateAssignedTo(dto.getDateAssignedTo());
			event.setComplete(dto.isComplete());
			return event;
		}else {
			JournalEventDto dto = (JournalEventDto)eventDto;
			JournalEvent event = eventFactory.createJournalEvent();
			event.setUserId(dto.getUserId());
			event.setTitle(dto.getTitle());
			event.setTag(dto.getTag());
			event.setTextBody(dto.getTextBody());
			event.setPriority(dto.getPriority());
			event.setImageName(dto.getImageName());
			event.setDateAssignedTo(dto.getDateAssignedTo());
			return event;
		}
	}
	
	private EventDto eventToDto(Event myEvent) {
		if(myEvent instanceof ReminderEvent) {
			ReminderEvent event = (ReminderEvent)myEvent;
			ReminderEventDto dto = eventDtoFactory.createReminderEventDto();
			dto.setUserId(event.getUserId());
			dto.setTitle(event.getTitle());
			dto.setTag(event.getTag());
			dto.setTextBody(event.getTextBody());
			dto.setPriority(event.getPriority());
			dto.setStartDate(event.getStartDate());
			dto.setEndDate(event.getEndDate());
			dto.setRemindTime(event.getRemindTime());
			return dto;
		}else if(myEvent instanceof MeetingEvent) {
			MeetingEvent event = (MeetingEvent)myEvent;
			MeetingEventDto dto = eventDtoFactory.createMeetingEventDto();
			dto.setUserId(event.getUserId());
			dto.setTitle(event.getTitle());
			dto.setTag(event.getTag());
			dto.setTextBody(event.getTextBody());
			dto.setPriority(event.getPriority());
			dto.setDateOfMeeting(event.getDateOfMeeting());
			dto.setStartTime(event.getStartTime());
			dto.setEndTime(event.getEndTime());
			return dto;
		}else if(myEvent instanceof TaskEvent) {
			TaskEvent event = (TaskEvent)myEvent;
			TaskEventDto dto = eventDtoFactory.createTaskEventDto();
			dto.setUserId(event.getUserId());
			dto.setTitle(event.getTitle());
			dto.setTag(event.getTag());
			dto.setTextBody(event.getTextBody());
			dto.setPriority(event.getPriority());
			dto.setDateAssignedTo(event.getDateAssignedTo());
			dto.setComplete(event.isComplete());
			return dto;
		}else {
			JournalEvent event = (JournalEvent)myEvent;
			JournalEventDto dto = eventDtoFactory.createJournalEventDto();
			dto.setUserId(event.getUserId());
			dto.setTitle(event.getTitle());
			dto.setTag(event.getTag());
			dto.setTextBody(event.getTextBody());
			dto.setPriority(event.getPriority());
			dto.setImageName(event.getImageName());
			dto.setDateAssignedTo(event.getDateAssignedTo());
			return dto;
		}
	}

}
