package com.sundera.timewise.domain;

import java.time.LocalDate;
import jakarta.persistence.Entity;


@Entity
public class JournalEvent extends Event {
	String imageName;
	
	public JournalEvent() {
		
	}
	JournalEvent(String userId, String title, String tag, String textBody, int priority, String imageName, LocalDate dateAssignedTo) {
		super(userId, title, tag, textBody, priority);
		this.imageName=imageName;
	}
	
	public String getImageName() {
		return imageName;
	}
	public void setImageName(String imageName) {
		this.imageName = imageName;
	}
	@Override
	public <T> T export(IEventExporter<T> visitor) {
		return visitor.exportJournalEvent(userId,title,tag,textBody, priority,assignedDate,imageName);
	}
}
