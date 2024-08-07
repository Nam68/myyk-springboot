package yk.web.myyk.util.cookie;

import java.util.Locale;

import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import yk.web.myyk.util.constant.Constant;
import yk.web.myyk.util.constant.KeyName;
import yk.web.myyk.util.constant.MyLocale;

public class CookieUtil {

    /**
     * <p>현재 세션을 가져온다.</p>
     * 
     * @return 세션
     */
    private static HttpSession getCurrentSession() {
        ServletRequestAttributes servletRequestAttribute = (ServletRequestAttributes) RequestContextHolder.currentRequestAttributes();
        HttpSession httpSession = servletRequestAttribute.getRequest().getSession(true);
        return httpSession;
    }

    /**
     * <p>횬재 로케일을 가져온다.</p>
     * 
     * @return
     */
    public static Locale getLocale() {
        Locale locale = (Locale) getCurrentSession().getAttribute(KeyName.LANGUAGE_SETTING);
        return MyLocale.parseLocale(locale);
    }

    /**
     * <p>쿠키를 설정한다.</p>
     * <p>쿠키 경로를 설정하지 않으면 / 으로 설정된다.</p>
     * <p>시간을 설정하지 않으면 ${value.cookie.defaultTime}로 설정된다.</p>
     * 
     * @param name
     * @param value
     * @param response
     */
    public static void setCookie(String name, String value, HttpServletResponse response) {
        setCookie(name, value, "/", Constant.getCookieDefaultTime(), response);
    }

    /**
     * <p>쿠키를 설정한다.</p>
     * <p>쿠키 경로를 설정하지 않으면 / 으로 설정된다.</p>
     * 
     * @param name 쿠키 이름
     * @param value 쿠키 값
     * @param maxAge 쿠키 유효시간(초)
     * @param response 리스폰스
     */
    public static void setCookie(String name, String value, int maxAge, HttpServletResponse response) {
        setCookie(name, value, "/", maxAge, response);
    }

    /**
     * <p>쿠키를 설정한다.</p>
     * <p>시간을 설정하지 않으면 ${value.cookie.defaultTime}로 설정된다.</p>
     * 
     * @param name 쿠키 이름
     * @param value 쿠키 값
     * @param path 쿠키 경로
     * @param response 리스폰스
     */
    public static void setCookie(String name, String value, String path, HttpServletResponse response) {
        setCookie(name, value, path, Constant.getCookieDefaultTime(), response);
    }

    /**
     * <p>쿠키를 설정한다.</p>
     * 
     * @param name 쿠키 이름
     * @param value 쿠키 값
     * @param path 쿠키 경로
     * @param maxAage 쿠키 유효시간(초)
     * @param response 리스폰스
     */
    public static void setCookie(String name, String value, String path, int maxAage, HttpServletResponse response) {
        Cookie cookie = new Cookie(name, value);
        cookie.setPath(path);
        cookie.setMaxAge(maxAage); //second
        response.addCookie(cookie);
    }

    /**
     * <p>쿠키를 가져온다.</p>
     * 
     * @param name 쿠키 이름
     * @param request 리퀘스트
     * @return 쿠키
     */
    public static Cookie getCookie(String name, HttpServletRequest request) {
        Cookie[] cookies = request.getCookies();
        if (cookies != null) {
            for (Cookie cookie : cookies) {
            String cookieName = cookie.getName();
                if (cookieName.equals(name)) {
                    return cookie;
                }
            }
        }
        return null;
    }

    /**
     * <p>쿠키 값을 가져온다.</p>
     *  
     * @param name 쿠키 이름
     * @param request 리퀘스트
     * @return 쿠키 값
     */
    public static String getValue(String name, HttpServletRequest request) {
        Cookie cookie = getCookie(name, request);
        String value = cookie != null ? cookie.getValue() : "";
        return value;
    }

    /**
     * <p>쿠키를 삭제한다.
     * <br>삭제가 완료되었는지 확인이 필요할 떄 사용한다.</p>
     * 
     * @param name 쿠키 이름
     * @param request 리퀘스트
     * @param response 리스폰스
     * @return 삭제됐으면 true, 대상 쿠키가 없으면 false
     */
    public static boolean deleteCookie(String name, HttpServletRequest request, HttpServletResponse response) {
        Cookie cookie = getCookie(name, request);
        if (cookie == null) {
            return false;
        }
        setCookie(name, null, 0, response);
        return true;
    }

    /**
     * <p>쿠키를 삭제한다.
     * <br>삭제가 완료되었는지 확인하지 않아도 될 때 사용한다.</p>
     * 
     * @param name 쿠키 이름
     * @param response 리스폰스
     */
    public static void deleteCookie(String name, HttpServletResponse response) {
        setCookie(name, null, 0, response);
    }

}
