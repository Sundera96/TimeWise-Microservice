package com.sundera.timewise.event_view.dto;

import java.time.LocalDateTime;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class EventViewLinkDto extends EventViewDto {
	private LocalDateTime linkDateTime;
}
