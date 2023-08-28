package com.sundera.timewise.event.view.dto;

import com.google.gson.annotations.SerializedName;

public class EventViewJournalDto extends EventViewDto {
	@SerializedName("image-name")
	String imageName;
	@SerializedName("date-assigned")
	String dateAssigned;
}
