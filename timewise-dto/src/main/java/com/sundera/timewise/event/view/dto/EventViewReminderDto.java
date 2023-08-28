package com.sundera.timewise.event.view.dto;

import java.time.LocalDate;
import java.time.LocalTime;
import com.google.gson.annotations.SerializedName;

public class EventViewReminderDto extends EventViewDto {
	
	@SerializedName("start-date")
	LocalDate startDate;
	
	@SerializedName("end-date")
	LocalDate endDate;
	
	@SerializedName("remind-time")
	LocalTime remindTime;
}
