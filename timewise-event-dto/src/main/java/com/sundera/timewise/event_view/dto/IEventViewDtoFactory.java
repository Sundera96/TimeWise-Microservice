package com.sundera.timewise.event_view.dto;

public interface IEventViewDtoFactory {
	
	public EventViewReminderDto createEventViewReminderDto();
	public EventViewMeetingDto createEventViewMeetingDto();
	public EventViewTaskDto createEventViewTaskDto();
	public EventViewJournalDto createEventViewJournalDto();
}
