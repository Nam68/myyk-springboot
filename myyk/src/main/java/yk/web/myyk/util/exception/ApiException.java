package yk.web.myyk.util.exception;

import yk.web.myyk.util.errorCode.ErrorCode;

public class ApiException extends RuntimeException {

	private static final long serialVersionUID = -6581959397284243711L;

	private String message;
	
	public ApiException() {
		super();
		this.message = "System failed...!";
	}
	
	public ApiException(String message) {
		super(message);
		this.message = message;
	}
	
	public ApiException(ErrorCode error, Class<?> clazz) {
		String message = ErrorCode.getErrorMessage(error, clazz);
		this.message = message;
	}
	
	public String getMessage() {
		return message;
	}
	
}
