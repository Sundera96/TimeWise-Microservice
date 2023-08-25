package com.sundera.timewise.event.service;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.sundera.timewise.domain.Event;
import com.sundera.timewise.domain.EventFactory;
import com.sundera.timewise.domain.JournalEvent;
import com.sundera.timewise.domain.MeetingEvent;
import com.sundera.timewise.domain.ReminderEvent;
import com.sundera.timewise.domain.TaskEvent;
import com.sundera.timewise.event.dto.IEventImporter;

@Component
public class EventImporter implements IEventImporter<Event> {
	
	@Autowired
	private EventFactory eventFactory;

	@Override
	public Event importReminderTreatment(UUID userId, String title, String tag, String typeEvent, String textBody,
			int priority, LocalDate startDate, LocalDate endDate, LocalTime remindTime) {
		ReminderEvent event = eventFactory.createReminderEvent();
		event.setUserId(userId);
		event.setTitle(title);
		event.setTag(tag);
		event.setTextBody(textBody);
		event.setPriority(priority);
		event.setStartDate(startDate);
		event.setEndDate(endDate);
		event.setRemindTime(remindTime);
		return event;
	}

	@Override
	public Event importMeetingTreatment(UUID userId, String title, String tag, String typeEvent, String textBody,
			int priority, LocalDate dateOfMeeting, LocalTime startTime, LocalTime endTime) {
		MeetingEvent event = eventFactory.createMeetingEvent();
		event.setUserId(userId);
		event.setTitle(title);
		event.setTag(tag);
		event.setTextBody(textBody);
		event.setPriority(priority);
		event.setDateOfMeeting(dateOfMeeting);
		event.setStartTime(startTime);
		event.setEndTime(endTime);
		return event;
	}

	@Override
	public Event importTaskTreatment(UUID userId, String title, String tag, String typeEvent, String textBody,
			int priority, LocalDate dateAssignedTo, boolean isComplete) {
		TaskEvent event = eventFactory.createTaskEvent();
		event.setUserId(userId);
		event.setTitle(title);
		event.setTag(tag);
		event.setTextBody(textBody);
		event.setPriority(priority);
		event.setDateAssignedTo(dateAssignedTo);
		event.setComplete(isComplete);
		return event;
	}

	@Override
	public Event importJournalTreatment(UUID userId, String title, String tag, String typeEvent, String textBody,
			int priority, String imageName, LocalDate dateAssignedTo) {
		JournalEvent event = eventFactory.createJournalEvent();
		event.setUserId(userId);
		event.setTitle(title);
		event.setTag(tag);
		event.setTextBody(textBody);
		event.setPriority(priority);
		event.setImageName(imageName);
		event.setDateAssignedTo(dateAssignedTo);
		return event;
	}

}
