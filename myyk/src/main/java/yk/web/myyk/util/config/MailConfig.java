package yk.web.myyk.util.config;

import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import yk.web.myyk.util.cookie.CookieUtil;
import yk.web.myyk.util.exception.SystemException;

@Component
public class MailConfig {
	
	@Autowired
	private MailTextKo mailTextKo;
	
	@Autowired
	private MailTextJp mailTextJp;
	
	public MailText getTextConfig() {
		Locale locale = CookieUtil.getLocale();

		if (locale.getLanguage().equals("ko")) {
			return mailTextKo;
		} else if (locale.getLanguage().equals("jp")) {
			return mailTextJp;
		} else {
			throw new SystemException("can not find language setting.");
		}
	}

	@Value("${spring.mail.username}")
	private String adminAddress;

	protected String getAdminAddress() {
		return adminAddress;
	}
}
