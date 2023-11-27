package yk.web.myyk.backend.dto.holder.member;

import yk.web.myyk.backend.dto.form.member.EmailForm;

public class TmpCodeHolder {

    /**
     * <p>이메일 로컬파트.</p>
     */
    private String emailLocalpart;

    /**
     * <p>이메일 도메인.</p>
     */
    private String emailDomain;

    /**
     * <p>임시코드</p>
     */
    private String tmpCode;

    /**
     * <p>생성자.</p>
     * 
     * @param emailLocalpart 이메일 로컬파트
     * @param emailDomain 이메일 도메인
     * @param tmpCode 임시코드
     */
    public TmpCodeHolder(EmailForm emailForm, String tmpCode) {
        this.emailLocalpart = emailForm.getEmailLocalpart();
        this.emailDomain = emailForm.getEmailDomain();
        this.tmpCode = tmpCode;
    }

    /**
     * <p>이메일 로컬파트를 반환한다.</p>
     * 
     * @return 이메일
     */
    public String getEmailLocalpart() {
        return emailLocalpart;
    }

    /**
     * <p>이메일 도메인을 반환한다.</p>
     * 
     * @return
     */
    public String getEmailDomain() {
        return emailDomain;
    }

    /**
     * <p>임시코드를 반환한다.</p>
     * 
     * @return 임시코드
     */
    public String getTmpCode() {
        return tmpCode;
    }

}
