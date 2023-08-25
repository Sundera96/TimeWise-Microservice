package com.sundera.timewise.event.dto;

import java.time.LocalDate;

import com.google.gson.annotations.SerializedName;

public class JournalEventDto extends EventDto {
	@SerializedName("image-name")
	String imageName;
	
	@SerializedName("date-assigned")
	LocalDate dateAssignedTo;
	
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
	@Override
	public <T> T eventImporter(IEventImporter<T> visitor) {
		return visitor.importJournalTreatment(userId, imageName, imageName, imageName, imageName, priority, imageName, dateAssignedTo);
	}
}
