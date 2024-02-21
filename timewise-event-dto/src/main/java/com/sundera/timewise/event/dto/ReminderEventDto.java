package com.sundera.timewise.event.dto;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import com.sundera.timewise.import_events.IEventImporter;
import com.google.gson.annotations.SerializedName;

public class ReminderEventDto extends EventDto {

	@SerializedName("start-date")
	LocalDate startDate;
	
	@SerializedName("end-date")
	LocalDate endDate;
	
	@SerializedName("remind-time")
	LocalTime remindTime;
	
	public LocalTime getRemindTime() {
		return remindTime;
	}
	public void setRemindTime(LocalTime remindTime) {
		this.remindTime = remindTime;
	}
	@Override
	public <T> List<T> eventImporter(IEventImporter<T> visitor) {
		return visitor.importReminder(userId, title, tag, textBody, priority,startDate,endDate, remindTime);
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
}
