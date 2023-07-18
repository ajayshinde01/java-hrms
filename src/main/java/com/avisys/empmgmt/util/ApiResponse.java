package com.avisys.empmgmt.util;

import java.time.LocalDateTime;

public class ApiResponse {

	private String message;
	private LocalDateTime dateTime;

	public ApiResponse() {
		// TODO Auto-generated constructor stub
	}

	public ApiResponse(String message) {
		super();
		this.message = message;
	}

	public ApiResponse(String message, LocalDateTime dateTime) {
		super();
		this.message = message;
		this.dateTime = dateTime;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public LocalDateTime getDateTime() {
		return dateTime;
	}

	public void setDateTime(LocalDateTime dateTime) {
		this.dateTime = dateTime;
	}

}
