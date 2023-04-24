package yk.web.myyk.util.interceptor;

import java.util.Locale;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import yk.web.myyk.util.cookie.CookieApp;

public class LanguageInterceptor implements HandlerInterceptor {

	private static final String LANGUAGE_SETTING = "/language/setting";
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		
		// 원래 URL이 언어설정이었다면 그대로 보낸다.
		if (request.getRequestURI().toString().equals(LANGUAGE_SETTING)) {
			return true;
		}
		
		// 자동으로 설정되는 쿠키가 없어도 강제로 언어설정으로 보낸다.
		Locale locale = (Locale) request.getSession().getAttribute(CookieApp.LANGUAGE_SETTING);
		if (locale == null && !request.getRequestURI().toString().contains(".")) { // 이미지 등의 주소도 변환되므로 .이 포함된 URI는 제외한다.
			response.sendRedirect(LANGUAGE_SETTING);
			return false;
		}
		
		return true;
	}
	
}
