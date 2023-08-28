package com.sundera.timewise.event.view.dto;

import com.google.gson.annotations.SerializedName;

public class EventViewDto {
	String title;
	String tag;
	@SerializedName("event-type")
	String eventType;
}
