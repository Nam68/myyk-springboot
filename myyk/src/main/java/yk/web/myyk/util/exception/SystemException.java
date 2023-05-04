package yk.web.myyk.util.exception;

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
	
	public String getMessage() {
		return message;
	}
}
