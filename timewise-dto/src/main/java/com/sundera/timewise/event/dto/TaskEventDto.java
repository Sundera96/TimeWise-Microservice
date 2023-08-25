package com.sundera.timewise.event.dto;

import java.time.LocalDate;

import com.google.gson.annotations.SerializedName;

public class TaskEventDto extends EventDto {
	
	@SerializedName("date-assigned")
	LocalDate dateAssignedTo;
	
	@SerializedName("is-complete")
	boolean isComplete;
	
	public LocalDate getDateAssignedTo() {
		return dateAssignedTo;
	}
	public void setDateAssignedTo(LocalDate dateAssignedTo) {
		this.dateAssignedTo = dateAssignedTo;
	}
	public boolean isComplete() {
		return isComplete;
	}
	public void setComplete(boolean isComplete) {
		this.isComplete = isComplete;
	}
	@Override
	public <T> T eventImporter(IEventImporter<T> visitor) {
		return visitor.importTaskTreatment(userId, title, tag, typeEvent, textBody, priority, dateAssignedTo, isComplete);
	}
}
