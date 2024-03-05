package com.sundera.timewise.domain;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name="event_media_file")
public class MediaFile {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@NotNull
	private String name;
	
	@NotNull
	private String type;
	
	@NotNull
	private String userId;
	
	boolean isActive;
	
	public MediaFile(){
		
	}
	
	public MediaFile(@NotNull String name, @NotNull String type, @NotNull String userId) {
		this.name = name;
		this.type = type;
		this.userId = userId;
	}
	
	public int getId() {
		return id;
	}



	public void setId(int id) {
		this.id = id;
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


	public String getUserId() {
		return userId;
	}



	public void setUserId(String userId) {
		this.userId = userId;
	}	
}