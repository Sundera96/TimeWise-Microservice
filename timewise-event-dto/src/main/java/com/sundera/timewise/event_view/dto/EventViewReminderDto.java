package com.sundera.timewise.event_view.dto;

import java.time.LocalDateTime;
import java.time.LocalTime;
import com.google.gson.annotations.SerializedName;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
public class EventViewReminderDto extends EventViewDto {
	
	@SerializedName("remind-date-time")
	private LocalDateTime remindDateTime;
}
