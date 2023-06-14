package yk.web.myyk.util.cookie;

import java.util.Locale;

import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import jakarta.servlet.http.HttpSession;

public class CookieUtil {

	private static HttpSession getCurrentSession() {
		ServletRequestAttributes servletRequestAttribute = 
				(ServletRequestAttributes) RequestContextHolder.currentRequestAttributes();
	    HttpSession httpSession = servletRequestAttribute.getRequest().getSession(true);
	    return httpSession;
	}
	
	public static Locale getLocale() {
		return (Locale) getCurrentSession().getAttribute(CookieApp.LANGUAGE_SETTING);
	}
	
}
