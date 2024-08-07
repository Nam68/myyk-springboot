package yk.web.myyk.backend;

import java.util.Locale;

import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import jakarta.servlet.http.HttpSession;
import yk.web.myyk.backend.dto.login.LoginInfo;
import yk.web.myyk.util.BaseApp;
import yk.web.myyk.util.constant.KeyName;
import yk.web.myyk.util.constant.MyLocale;
import yk.web.myyk.util.errorCode.ErrorCode;
import yk.web.myyk.util.exception.SystemException;

public class BaseMvc extends BaseApp {

    /**
     * <p>이메일 배열의 길이(이메일 로컬파트 + 이메일 도메인 = 2)</p>
     */
    private static final int EMAIL_PARTS_NUMBER = 2;

    /**
     * <p>이메일 로컬파트의 배열에서의 위치</p>
     */
    private static final int EMAIL_LOCALPART = 0;

    /**
     * <p>이메일 도메인의 배열에서의 위치</p>
     */
    private static final int EMAIL_DOMAIN = 1;

    /**
     * <p>현재 세션을 반환한다.</p>
     *
     * @return 세션
     */
    private static HttpSession getCurrentSession() {
        ServletRequestAttributes servletRequestAttribute =
                (ServletRequestAttributes) RequestContextHolder.currentRequestAttributes();
        HttpSession httpSession = servletRequestAttribute.getRequest().getSession(true);
        return httpSession;
    }

    /**
     * <p>현재 로그인 정보를 반환한다.</p>
     *
     * @param clazz 메서드를 사용하는 클래스
     * @return 로그인 정보
     */
    protected LoginInfo getLoginInfo(Class<? extends BaseMvc> clazz) {
        HttpSession session = getCurrentSession();
        Object object = session.getAttribute(LOGIN_INFO);

        LoginInfo loginInfo = null;
        if (object != null) {
            try {
                loginInfo = (LoginInfo) object;
            } catch (ClassCastException e) {
                throw new SystemException(ErrorCode.LG_101, clazz);
            }
        }
        return loginInfo;
    }

    /**
     * <p>세션에 설정되어있는 언어값의 문자열을 반환한다.</p>
     *
     * @param clazz 메서드를 사용하는 클래스
     * @return 언어값
     */
    protected String getCurrentLanguage(Class<? extends BaseMvc> clazz) {
        HttpSession session = getCurrentSession();

        Object langObj = session.getAttribute(KeyName.SELECTED_LANGUAGE);
        if (langObj == null) {
            throw new SystemException(ErrorCode.SS_101, clazz);
        }

        try {
            String lang = (String) langObj;
            if (!MyLocale.isKorean(lang) && !MyLocale.isJapanese(lang)) {
                throw new SystemException(ErrorCode.SS_103, clazz);
            }
            return lang;
        } catch (ClassCastException e) {
            throw new SystemException(ErrorCode.SS_102, clazz);
        }
    }

    /**
     * <p>세션에 설정되어있는 로케일을 반환한다.</p>
     *
     * @param clazz 메서드를 사용하는 클래스
     * @return 로케일
     */
    protected Locale getCurrentLocale(Class<? extends BaseMvc> clazz) {
        HttpSession session = getCurrentSession();

        Object langObj = session.getAttribute(KeyName.SELECTED_LANGUAGE);
        if (langObj == null) {
            throw new SystemException(ErrorCode.SS_101, clazz);
        }

        try {
            String lang = (String) langObj;
            if (!MyLocale.isKorean(lang) && !MyLocale.isJapanese(lang)) {
                throw new SystemException(ErrorCode.SS_103, clazz);
            }
            return MyLocale.parseLocale(lang);

        } catch (ClassCastException e) {
            throw new SystemException(ErrorCode.SS_102, clazz);
        }
    }

    /**
     * <p>이메일에서 로컬파트를 반환한다.</p>
     *
     * @param email 이메일
     * @return 이메일 로컬파트
     */
    protected String getEmailLocalpart(String email) {
        return devideEmail(email)[EMAIL_LOCALPART];
    }

    /**
     * <p>이메일에서 도메인을 반환한다.</p>
     *
     * @param email 이메일
     * @return 이메일 도메인
     */
    protected String getEmailDomain(String email) {
        return devideEmail(email)[EMAIL_DOMAIN];
    }

    /**
     * <p>이메일을 분리한다.</p>
     *
     * @param email 이메일
     * @return 분리된 이메일의 문자열 배열
     */
    private String[] devideEmail(String email) {
        String[] emailParts = email.split("@");
        if (emailParts.length != EMAIL_PARTS_NUMBER) {
            throw new SystemException(ErrorCode.EE_ME_103, BaseMvc.class);
        }
        return emailParts;
    }

    protected String getCombinedEmail(String emailLocalpart, String emailDomain) {
        return emailLocalpart + "@" + emailDomain;
    }

}
