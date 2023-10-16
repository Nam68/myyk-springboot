package yk.web.myyk.config;

import org.springframework.web.servlet.i18n.SessionLocaleResolver;

public class KeyName {

	//
	// 세션
	//
	
	/**
	 * <p>언어 정보를 가지고 있는 세션 키.</p>
	 */
	public static final String LANGUAGE_SETTING = SessionLocaleResolver.LOCALE_SESSION_ATTRIBUTE_NAME;
	
	/**
	 * <p>언어 정보를 뷰에서 사용하기 위한 세션 키.</p>
	 */
	public static final String SELECTED_LANGUAGE = "selected_language";
	public static final String UNSELECTED_LANGUAGE = "unselected_language";
	
	//
	// 리퀘스트
	//
	
	/**
	 * <p>지역 정보를 가지고 있는 리퀘스트명.</p>
	 */
	public static final String REGION = "region";
	
	/**
	 * <p>카테고리 정보를 가지고 있는 리퀘스트명.</p>
	 */
	public static final String CATEGORY = "category";
	
	/**
	 * <p>부가세 정보를 가지고 있는 리퀘스트명.</p>
	 */
	public static final String RATE = "rate";
	
	//
	// 쿠키
	//
	
	/**
	 * <p>언어 정보 쿠키를 저장하는 쿠키.(저장하지 않으면 매번 클리어되기 때문)</p>
	 */
	public static final String LANGUAGE_SETTING_SAVE = "language_setting_save";
	
	/**
	 * <p>자동 로그인 정보를 가지고 있는 쿠키.</p>
	 */
	public static final String AUTO_LOGIN = "auto_login";
	
}
