package com.sundera.timewise.event.util;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.sundera.timewise.event.dto.EventDto;
import com.sundera.timewise.event.dto.JournalEventDto;
import com.sundera.timewise.event.dto.MeetingEventDto;
import com.sundera.timewise.event.dto.ReminderEventDto;
import com.sundera.timewise.event.dto.TaskEventDto;
import com.sundera.timewise.event_view.dto.EventViewDto;
import com.sundera.timewise.event_view.dto.EventViewJournalDto;
import com.sundera.timewise.event_view.dto.EventViewMeetingDto;
import com.sundera.timewise.event_view.dto.EventViewReminderDto;
import com.sundera.timewise.event_view.dto.EventViewTaskDto;

public class GsonFactory {
	public static final String Type_Tag="type-tag";
	public static final String Reminder_Tag = "REMINDER";
	public static final String Meeting_Tag = "MEETING";
	public static final String Task_Tag = "TASK";
	public static final String Journal_Tag = "JOURNAL";
	public static Gson createGson() {
		RuntimeTypeAdapterFactory<EventDto> adapterFactoryEventDto = RuntimeTypeAdapterFactory.of(EventDto.class,Type_Tag)
				.registerSubtype(ReminderEventDto.class,Reminder_Tag)
				.registerSubtype(MeetingEventDto.class,Meeting_Tag)
				.registerSubtype(TaskEventDto.class,Task_Tag)
				.registerSubtype(JournalEventDto.class,Journal_Tag);
		
		RuntimeTypeAdapterFactory<EventViewDto> adapterFactoryEventViewDto = RuntimeTypeAdapterFactory.of(EventViewDto.class,Type_Tag)
				.registerSubtype(EventViewReminderDto.class,Reminder_Tag)
				.registerSubtype(EventViewMeetingDto.class,Meeting_Tag)
				.registerSubtype(EventViewTaskDto.class,Task_Tag)
				.registerSubtype(EventViewJournalDto.class,Journal_Tag);
		
		GsonBuilder gsonBuilder = new GsonBuilder();
		gsonBuilder.setPrettyPrinting()
		.registerTypeAdapter(LocalDate.class, new LocalDateSerializer())
		.registerTypeAdapter(LocalTime.class, new LocalTimeSerializer())
		.registerTypeAdapter(LocalDateTime.class, new LocalDateTimeSerializer())
		.registerTypeAdapterFactory(adapterFactoryEventDto)
		.registerTypeAdapterFactory(adapterFactoryEventViewDto);
		return gsonBuilder.create();
	}
}
