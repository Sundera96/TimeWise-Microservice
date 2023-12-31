package com.sundera.timewise.event.dto;
import java.time.LocalDate;
import java.util.List;

import com.google.gson.annotations.SerializedName;

public class JournalEventDto extends EventDto {
	@SerializedName("image-name")
	String imageName;
	
	@SerializedName("date-assigned")
	LocalDate assignedDate;
	
	public LocalDate getAssignedDate() {
		return assignedDate;
	}
	public void setAssignedDate(LocalDate assignedDate) {
		this.assignedDate = assignedDate;
	}
	public String getImageName() {
		return imageName;
	}
	public void setImageName(String imageName) {
		this.imageName = imageName;
	}
	
	@Override
	public <T> List<T> eventImporter(IEventImporter<T> visitor) {
		return visitor.importJournalTreatment(userId,title,tag, textBody, priority, assignedDate, imageName);
	}
}
