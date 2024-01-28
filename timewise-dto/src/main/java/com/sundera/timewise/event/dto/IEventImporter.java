package com.sundera.timewise.event.dto;

import java.time.LocalDate;
import java.util.List;
import java.time.LocalTime;

public interface IEventImporter<T> {
	public List<T> importReminder(String userId, String title, String tag, String textBody, int priority,LocalDate startDate,LocalDate endDate, LocalTime remindTime);
	public List<T> importMeeting(String userId, String title, String tag, String textBody, int priority,LocalDate startDate,LocalDate endDate,LocalTime startTime,LocalTime endTime);
	public List<T> importTask(String userId, String title, String tag, String textBody, int priority,LocalDate assignedDate, boolean isComplete);
	public List<T> importJournal(String userId, String title, String tag, String textBody, int priority,LocalDate assignedDate, String imageName);
}
