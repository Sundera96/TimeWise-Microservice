package com.sundera.timewise.domain;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.UUID;

import jakarta.persistence.Entity;

@Entity
public class ReminderEvent extends Event {
	LocalTime remindTime;
	
	public ReminderEvent() {
		
	}
	public ReminderEvent(UUID userId, String title, String tag, String textBody, int priority, LocalTime remindTime, LocalDate assignedDate) {
		super(userId, title, tag, textBody, priority);
		this.remindTime=remindTime;
	}
	
	public LocalTime getRemindTime() {
		return remindTime;
	}
	public void setRemindTime(LocalTime remindTime) {
		this.remindTime = remindTime;
	}
	@Override
	public <T> T export(IEventExporter<T> visitor) {
		return visitor.exportReminderEvent(userId, title, tag, textBody, priority,assignedDate,remindTime);
	}
}
