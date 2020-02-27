package com.campushiring.services;

import java.util.Date;

public class ErrorMessages {
	
	private Date timestamp;
	private String errorMessages;
	public Date getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(Date timestamp) {
		this.timestamp = timestamp;
	}
	public String getErrorMessages() {
		return errorMessages;
	}
	public void setErrorMessages(String errorMessages) {
		this.errorMessages = errorMessages;
	}
	public ErrorMessages(Date timestamp, String errorMessages) {
		super();
		this.timestamp = timestamp;
		this.errorMessages = errorMessages;
	}
	
	

}
