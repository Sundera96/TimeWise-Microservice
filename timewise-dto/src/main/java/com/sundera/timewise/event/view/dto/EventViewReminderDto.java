package com.sundera.timewise.event.view.dto;

import java.time.LocalTime;
import com.google.gson.annotations.SerializedName;

public class EventViewReminderDto extends EventViewDto {
	
	@SerializedName("remind-time")
	LocalTime remindTime;

	public LocalTime getRemindTime() {
		return remindTime;
	}

	public void setRemindTime(LocalTime remindTime) {
		this.remindTime = remindTime;
	}
}
