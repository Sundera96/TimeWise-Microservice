package com.sundera.timewise.event_view.dto;

import org.springframework.stereotype.Component;

@Component
public class EventViewDtoFactory implements IEventViewDtoFactory {

	@Override
	public EventViewReminderDto createEventViewReminderDto() {
		return new EventViewReminderDto();
	}

	@Override
	public EventViewMeetingDto createEventViewMeetingDto() {
		return new EventViewMeetingDto();
	}

	@Override
	public EventViewTaskDto createEventViewTaskDto() {
		return new EventViewTaskDto();
	}

	@Override
	public EventViewJournalDto createEventViewJournalDto() {
		return new EventViewJournalDto();
	}

}
