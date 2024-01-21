package com.sundera.timewise.event.view.dto;

public interface IEventViewDtoFactory {
	
	public EventViewReminderDto createEventViewReminderDto();
	public EventViewMeetingDto createEventViewMeetingDto();
	public EventViewTaskDto createEventViewTaskDto();
	public EventViewJournalDto createEventViewJournalDto();
}
