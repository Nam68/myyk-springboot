package yk.web.myyk.backend.logic.login;

import java.util.List;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import yk.web.myyk.backend.dto.login.LoginInfo;
import yk.web.myyk.backend.entity.member.MemberEntity;
import yk.web.myyk.backend.entity.token.LoginToken;
import yk.web.myyk.backend.logic.BaseLogic;
import yk.web.myyk.backend.service.login.Login;
import yk.web.myyk.util.constant.Constant;
import yk.web.myyk.util.errorCode.ErrorCode;
import yk.web.myyk.util.exception.AppException;
import yk.web.myyk.util.exception.SystemException;

@Service
@Scope(scopeName = ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class LoginLogic extends BaseLogic implements Login {

    private String email;

    private String password;

    private boolean autoLogin;

    private MemberEntity member;

    private LoginInfo loginInfo;

    private String tokenId;

    @Override
    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public void setAutoLogin(boolean autoLogin) {
        this.autoLogin = autoLogin;
    }

    @Override
    public void validate() throws SystemException, AppException {

        // 입력값이 빈 값인지 검사
        if (email == null || "".equals(email)) {
            throw new AppException(ErrorCode.LE_LG_101);
        }
        if (password == null || "".equals(password)) {
            throw new AppException(ErrorCode.LE_LG_101);
        }

        // 해당 이메일을 사용하는 회원이 있는지 검사
        List<MemberEntity> memberList = getRepository().getMember().findByEmail(encrypt(email));
        if (memberList.isEmpty() || memberList.size() > 1) {
            throw new AppException(ErrorCode.LE_LG_101);
        }

        // 비밀번호가 일치하는지 검사
        MemberEntity member = memberList.get(0);
        int hashingTimes = Constant.getMemberPasswordHashingTimes();
        String loginPassword = hashing(password, member.getPasswordSalt(), hashingTimes);
        if (!loginPassword.equals(member.getPassword())) {
            throw new AppException(ErrorCode.LE_LG_101);
        }

        // 이상이 없는 경우 클래스 변수에 세팅
        this.member = member;
    }

    @Override
    public void excute() throws SystemException, AppException {
        validate();

        // 로그인 토큰 생성
        if (autoLogin) {
            List<LoginToken> tokenList = getRepository().getLoginToken().findAllByMemberMemberIdx(member.getMemberIdx());
            LoginToken token = new LoginToken(member);
            getRepository().getLoginToken().save(token);

            // 저장에 성공한 경우 기존 토큰을 모두 삭제한다
            for (LoginToken oldToken : tokenList) {
                getRepository().getLoginToken().delete(oldToken);
            }

            this.tokenId = token.getTokenId();
        }

        this.loginInfo = member.createLoginInfo();
    }

    @Override
    public LoginInfo getCreatedLoginInfo() {
        return loginInfo;
    }

    @Override
    public String getCreatedTokenId() {
        return tokenId;
    }
}
