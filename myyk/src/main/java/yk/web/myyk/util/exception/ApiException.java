package yk.web.myyk.util.exception;

import yk.web.myyk.util.errorCode.ErrorCode;

public class ApiException extends SystemException {

    private static final long serialVersionUID = -6581959397284243711L;

    private String code;

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
        this.code = error.name();
        this.message = ErrorCode.getErrorMessage(error, clazz);
    }

    @Override
    public String getMessage() {
        return message;
    }

    public String getCode() {
        return code;
    }

}
