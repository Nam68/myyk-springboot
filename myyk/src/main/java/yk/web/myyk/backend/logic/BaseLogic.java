package yk.web.myyk.backend.logic;

import org.springframework.beans.factory.annotation.Autowired;

import yk.web.myyk.backend.BaseMvc;
import yk.web.myyk.backend.factory.RepositoryFactory;
import yk.web.myyk.util.mail.MailTemplate;

public class BaseLogic extends BaseMvc {
	
	protected static final String EMAIL_DUPLICATION_ERROR = "error.member.create.email";
	protected static final String NICKNAME_DUPLICATION_ERROR = "error.member.create.nickname";
	
	@Autowired
	private MailTemplate mailTemplate;
	
	@Autowired
	private RepositoryFactory repositoryFactory;
	
	protected MailTemplate getMailTemplate() {
		return mailTemplate;
	}
	
	protected RepositoryFactory getRepository() {
		return repositoryFactory;
	}
}
