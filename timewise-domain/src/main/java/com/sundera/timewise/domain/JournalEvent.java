package com.sundera.timewise.domain;

import java.time.LocalDate;
import java.util.UUID;

import jakarta.persistence.Entity;


@Entity
public class JournalEvent extends Event {
	String imageName;
	LocalDate dateAssignedTo;
	
	public JournalEvent() {
		
	}
	JournalEvent(UUID userId, String title, String tag, String textBody, int priority, String imageName, LocalDate dateAssignedTo) {
		super(userId, title, tag, textBody, priority);
		this.imageName=imageName;
		this.dateAssignedTo=dateAssignedTo;
	}
	
	public String getImageName() {
		return imageName;
	}
	public void setImageName(String imageName) {
		this.imageName = imageName;
	}
	public LocalDate getDateAssignedTo() {
		return dateAssignedTo;
	}
	public void setDateAssignedTo(LocalDate dateAssignedTo) {
		this.dateAssignedTo = dateAssignedTo;
	}
}
