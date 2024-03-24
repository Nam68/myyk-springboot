package yk.web.myyk.backend.service.login;

import yk.web.myyk.backend.dto.login.LoginInfo;
import yk.web.myyk.backend.service.BaseService;

public interface Login extends BaseService {

    /**
     * <p>이메일을 설정한다.</p>
     *
     * @param email 이메일
     */
    public void setEmail(String email);

    /**
     * <p>비밀번호를 설정한다.</p>
     *
     * @param password 비밀번호
     */
    public void setPassword(String password);

    /**
     * <p>자동 로그인을 설정한다.</p>
     *
     * @param autoLogin 자동 로그인
     */
    public void setAutoLogin(boolean autoLogin);

    /**
     * <p>로그인 정보를 반환한다.</p>
     *
     * @return 로그인 정보
     */
    public LoginInfo getCreatedLoginInfo();

    /**
     * <p>로그인 토큰 아이디를 반환한다.</p>
     *
     * @return 로그인 토큰 아이디
     */
    public String getCreatedTokenId();
}
