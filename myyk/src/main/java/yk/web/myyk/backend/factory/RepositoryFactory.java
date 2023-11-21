package yk.web.myyk.backend.factory;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import yk.web.myyk.backend.entity.member.TmpCodeEntity;
import yk.web.myyk.backend.repository.AccountBookAuthRepository;
import yk.web.myyk.backend.repository.AccountBookRepository;
import yk.web.myyk.backend.repository.AccountRepository;
import yk.web.myyk.backend.repository.AutoLoginRepository;
import yk.web.myyk.backend.repository.CategoryRepository;
import yk.web.myyk.backend.repository.MemberRepository;
import yk.web.myyk.backend.repository.SubCategoryOptionRepository;
import yk.web.myyk.backend.repository.CategoryOptionRepository;
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
	
	@Autowired
	private AccountRepository accountRepository;
	
	@Autowired
	private AccountBookRepository accountBookRepository;
	
	@Autowired
	private AccountBookAuthRepository accountBookAuthRepository;
	
	@Autowired
	private CategoryRepository categoryRepository;
	
	@Autowired
	private CategoryOptionRepository categoryOptionRepository;
	
	@Autowired
	private SubCategoryOptionRepository subCategoryOptionRepository;

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
	
	public AccountRepository getAccount() {
		return accountRepository;
	}
	
	public AccountBookRepository getAccountBook() {
		return accountBookRepository;
	}
	
	public AccountBookAuthRepository getAccountBookAuth() {
		return accountBookAuthRepository;
	}
	
	public CategoryRepository getCategory() {
		return categoryRepository;
	}
	
	public CategoryOptionRepository getCategoryOption() {
		return categoryOptionRepository;
	}
	
	public SubCategoryOptionRepository getSubCategoryOption() {
		return subCategoryOptionRepository;
	}
	
}
