package com.sundera.timewise.event.dto;

import java.time.LocalDateTime;

import com.sundera.timewise.import_events.IEventImporter;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


import java.util.List;
import com.google.gson.annotations.SerializedName;

@Getter
@Setter
@NoArgsConstructor
public class MeetingEventDto extends EventDto {
	
	@SerializedName("start-date-time")
	private LocalDateTime startDateTime;
	
	@SerializedName("end-date-time")
	private LocalDateTime endDateTime;
	
	@SerializedName("recurrence-count")
	int recurrenceCount;
	@Override
	public <T> List<T> eventImporter(IEventImporter<T> visitor) {
		return visitor.importMeetingEvent(getEventId(), getUserId(), getTitle(), getTopic(), getNotes(), getPriority(), getCreatedDateTime(), getExpiryDateTime(), getStartDateTime(), getEndDateTime(), recurrenceCount);
	}
	
}
