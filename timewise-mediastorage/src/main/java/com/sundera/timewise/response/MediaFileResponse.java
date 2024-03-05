package com.sundera.timewise.response;

public class MediaFileResponse {
	private byte[] data;

	private String contentType;
	
	public byte[] getData() {
		return data;
	}

	public void setData(byte[] data) {
		this.data = data;
	}

	public String getContentType() {
		return contentType;
	}

	public void setContentType(String contentType) {
		this.contentType = contentType;
	}
	
	public MediaFileResponse(byte[] data, String contentType) {
		this.data = data;
		this.contentType = contentType;
	}
}
