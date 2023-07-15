package yk.web.myyk.util.config;

import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import yk.web.myyk.config.MyLocale;
import yk.web.myyk.util.cookie.CookieUtil;
import yk.web.myyk.util.errorCode.ErrorCode;
import yk.web.myyk.util.exception.SystemException;

@Component
public class MailConfig {
	
	@Autowired
	private MailTextKo mailTextKo;
	
	@Autowired
	private MailTextJp mailTextJp;
	
	public MailText getTextConfig() {
		Locale locale = CookieUtil.getLocale();

		if (MyLocale.isKorean(locale)) {
			return mailTextKo;
		} else if (MyLocale.isJapanese(locale)) {
			return mailTextJp;
		} else {
			throw new SystemException(ErrorCode.CF_102, MailConfig.class);
		}
	}

	@Value("${spring.mail.username}")
	private String adminAddress;

	protected String getAdminAddress() {
		return adminAddress;
	}
}
