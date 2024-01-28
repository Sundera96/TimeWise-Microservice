package com.sundera.timewise.event.dto;
import java.util.List;

import com.google.gson.annotations.SerializedName;

public abstract class EventDto {
	
	String userId;
	
	String title;
	
	String tag;
	
	@SerializedName("type-tag")
	String typeEvent;

	@SerializedName("text-body")
	String textBody;
	
	int priority;

	public abstract <T> List<T> eventImporter(IEventImporter<T> visitor);
	
	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

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

	public String getTextBody() {
		return textBody;
	}

	public void setTextBody(String textBody) {
		this.textBody = textBody;
	}

	public int getPriority() {
		return priority;
	}

	public void setPriority(int priority) {
		this.priority = priority;
	}
	
	public String getTypeEvent() {
		return typeEvent;
	}

	public void setTypeEvent(String typeEvent) {
		this.typeEvent = typeEvent;
	}
}
