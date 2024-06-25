package yk.web.myyk.util.checker;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

import yk.web.myyk.util.constant.MyLocale;
import yk.web.myyk.util.errorCode.ErrorCode;

/**
 * <p>로케일을 검증한다.</p>
 */
public class LocaleChecker extends BaseChecker {

    /**
     * <p>로케일이 올바른 값인지 검증한다.</p>
     *
     * @param locale 로케일
     * @return 에러 리스트
     */
    public static Map<String, ErrorCode> checkValidLocale(Locale locale) {

        Map<String, ErrorCode> errors = new HashMap<>();

        if (locale == null) {
            setError(errors, ErrorCode.LC_101);
            return errors;
        }

        if (!MyLocale.isKorean(locale) && !MyLocale.isJapanese(locale)) {
            setError(errors, ErrorCode.LC_102);
            return errors;
        }

        return errors;
    }
}
