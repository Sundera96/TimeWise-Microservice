package com.sundera.timewise.domain;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.UUID;

import jakarta.persistence.Entity;

@Entity
public class ReminderEvent extends Event {
	LocalDate startDate;
	LocalDate endDate;
	LocalTime remindTime;
	
	public ReminderEvent() {
		
	}
	public ReminderEvent(UUID userId, String title, String tag, String textBody, int priority, LocalDate startDate, LocalDate endDate, LocalTime remindTime) {
		super(userId, title, tag, textBody, priority);
		this.startDate=startDate;
		this.endDate=endDate;
		this.remindTime=remindTime;
	}
	
	public LocalDate getStartDate() {
		return startDate;
	}
	public void setStartDate(LocalDate startDate) {
		this.startDate = startDate;
	}
	public LocalDate getEndDate() {
		return endDate;
	}
	public void setEndDate(LocalDate endDate) {
		this.endDate = endDate;
	}
	public LocalTime getRemindTime() {
		return remindTime;
	}
	public void setRemindTime(LocalTime remindTime) {
		this.remindTime = remindTime;
	}
}
