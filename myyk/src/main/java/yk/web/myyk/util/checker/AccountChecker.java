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
     * <p>가계부 이름을 검증한다.</p>
     *
     * @param accountName 가계부 이름
     * @return 에러 리스트
     */
    public static Map<String, ErrorCode> checkName(String accountName) {

        Map<String, ErrorCode> errors = new HashMap<>();

        if (isEmpty(accountName)) {
            setError(errors, ErrorCode.EE_AC_101);
            return errors;
        }
        if (accountName.length() > Constant.getAccountNameMax()) {
            setError(errors, ErrorCode.EE_AC_102);
            return errors;
        }
        return errors;
    }
}
