package yk.web.myyk.util.interceptor;

import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.resource.ResourceHttpRequestHandler;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import yk.web.myyk.util.annotation.RegionSetter;
import yk.web.myyk.util.cookie.CookieApp;
import yk.web.myyk.util.enumerated.Region;

/**
 * <p>{@link RegionSetter}가 부착된 메서드의 리퀘스트에 {@link Region}을 세팅하는 인터셉터.</p>
 */
public class RegionInterceptor implements HandlerInterceptor {

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		
		if (!(handler instanceof HandlerMethod)) {
			return true;
		}
		
		HandlerMethod handlerMethod = (HandlerMethod) handler;  
		
		RegionSetter anno = handlerMethod.getMethod().getAnnotation(RegionSetter.class);
		if (anno != null) {
			request.setAttribute(CookieApp.REGION, Region.values());
		}
		return true;
	}
	
}
