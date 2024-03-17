package com.sundera.timewise.event.dto;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

import com.google.gson.annotations.SerializedName;
import com.sundera.timewise.import_events.IEventImporter;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public abstract class EventDto {
	
	@SerializedName("event-id")
	private String eventId;

	private String userId;
	
	private String title;
	
	private String topic;
	
	@SerializedName("event-type")
	private String eventType;

	@SerializedName("notes")
	private String notes;
	
	private int priority;
	
	@SerializedName("created-date-time")
	private LocalDateTime createdDateTime;

	@SerializedName("expired-date-time")
	private LocalDateTime expiryDateTime;

	public abstract <T> List<T> eventImporter(IEventImporter<T> visitor);
}
