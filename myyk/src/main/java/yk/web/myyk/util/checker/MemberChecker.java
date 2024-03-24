package yk.web.myyk.util.checker;

import java.util.HashMap;
import java.util.Map;

import yk.web.myyk.util.constant.Constant;
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
            return errors;
        }
        if (!emailDomain.contains(".")) {
            setError(errors, ErrorCode.EE_ME_103);
        }
        return errors;
    }

    /**
     * <p>비밀번호를 검증한다.</p>
     *
     * @param password 비밀번호
     * @return 에러 리스트
     */
    public static Map<String, ErrorCode> checkPassword(String password) {

        Map<String, ErrorCode> errors = new HashMap<>();

        if (isEmpty(password)) {
            setError(errors, ErrorCode.EE_ME_106);
            return errors;
        }
        if (password.length() < Constant.getMemberPasswordMin()) {
            setError(errors, ErrorCode.EE_ME_107);
        } else if (password.length() > Constant.getMemberPasswordMax()) {
            setError(errors, ErrorCode.EE_ME_108);
        }
        if (!hasAllCaseAndNumber(password)) {
            setError(errors, ErrorCode.EE_ME_109);
        }
        return errors;
    }

    /**
     * <p>비밀번호 확인을 검증한다.</p>
     *
     * @param password 비밀번호
     * @param passwordCheck 비밀번호 확인
     * @return 에러 리스트
     */
    public static Map<String, ErrorCode> checkPasswordCheck(String password, String passwordCheck) {

        Map<String, ErrorCode> errors = new HashMap<>();

        if (isEmpty(password)) {
            setError(errors, ErrorCode.EE_ME_106);
            return errors;
        }
        if (!password.equals(passwordCheck)) {
            setError(errors, ErrorCode.EE_ME_110);
        }
        return errors;
    }

    /**
     * <p>닉네임을 검증한다.</p>
     *
     * @param nickname 닉네임
     * @return 에러 리스트
     */
    public static Map<String, ErrorCode> checkNickname(String nickname) {

        Map<String, ErrorCode> errors = new HashMap<>();

        if (isEmpty(nickname)) {
            setError(errors, ErrorCode.EE_ME_111);
            return errors;
        }
        if (nickname.length() > Constant.getMemberNicknameMax()) {
            setError(errors, ErrorCode.EE_ME_112);
        }
        return errors;
    }

    /**
     * <p>닉네임 타언어를 검증한다.</p>
     *
     * @param nickname 닉네임 타언어
     * @return 에러 리스트
     */
    public static Map<String, ErrorCode> checkNicknameLang(String nicknameLang) {

        Map<String, ErrorCode> errors = new HashMap<>();

        if (isEmpty(nicknameLang)) {
            setError(errors, ErrorCode.EE_ME_113);
            return errors;
        }
        if (nicknameLang.length() > Constant.getMemberNicknameMax()) {
            setError(errors, ErrorCode.EE_ME_114);
        }
        return errors;
    }

}
