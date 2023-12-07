package yk.web.myyk.backend.dto.holder.member;

import yk.web.myyk.backend.dto.form.member.EmailForm;
import yk.web.myyk.backend.dto.holder.BaseHolder;

/**
 * <p>이메일 홀더.</p>
 */
public class EmailHolder extends BaseHolder {

    /**
     * <p>이메일 로컬파트.</p>
     */
    private String emailLocalpart = "";

    /**
     * <p>이메일 도메인.</p>
     */
    private String emailDomain = "";

    /**
     * <p>생성자.</p>
     */
    public EmailHolder() {
        // nop
    }

    /**
     * <p>생성자.</p>
     * 
     * @param form 이메일 폼
     */
    public EmailHolder(EmailForm form) {
        this.emailLocalpart = form.getEmailLocalpart();
        this.emailDomain = form.getEmailDomain();
    }

    /**
     * <p>생성자.</p>
     * 
     * @param emailLocalpart 이메일 로컬파트
     * @param emailDomain 이메일 도메인
     */
    public EmailHolder(String emailLocalpart, String emailDomain) {
        this.emailLocalpart = emailLocalpart;
        this.emailDomain = emailDomain;
    }

    /**
     * <p>이메일 로컬파트를 반환한다.</p>
     * 
     * @return 이메일 로컬파트
     */
    public String getEmailLocalpart() {
        return emailLocalpart;
    }

    /**
     * <p>이메일 도메인을 반환한다.</p>
     * 
     * @return 이메일 도메인
     */
    public String getEmailDomain() {
        return emailDomain;
    }

}
