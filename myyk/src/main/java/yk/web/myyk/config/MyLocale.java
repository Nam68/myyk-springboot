package yk.web.myyk.config;

import java.util.Locale;

import yk.web.myyk.util.errorCode.ErrorCode;
import yk.web.myyk.util.exception.SystemException;

public class MyLocale {

	// ko
	private static final Locale KOREA = Locale.KOREA;
	
	// ja - 기본 로케일 설정값이지만, 이 어플리케이션에서는 jp를 기본으로 사용하기 때문에 파싱해야 함
	private static final Locale JAPAN_JA = Locale.JAPAN;
	
	// jp
	private static final Locale JAPAN_JP = new Locale("jp", "JP");
	
	/**
	 * <p>한국어 로케일(ko)을 반환한다.</p>
	 * 
	 * @return 한국어(ko)
	 */
	public static Locale getKorean() {
		return KOREA;
	}
	
	/**
	 * <p>일본어 로케일(jp)을 반환한다.</p>
	 * 
	 * @return 일본어(jp)
	 */
	public static Locale getJapanese() {
		return JAPAN_JP;
	}
	
	/**
	 * <p>기본 로케일을 전용 로케일로 파싱한다.<br>
	 * 주로 ja로 되어 있는 일본어 로케일을 jp로 변형하는 데에 사용된다.</p>
	 * 
	 * @param locale 기본 로케일
	 * @return 전용 로케일
	 */
	public static Locale parseLocale(Locale locale) {
		return parseLocale(locale.getLanguage());
	}
	
	/**
	 * <p>언어 코드를 받아서 전용 로케일을 반환한다.</p>
	 * <ul>
	 * <li>한국어 코드 : ko &gt; 한국어 로케일(ko)</li>
	 * <li>일본어 코드 : ja, jp &gt; 일본어 로케일(jp)</li>
	 * </ul>
	 * 
	 * @param lang 언어코드
	 * @return 전용 로케일
	 */
	public static Locale parseLocale(String lang) {
		if (isKorean(lang)) {
			return getKorean();
		} else if (isJapanese(lang)) {
			return getJapanese();
		} else {
			throw new SystemException(ErrorCode.CF_102, MyLocale.class);
		}
	}
	
	/**
	 * <p>로케일을 언어코드로 변환한다.</p>
	 * <ul>
	 * <li>한국어 로케일(ko) &gt; 한국어 코드 : ko</li>
	 * <li>일본어 로케일(ja, jp) &gt; 일본어 코드 : jp</li>
	 * </ul>
	 * 
	 * @param locale
	 */
	public static String toLanguageCode(Locale locale) {
		if (isKorean(locale)) {
			return getKorean().getLanguage();
		} else if (isJapanese(locale)) {
			return getJapanese().getLanguage();
		} else {
			throw new SystemException(ErrorCode.CF_102, MyLocale.class);
		}
	}
	
	/**
	 * <p>해당 로케일이 한국어 로케일(ko)인지 판단한다.</p>
	 * 
	 * @param locale 로케일
	 * @return 한국어면 true
	 */
	public static boolean isKorean(Locale locale) {
		return isKorean(locale.getLanguage());
	}
	
	/**
	 * <p>해당 언어코드가 한국어 코드(ko)인지 판단한다.</p>
	 * 
	 * @param lang 언어코드
	 * @return 한국어면 true
	 */
	public static boolean isKorean(String lang) {
		if (KOREA.getLanguage().equals(lang)) {
			return true;
		}
		return false;
	}
	
	/**
	 * <p>해당 로케일이 일본어 로케일(ja, jp)인지 판단한다.</p>
	 * 
	 * @param locale 로케일
	 * @return 일본어면 true
	 */
	public static boolean isJapanese(Locale locale) {
		return isJapanese(locale.getLanguage());
	}
	
	/**
	 * <p>해당 언어코드가 일본어 코드(ja, jp)인지 판단한다.</p>
	 * 
	 * @param lang 언어코드
	 * @return 일본어면 true
	 */
	public static boolean isJapanese(String lang) {
		if (JAPAN_JA.getLanguage().equals(lang)
			|| JAPAN_JP.getLanguage().equals(lang)) {
			return true;
		}
		return false;
	}
	
	
}
