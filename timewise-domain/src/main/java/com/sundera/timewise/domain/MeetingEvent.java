package com.sundera.timewise.domain;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.UUID;

import jakarta.persistence.Entity;

@Entity
public class MeetingEvent extends Event {
	LocalTime startTime;
	LocalTime endTime;
	
	public MeetingEvent() {
		
	}
	
	public MeetingEvent(UUID userId, String title, String tag, String textBody, int priority, LocalDate dateOfMeeting, LocalTime starTime, LocalTime endTime) {
		super(userId, title, tag, textBody, priority);
		this.startTime=starTime;
		this.endTime=endTime;
	}

	public LocalTime getStartTime() {
		return startTime;
	}

	public void setStartTime(LocalTime startTime) {
		this.startTime = startTime;
	}

	public LocalTime getEndTime() {
		return endTime;
	}

	public void setEndTime(LocalTime endTime) {
		this.endTime = endTime;
	}

	@Override
	public <T> T export(IEventExporter<T> visitor) {
		return visitor.exportMeetingEvent(userId, title, tag, textBody, priority, assignedDate,startTime, endTime);
	}
}
