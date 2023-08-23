package com.sundera.timewise.domain;

import java.time.LocalDate;
import java.util.UUID;

import jakarta.persistence.Entity;

@Entity
public class TaskEvent extends Event {
	LocalDate dateAssignedTo;
	boolean isComplete;
	
	TaskEvent(){
		
	}
	TaskEvent(UUID userId, String title, String tag, String textBody, int priority, LocalDate dateAssignedTo, boolean isComplete) {
		super(userId, title, tag, textBody, priority);
		this.dateAssignedTo=dateAssignedTo;
		this.isComplete=isComplete;
	}
	
	public LocalDate getDateAssignedTo() {
		return dateAssignedTo;
	}
	public void setDateAssignedTo(LocalDate dateAssignedTo) {
		this.dateAssignedTo = dateAssignedTo;
	}
	public boolean isComplete() {
		return isComplete;
	}
	public void setComplete(boolean isComplete) {
		this.isComplete = isComplete;
	}
}
