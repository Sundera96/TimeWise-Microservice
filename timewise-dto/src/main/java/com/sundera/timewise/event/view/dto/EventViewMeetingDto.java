package com.sundera.timewise.event.view.dto;
import java.time.LocalTime;

import com.google.gson.annotations.SerializedName;

public class EventViewMeetingDto extends EventViewDto {
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
}
