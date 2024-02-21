package com.sundera.timewise.domain;

public interface IEventFactory {
	
	ReminderEvent createReminderEvent();
	MeetingEvent createMeetingEvent();
	TaskEvent createTaskEvent();
	JournalEvent createJournalEvent();
}
