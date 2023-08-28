package com.sundera.timewise.event.view.dto;

import java.time.LocalDate;

import com.google.gson.annotations.SerializedName;

public class EventViewTaskDto extends EventViewDto {
	@SerializedName("date-assigned")
	LocalDate dateAssigned;
	boolean isComplete;
}
