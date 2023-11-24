package yk.web.myyk.backend.dto.holder.member;

import yk.web.myyk.backend.dto.form.member.EmailForm;

public class EmailHolder {

    private String emailLocalpart = "";

    private String emailDomain = "";

    public EmailHolder() {
        // nop
    }

    public EmailHolder(EmailForm form) {
        this.emailLocalpart = form.getEmailLocalpart();
        this.emailDomain = form.getEmailDomain();
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
