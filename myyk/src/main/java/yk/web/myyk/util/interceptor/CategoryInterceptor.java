package yk.web.myyk.util.interceptor;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import yk.web.myyk.util.annotation.CategorySetter;
import yk.web.myyk.util.cookie.CookieApp;
import yk.web.myyk.util.exception.SystemException;

/**
 * <p>해당 어노테이션이 부착된 컨트롤러가 어떤 기능의 카테고리에 속하는지 결정하는 인터셉터.</p>
 */
public class CategoryInterceptor implements HandlerInterceptor {

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		
		HandlerMethod handlerMethod = (HandlerMethod) handler;  
		
		// API용 컨트롤러면 건너뛰기
		RestController controller = handlerMethod.getBeanType().getAnnotation(RestController.class);
		if(controller != null) {
			return true;
		}
		
		CategorySetter methodCategory = handlerMethod.getMethod().getAnnotation(CategorySetter.class);
		if (methodCategory != null) {
			request.setAttribute(CookieApp.CATEGORY, methodCategory.value().toString());
			return true;
		}
		
		CategorySetter category = handlerMethod.getBeanType().getAnnotation(CategorySetter.class);
		if (category != null) {
			request.setAttribute(CookieApp.CATEGORY, category.value().toString());
			return true;
		}
		
		throw new SystemException("Category Annotation is missing.");
	}
	
}
