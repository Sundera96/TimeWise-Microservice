package com.sundera.timewise.event.importer;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.sundera.timewise.domain.Event;
import com.sundera.timewise.domain.EventFactory;
import com.sundera.timewise.domain.JournalEvent;
import com.sundera.timewise.domain.MeetingEvent;
import com.sundera.timewise.domain.ReminderEvent;
import com.sundera.timewise.domain.TaskEvent;
import com.sundera.timewise.import_events.IEventImporter;

@Component
public class EventImporter implements IEventImporter<Event> {
	
	@Autowired
	private EventFactory eventFactory;

	@Override
	public List<Event> importReminder(String userId, String title, String tag, String textBody,
			int priority, LocalDate startDate, LocalDate endDate, LocalTime remindTime) {
		LocalDate currDate = startDate;
		List<Event> listOfEvent = new ArrayList<>();
		while(currDate.isBefore(endDate)||currDate.isEqual(endDate)) {
			ReminderEvent event = eventFactory.createReminderEvent();
			event.setUserId(userId);
			event.setTitle(title);
			event.setTag(tag);
			event.setTextBody(textBody);
			event.setPriority(priority);
			event.setAssignedDate(currDate);
			event.setRemindTime(remindTime);
			listOfEvent.add(event);
			currDate = currDate.plusDays(1);
		}
		return listOfEvent;
	}

	@Override
	public List<Event> importMeeting(String userId, String title, String tag, String textBody,
			int priority, LocalDate startDate,LocalDate endDate, LocalTime startTime, LocalTime endTime) {
		LocalDate currDate = startDate;
		List<Event> listOfEvent = new ArrayList<>();
		while(currDate.isBefore(endDate)||currDate.isEqual(endDate)) {
			MeetingEvent event = eventFactory.createMeetingEvent();
			event.setUserId(userId);
			event.setTitle(title);
			event.setTag(tag);
			event.setTextBody(textBody);
			event.setPriority(priority);
			event.setAssignedDate(currDate);
			event.setStartTime(startTime);
			event.setEndTime(endTime);
			listOfEvent.add(event);
			currDate = currDate.plusDays(1);
		}
		return listOfEvent;
	}

	@Override
	public List<Event> importTask(String userId, String title, String tag, String textBody,
			int priority, LocalDate assignedDate, boolean isComplete) {
		List<Event> listOfEvent = new ArrayList<>();
		TaskEvent event = eventFactory.createTaskEvent();
		event.setUserId(userId);
		event.setTitle(title);
		event.setTag(tag);
		event.setTextBody(textBody);
		event.setPriority(priority);
		event.setDateAssignedTo(assignedDate);
		event.setComplete(isComplete);
		listOfEvent.add(event);
		return listOfEvent;
	}

	@Override
	public List<Event> importJournal(String userId, String title, String tag, String textBody,
			int priority, LocalDate assignedDate,String imageName) {
		List<Event> listOfEvent = new ArrayList<>();
		JournalEvent event = eventFactory.createJournalEvent();
		event.setUserId(userId);
		event.setTitle(title);
		event.setTag(tag);
		event.setTextBody(textBody);
		event.setPriority(priority);
		event.setImageName(imageName);
		event.setAssignedDate(assignedDate);
		listOfEvent.add(event);
		return listOfEvent;
	}
}
