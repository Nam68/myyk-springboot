package yk.web.myyk.util.interceptor;

import java.util.Enumeration;

import org.springframework.web.method.HandlerMethod;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import yk.web.myyk.backend.dto.form.BaseForm;
import yk.web.myyk.util.annotation.SessionClear;

/**
 * <p>세션에 있는 모든 폼 데이터를 삭제하는 인터셉터.</p>
 */
public class SessionClearInterceptor extends BaseInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {

        HandlerMethod hm = getHandlerMethod(handler);
        if (hm == null) {
            return true;
        }

        SessionClear anno = getAnnotation(SessionClear.class, hm);
        if (anno == null) {
            return true;
        }

        HttpSession session = request.getSession();
        Enumeration<String> nameList = session.getAttributeNames();

        while (nameList.hasMoreElements()) {
            String name = nameList.nextElement();
            if (session.getAttribute(name) instanceof BaseForm) {
                session.removeAttribute(name);
            }
        }
        return true;
    }
}
