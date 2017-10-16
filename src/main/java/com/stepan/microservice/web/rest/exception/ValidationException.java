
package com.stepan.microservice.web.rest.exception;

import java.util.Map;

@SuppressWarnings("serial")
public class ValidationException extends RuntimeException {

	private Map<String, String> validationErrors;

	public ValidationException(Map<String, String> validationErrors) {
		super("A validation error.");
		this.validationErrors = validationErrors;
	}

	public Map<String, String> getValidationErrors() {
		return validationErrors;
	}

}