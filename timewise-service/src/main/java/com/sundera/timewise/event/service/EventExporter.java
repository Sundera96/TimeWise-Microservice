package com.sundera.timewise.event.service;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.sundera.timewise.domain.IEventExporter;
import com.sundera.timewise.event.dto.EventDto;
import com.sundera.timewise.event.dto.EventDtoFactory;
import com.sundera.timewise.event.dto.JournalEventDto;
import com.sundera.timewise.event.dto.MeetingEventDto;
import com.sundera.timewise.event.dto.ReminderEventDto;
import com.sundera.timewise.event.dto.TaskEventDto;

@Component
public class EventExporter implements IEventExporter<EventDto> {

	@Autowired
	private EventDtoFactory dtoFactory;
	
	@Override
	public EventDto exportReminderEvent(UUID userId, String title, String tag, String typeEvent, String textBody,
			int priority, LocalDate startDate, LocalDate endDate, LocalTime remindTime) {
		ReminderEventDto dto = dtoFactory.createReminderEventDto();
		dto.setUserId(userId);
		dto.setTitle(title);
		dto.setTag(tag);
		dto.setTextBody(textBody);
		dto.setPriority(priority);
		dto.setStartDate(startDate);
		dto.setEndDate(endDate);
		dto.setRemindTime(remindTime);
		dto.setTypeEvent("REMINDER");
		return dto;
	}

	@Override
	public EventDto exportMeetingEvent(UUID userId, String title, String tag, String typeEvent, String textBody,
			int priority, LocalDate dateOfMeeting, LocalTime startTime, LocalTime endTime) {
		MeetingEventDto dto = dtoFactory.createMeetingEventDto();
		dto.setUserId(userId);
		dto.setTitle(title);
		dto.setTag(tag);
		dto.setTextBody(textBody);
		dto.setPriority(priority);
		dto.setDateOfMeeting(dateOfMeeting);
		dto.setStartTime(startTime);
		dto.setEndTime(endTime);
		dto.setTypeEvent("MEETING");
		return dto;
	}

	@Override
	public EventDto exportTaskEvent(UUID userId, String title, String tag, String typeEvent, String textBody,
			int priority, LocalDate dateAssignedTo, boolean isComplete) {
		TaskEventDto dto = dtoFactory.createTaskEventDto();
		dto.setUserId(userId);
		dto.setTitle(title);
		dto.setTag(tag);
		dto.setTextBody(textBody);
		dto.setPriority(priority);
		dto.setDateAssignedTo(dateAssignedTo);
		dto.setComplete(isComplete);
		dto.setTypeEvent("TASK");
		return dto;
	}

	@Override
	public EventDto exportJournalEvent(UUID userId, String title, String tag, String typeEvent, String textBody,
			int priority, String imageName, LocalDate dateAssignedTo) {
		JournalEventDto dto =dtoFactory.createJournalEventDto();
		dto.setUserId(userId);
		dto.setTitle(title);
		dto.setTag(tag);
		dto.setTextBody(textBody);
		dto.setPriority(priority);
		dto.setImageName(imageName);
		dto.setDateAssignedTo(dateAssignedTo);
		dto.setTypeEvent("JOURNAL");
		return dto;
	}

}
