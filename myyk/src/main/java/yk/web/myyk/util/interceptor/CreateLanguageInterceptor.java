package yk.web.myyk.util.interceptor;

import java.util.Locale;

import org.springframework.web.servlet.HandlerInterceptor;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import yk.web.myyk.util.constant.KeyName;
import yk.web.myyk.util.constant.MyLocale;
import yk.web.myyk.util.cookie.CookieUtil;

public class CreateLanguageInterceptor extends BaseInterceptor implements HandlerInterceptor {

    private static final String LANGUAGE_SETTING = "/language/setting";

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {

        // 원래 URL이 언어설정이었다면 그대로 보낸다.
        if (request.getRequestURI().toString().equals(LANGUAGE_SETTING)) {
                return true;
        }
        
        // 세션 언어 정보를 검색해서, 있으면 로컬쿠키에 등록한다
        Locale locale = getSessionAttribute(request, KeyName.LANGUAGE_SETTING, Locale.class);
        if (locale != null && !isResource(request)) { // 이미지 등의 주소도 변환되므로 .이 포함된 URI는 제외한다.
            // 세션 언어 정보가 있는 경우
            // 로컬 쿠키에 등록
            CookieUtil.setCookie(KeyName.LANGUAGE_SETTING_SAVE, MyLocale.toLanguageCode(locale), response);
            setSessionAttribute(request, KeyName.SELECTED_LANGUAGE, MyLocale.toLanguageCode(locale));
            setSessionAttribute(request, KeyName.UNSELECTED_LANGUAGE, MyLocale.toLanguageCode(MyLocale.getOppositeLocale(locale)));
            return true;
        } else {
            // 세션 언어 정보가 없는 경우
            // 로컬 쿠키를 찾는다
            String lang = CookieUtil.getValue(KeyName.LANGUAGE_SETTING_SAVE, request);
            if (lang == null || "".equals(lang)) {
                // 로컬 쿠키 정보마저 없으면 언어설정으로 리다이렉트
                response.sendRedirect(LANGUAGE_SETTING);
                return false;
            } else {
                // 있으면 로컬 쿠키를 통해 세션 언어 정보를 세팅
                setSessionAttribute(request, KeyName.LANGUAGE_SETTING, MyLocale.parseLocale(lang));
                setSessionAttribute(request, KeyName.SELECTED_LANGUAGE, MyLocale.getValidLanguageCode(lang));
                setSessionAttribute(request, KeyName.UNSELECTED_LANGUAGE, MyLocale.getOppositeLocale(lang));
                return true;
            }
        }
    }
}