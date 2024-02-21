package com.sundera.timewise.export_events;

import java.time.LocalDate;
import java.time.LocalTime;

public interface IEventExporter<T> {
	
	public T exportReminderEvent(String userId, String title, String tag,String textBody, int priority,LocalDate assignedDate,LocalTime remindTime);
	public T exportMeetingEvent(String userId, String title, String tag, String textBody, int priority,LocalDate assignedDate, LocalTime startTime,LocalTime endTime);
	public T exportTaskEvent(String userId, String title, String tag, String textBody, int priority,LocalDate assignedDate, boolean isComplete);
	public T exportJournalEvent(String userId, String title, String tag, String textBody, int priority,LocalDate assignedDate,String imageName);
}
