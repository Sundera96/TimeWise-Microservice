package com.sundera.timewise.domain;

import java.util.UUID;

import jakarta.annotation.Nonnull;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class MediaFile {

	@Id
	@GeneratedValue
	private long id;
	
	@Nonnull
	private UUID name;
	
	@Nonnull
	private String type;
	
	@Nonnull
	private String filePath;
	
	@Nonnull
	private String userId;
	
	
	public MediaFile(){
		
	}
	public MediaFile(UUID name, String type, String filePath, String userId) {
		this.name = name;
		this.type = type;
		this.filePath = filePath;
	}

	public UUID getName() {
		return name;
	}

	public void setName(UUID name) {
		this.name = name;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getFilePath() {
		return filePath;
	}

	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}
	
	
}

