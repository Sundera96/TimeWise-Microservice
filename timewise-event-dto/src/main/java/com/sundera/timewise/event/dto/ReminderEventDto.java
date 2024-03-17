package com.sundera.timewise.event.dto;
import java.time.LocalDateTime;
import java.util.List;
import com.sundera.timewise.import_events.IEventImporter;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import com.google.gson.annotations.SerializedName;

@Getter
@Setter
@NoArgsConstructor
public class ReminderEventDto extends EventDto {

	@SerializedName("remind-date-time")
	LocalDateTime remindDateTime;

	@SerializedName("recurrence-count")
	int recurrenceCount;

	@Override
	public <T> List<T> eventImporter(IEventImporter<T> visitor) {
		return visitor.importReminderEvent(getEventId(), getUserId(), getTitle(), getTopic(), getNotes(), getPriority(), getCreatedDateTime(), getExpiryDateTime(), getRemindDateTime(), recurrenceCount);
	}

}
