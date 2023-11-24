package yk.web.myyk.util.exception;

import java.util.HashMap;
import java.util.Map;

import yk.web.myyk.util.errorCode.ErrorCode;

public class AppException extends RuntimeException {

    private static final long serialVersionUID = -4264415583683358611L;

    private Map<String, ErrorCode> errors = new HashMap<>();

    public AppException(Map<String, ErrorCode> errors) {
        super();
        this.errors = errors;
    }

    public AppException(ErrorCode error) {
        errors.put(error.name(), error);
    }

    /**
     * <p>에러 리스트를 반환한다.</p>
     * 
     * @return 에러 리스트
     */
    public Map<String, ErrorCode> getErrors() {
        return errors;
    }
}
