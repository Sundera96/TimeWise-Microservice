package com.sundera.timewise.event_view.dto;
import java.time.LocalDateTime;
import java.time.LocalTime;

import com.google.gson.annotations.SerializedName;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class EventViewMeetingDto extends EventViewDto {
	@SerializedName("start-date-time")
	LocalDateTime startDateTime;
	
	@SerializedName("end-date-time")
	LocalDateTime endDateTime;
}
