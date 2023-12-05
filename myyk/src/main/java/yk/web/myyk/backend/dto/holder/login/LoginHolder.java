package yk.web.myyk.backend.dto.holder.login;

import yk.web.myyk.backend.dto.form.login.LoginForm;
import yk.web.myyk.backend.dto.holder.BaseHolder;

/**
 * <p>이메일 홀더.</p>
 */
public class LoginHolder extends BaseHolder {

    /**
     * <p>이메일.</p>
     */
    private String email = "";

    /**
     * <p>자동 로그인 여부.</p>
     */
    private boolean autoLogin = false;

    /**
     * <p>생성자.</p>
     */
    public LoginHolder() {
        // nop
    }

    /**
     * <p>생성자.</p>
     * 
     * @param form 로그인 폼
     */
    public LoginHolder(LoginForm form) {
        this.email = form.getEmail();
        this.autoLogin = form.isAutoLogin();
    }

    /**
     * <p>이메일을 반환한다.</p>
     * 
     * @return 이메일
     */
    public String getEmail() {
        return email;
    }

    /**
     * <p>자동 로그인 여부를 반환한다.</p>
     * 
     * @return 자동 로그인 여부
     */
    public boolean isAutoLogin() {
        return autoLogin;
    }
}
