package com.sundera.timewise.event.dto;

import java.time.LocalDate;
import java.time.LocalTime;

import com.google.gson.annotations.SerializedName;

public class MeetingEventDto extends EventDto {
	
	@SerializedName("meeting-date")
	LocalDate dateOfMeeting;
	@SerializedName("start-time")
	LocalTime startTime;
	@SerializedName("end-time")
	LocalTime endTime;
	
	public LocalDate getDateOfMeeting() {
		return dateOfMeeting;
	}
	public void setDateOfMeeting(LocalDate dateOfMeeting) {
		this.dateOfMeeting = dateOfMeeting;
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
	
}
