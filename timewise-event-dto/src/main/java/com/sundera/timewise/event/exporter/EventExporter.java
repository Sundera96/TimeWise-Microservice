package com.sundera.timewise.event.exporter;


import java.time.LocalDateTime;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.sundera.timewise.domain.EventSeries;
import com.sundera.timewise.domain.EventTypes;
import com.sundera.timewise.event.dto.EventDto;
import com.sundera.timewise.event.dto.IEventDtoFactory;
import com.sundera.timewise.event.dto.LinkEventDto;
import com.sundera.timewise.event.dto.MeetingEventDto;
import com.sundera.timewise.event.dto.ReminderEventDto;
import com.sundera.timewise.event.dto.TaskEventDto;
import com.sundera.timewise.export_events.IEventExporter;

@Component
public class EventExporter implements IEventExporter<EventDto> {

	@Autowired
	private IEventDtoFactory eventDtoFactory;

	@Override
	public EventDto exportReminderEvent(UUID eventId, String userId, String title, String topic, String notes,
			int priority, LocalDateTime createdDateTime, LocalDateTime expiryDateTime, LocalDateTime eventDateTime) {
		ReminderEventDto eventDto =  eventDtoFactory.createReminderEventDto();
		eventDto.setEventId(eventId.toString());
		eventDto.setUserId(userId);
		eventDto.setTitle(title);
		eventDto.setTopic(topic);
		eventDto.setNotes(notes);
		eventDto.setPriority(priority);
		eventDto.setCreatedDateTime(createdDateTime);
		eventDto.setExpiryDateTime(expiryDateTime);
		eventDto.setRemindDateTime(eventDateTime);
		eventDto.setEventType(EventTypes.REMINDER.toString());
		return eventDto;
	}

	@Override
	public EventDto exportMeetingEvent(UUID eventId, String userId, String title, String topic, String notes,
			int priority, LocalDateTime createdDateTime, LocalDateTime expiryDateTime, LocalDateTime eventDateTime,
			LocalDateTime endDateTime) {
		MeetingEventDto eventDto =  eventDtoFactory.createMeetingEventDto();
		eventDto.setEventId(eventId.toString());
		eventDto.setUserId(userId);
		eventDto.setTitle(title);
		eventDto.setTopic(topic);
		eventDto.setNotes(notes);
		eventDto.setPriority(priority);
		eventDto.setCreatedDateTime(createdDateTime);
		eventDto.setExpiryDateTime(expiryDateTime);
		eventDto.setStartDateTime(eventDateTime);
		eventDto.setEndDateTime(endDateTime);
		eventDto.setEventType(EventTypes.MEETING.toString());
		return eventDto;
	}

	@Override
	public EventDto exportTaskEvent(UUID eventId, String userId, String title, String topic, String notes, int priority,
			LocalDateTime createdDateTime, LocalDateTime expiryDateTime, LocalDateTime eventDateTime,
			boolean formHabit) {
		TaskEventDto eventDto = eventDtoFactory.createTaskEventDto();
		eventDto.setEventId(eventId.toString());
		eventDto.setUserId(userId);
		eventDto.setTitle(title);
		eventDto.setTopic(topic);
		eventDto.setNotes(notes);
		eventDto.setPriority(priority);
		eventDto.setCreatedDateTime(createdDateTime);
		eventDto.setExpiryDateTime(expiryDateTime);
		eventDto.setTaskDate(eventDateTime.toLocalDate());
		eventDto.setFormHabit(formHabit);
		eventDto.setEventType(EventTypes.TASK.toString());
		return eventDto;
	}

	@Override
	public EventDto exportLinkEvent(UUID eventId, String userId, String title, String topic, String notes, int priority,
			LocalDateTime createdDateTime, LocalDateTime expiryDateTime, LocalDateTime eventDateTime, String link) {
		LinkEventDto eventDto = eventDtoFactory.createLinkEventDto();
		eventDto.setEventId(eventId.toString());
		eventDto.setUserId(userId);
		eventDto.setTitle(title);
		eventDto.setTopic(topic);
		eventDto.setNotes(notes);
		eventDto.setPriority(priority);
		eventDto.setCreatedDateTime(createdDateTime);
		eventDto.setExpiryDateTime(expiryDateTime);
		eventDto.setLink(link);
		eventDto.setEventType(EventTypes.LINK.toString());
		return eventDto;
	}


}
