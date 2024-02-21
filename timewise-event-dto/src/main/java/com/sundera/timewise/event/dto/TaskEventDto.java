package com.sundera.timewise.event.dto;
import java.time.LocalDate;
import java.util.List;
import com.google.gson.annotations.SerializedName;
import com.sundera.timewise.import_events.IEventImporter;

public class TaskEventDto extends EventDto {
	
	@SerializedName("is-complete")
	boolean isComplete;
	
	@SerializedName("task-date")
	LocalDate date;
	
	public LocalDate getDate() {
		return date;
	}
	public void setDate(LocalDate date) {
		this.date = date;
	}
	public boolean isComplete() {
		return isComplete;
	}
	public void setComplete(boolean isComplete) {
		this.isComplete = isComplete;
	}
	@Override
	public <T> List<T> eventImporter(IEventImporter<T> visitor) {
		// TODO Auto-generated method stub
		return visitor.importTask(userId, title, tag, textBody, priority, date, isComplete);
	}
}
