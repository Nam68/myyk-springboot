package yk.web.myyk.backend.service.login;

import yk.web.myyk.backend.dto.form.login.LoginForm;
import yk.web.myyk.backend.dto.login.LoginInfo;
import yk.web.myyk.util.exception.AppException;
import yk.web.myyk.util.exception.SystemException;

public interface LoginService {

    /**
     * <p>로그인 정보를 반환한다.</p>
     * 
     * @param loginForm 로그인 폼
     * @return 로그인 정보
     * @throws SystemException 시스템에러
     * @throws AppException 앱에러
     */
    public LoginInfo getLoginInfo(LoginForm loginForm) throws SystemException, AppException;
}
