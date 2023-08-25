package com.sundera.timewise.event.dto;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.UUID;

public interface IEventImporter<T> {
	public T importReminderTreatment(UUID userId, String title, String tag, String typeEvent, String textBody, int priority,LocalDate startDate, LocalDate endDate, LocalTime remindTime);
	public T importMeetingTreatment(UUID userId, String title, String tag, String typeEvent, String textBody, int priority,LocalDate dateOfMeeting,LocalTime startTime,LocalTime endTime);
	public T importTaskTreatment(UUID userId, String title, String tag, String typeEvent, String textBody, int priority,LocalDate dateAssignedTo, boolean isComplete);
	public T importJournalTreatment(UUID userId, String title, String tag, String typeEvent, String textBody, int priority, String imageName, LocalDate dateAssignedTo);
}
