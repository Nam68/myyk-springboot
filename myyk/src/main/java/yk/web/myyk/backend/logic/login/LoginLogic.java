package yk.web.myyk.backend.logic.login;

import java.util.List;

import org.springframework.stereotype.Service;

import jakarta.servlet.http.HttpSession;
import yk.web.myyk.backend.dto.form.login.LoginForm;
import yk.web.myyk.backend.dto.login.AdminInfo;
import yk.web.myyk.backend.dto.login.LoginInfo;
import yk.web.myyk.backend.dto.login.MemberInfo;
import yk.web.myyk.backend.entity.member.MemberEntity;
import yk.web.myyk.backend.logic.BaseLogic;
import yk.web.myyk.backend.service.login.LoginService;
import yk.web.myyk.util.constant.Constant;
import yk.web.myyk.util.enumerated.MemberType;
import yk.web.myyk.util.errorCode.ErrorCode;
import yk.web.myyk.util.exception.AppException;
import yk.web.myyk.util.exception.SystemException;

@Service
public class LoginLogic extends BaseLogic implements LoginService {

    @Override
    public LoginInfo getLoginInfo(LoginForm loginForm) throws SystemException, AppException {

        List<MemberEntity> memberList = getRepository().getMember().findAllByEmail(encrypt(loginForm.getEmail()));
        if (memberList == null || memberList.isEmpty() || memberList.size() > 1) {
            throw new AppException(ErrorCode.LE_LG_101);
        }

        MemberEntity member = memberList.get(0);

        int hashingTimes = Constant.getMemberPasswordHashingTimes();
        String loginPassword = hashing(loginForm.getPassword(), member.getPasswordSalt(), hashingTimes);

        if (!loginPassword.equals(member.getPassword())) {
            throw new AppException(ErrorCode.LE_LG_101);
        }

        LoginInfo loginInfo = null;
        if (member.getMemberType().equals(MemberType.ADMIN)) {
            loginInfo = new AdminInfo();
        } else {
            loginInfo = new MemberInfo();
        }
        loginInfo.setByLoginForm(member);

        return loginInfo;
    }
}
