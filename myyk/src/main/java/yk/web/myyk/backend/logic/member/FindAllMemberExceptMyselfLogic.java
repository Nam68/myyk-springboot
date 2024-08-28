package yk.web.myyk.backend.logic.member;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import yk.web.myyk.backend.dto.MemberDTO;
import yk.web.myyk.backend.dto.login.LoginInfo;
import yk.web.myyk.backend.entity.member.MemberEntity;
import yk.web.myyk.backend.logic.BaseLogic;
import yk.web.myyk.backend.service.member.FindAllMemberExceptMyself;
import yk.web.myyk.util.errorCode.ErrorCode;
import yk.web.myyk.util.exception.AppException;
import yk.web.myyk.util.exception.SystemException;

@Service
@Scope(scopeName = ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class FindAllMemberExceptMyselfLogic extends BaseLogic implements FindAllMemberExceptMyself {

    private long memberIdx;

    private List<MemberDTO> memberList;

    @Override
    public void setMemberIdx(long memberIdx) {
        this.memberIdx = memberIdx;
    }

    @Override
    public void validate() throws SystemException, AppException {
        if (!getRepository().getMember().existsById(memberIdx)) {
            throw new SystemException(ErrorCode.LG_101, FindAllMemberExceptMyselfLogic.class);
        }
    }

    @Override
    public void excute() throws SystemException, AppException {
        validate();

        List<MemberEntity> memberEntityList = getRepository().getMember().findAll();
        List<MemberDTO> memberList = new ArrayList<>();

        for (MemberEntity memberEntity : memberEntityList) {
            if (memberEntity.getMemberIdx() != memberIdx) {
                memberList.add(new MemberDTO(memberEntity));
            }
        }
        this.memberList = memberList;
    }

    @Override
    public List<MemberDTO> getMemberList() {
        return memberList;
    }
}
