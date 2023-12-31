package com.sundera.timewise.domain;

import java.time.LocalDate;
import java.util.UUID;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name="event")
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Event {
	
	@Id 
	@GeneratedValue
	protected UUID id;

	@Column(nullable = false)
	UUID userId;
	
	@NotNull
	String title;
	
	String tag;
	
	String textBody;
	
	@Min(value = 1)
	@Max(value = 3)
	protected int priority;
	
	LocalDate assignedDate;
	
	@ManyToOne
	@JoinColumn(name="series_id")
	EventSeries series;


	Event(){
		
	}
	
	Event(UUID userId, String title, String tag,String textBody, int priority){
		this.userId=userId;
		this.title=title;
		this.tag=tag;
		this.textBody=textBody;
		this.priority=priority;
	}
	
	public UUID getUserId() {
		return userId;
	}

	public void setUserId(UUID userId) {
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
	
	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
	}
	
	public abstract <T> T export (IEventExporter<T> visitor);
	
	public LocalDate getAssignedDate() {
		return assignedDate;
	}

	public void setAssignedDate(LocalDate assignedDate) {
		this.assignedDate = assignedDate;
	}
	
	public EventSeries getSeries() {
		return series;
	}

	public void setSeries(EventSeries series) {
		this.series = series;
	}
}

