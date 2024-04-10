package yk.web.myyk.util.checker;

import java.util.HashMap;
import java.util.Map;

import yk.web.myyk.util.constant.Constant;
import yk.web.myyk.util.errorCode.ErrorCode;

/**
 * <p>가계부에 필요한 값을 검증한다.</p>
 */
public class AccountChecker extends BaseChecker {

    /**
     * <p>가계부 이름(한국어)을 검증한다.</p>
     *
     * @param accountBookNameKo 가계부 이름(한국어)
     * @return 에러 리스트
     */
    public static Map<String, ErrorCode> checkAccountBookNameKo(String accountBookNameKo) {

        Map<String, ErrorCode> errors = new HashMap<>();

        if (isEmpty(accountBookNameKo)) {
            setError(errors, ErrorCode.EE_AC_101);
            return errors;
        }
        if (accountBookNameKo.length() > Constant.getBookNameMax()) {
            setError(errors, ErrorCode.EE_AC_102);
            return errors;
        }
        return errors;
    }

    /**
     * <p>가계부 이름(일본어)을 검증한다.</p>
     *
     * @param accountBookNameJp 가계부 이름(일본어)
     * @return 에러 리스트
     */
    public static Map<String, ErrorCode> checkAccountBookNameJp(String accountBookNameJp) {

        Map<String, ErrorCode> errors = new HashMap<>();

        if (isEmpty(accountBookNameJp)) {
            setError(errors, ErrorCode.EE_AC_104);
            return errors;
        }
        if (accountBookNameJp.length() > Constant.getBookNameMax()) {
            setError(errors, ErrorCode.EE_AC_105);
            return errors;
        }
        return errors;
    }
}
