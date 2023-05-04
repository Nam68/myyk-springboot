package yk.web.myyk.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import yk.web.myyk.util.interceptor.CategoryInterceptor;
import yk.web.myyk.util.interceptor.LanguageInterceptor;

@Configuration
public class WebMvcConfig implements WebMvcConfigurer {

	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(new LanguageInterceptor())
			.excludePathPatterns("/css/**", "/images/**", "/js/**"); //해당 리소스는 인터셉트하지 않음
		
		registry.addInterceptor(new CategoryInterceptor())
			.excludePathPatterns("/css/**", "/images/**", "/js/**");
	}
	
}
