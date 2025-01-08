package com.vksk.Enotes_Api_Service.exceptions;

import java.util.Map;

public class ValidationException extends RuntimeException {
	private Map<String, String> error;

	public ValidationException(Map<String, String> error) {
		super("validations failed");
		this.error = error;
	}

	public Map<String, String> getError() {
		return error;
	}
}
