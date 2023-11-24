package yk.web.myyk.util.checker;

import java.util.HashMap;
import java.util.Map;

import yk.web.myyk.util.errorCode.ErrorCode;

/**
 * <p>회원에 필요한 값을 검증한다.</p>
 */
public class MemberChecker extends BaseChecker {

    /**
     * <p>이메일을 검증한다.</p>
     * 
     * @param emailLocalpart 이메일 로컬파트
     * @param emailDomain 이메일 도메인
     * @return 에러 리스트
     */
    public static Map<String, ErrorCode> checkEmail(String emailLocalpart, String emailDomain) {

        Map<String, ErrorCode> errors = new HashMap<>();

        if (isEmpty(emailLocalpart)) {
            setError(errors, ErrorCode.EE_ME_101);
        }
        if (isEmpty(emailDomain)) {
            setError(errors, ErrorCode.EE_ME_102);
        }
        if (!emailDomain.contains(".")) {
            setError(errors, ErrorCode.EE_ME_103);
        }
        return errors;
    }

}
