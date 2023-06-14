package yk.web.myyk;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
public class MyConfig {

    @Primary
    @Bean
    public freemarker.template.Configuration freemarkerConfiguration() {
        freemarker.template.Configuration freemarkerConfiguration = 
            new freemarker.template.Configuration(freemarker.template.Configuration.VERSION_2_3_31);
        freemarkerConfiguration.setClassForTemplateLoading(this.getClass(), "/mail/");
        return freemarkerConfiguration;
    }
	
}
