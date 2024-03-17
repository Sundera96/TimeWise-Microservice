package com.sundera.timewise.event.importer;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.sundera.timewise.domain.Event;
import com.sundera.timewise.domain.EventFactory;
import com.sundera.timewise.domain.LinkEvent;
import com.sundera.timewise.domain.MeetingEvent;
import com.sundera.timewise.domain.ReminderEvent;
import com.sundera.timewise.domain.TaskEvent;
import com.sundera.timewise.import_events.IEventImporter;

@Component
public class EventImporter implements IEventImporter<Event> {
	
	@Autowired
	private EventFactory eventFactory;

	@Override
	public List<Event> importReminderEvent(String eventId, String userId, String title, String topic, String notes,
			int priority, LocalDateTime createdDateTime, LocalDateTime expiryDateTime, LocalDateTime remindDateTime,
			int recurrenceCount) {
		LocalDateTime currDateTime = remindDateTime;
		List<Event> events = new ArrayList<>(recurrenceCount);
		int counter=recurrenceCount;
		while(counter>0) {
			ReminderEvent event = eventFactory.createReminderEvent();
			event.setUserId(userId);
			event.setTitle(title);
			event.setTopic(topic);
			event.setNotes(notes);
			event.setPriority(priority);
			event.setCreatedDateTime(createdDateTime);
			event.setExpiryDateTime(null);
			event.setEventDateTime(currDateTime);
			currDateTime=currDateTime.plusDays(1);
			events.add(event);
			counter--;
		}
		return events;
	}

	@Override
	public List<Event> importMeetingEvent(String eventId, String userId, String title, String topic, String notes,
			int priority, LocalDateTime createdDateTime, LocalDateTime expiryDateTime, LocalDateTime startDateTime,
			LocalDateTime endDateTime, int recurrenceCount) {
		List<Event> events = new ArrayList<>(recurrenceCount);
		LocalDateTime currStartDateTime = startDateTime;
		LocalDateTime currEndDateTime = endDateTime;
		int counter=recurrenceCount;
		while(counter>0) {
			MeetingEvent event = eventFactory.createMeetingEvent();
			event.setUserId(userId);
			event.setTitle(title);
			event.setTopic(topic);
			event.setNotes(notes);
			event.setPriority(priority);
			event.setCreatedDateTime(createdDateTime);
			event.setExpiryDateTime(null);
			event.setEventDateTime(currStartDateTime);
			event.setEndDateTime(currEndDateTime);
			currStartDateTime=currStartDateTime.plusDays(1);
			currEndDateTime = currEndDateTime.plusDays(1);
			events.add(event);
			counter--;
		}
		return events;
	}

	@Override
	public List<Event> importTaskEvent(String eventId, String userId, String title, String topic, String notes,
			int priority, LocalDateTime createdDateTime, LocalDateTime expiryDateTime, LocalDate taskDate,
			boolean isHabitFlag) {
		if(isHabitFlag) {
			List<Event> events = new ArrayList<>(45);
			int counter=45;
			LocalDate currDate = taskDate;
			while(counter>0) {
				TaskEvent event = eventFactory.createTaskEvent();
				event.setUserId(userId);
				event.setTitle(title);
				event.setTopic(topic);
				event.setNotes(notes);
				event.setPriority(priority);
				event.setCreatedDateTime(createdDateTime);
				event.setExpiryDateTime(null);
				event.setEventDateTime(currDate.atStartOfDay());
				events.add(event);
				counter--;
				currDate.plusDays(1);
			}
			return events;
		}else {
			TaskEvent event = eventFactory.createTaskEvent();
			event.setUserId(userId);
			event.setTitle(title);
			event.setTopic(topic);
			event.setNotes(notes);
			event.setPriority(priority);
			event.setCreatedDateTime(createdDateTime);
			event.setExpiryDateTime(null);
			event.setEventDateTime(taskDate.atStartOfDay());
			return Arrays.asList(event);
		}
	}

	@Override
	public List<Event> importLinkEvent(String eventId, String userId, String title, String topic, String notes,
			int priority, LocalDateTime createdDateTime, LocalDateTime expiryDateTime, String link) {
		LinkEvent event = eventFactory.createLinkEvent();
		event.setUserId(userId);
		event.setTitle(title);
		event.setTopic(topic);
		event.setNotes(notes);
		event.setPriority(priority);
		event.setCreatedDateTime(createdDateTime);
		event.setEventDateTime(createdDateTime);
		event.setExpiryDateTime(null);
		event.setLink(link);
		return Arrays.asList(event);
	}
}
