package com.sundera.timewise.import_events;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public interface IEventImporter<T> {
	public List<T> importReminderEvent(String eventId,String userId, String title, String topic, String notes,int priority, LocalDateTime createdDateTime, LocalDateTime expiryDateTime, LocalDateTime remindDateTime, int recurrenceCount);
	public List<T> importMeetingEvent(String eventId,String userId, String title, String topic, String notes,int priority, LocalDateTime createdDateTime, LocalDateTime expiryDateTime,LocalDateTime startDateTime, LocalDateTime endDateTime, int recurrenceCOunt);
	public List<T> importTaskEvent(String eventId,String userId, String title, String topic, String notes, int priority, LocalDateTime createdDateTime, LocalDateTime expiryDateTime,LocalDate taskDate,boolean isHabitFlag);
	public List<T> importLinkEvent(String eventId,String userId, String title, String topic, String notes, int priority,LocalDateTime createdDateTime, LocalDateTime expiryDateTime, String link);
}
