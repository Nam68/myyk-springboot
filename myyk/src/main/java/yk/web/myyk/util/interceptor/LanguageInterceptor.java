package yk.web.myyk.util.interceptor;

import java.util.Locale;

import org.springframework.web.servlet.HandlerInterceptor;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import yk.web.myyk.config.MyLocale;
import yk.web.myyk.util.cookie.CookieApp;
import yk.web.myyk.util.cookie.CookieUtil;

public class LanguageInterceptor implements HandlerInterceptor {

	private static final String LANGUAGE_SETTING = "/language/setting";
	
	/**
	 * <p>언어 설정의 URL.</p>
	 * <p>컨테이너 변경 등의 이유로 유지보수가 어려울 수 있으므로 극도로 사용을 제한할 것.</p>
	 * <p>사용하는 경우는 가급적 이 주석에 위치를 기재할 것.</p>
	 * <ul>
	 * <li>LanguageSettingInterceptor</li>
	 * </ul>
	 * 
	 * @return 언어설정 컨테이너의 URL
	 */
	public static String getLanguageSetting() {
		return LANGUAGE_SETTING;
	}
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		
		// 원래 URL이 언어설정이었다면 그대로 보낸다.
		if (request.getRequestURI().toString().equals(LANGUAGE_SETTING)) {
			return true;
		}
		
		// 세션 언어 정보를 검색해서, 있으면 로컬쿠키에 등록한다
		Locale locale = (Locale) request.getSession().getAttribute(CookieApp.LANGUAGE_SETTING);
		if (locale != null && !request.getRequestURI().toString().contains(".")) { // 이미지 등의 주소도 변환되므로 .이 포함된 URI는 제외한다.
			// 세션 언어 정보가 있는 경우
			// 로컬 쿠키에 등록
			CookieUtil.setCookie(CookieApp.LANGUAGE_SETTING_SAVE, MyLocale.toLanguageCode(locale), response);
			return true;
		} else { // 
			// 세션 언어 정보가 없는 경우
			// 로컬 쿠키를 찾는다
			String lang = CookieUtil.getValue(CookieApp.LANGUAGE_SETTING_SAVE, request);
			if (lang == null || "".equals(lang)) {
				// 로컬 쿠키 정보마저 없으면 언어설정으로 리다이렉트
				response.sendRedirect(LanguageInterceptor.getLanguageSetting());
				return false;
			} else {
				// 있으면 로컬 쿠키를 통해 세션 언어 정보를 세팅
				request.getSession().setAttribute(CookieApp.LANGUAGE_SETTING, MyLocale.parseLocale(lang));
				return true;
			}
		}
	}
	
}
