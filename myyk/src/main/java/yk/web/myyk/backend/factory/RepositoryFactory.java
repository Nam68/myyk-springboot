package yk.web.myyk.backend.factory;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import yk.web.myyk.backend.entity.member.TmpCodeEntity;
import yk.web.myyk.backend.repository.AutoLoginRepository;
import yk.web.myyk.backend.repository.MemberRepository;
import yk.web.myyk.backend.repository.TmpCodeRepository;
import yk.web.myyk.util.BaseApp;

@Component
@Scope(scopeName = ConfigurableBeanFactory.SCOPE_SINGLETON)
public class RepositoryFactory extends BaseApp {
	
	@Autowired
	private MemberRepository memberRepository;
	
	@Autowired
	private TmpCodeRepository tmpCodeRepository;
	
	@Autowired
	private AutoLoginRepository autoLoginRepository;

	public MemberRepository getMember() {
		return memberRepository;
	}
	
	public TmpCodeRepository getTmpCode() {
		
		if (tmpCodeRepository == null) {
			return tmpCodeRepository;
		}
		
		// 기한이 지난 코드는 삭제
		List<TmpCodeEntity> list = tmpCodeRepository.findAll();
		for (TmpCodeEntity entity : list) {
			if (entity.getRegisterdDate().isBefore(
					LocalDateTime.now().minusMinutes(getConstants().getTmpCodeLImitMinutes()))) {
				tmpCodeRepository.delete(entity);
			}
		}
		return tmpCodeRepository;
	}
	
	public AutoLoginRepository getAutoLogin() {
		return autoLoginRepository;
	}
	
}
