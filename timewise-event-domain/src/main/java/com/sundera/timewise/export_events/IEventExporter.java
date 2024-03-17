package com.sundera.timewise.export_events;

import java.time.LocalDateTime;
import java.util.UUID;
import com.sundera.timewise.domain.EventSeries;

public interface IEventExporter<T> {
	public T exportReminderEvent(UUID eventId,String userId, String title, String topic, String notes,int priority, LocalDateTime createdDateTime, LocalDateTime expiryDateTime, LocalDateTime eventDateTime);
	public T exportMeetingEvent(UUID eventId,String userId, String title, String topic, String notes,int priority, LocalDateTime createdDateTime, LocalDateTime expiryDateTime,LocalDateTime eventDateTime, LocalDateTime endDateTime);
	public T exportTaskEvent(UUID eventId,String userId, String title, String topic, String notes, int priority, LocalDateTime createdDateTime, LocalDateTime expiryDateTime,LocalDateTime eventDateTime,boolean formHabit);
	public T exportLinkEvent(UUID eventId,String userId, String title, String topic, String notes, int priority,LocalDateTime createdDateTime, LocalDateTime expiryDateTime, LocalDateTime eventDateTime,String link);
}
