package yk.web.myyk.util.constant;

import java.util.Locale;

import yk.web.myyk.util.errorCode.ErrorCode;
import yk.web.myyk.util.exception.SystemException;

public class MyLocale {

    // ko - 기본 로케일 설정값이지만, 이 어플리케이션에서는 kr를 기본으로 사용하기 때문에 파싱해야 함
    private static final Locale KOREA_KO = Locale.KOREA;

    // kr
    private static final Locale KOREA_KR = new Locale("kr", "KR");

    // ja - 기본 로케일 설정값이지만, 이 어플리케이션에서는 jp를 기본으로 사용하기 때문에 파싱해야 함
    private static final Locale JAPAN_JA = Locale.JAPAN;

    // jp
    private static final Locale JAPAN_JP = new Locale("jp", "JP");

    /**
     * <p>한국어 로케일(kr)을 반환한다.</p>
     *
     * @return 한국어(kr)
     */
    public static Locale getKorean() {
        return KOREA_KR;
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
     * ja > jp // ko > kr</p>
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
     * <li>한국어 코드 : ko, kr &gt; 한국어 로케일(kr)</li>
     * <li>일본어 코드 : ja, jp &gt; 일본어 로케일(jp)</li>
     * </ul>
     *
     * @param lang 언어코드
     * @return 전용 로케일
     */
    public static Locale parseLocale(String lang) {
        String validLang = getValidLanguageCode(lang);
        if (isKorean(validLang)) {
            return getKorean();
        } else if (isJapanese(validLang)) {
            return getJapanese();
        } else {
            throw new SystemException(ErrorCode.CF_102, MyLocale.class);
        }
    }

    /**
     * <p>반대되는 로케일을 가져온다.</p>
     * <ul>
     * <li>한국어를 설정하면 일본어를 반환</li>
     * <li>일본어를 설정하면 한국어를 반환</li>
     * </ul>
     *
     * @param locale 대상 로케일
     * @return 반대되는 로케일
     */
    public static Locale getOppositeLocale(Locale locale) {
        if (isKorean(locale)) {
            return getJapanese();
        } else if (isJapanese(locale)) {
            return getKorean();
        } else {
            throw new SystemException(ErrorCode.CF_102, MyLocale.class);
        }
    }

    /**
     * <p>반대되는 로케일을 가져온다.</p>
     * <ul>
     * <li>한국어를 설정하면 일본어를 반환</li>
     * <li>일본어를 설정하면 한국어를 반환</li>
     * </ul>
     *
     * @param lang 대상 언어코드
     * @return 반대되는 로케일
     */
    public static Locale getOppositeLocale(String lang) {
        return getOppositeLocale(parseLocale(lang));
    }

    /**
     * <p>반대되는 언어코드를 가져온다.</p>
     * <ul>
     * <li>한국어 언어코드를 설정하면 일본어 언어코드를 반환</li>
     * <li>일본어 언어코드를 설정하면 한국어 언어코드를 반환</li>
     * </ul>
     *
     * @param lang 대상 언어코드
     * @return 반대되는 언어코드
     */
    public static String getOppositeLanguageCode(String lang) {
        Locale oppositeLocale = getOppositeLocale(lang);
        return toLanguageCode(oppositeLocale);
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
     * <p>한국어 언어코드가 ko인 경우 kr로, 일본어 언어코드가 ja인 경우 jp로 변환한다.</p>
     *
     * @param lang 언어코드
     * @return 검증된 언어코드
     */
    public static String getValidLanguageCode(String lang) {
        if (KOREA_KR.getLanguage().equals(lang) || JAPAN_JP.getLanguage().equals(lang)) {
            return lang;
        } else if (KOREA_KO.getLanguage().equals(lang)) {
            return KOREA_KR.getLanguage();
        } else if (JAPAN_JA.getLanguage().equals(lang)) {
            return JAPAN_JP.getLanguage();
        } else {
            throw new SystemException(ErrorCode.CF_101, MyLocale.class);
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
        return KOREA_KO.getLanguage().equals(lang) || KOREA_KR.getLanguage().equals(lang);
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
        return JAPAN_JA.getLanguage().equals(lang) || JAPAN_JP.getLanguage().equals(lang);
    }

}

