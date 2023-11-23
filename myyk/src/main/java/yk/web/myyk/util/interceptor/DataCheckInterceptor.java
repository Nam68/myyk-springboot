package yk.web.myyk.util.interceptor;

import org.springframework.web.method.HandlerMethod;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import yk.web.myyk.util.annotation.DataCheck;
import yk.web.myyk.util.errorCode.ErrorCode;
import yk.web.myyk.util.exception.SystemException;

/**
 * <p>필수 데이터 클래스(DTO 등)가 세션에 세팅되어 있는지 확인하는 인터셉터.</p>
 */
public class DataCheckInterceptor extends BaseInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {

        HandlerMethod hm = getHandlerMethod(handler);
        if (hm == null) {
            return true;
        }

        DataCheck anno = getAnnotation(DataCheck.class, hm);
        if (anno == null) {
            return true;
        }

        Class<?>[] classList = anno.target();
        HttpSession session = request.getSession();
        for (Class<?> clazz : classList) {
            if (session.getAttribute(clazz.getSimpleName()) == null) {
                throw new SystemException(ErrorCode.IC_102, DataCheckInterceptor.class);
            }
        }
        return true;
    }
}
