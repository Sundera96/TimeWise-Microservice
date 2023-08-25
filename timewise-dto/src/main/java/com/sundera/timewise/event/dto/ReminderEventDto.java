package com.sundera.timewise.event.dto;

import java.time.LocalDate;
import java.time.LocalTime;

import com.google.gson.annotations.SerializedName;

public class ReminderEventDto extends EventDto {
	
	@SerializedName("start-date")
	LocalDate startDate;
	@SerializedName("end-date")
	LocalDate endDate;
	@SerializedName("remind-time")
	LocalTime remindTime;
	
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
	@Override
	public <T> T eventImporter(IEventImporter<T> visitor) {
		return visitor.importReminderTreatment(userId, title, tag, typeEvent, textBody, priority, startDate, endDate, remindTime);
	}
}
