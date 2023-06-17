package yk.web.myyk.config;

import java.time.Duration;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.CacheControl;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.mvc.WebContentInterceptor;

import yk.web.myyk.util.interceptor.CategoryInterceptor;
import yk.web.myyk.util.interceptor.LanguageInterceptor;
import yk.web.myyk.util.interceptor.RegionInterceptor;

@Configuration
public class WebMvcConfig implements WebMvcConfigurer {

	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(new LanguageInterceptor())
			.excludePathPatterns("/css/**", "/img/**", "/js/**"); //해당 리소스는 인터셉트하지 않음
		
		registry.addInterceptor(new CategoryInterceptor())
			.excludePathPatterns("/css/**", "/img/**", "/js/**");
		
		registry.addInterceptor(new RegionInterceptor())
			.excludePathPatterns("/css/**", "/img/**", "/js/**");
		
//		registry.addInterceptor(new WebContentInterceptor())
//			.excludePathPatterns("/css/**", "/images/**", "/js/**");
//		
//		// POST 뒤로가기 방지
//		CacheControl cacheControl = CacheControl.maxAge(Duration.ofDays(365));
//	    WebContentInterceptor webContentInterceptor = new WebContentInterceptor();
//	    webContentInterceptor.addCacheMapping(cacheControl, "/**");
//	    registry.addInterceptor(webContentInterceptor);
	}
	
}
