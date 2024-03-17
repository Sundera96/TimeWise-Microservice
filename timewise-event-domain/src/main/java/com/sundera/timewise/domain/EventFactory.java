package com.sundera.timewise.domain;

import org.springframework.stereotype.Component;

@Component
public class EventFactory implements IEventFactory {

	@Override
	public ReminderEvent createReminderEvent() {
		return new ReminderEvent();
	}

	@Override
	public MeetingEvent createMeetingEvent() {
		return new MeetingEvent();
	}

	@Override
	public TaskEvent createTaskEvent() {
		return new TaskEvent();
	}

	@Override
	public LinkEvent createLinkEvent() {
		return new LinkEvent();
	}

}
