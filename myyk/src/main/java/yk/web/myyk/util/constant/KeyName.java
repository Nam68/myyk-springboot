package yk.web.myyk.util.constant;

import org.springframework.web.servlet.i18n.SessionLocaleResolver;

public class KeyName {

    /**
     * 언어정보
     */

    /**
     * <p>언어 정보 세션키.</p>
     */
    public static final String LANGUAGE_SETTING = SessionLocaleResolver.LOCALE_SESSION_ATTRIBUTE_NAME;

    /**
     * <p>현재 설정된 언어의 세션키.</p>
     */
    public static final String SELECTED_LANGUAGE = "selected_language";

    /**
     * <p>현재 설정되지 않은 언어의 세션키.</p>
     */
    public static final String UNSELECTED_LANGUAGE = "unselected_language";

    /**
     * <p>언어 정보 쿠키를 저장하는 쿠키.(저장하지 않으면 매번 클리어되기 때문)</p>
     */
    public static final String LANGUAGE_SETTING_SAVE = "language_setting_save";

    /**
     * 로그인 정보
     */

    /**
     * <p>로그인 정보</p>
     */
    public static final String LOGIN_INFO = "login_info";

    /**
     * <p>자동 로그인</p>
     */
    public static final String AUTO_LOGIN = "auto_login";
}
