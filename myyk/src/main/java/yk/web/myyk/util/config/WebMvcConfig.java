package yk.web.myyk.util.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import yk.web.myyk.util.interceptor.AccessCheckInterceptor;
import yk.web.myyk.util.interceptor.AutoLoginInterceptor;
import yk.web.myyk.util.interceptor.BaseInterceptor;
import yk.web.myyk.util.interceptor.CategoryInterceptor;
import yk.web.myyk.util.interceptor.CreateLanguageInterceptor;
import yk.web.myyk.util.interceptor.DataCheckInterceptor;
import yk.web.myyk.util.interceptor.SessionClearInterceptor;
import yk.web.myyk.util.interceptor.SetEnumInterceptor;

@Configuration
public class WebMvcConfig implements WebMvcConfigurer {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {

        addInterceptor(registry, createLanguageInterceptor());
        addInterceptor(registry, dataCheckInterceptor());
        addInterceptor(registry, setEnumInterceptor());
        addInterceptor(registry, sessionClearInterceptor());
        addInterceptor(registry, autoLoginInterceptor());
        addInterceptor(registry, accessCheckInterceptor());

//        addInterceptor(registry, categoryInterceptor());

//        addInterceptor(registry, accessCheckInterceptor());

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
        registry.addInterceptor(interceptor).excludePathPatterns("/css/**", "/img/**", "/js/**");
    }

    @Bean
    public CreateLanguageInterceptor createLanguageInterceptor() {
        return new CreateLanguageInterceptor();
    }

    @Bean
    public DataCheckInterceptor dataCheckInterceptor() {
        return new DataCheckInterceptor();
    }

    @Bean
    public SetEnumInterceptor setEnumInterceptor() {
        return new SetEnumInterceptor();
    }

    @Bean
    public SessionClearInterceptor sessionClearInterceptor() {
        return new SessionClearInterceptor();
    }

    @Bean
    public AccessCheckInterceptor accessCheckInterceptor() {
        return new AccessCheckInterceptor();
    }




    @Bean
    public CategoryInterceptor categoryInterceptor() {
        return new CategoryInterceptor();
    }

    @Bean
    public AutoLoginInterceptor autoLoginInterceptor() {
        return new AutoLoginInterceptor();
    }

}
