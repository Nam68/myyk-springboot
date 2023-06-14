package yk.web.myyk.backend.factory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import yk.web.myyk.backend.repository.MemberRepository;
import yk.web.myyk.backend.repository.TmpCodeRepository;

@Component
@Scope(scopeName = ConfigurableBeanFactory.SCOPE_SINGLETON)
public class RepositoryFactory {
	
	@Autowired
	private MemberRepository memberRepository;
	
	@Autowired
	private TmpCodeRepository tmpCodeRepository;

	public MemberRepository getMember() {
		return memberRepository;
	}
	
	public TmpCodeRepository getTmpCode() {
		return tmpCodeRepository;
	}
	
}
