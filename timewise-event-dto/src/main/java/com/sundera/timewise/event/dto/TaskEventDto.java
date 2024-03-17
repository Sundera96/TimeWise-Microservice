package com.sundera.timewise.event.dto;
import java.time.LocalDate;
import java.util.List;
import com.google.gson.annotations.SerializedName;
import com.sundera.timewise.import_events.IEventImporter;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@NoArgsConstructor
public class TaskEventDto extends EventDto {
	
	@SerializedName("task-date")
	LocalDate taskDate;
	
	@SerializedName("form-habit")
	boolean isFormHabit;

	@Override
	public <T> List<T> eventImporter(IEventImporter<T> visitor) {
		// TODO Auto-generated method stub
		return visitor.importTaskEvent(getEventId(), getUserId(), getTitle(), getTopic(), getNotes(), getPriority(), getCreatedDateTime(), getExpiryDateTime(), getTaskDate(), isFormHabit);
	}

}
