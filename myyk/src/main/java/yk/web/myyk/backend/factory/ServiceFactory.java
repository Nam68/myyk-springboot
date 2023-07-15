package yk.web.myyk.backend.factory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import yk.web.myyk.backend.service.member.EmailService;
import yk.web.myyk.backend.service.member.LoginService;
import yk.web.myyk.backend.service.member.MemberService;

@Component
@Scope(scopeName = ConfigurableBeanFactory.SCOPE_SINGLETON)
public class ServiceFactory {
	
	@Autowired
	private EmailService emailService;
	
	@Autowired
	private MemberService memberService;
	
	@Autowired
	private LoginService loginService;
	
	public EmailService getEmail() {
		return emailService;
	}
	
	public MemberService getMember() {
		return memberService;
	}
	
	public LoginService getLogin() {
		return loginService;
	}
	
}
