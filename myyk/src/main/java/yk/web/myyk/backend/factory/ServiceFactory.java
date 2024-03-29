package yk.web.myyk.backend.factory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import yk.web.myyk.backend.service.account.AccountBookService;
import yk.web.myyk.backend.service.account.CategoryService;
import yk.web.myyk.backend.service.external.BootstrapService;
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
	
	@Autowired
	private AccountBookService accountBookService;
	
	@Autowired
	private BootstrapService bootstrapService;
	
	@Autowired
	private CategoryService categoryService;
	
	public EmailService getEmail() {
		return emailService;
	}
	
	public MemberService getMember() {
		return memberService;
	}
	
	public LoginService getLogin() {
		return loginService;
	}
	
	public AccountBookService getAccountBook() {
		return accountBookService;
	}
	
	public BootstrapService getBootstrap() {
		return bootstrapService;
	}
	
	public CategoryService getCategory() {
		return categoryService;
	}
}
