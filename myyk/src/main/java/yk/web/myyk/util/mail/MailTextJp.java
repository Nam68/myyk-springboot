package yk.web.myyk.util.mail;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

/**
 * <p>메일의 일본어 언어설정.</p>
 */
@Configuration
@PropertySource("classpath:/mail/yaml/mail-template-jp.yaml")
public class MailTextJp implements MailText {

    ///////////////////////////////////////////
    // 회원가입 이메일 확인

    @Value("${signup.jp.subject}")
    private String signupSubject;
    
    @Value("${signup.jp.text}")
    private String signupText;

    @Value("${signup.jp.code}")
    private String signupCode;
    
    ///////////////////////////////////////////
    // 회원가입 이메일 확인

    @Autowired
    public String signupSubject() {
        return signupSubject;
    }

    @Autowired
    public String signupText() {
        return signupText;
    }

    @Autowired
    public String signupCode() {
        return signupCode;
    }

}
