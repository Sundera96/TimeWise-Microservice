package com.sundera.timewise.event.dto;

import org.springframework.stereotype.Component;

@Component
public class EventDtoFactory implements IEventDtoFactory {

	@Override
	public ReminderEventDto createReminderEventDto() {
		return new ReminderEventDto();
	}

	@Override
	public MeetingEventDto createMeetingEventDto() {
		return new MeetingEventDto();
	}

	@Override
	public TaskEventDto createTaskEventDto() {
		return new TaskEventDto();
	}

	@Override
	public LinkEventDto createLinkEventDto() {
		return new LinkEventDto();
	}

}
