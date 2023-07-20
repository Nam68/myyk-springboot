package yk.web.myyk.util.interceptor;

import java.lang.annotation.Annotation;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.method.HandlerMethod;

import jakarta.servlet.http.HttpServletRequest;
import yk.web.myyk.util.BaseApp;

public class BaseInterceptor extends BaseApp {

	private static final String LANGUAGE_SETTING = "/language/setting";
	
	protected static final int BOTH_ANNOTATION = 0;
	protected static final int TYPE_ANNOTATION = 1;
	protected static final int METHOD_ANNOTATION = 2;

	/**
	 * <p>언어 설정의 URL.</p>
	 * <p>컨테이너 변경 등의 이유로 유지보수가 어려울 수 있으므로 극도로 사용을 제한할 것.</p>
	 * <p>사용하는 경우는 가급적 이 주석에 위치를 기재할 것.</p>
	 * <ul>
	 * <li>LanguageInterceptor</li>
	 * </ul>
	 * 
	 * @return 언어설정 컨테이너의 URL
	 */
	protected String getLanguageSetting() {
		return LANGUAGE_SETTING;
	}
	
	/**
	 * <p>해당 리퀘스트의 URI가 리소스에 대한 것인지 판단한다.</p>
	 * 
	 * @param request 리퀘스트
	 * @return 리소스 URI(이미지 등)이면 true
	 */
	protected boolean isResource(HttpServletRequest request) {
		return request.getRequestURI().toString().contains(".");
	}
	
	/**
	 * <p>인터셉터에 필요한 리포지토리가 있는지 확인한다.</p>
	 * 
	 * @param repositories 필수 리포지토리
	 * @return 전부 갖추고 있으면 true
	 */
	protected boolean hasRepositories(JpaRepository<?, ?>... repositories) {
		for (JpaRepository<?, ?> repository : repositories) {
			if (repository == null) {
				return false;
			}
		}
		return true;
	}
	
	/**
	 * <p>검증된 HandlerMethod를 반환한다.</p>
	 * <p>정상적인 컨트롤러의 접근이 아니면 NULL이 반환되므로, NULL을 리턴받았을 경우는 return true를 하는 것이 바람직하다.</p>
	 * <ul>
	 * <li>자원에 대한 핸들러인지</li>
	 * <li>api용 컨트롤러인지</li>
	 * </ul>
	 * 
	 * @return 핸들러
	 */
	protected HandlerMethod getHandlerMethod(Object handler) {
		// 자원에 대한 핸들러면 통과시키기
		if (!(handler instanceof HandlerMethod)) {
			return null;
		}
		HandlerMethod handlerMethod = (HandlerMethod) handler;  
		
		// API용 컨트롤러면 통과시키기
		RestController controller = handlerMethod.getBeanType().getAnnotation(RestController.class);
		if(controller != null) {
			return null;
		}
		return handlerMethod;
	}
	
	/**
	 * <p>지정한 어노테이션을 반환한다.</p>
	 * 
	 * @param <T> 어노테이션
	 * @param annotationClass 어노테이션.class
	 * @param handlerMethod 핸들러메서드
	 * @return 어노테이션
	 */
	protected <T extends Annotation> T getAnnotation(Class<T> annotationClass, HandlerMethod handlerMethod) {
		T annotation = getMethodAnnotation(annotationClass, handlerMethod);
		if (annotation != null) {
			return annotation;
		}
		return getTypeAnnotation(annotationClass, handlerMethod);
	}
	
	// 메서트 타입의 어노테이션이 있으면 반환
	private <T extends Annotation> T getMethodAnnotation(Class<T> annotationClass, HandlerMethod handlerMethod) {
		T annotation = handlerMethod.getMethod().getAnnotation(annotationClass);
		return annotation != null ? annotation : null;
	}
	
	// 타입 타입의 어노테이션이 있으면 반환
	private <T extends Annotation> T getTypeAnnotation(Class<T> annotationClass, HandlerMethod handlerMethod) {
		T annotation = handlerMethod.getBeanType().getAnnotation(annotationClass);
		return annotation != null ? annotation : null;
	}
}
