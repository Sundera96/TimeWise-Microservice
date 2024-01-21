package com.sundera.timewise.event.dto;


import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import com.google.gson.annotations.SerializedName;

public class MeetingEventDto extends EventDto {
	
	@SerializedName("start-date")
	LocalDate startDate;
	
	@SerializedName("end-date")
	LocalDate endDate;
	
	@SerializedName("start-time")
	LocalTime startTime;
	@SerializedName("end-time")
	LocalTime endTime;
	
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
	
	@Override
	public <T> List<T> eventImporter(IEventImporter<T> visitor) {
		return visitor.importMeeting(userId, title, tag, textBody, priority, startDate,endDate, startTime, endTime);
	}
}
