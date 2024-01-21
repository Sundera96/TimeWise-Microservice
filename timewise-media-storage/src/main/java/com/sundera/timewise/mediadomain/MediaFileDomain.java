package com.sundera.timewise.mediadomain;

import jakarta.annotation.Nonnull;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

public class MediaFileDomain {

	@Id
	@GeneratedValue
	private long id;
	
	
	
	@Nonnull
	private String name;
	
	@Nonnull
	private String type;
	
	@Nonnull
	private String filePath;
	
	

	public MediaFileDomain(String name, String type, String filePath) {
		this.name = name;
		this.type = type;
		this.filePath = filePath;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
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
