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
     * @return 검증결과
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

    /**
     * <p>문자열이 숫자를 포함하는지 검증한다.</p>
     *
     * @param str 문자열
     * @return 검증결과
     */
    protected static boolean hasNumber(String str) {

        boolean result = false;

        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (c >= '0' && c <= '9') {
                result = true;
                break;
            }
        }

        return result;
    }

    /**
     * <p>문자열이 대문자를 포함하는지 검증한다.</p>
     *
     * @param str 문자열
     * @return 검증결과
     */
    protected static boolean hasUpperCase(String str) {

        boolean result = false;

        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (c >= 'A' && c <= 'Z') {
                result = true;
                break;
            }
        }

        return result;

    }

    /**
     * <p>문자열이 소문자를 포함하는지 검증한다.</p>
     *
     * @param str 문자열
     * @return 검증결과
     */
    protected static boolean hasLowerCase(String str) {

        boolean result = false;

        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (c >= 'a' && c <= 'z') {
                result = true;
                break;
            }
        }

        return result;
    }

    /**
     * <p>문자열이 대소문자와 숫자를 모두 포함하는지 검증한다.</p>
     *
     * @param str 문자열
     * @return 검증결과
     */
    protected static boolean hasAllCaseAndNumber(String str) {

        boolean number = hasNumber(str);
        boolean upper = hasUpperCase(str);
        boolean lower = hasLowerCase(str);

        return number && upper && lower;
    }

    /**
     * <p>컬러코드 형식에 맞는지 검증한다.</p>
     *
     * @param str 문자열
     * @return 검증결과
     */
    protected static boolean isCorrectColorCode(String str) {

        String colorCodeExample = "#AAAAAA";

        char firstChar = str.charAt(0);
        if (firstChar != colorCodeExample.charAt(0)) {
            return false;
        }

        if (str.length() != colorCodeExample.length()) {
            return false;
        }
        return true;
    }

    /**
     * <p>제한을 넘었는지 검증한다.
     * <br>제한을 넘는다면 true를 반환한다.
     * <br>제한과 동률이어도 true를 반환한다.</p>
     *
     * @param limit 제한
     * @param targetLength 대상 숫자
     * @return
     */
    protected static boolean isWithoutLimit(int limit, int targetLength) {

        if (limit <= targetLength) {
            return true;
        }
        return false;
    }

}
