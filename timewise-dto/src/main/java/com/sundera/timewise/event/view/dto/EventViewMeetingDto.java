package com.sundera.timewise.event.view.dto;

import java.time.LocalDate;
import java.time.LocalTime;

import com.google.gson.annotations.SerializedName;

public class EventViewMeetingDto extends EventViewDto {
	@SerializedName("meeting-date")
	LocalDate meetingDate;
	@SerializedName("start-time")
	LocalTime startTime;
	@SerializedName("end-time")
	LocalTime endTime;
}
