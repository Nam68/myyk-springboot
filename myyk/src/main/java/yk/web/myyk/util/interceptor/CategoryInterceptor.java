package yk.web.myyk.util.interceptor;

import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import yk.web.myyk.util.annotation.CategorySetter;

/**
 * <p>해당 어노테이션이 부착된 컨트롤러가 어떤 기능의 카테고리에 속하는지 결정하는 인터셉터.</p>
 */
public class CategoryInterceptor extends BaseInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {
        
        HandlerMethod handlerMethod = getHandlerMethod(handler);
        if (handlerMethod == null) {
            return true;
        }
        
        CategorySetter category = getAnnotation(CategorySetter.class, handlerMethod);
        if (category != null) {
//            request.setAttribute(KeyName.CATEGORY, category.value().toString());
            return true;
        }
//        request.setAttribute(KeyName.CATEGORY, Category.HOME.getValue());
        return true;    
//      throw new SystemException(ErrorCode.getErrorMessage(ErrorCode.IC_101, getClass()));
    }

}
