package com.sundera.timewise.event_view.dto;

public class EventViewTaskDto extends EventViewDto {
	boolean isComplete;

	public boolean isComplete() {
		return isComplete;
	}

	public void setComplete(boolean isComplete) {
		this.isComplete = isComplete;
	}
}
