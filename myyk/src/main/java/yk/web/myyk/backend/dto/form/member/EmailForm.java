package yk.web.myyk.backend.dto.form.member;

import yk.web.myyk.backend.dto.form.BaseForm;

public class EmailForm extends BaseForm {

    private String emailLocalpart = "";

    private String emailDomain = "";

    /**
     * <p>이메일 로컬파트를 설정한다.</p>
     * 
     * @param emailLocalpart 이메일 로컬파트
     */
    public void setEmailLocalpart(String emailLocalpart) {
        this.emailLocalpart = emailLocalpart;
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
     * <p>이메일 도메인을 설정한다.</p>
     * 
     * @param emailDomain 이메일 도메인
     */
    public void setEmailDomain(String emailDomain) {
        this.emailDomain = emailDomain;
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
