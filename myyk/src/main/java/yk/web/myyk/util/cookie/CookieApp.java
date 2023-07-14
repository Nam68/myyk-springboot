package yk.web.myyk.util.cookie;

import org.springframework.web.servlet.i18n.SessionLocaleResolver;

public class CookieApp {
	
	/**
	 * <p>언어 정보를 가지고 있는 쿠키.</p>
	 */
	public static final String LANGUAGE_SETTING = SessionLocaleResolver.LOCALE_SESSION_ATTRIBUTE_NAME;
	
	/**
	 * <p>언어 정보 쿠키를 저장하는 쿠키.(저장하지 않으면 매번 클리어되기 때문)</p>
	 */
	public static final String LANGUAGE_SETTING_SAVE = "language_setting_save"; 
	
	/**
	 * <p>카테고리 정보를 가지고 있는 쿠키.</p>
	 */
	public static final String CATEGORY = "category";
	
	/**
	 * <p>지역 정보를 가지고 있는 쿠키.</p>
	 */
	public static final String REGION = "region";
	
}
