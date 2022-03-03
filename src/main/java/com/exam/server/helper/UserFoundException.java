package com.exam.server.helper;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserFoundException extends RuntimeException {
	private String ex;


	public UserFoundException(String ex) {
		super(ex);
	}
	
	public UserFoundException() {
		super("user is already present in database..");
	}

}
