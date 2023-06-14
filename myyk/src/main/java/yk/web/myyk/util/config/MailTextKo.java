package yk.web.myyk.util.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("classpath:/mail/yaml/mail-template-ko.yaml")
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
	
	public String signupSubject() {
		return signupSubject;
	}
	
	public String signupText() {
		return signupText;
	}
	
	public String signupCode() {
		return signupCode;
	}
	
}
