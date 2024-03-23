package yk.web.myyk.backend.logic.login;

import java.util.List;

import org.springframework.stereotype.Service;

import yk.web.myyk.backend.dto.form.login.LoginForm;
import yk.web.myyk.backend.dto.login.LoginInfo;
import yk.web.myyk.backend.entity.member.MemberEntity;
import yk.web.myyk.backend.entity.token.LoginToken;
import yk.web.myyk.backend.logic.BaseLogic;
import yk.web.myyk.backend.service.login.LoginService;
import yk.web.myyk.util.constant.Constant;
import yk.web.myyk.util.errorCode.ErrorCode;
import yk.web.myyk.util.exception.AppException;
import yk.web.myyk.util.exception.SystemException;

@Service
public class LoginLogic extends BaseLogic implements LoginService {

    @Override
    public LoginInfo createLoginInfo(LoginForm loginForm) throws SystemException, AppException {

        List<MemberEntity> memberList = getRepository().getMember().findByEmail(encrypt(loginForm.getEmail()));
        if (memberList.isEmpty() || memberList.size() > 1) {
            throw new AppException(ErrorCode.LE_LG_101);
        }
        MemberEntity member = memberList.get(0);

        int hashingTimes = Constant.getMemberPasswordHashingTimes();
        String loginPassword = hashing(loginForm.getPassword(), member.getPasswordSalt(), hashingTimes);

        if (!loginPassword.equals(member.getPassword())) {
            throw new AppException(ErrorCode.LE_LG_101);
        }

        return member.createLoginInfo();
    }

    @Override
    public String createLoginToken(LoginInfo loginInfo) throws SystemException, AppException {
        List<MemberEntity> memberList = getRepository().getMember().findByEmail(encrypt(loginInfo.getEmail()));
        if (memberList.isEmpty() || memberList.size() > 1) {
            throw new AppException(ErrorCode.LE_LG_101);
        }
        MemberEntity member = memberList.get(0);

        List<LoginToken> tokenList = getRepository().getLoginToken().findAllByMemberMemberIdx(member.getMemberIdx());
        LoginToken token = new LoginToken(member);
        getRepository().getLoginToken().save(token);

        // 저장에 성공한 경우 기존 토큰을 모두 삭제한다
        for (LoginToken oldToken : tokenList) {
            getRepository().getLoginToken().delete(oldToken);
        }

        return token.getTokenId();
    }
}
