package com.sundera.timewise.event.dto;

import java.time.LocalDate;
import java.util.List;
import java.time.LocalTime;
import java.util.UUID;

public interface IEventImporter<T> {
	public List<T> importReminder(UUID userId, String title, String tag, String textBody, int priority,LocalDate startDate,LocalDate endDate, LocalTime remindTime);
	public List<T> importMeeting(UUID userId, String title, String tag, String textBody, int priority,LocalDate startDate,LocalDate endDate,LocalTime startTime,LocalTime endTime);
	public List<T> importTask(UUID userId, String title, String tag, String textBody, int priority,LocalDate assignedDate, boolean isComplete);
	public List<T> importJournal(UUID userId, String title, String tag, String textBody, int priority,LocalDate assignedDate, String imageName);
}
