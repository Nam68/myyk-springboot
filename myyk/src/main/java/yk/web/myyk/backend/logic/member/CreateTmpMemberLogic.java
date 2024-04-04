package yk.web.myyk.backend.logic.member;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;
import yk.web.myyk.backend.entity.member.MemberEntity;
import yk.web.myyk.backend.entity.member.TmpCodeEntity;
import yk.web.myyk.backend.logic.BaseLogic;
import yk.web.myyk.backend.service.member.CreateTmpMember;
import yk.web.myyk.util.checker.MemberChecker;
import yk.web.myyk.util.errorCode.ErrorCode;
import yk.web.myyk.util.exception.AppException;
import yk.web.myyk.util.exception.SystemException;

@Service
@Scope(scopeName = ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class CreateTmpMemberLogic extends BaseLogic implements CreateTmpMember {

    private String emailLocalpart;

    private String emailDomain;

    private String tmpCode;

    @Override
    public void setEmailLocalpart(String emailLocalpart) {
        this.emailLocalpart = emailLocalpart;
    }

    @Override
    public void setEmailDomain(String emailDomain) {
        this.emailDomain = emailDomain;
    }

    @Override
    public void validate()throws SystemException, AppException {

        String email = combineEmail(emailLocalpart, emailDomain);

        // 이메일 양식 체크하기
        Map<String, ErrorCode> errors = MemberChecker.checkEmail(emailLocalpart, emailDomain);
        if (!errors.isEmpty()) {
            throw new AppException(errors);
        }

        // 중복된 이메일 검사하기
        List<MemberEntity> memberList = getRepository().getMember().findByEmail(encrypt(email));
        if (!memberList.isEmpty()) {
            throw new AppException(ErrorCode.LE_ME_101);
        }
    }

    @Override
    public void excute() throws SystemException, AppException {
        validate();

        int tmpCodeLength = 6;

        String email = combineEmail(emailLocalpart, emailDomain);
        String tmpCode = getRandomString(tmpCodeLength);

        // 중복된 코드를 생성하지 않음
        while (getRepository().getTmpCode().findByTmpCode(tmpCode).isPresent()) {
            tmpCode = getRandomString(tmpCodeLength);
        }

        createTmpMember(tmpCode, email);
    }

    @Transactional
    private void createTmpMember(String tmpCode, String email) throws SystemException, AppException {
        TmpCodeEntity entity = new TmpCodeEntity(tmpCode, email);
        getRepository().getTmpCode().save(entity);
        this.tmpCode = tmpCode;
    }

    @Override
    public String getTmpCode() {
        return tmpCode;
    }
}
