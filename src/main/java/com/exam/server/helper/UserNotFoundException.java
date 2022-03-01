package com.exam.server.helper;

import lombok.Data;

@Data
public class UserNotFoundException extends Exception {
	private String ex;
	public UserNotFoundException(String ex) {
		super(ex);
	}
  
}
