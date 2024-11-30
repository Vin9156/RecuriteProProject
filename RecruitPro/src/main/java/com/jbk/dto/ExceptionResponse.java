package com.jbk.dto;

import java.sql.Timestamp;

public class ExceptionResponse {

	String username;
	String path;
    Timestamp timestamp;
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPath() {
		return path;
	}
	public void setPath(String path) {
		this.path = path;
	}
	public Timestamp getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(Timestamp timestamp) {
		this.timestamp = timestamp;
	}
	@Override
	public String toString() {
		return "ExceptionResponse [username=" + username + ", path=" + path + ", timestamp=" + timestamp + "]";
	}
	public ExceptionResponse(String username, String path, Timestamp timestamp) {
		super();
		this.username = username;
		this.path = path;
		this.timestamp = timestamp;
	}
	public ExceptionResponse() {
		super();
		// TODO Auto-generated constructor stub
	}
}
