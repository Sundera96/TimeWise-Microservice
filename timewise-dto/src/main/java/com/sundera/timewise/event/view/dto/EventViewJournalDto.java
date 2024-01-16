package com.sundera.timewise.event.view.dto;

import com.google.gson.annotations.SerializedName;

public class EventViewJournalDto extends EventViewDto {
	@SerializedName("image-name")
	String imageName;

	public String getImageName() {
		return imageName;
	}

	public void setImageName(String imageName) {
		this.imageName = imageName;
	}
}
