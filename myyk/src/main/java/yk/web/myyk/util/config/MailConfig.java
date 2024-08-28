package yk.web.myyk.util.config;

import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import yk.web.myyk.util.constant.MyLocale;
import yk.web.myyk.util.cookie.CookieUtil;
import yk.web.myyk.util.errorCode.ErrorCode;
import yk.web.myyk.util.exception.SystemException;
import yk.web.myyk.util.mail.MailText;
import yk.web.myyk.util.mail.MailTextJp;
import yk.web.myyk.util.mail.MailTextKr;

/**
 * <p>메일 설정.
 * <ul>
 * <li>관리자 주소</li>
 * <li>메일 언어 설정(다언어 대응)</li>
 * </ul>
 * </p>
 */
@Component
public class MailConfig {

    @Autowired
    private MailTextKr mailTextKo;

    @Autowired
    private MailTextJp mailTextJp;

    @Value("${spring.mail.username}")
    private String adminAddress;

    /**
     * <p>메일 언어 설정을 가져온다.</p>
     *
     * @return 메일 언어 설정
     */
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

    /**
     * <p>관리자 주소를 가져온다.</p>
     *
     * @return 관리자 주소.
     */
    protected String getAdminAddress() {
        return adminAddress;
    }
}
