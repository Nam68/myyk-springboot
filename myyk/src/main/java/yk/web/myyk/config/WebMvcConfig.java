package yk.web.myyk.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import yk.web.myyk.util.interceptor.AccessCheckInterceptor;
import yk.web.myyk.util.interceptor.AutoLoginInterceptor;
import yk.web.myyk.util.interceptor.CategoryInterceptor;
import yk.web.myyk.util.interceptor.LanguageInterceptor;
import yk.web.myyk.util.interceptor.RegionInterceptor;

@Configuration
public class WebMvcConfig implements WebMvcConfigurer {

	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(languageInterceptor())
			.excludePathPatterns("/css/**", "/img/**", "/js/**"); //해당 리소스는 인터셉트하지 않음
		
		registry.addInterceptor(categoryInterceptor())
			.excludePathPatterns("/css/**", "/img/**", "/js/**");
		
		registry.addInterceptor(regionInterceptor())
			.excludePathPatterns("/css/**", "/img/**", "/js/**");
		
		registry.addInterceptor(autoLoginInterceptor())
			.excludePathPatterns("/css/**", "/img/**", "/js/**");
		
		registry.addInterceptor(accessCheckInterceptor())
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
	
	@Bean
	public LanguageInterceptor languageInterceptor() {
		return new LanguageInterceptor();
	}
	
	@Bean
	public CategoryInterceptor categoryInterceptor() {
		return new CategoryInterceptor();
	}
	
	@Bean
	public RegionInterceptor regionInterceptor() {
		return new RegionInterceptor();
	}
	
	@Bean
	public AutoLoginInterceptor autoLoginInterceptor() {
		return new AutoLoginInterceptor();
	}
	
	@Bean
	public AccessCheckInterceptor accessCheckInterceptor() {
		return new AccessCheckInterceptor();
	}
	
}
