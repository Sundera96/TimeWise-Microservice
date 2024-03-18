package com.sundera.timewise.event_view.dto;

import java.time.LocalDate;
import java.time.LocalDateTime;

import com.google.gson.annotations.SerializedName;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Setter
@Getter
@NoArgsConstructor
public class EventViewTaskDto extends EventViewDto {
	@SerializedName("form-habit")
	private boolean formHabit;
	
	@SerializedName("task-date")
	private LocalDate taskDate;
}
