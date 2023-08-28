package com.sundera.timewise.event.service;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.UUID;

import org.springframework.stereotype.Component;

import com.sundera.timewise.domain.IEventExporter;
import com.sundera.timewise.event.view.dto.EventViewDto;

@Component
public class EventViewExporter implements IEventExporter<EventViewDto> {

	@Override
	public EventViewDto exportReminderEvent(UUID userId, String title, String tag, String textBody, int priority,
			LocalDate assignedDate, LocalTime remindTime) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public EventViewDto exportMeetingEvent(UUID userId, String title, String tag, String textBody, int priority,
			LocalDate assignedDate, LocalTime startTime, LocalTime endTime) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public EventViewDto exportTaskEvent(UUID userId, String title, String tag, String textBody, int priority,
			LocalDate assignedDate, boolean isComplete) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public EventViewDto exportJournalEvent(UUID userId, String title, String tag, String textBody, int priority,
			LocalDate assignedDate, String imageName) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
