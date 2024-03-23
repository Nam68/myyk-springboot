package yk.web.myyk.util.checker;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import yk.web.myyk.util.constant.Constant;
import yk.web.myyk.util.errorCode.ErrorCode;

/**
 * <p>가계부에 필요한 값을 검증한다.</p>
 */
public class AccountChecker extends BaseChecker {

    public static Map<String, ErrorCode> checkName(String name, List<String> accountNameList) {

        Map<String, ErrorCode> errors = new HashMap<>();

        if (isEmpty(name)) {
            setError(errors, ErrorCode.EE_AC_101);
            return errors;
        }
        if (name.length() > Constant.getAccountNameMax()) {
            setError(errors, ErrorCode.EE_AC_102);
            return errors;
        }
        for (String accountName : accountNameList) {
            if (accountName.equals(name)) {
                setError(errors, ErrorCode.EE_AC_103);
            }
        }
        return errors;
    }
}
