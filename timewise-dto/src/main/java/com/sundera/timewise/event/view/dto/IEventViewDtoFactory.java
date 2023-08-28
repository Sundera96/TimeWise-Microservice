package com.sundera.timewise.event.view.dto;

public interface IEventViewDtoFactory {
	
	public EventViewDto createEventViewReminderDto();
	public EventViewDto createEventViewMeetingDto();
	public EventViewDto createEventViewTaskDto();
	public EventViewDto createEventViewJournalDto();
}
