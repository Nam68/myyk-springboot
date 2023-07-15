package yk.web.myyk.util.exception;

import yk.web.myyk.util.errorCode.ErrorCode;

public class SystemException extends RuntimeException {

	private static final long serialVersionUID = 1376976944120752685L;
	
	private String message;
	
	public SystemException() {
		super();
		this.message = "System failed...!";
	}
	
	public SystemException(String message) {
		super(message);
		this.message = message;
	}
	
	public SystemException(ErrorCode error, Class<?> clazz) {
		String message = ErrorCode.getErrorMessage(error, clazz);
		this.message = message;
	}
	
	public String getMessage() {
		return message;
	}
}
