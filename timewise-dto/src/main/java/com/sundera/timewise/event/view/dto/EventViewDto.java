package com.sundera.timewise.event.view.dto;

import java.time.LocalDate;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class EventViewDto {
	String title;
	String tag;
	@SerializedName(value = "event-type")
	@Expose
	String eventType;
	@SerializedName(value="date-assigned")
	@Expose
	LocalDate dateAssigned;
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getTag() {
		return tag;
	}
	public void setTag(String tag) {
		this.tag = tag;
	}
	public String getEventType() {
		return eventType;
	}
	public void setEventType(String eventType) {
		this.eventType = eventType;
	}
	public LocalDate getDateAssigned() {
		return dateAssigned;
	}
	public void setDateAssigned(LocalDate dateAssigned) {
		this.dateAssigned = dateAssigned;
	}
}
