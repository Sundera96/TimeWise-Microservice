package com.sundera.timewise.event.service;

import java.time.LocalDate;
import java.time.LocalTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.sundera.timewise.domain.IEventExporter;
import com.sundera.timewise.event.dto.EventDto;
import com.sundera.timewise.event.dto.IEventDtoFactory;
import com.sundera.timewise.event.dto.JournalEventDto;
import com.sundera.timewise.event.dto.MeetingEventDto;
import com.sundera.timewise.event.dto.ReminderEventDto;
import com.sundera.timewise.event.dto.TaskEventDto;

@Component
public class EventExporter implements IEventExporter<EventDto> {

	@Autowired
	private IEventDtoFactory dtoFactory;
	
	@Override
	public EventDto exportReminderEvent(String userId, String title, String tag, String textBody,
			int priority, LocalDate assignedDate, LocalTime remindTime) {
		ReminderEventDto dto = dtoFactory.createReminderEventDto();
		dto.setTitle(title);
		dto.setTag(tag);
		dto.setTextBody(textBody);
		dto.setPriority(priority);
		dto.setStartDate(assignedDate);
		dto.setEndDate(assignedDate);
		dto.setRemindTime(remindTime);
		dto.setTypeEvent("REMINDER");
		return dto;
	}

	@Override
	public EventDto exportMeetingEvent(String userId, String title, String tag, String textBody,
			int priority, LocalDate assignedDate, LocalTime startTime, LocalTime endTime) {
		MeetingEventDto dto = dtoFactory.createMeetingEventDto();
		dto.setTitle(title);
		dto.setTag(tag);
		dto.setTextBody(textBody);
		dto.setPriority(priority);
		dto.setStartDate(assignedDate);
		dto.setEndDate(assignedDate);
		dto.setStartTime(startTime);
		dto.setEndTime(endTime);
		dto.setTypeEvent("MEETING");
		return dto;
	}

	@Override
	public EventDto exportTaskEvent(String userId, String title, String tag, String textBody,
			int priority, LocalDate assignedDate, boolean isComplete) {
		TaskEventDto dto = dtoFactory.createTaskEventDto();
		dto.setTitle(title);
		dto.setTag(tag);
		dto.setTextBody(textBody);
		dto.setPriority(priority);
		dto.setDate(assignedDate);
		dto.setComplete(isComplete);
		dto.setTypeEvent("TASK");
		return dto;
	}

	@Override
	public EventDto exportJournalEvent(String userId, String title, String tag, String textBody,
			int priority,LocalDate assignedDate, String imageName) {
		JournalEventDto dto =dtoFactory.createJournalEventDto();
		dto.setTitle(title);
		dto.setTag(tag);
		dto.setTextBody(textBody);
		dto.setPriority(priority);
		dto.setImageName(imageName);
		dto.setAssignedDate(assignedDate);
		dto.setTypeEvent("JOURNAL");
		return dto;
	}

}
