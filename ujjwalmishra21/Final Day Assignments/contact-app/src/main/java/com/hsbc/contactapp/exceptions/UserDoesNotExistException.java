package com.hsbc.contactapp.exceptions;

@SuppressWarnings("serial")
public class UserDoesNotExistException extends Exception {

	public UserDoesNotExistException(String message) {
		super(message);
	}
}
