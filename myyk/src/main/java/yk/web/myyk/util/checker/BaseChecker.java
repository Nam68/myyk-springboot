package yk.web.myyk.util.checker;

import java.util.Map;

import yk.web.myyk.util.BaseApp;
import yk.web.myyk.util.errorCode.ErrorCode;

/**
 * <p>기본 검증 클래스.</p>
 */
public class BaseChecker extends BaseApp {

    /**
     * <p>문자열이 비어있는지 검증한다.</p>
     * 
     * @param str 문자열
     * @return 에러여부
     */
    protected static boolean isEmpty(String str) {
        if (str == null || "".equals(str)) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * <p>에러 맵에 에러를 설정한다.</p>
     * 
     * @param errors 에러 맵
     * @param error 에러
     */
    protected static void setError(Map<String, ErrorCode> errors, ErrorCode error) {
        errors.put(error.name(), error);
    }

}
