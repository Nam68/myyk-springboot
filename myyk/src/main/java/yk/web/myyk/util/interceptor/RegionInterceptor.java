package yk.web.myyk.util.interceptor;

import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import yk.web.myyk.config.KeyName;
import yk.web.myyk.util.annotation.RegionSetter;
import yk.web.myyk.util.enumerated.Region;

/**
 * <p>{@link RegionSetter}가 부착된 메서드의 리퀘스트에 {@link Region}을 세팅하는 인터셉터.</p>
 */
public class RegionInterceptor extends BaseInterceptor implements HandlerInterceptor {

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		
		HandlerMethod handlerMethod = getHandlerMethod(handler);
		if (handlerMethod == null) {
			return true;
		}
		
		RegionSetter region = getAnnotation(RegionSetter.class, handlerMethod);
		if (region != null) {
			request.setAttribute(KeyName.REGION, Region.values());
		}
		return true;
	}
	
}
