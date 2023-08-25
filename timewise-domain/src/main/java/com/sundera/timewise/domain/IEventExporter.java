package com.sundera.timewise.domain;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.UUID;

public interface IEventExporter<T> {
	
	public T exportReminderEvent(UUID userId, String title, String tag, String typeEvent, String textBody, int priority,LocalDate startDate,LocalDate endDate, LocalTime remindTime);
	
	public T exportMeetingEvent(UUID userId, String title, String tag, String typeEvent, String textBody, int priority,LocalDate dateOfMeeting, LocalTime startTime,LocalTime endTime);
	
	public T exportTaskEvent(UUID userId, String title, String tag, String typeEvent, String textBody, int priority,LocalDate dateAssignedTo, boolean isComplete);
	
	public T exportJournalEvent(UUID userId, String title, String tag, String typeEvent, String textBody, int priority,String imageName, LocalDate dateAssignedTo);
}
