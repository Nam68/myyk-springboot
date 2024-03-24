package yk.web.myyk.backend.logic.member;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;
import yk.web.myyk.backend.dto.MemberDto;
import yk.web.myyk.backend.entity.member.MemberEntity;
import yk.web.myyk.backend.logic.BaseLogic;
import yk.web.myyk.backend.service.member.CreateMember;
import yk.web.myyk.util.checker.MemberChecker;
import yk.web.myyk.util.enumerated.Region;
import yk.web.myyk.util.errorCode.ErrorCode;
import yk.web.myyk.util.exception.AppException;
import yk.web.myyk.util.exception.SystemException;

@Service
public class CreateMemberLogic extends BaseLogic implements CreateMember {

    // setter

    private String emailLocalpart;

    private String emailDomain;

    private String password;

    private String passwordCheck;

    private String nickname;

    private String nicknameLang;

    private Region region;

    // getter

    private String email;

    @Override
    public void setEmailLocalpart(String emailLocalpart) {
        this.emailLocalpart = emailLocalpart;
    }

    @Override
    public void setEmailDomain(String emailDomain) {
        this.emailDomain = emailDomain;
    }

    @Override
    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public void setPasswordCheck(String passwordCheck) {
        this.passwordCheck = passwordCheck;
    }

    @Override
    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    @Override
    public void setNicknameLang(String nicknameLang) {
        this.nicknameLang = nicknameLang;
    }

    @Override
    public void setRegion(Region region) {
        this.region = region;
    }

    @Override
    public void validate() throws SystemException, AppException {

        Map<String, ErrorCode> errors = new HashMap<>();

        errors.putAll(MemberChecker.checkPassword(password));
        errors.putAll(MemberChecker.checkPasswordCheck(password, passwordCheck));
        errors.putAll(MemberChecker.checkNickname(nickname));
        errors.putAll(MemberChecker.checkNicknameLang(nicknameLang));

        // 중복된 닉네임 검사하기
        List<MemberEntity> nicknameList = getRepository().getMember().findByNickname(nickname);
        if (!nicknameList.isEmpty()) {
            setError(errors, ErrorCode.LE_ME_102);
        }

        // 중복된 닉네임 타언어 검사하기
        List<MemberEntity> nicknameLangList = getRepository().getMember().findByNicknameLang(nicknameLang);
        if (!nicknameLangList.isEmpty()) {
            setError(errors, ErrorCode.LE_ME_103);
        }

        if (!errors.isEmpty()) {
            throw new AppException(errors);
        }
    }

    @Override
    public void excute() throws SystemException, AppException {
        validate();

        String email = combineEmail(emailLocalpart, emailDomain);
        MemberDto dto = new MemberDto(email, password, nickname, nicknameLang, region);

        createMember(dto);
        this.email = email;
    }

    @Override
    public String getEmail() {
        return email;
    }

    @Transactional
    private void createMember(MemberDto dto) {
        MemberEntity entity = new MemberEntity(dto);
        getRepository().getMember().save(entity);
    }

}
