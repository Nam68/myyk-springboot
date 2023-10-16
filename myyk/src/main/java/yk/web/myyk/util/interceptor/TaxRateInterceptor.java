package yk.web.myyk.util.interceptor;

import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import yk.web.myyk.config.KeyName;
import yk.web.myyk.util.annotation.TaxRateSetter;
import yk.web.myyk.util.enumerated.TaxRate;


/**
 * <p>{@link TaxRateSetter}가 부착된 메서드의 리퀘스트에 {@link TaxRate}을 세팅하는 인터셉터.</p>
 */
public class TaxRateInterceptor extends BaseInterceptor implements HandlerInterceptor {

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		HandlerMethod handlerMethod = getHandlerMethod(handler);
		if (handlerMethod == null) {
			return true;
		}
		
		TaxRateSetter anno = getAnnotation(TaxRateSetter.class, handlerMethod);
		if (anno != null) {
			request.setAttribute(KeyName.RATE, TaxRate.values());
		}
		return true;
	}
}
