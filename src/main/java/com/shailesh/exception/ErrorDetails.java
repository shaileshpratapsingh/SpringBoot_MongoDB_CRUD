package com.shailesh.exception;

import java.util.Date;

/**
 * 
 * @author Shailesh
 *
 */
public class ErrorDetails {
	
	private Date timestamp;
	private String message;
	private String data;
	private Boolean status;

	public ErrorDetails(Date timestamp, String message, String data, Boolean status) {
		super();
		this.timestamp = timestamp;
		this.message = message;
		this.data = data;
		this.status = status;
	}

	public Date getTimestamp() {
		return timestamp;
	}

	public String getMessage() {
		return message;
	}

	public String getData() {
		return data;
	}
	
	public Boolean getStatus() {
		return status;
	}
}
