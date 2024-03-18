package com.sundera.timewise.event_view.dto;

import org.springframework.hateoas.RepresentationModel;

import com.google.gson.annotations.SerializedName;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class EventViewDto extends RepresentationModel<EventViewDto>{
	@SerializedName(value = "event-id")
	private String eventId;

	private String title;

	private String topic;
	
	@SerializedName(value = "event-type")
	private String eventType;
}
