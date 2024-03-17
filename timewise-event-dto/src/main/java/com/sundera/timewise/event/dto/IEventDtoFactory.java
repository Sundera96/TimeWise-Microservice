package com.sundera.timewise.event.dto;

public interface IEventDtoFactory {
	public ReminderEventDto createReminderEventDto();
	public MeetingEventDto createMeetingEventDto();
	public TaskEventDto createTaskEventDto();
	public LinkEventDto createLinkEventDto();
}
