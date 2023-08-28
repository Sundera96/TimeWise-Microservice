package com.sundera.timewise.domain;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.UUID;

public interface IEventExporter<T> {
	
	public T exportReminderEvent(UUID userId, String title, String tag,String textBody, int priority,LocalDate assignedDate,LocalTime remindTime);
	
	public T exportMeetingEvent(UUID userId, String title, String tag, String textBody, int priority,LocalDate assignedDate, LocalTime startTime,LocalTime endTime);
	
	public T exportTaskEvent(UUID userId, String title, String tag, String textBody, int priority,LocalDate assignedDate, boolean isComplete);
	
	public T exportJournalEvent(UUID userId, String title, String tag, String textBody, int priority,LocalDate assignedDate,String imageName);
}
