package com.sundera.timewise.domain;

import java.time.LocalDate;

import com.sundera.timewise.export_events.IEventExporter;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;


@Entity
public class JournalEvent extends Event {
	
	@Column(unique = true)
	String imageId;
	
	public JournalEvent() {
		
	}
	JournalEvent(String userId, String title, String tag, String textBody, int priority, String imageName, LocalDate dateAssignedTo) {
		super(userId, title, tag, textBody, priority);
		this.imageId=imageName;
	}
	
	public String getImageName() {
		return imageId;
	}
	public void setImageName(String imageName) {
		this.imageId = imageName;
	}
	@Override
	public <T> T export(IEventExporter<T> visitor) {
		return visitor.exportJournalEvent(userId,title,tag,textBody, priority,assignedDate,imageId);
	}
}
