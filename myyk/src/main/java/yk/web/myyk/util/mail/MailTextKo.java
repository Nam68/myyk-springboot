package yk.web.myyk.util.mail;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

/**
 * <p>메일의 한국어 설정.</p>
 */
@Configuration
@PropertySource("classpath:/mail-template-ko.yaml")
public class MailTextKo implements MailText {

    ///////////////////////////////////////////
    // 회원가입 이메일 확인

    @Value("${signup.ko.subject}")
    private String signupSubject;

    @Value("${signup.ko.text}")
    private String signupText;

    @Value("${signup.ko.code}")
    private String signupCode;

    ///////////////////////////////////////////
    // 회원가입 이메일 확인

    @Override
    @Autowired
    public String signupSubject() {
        return signupSubject;
    }

    @Override
    @Autowired
    public String signupText() {
        return signupText;
    }

    @Override
    @Autowired
    public String signupCode() {
        return signupCode;
    }

}
