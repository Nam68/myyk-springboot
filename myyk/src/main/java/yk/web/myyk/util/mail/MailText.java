package yk.web.myyk.util.mail;

/**
 * <p>메일 언어 템플레이트.</p>
 */
public interface MailText {

    /**
     * @return 회원가입 임시코드 제목
     */
    public String signupSubject();

    /**
     * @return 회원가입 임시코드 본문
     */
    public String signupText();

    /**
     * @return 회원가입 임시코드 코드안내
     */
    public String signupCode();

}
