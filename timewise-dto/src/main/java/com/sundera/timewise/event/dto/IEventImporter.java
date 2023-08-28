package com.sundera.timewise.event.dto;

import java.time.LocalDate;
import java.util.List;
import java.time.LocalTime;
import java.util.UUID;

public interface IEventImporter<T> {
	public List<T> importReminderTreatment(UUID userId, String title, String tag, String textBody, int priority,LocalDate startDate,LocalDate endDate, LocalTime remindTime);
	public List<T> importMeetingTreatment(UUID userId, String title, String tag, String textBody, int priority,LocalDate startDate,LocalDate endDate,LocalTime startTime,LocalTime endTime);
	public List<T> importTaskTreatment(UUID userId, String title, String tag, String textBody, int priority,LocalDate assignedDate, boolean isComplete);
	public List<T> importJournalTreatment(UUID userId, String title, String tag, String textBody, int priority,LocalDate assignedDate, String imageName);
}
