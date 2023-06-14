package yk.web.myyk.util.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

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
