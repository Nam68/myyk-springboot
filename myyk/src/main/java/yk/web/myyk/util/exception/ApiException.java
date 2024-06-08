package yk.web.myyk.util.exception;

import java.util.HashMap;
import java.util.Map;

import yk.web.myyk.util.errorCode.ErrorCode;

public class ApiException extends SystemException {

    private static final long serialVersionUID = -6581959397284243711L;

    private String code;

    private String message;

    private Map<String, ErrorCode> errors = new HashMap<>();

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

    public ApiException(Map<String, ErrorCode> errors) {
        super();
        this.errors = errors;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public String getCode() {
        return code;
    }

    public Map<String, ErrorCode> getErrors() {
        return errors;
    }

}
