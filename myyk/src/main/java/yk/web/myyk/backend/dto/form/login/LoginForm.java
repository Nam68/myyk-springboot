package yk.web.myyk.backend.dto.form.login;

import yk.web.myyk.backend.dto.form.BaseForm;

/**
 * <p>로그인 폼.</p>
 */
public class LoginForm extends BaseForm {

    /**
     * <p>이메일.</p>
     */
    private String email = "";

    /**
     * <p>비밀번호.</p>
     */
    private String password = "";

    /**
     * <p>자동 로그인.</p>
     */
    private boolean autoLogin = false;

    /**
     * <p>이메일을 반환한다.</p>
     * 
     * @return 이메일
     */
    public String getEmail() {
        return email;
    }

    /**
     * <p>이메일을 설정한다.</p>
     * 
     * @param email 이메일
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * <p>비밀번호를 반환한다.</p>
     * 
     * @return 비밀번호
     */
    public String getPassword() {
        return password;
    }

    /**
     * <p>비밀번호 설정한다.</p>
     * 
     * @param password 비밀번호
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * <p>자동 로그인 여부를 반환한다.</p>
     * 
     * @return 자동 로그인 여부
     */
    public boolean isAutoLogin() {
        return autoLogin;
    }

    /**
     * <p>자동 로그인 여부를 설정한다.</p>
     * 
     * @param autoLogin 자동 로그인 여부
     */
    public void setAutoLogin(boolean autoLogin) {
        this.autoLogin = autoLogin;
    }
}
