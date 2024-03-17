package com.sundera.timewise.event.exporter;

import java.time.LocalDateTime;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.sundera.timewise.domain.EventSeries;
import com.sundera.timewise.domain.EventTypes;
import com.sundera.timewise.event_view.dto.EventViewDto;
import com.sundera.timewise.event_view.dto.EventViewLinkDto;
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
	public EventViewDto exportReminderEvent(UUID eventId, String userId, String title, String topic, String notes,
			int priority, LocalDateTime createdDateTime, LocalDateTime expiryDateTime, LocalDateTime eventDateTime) {
		EventViewReminderDto eventViewDto = eventViewDtoFactory.createEventViewReminderDto();
		eventViewDto.setEventId(eventId.toString());
		eventViewDto.setTitle(title);
		eventViewDto.setTopic(topic);
		eventViewDto.setRemindDateTime(eventDateTime);
		eventViewDto.setEventType(EventTypes.REMINDER.toString());
		return eventViewDto;
	}

	@Override
	public EventViewDto exportMeetingEvent(UUID eventId, String userId, String title, String topic, String notes,
			int priority, LocalDateTime createdDateTime, LocalDateTime expiryDateTime, LocalDateTime eventDateTime,
			LocalDateTime endDateTime) {
		EventViewMeetingDto eventViewDto = eventViewDtoFactory.createEventViewMeetingDto();
		eventViewDto.setEventId(eventId.toString());
		eventViewDto.setTitle(title);
		eventViewDto.setTopic(topic);
		eventViewDto.setStartDateTime(eventDateTime);
		eventViewDto.setEndDateTime(endDateTime);
		eventViewDto.setEventType(EventTypes.MEETING.toString());
		return eventViewDto;
	}

	@Override
	public EventViewDto exportTaskEvent(UUID eventId, String userId, String title, String topic, String notes,
			int priority, LocalDateTime createdDateTime, LocalDateTime expiryDateTime, LocalDateTime eventDateTime,
			boolean formHabit) {
		EventViewTaskDto eventViewDto = eventViewDtoFactory.createEventViewTaskDto();
		eventViewDto.setEventId(eventId.toString());
		eventViewDto.setTitle(title);
		eventViewDto.setTopic(topic);
		eventViewDto.setFormHabit(formHabit);
		eventViewDto.setEventType(EventTypes.TASK.toString());
		return eventViewDto;
	}

	@Override
	public EventViewDto exportLinkEvent(UUID eventId, String userId, String title, String topic, String notes,
			int priority, LocalDateTime createdDateTime, LocalDateTime expiryDateTime, LocalDateTime eventDateTime,
			String link) {
		EventViewLinkDto eventViewDto = eventViewDtoFactory.createEventViewLinkDto();
		eventViewDto.setEventId(eventId.toString());
		eventViewDto.setTitle(title);
		eventViewDto.setTopic(topic);
		eventViewDto.setLinkDateTime(eventDateTime);
		eventViewDto.setEventType(EventTypes.LINK.toString());
		return eventViewDto;
	}
	
}
