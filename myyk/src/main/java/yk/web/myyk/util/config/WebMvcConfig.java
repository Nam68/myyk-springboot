package yk.web.myyk.util.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import yk.web.myyk.util.interceptor.AccessCheckInterceptor;
import yk.web.myyk.util.interceptor.AutoLoginInterceptor;
import yk.web.myyk.util.interceptor.BaseInterceptor;
import yk.web.myyk.util.interceptor.CategoryInterceptor;
import yk.web.myyk.util.interceptor.CreateLanguageInterceptor;
import yk.web.myyk.util.interceptor.RegionInterceptor;
import yk.web.myyk.util.interceptor.TaxRateInterceptor;

@Configuration
public class WebMvcConfig implements WebMvcConfigurer {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {

        addInterceptor(registry, createLanguageInterceptor());

//        addInterceptor(registry, categoryInterceptor());

//        addInterceptor(registry, regionInterceptor());

//        addInterceptor(registry, autoLoginInterceptor());

//        addInterceptor(registry, accessCheckInterceptor());

//        addInterceptor(registry, taxRateInterceptor());

//          registry.addInterceptor(new WebContentInterceptor())
//                  .excludePathPatterns("/css/**", "/images/**", "/js/**");
//          
//          // POST 뒤로가기 방지
//          CacheControl cacheControl = CacheControl.maxAge(Duration.ofDays(365));
//      WebContentInterceptor webContentInterceptor = new WebContentInterceptor();
//      webContentInterceptor.addCacheMapping(cacheControl, "/**");
//      registry.addInterceptor(webContentInterceptor);
    }

    private <T extends BaseInterceptor> void addInterceptor(InterceptorRegistry registry, T interceptor) {
        registry.addInterceptor((HandlerInterceptor) interceptor).excludePathPatterns("/css/**", "/img/**", "/js/**");
    }

    @Bean
    public CreateLanguageInterceptor createLanguageInterceptor() {
        return new CreateLanguageInterceptor();
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

    @Bean
    public TaxRateInterceptor taxRateInterceptor() {
        return new TaxRateInterceptor();
    }

}
