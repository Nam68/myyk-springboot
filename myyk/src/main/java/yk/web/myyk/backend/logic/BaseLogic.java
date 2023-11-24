package yk.web.myyk.backend.logic;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import yk.web.myyk.backend.BaseMvc;
import yk.web.myyk.backend.dto.form.member.EmailForm;
import yk.web.myyk.backend.factory.RepositoryFactory;
import yk.web.myyk.util.config.MailConfig;
import yk.web.myyk.util.errorCode.ErrorCode;
import yk.web.myyk.util.mail.FreeMarkerFactory;
import yk.web.myyk.util.mail.MailTemplate;
import yk.web.myyk.util.mail.MailText;

public class BaseLogic extends BaseMvc {

    @Autowired
    private MailTemplate mailTemplate;

    @Autowired
    private FreeMarkerFactory freeMarkerFactory;

    @Autowired
    private RepositoryFactory repositoryFactory;

    protected MailTemplate getMailTemplate() {
        return mailTemplate;
    }

    protected MailText getMailText() {
        return getMailTemplate().getTextConfig();
    }

    protected FreeMarkerFactory getFreeMarkerFactory() {
        return freeMarkerFactory;
    }

    protected RepositoryFactory getRepository() {
        return repositoryFactory;
    }

    /**
     * <p>이메일 로컬파트와 도메인을 합쳐서 이메일 주소를 반환한다.</p>
     * 
     * @param emailLocalpart 이메일 로컬파트
     * @param emailDomain 이메일 도메인
     * @return 이메일 주소
     */
    protected String combineEmail(String emailLocalpart, String emailDomain) {
        return emailLocalpart + "@" + emailDomain;
    }

    /**
     * <p>이메일 정보를 통해 이메일 주소를 반환한다.</p>
     * 
     * @param emailForm 이메일 정보
     * @return 이메일 주소
     */
    protected String combineEmail(EmailForm emailForm) {
        return combineEmail(emailForm.getEmailLocalpart(), emailForm.getEmailDomain());
    }

    /**
     * <p>에러 맵에 에러를 설정한다.</p>
     * 
     * @param errors 에러 맵
     * @param error 에러
     */
    protected static void setError(Map<String, ErrorCode> errors, ErrorCode error) {
        errors.put(error.name(), error);
    }
}
