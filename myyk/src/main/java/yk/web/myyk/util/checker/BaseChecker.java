package yk.web.myyk.util.checker;

import yk.web.myyk.util.BaseApp;

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

}
