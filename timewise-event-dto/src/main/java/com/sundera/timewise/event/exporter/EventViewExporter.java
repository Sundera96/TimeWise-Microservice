package com.sundera.timewise.event.exporter;

import java.time.LocalDate;
import java.time.LocalTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.sundera.timewise.event_view.dto.EventViewDto;
import com.sundera.timewise.event_view.dto.EventViewJournalDto;
import com.sundera.timewise.event_view.dto.EventViewMeetingDto;
import com.sundera.timewise.event_view.dto.EventViewReminderDto;
import com.sundera.timewise.event_view.dto.EventViewTaskDto;
import com.sundera.timewise.event_view.dto.IEventViewDtoFactory;
import com.sundera.timewise.export_events.IEventExporter;

@Component
public class EventViewExporter implements IEventExporter<EventViewDto> {
	
	@Autowired
	private IEventViewDtoFactory eventViewDtoFactory;

	@Override
	public EventViewReminderDto exportReminderEvent(String userId, String title, String tag, String textBody, int priority,
			LocalDate assignedDate, LocalTime remindTime) {
		EventViewReminderDto dto = eventViewDtoFactory.createEventViewReminderDto();
		dto.setTitle(title);
		dto.setTag(tag);
		dto.setDateAssigned(assignedDate);
		dto.setRemindTime(remindTime);
		dto.setEventType("REMINDER");
		return dto;
	}

	@Override
	public EventViewMeetingDto exportMeetingEvent(String userId, String title, String tag, String textBody, int priority,
			LocalDate assignedDate, LocalTime startTime, LocalTime endTime) {
		EventViewMeetingDto dto = eventViewDtoFactory.createEventViewMeetingDto();
		dto.setTitle(title);
		dto.setTag(tag);
		dto.setDateAssigned(assignedDate);
		dto.setStartTime(startTime);
		dto.setEndTime(endTime);
		dto.setEventType("MEETING");
		return dto;
	}

	@Override
	public EventViewTaskDto exportTaskEvent(String userId, String title, String tag, String textBody, int priority,
			LocalDate assignedDate, boolean isComplete) {
		EventViewTaskDto dto = eventViewDtoFactory.createEventViewTaskDto();
		dto.setTitle(title);
		dto.setTag(tag);
		dto.setDateAssigned(assignedDate);
		dto.setComplete(isComplete);
		dto.setEventType("TASK");
		return dto;
	}

	@Override
	public EventViewJournalDto exportJournalEvent(String userId, String title, String tag, String textBody, int priority,
			LocalDate assignedDate, String imageName) {
		EventViewJournalDto dto = eventViewDtoFactory.createEventViewJournalDto();
		dto.setTitle(title);
		dto.setTag(tag);
		dto.setDateAssigned(assignedDate);
		dto.setImageName(imageName);
		dto.setEventType("JOURNAL");
		return dto;
	}
	
}
