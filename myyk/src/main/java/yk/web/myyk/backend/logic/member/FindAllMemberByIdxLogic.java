package yk.web.myyk.backend.logic.member;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import yk.web.myyk.backend.dto.MemberDTO;
import yk.web.myyk.backend.entity.member.MemberEntity;
import yk.web.myyk.backend.logic.BaseLogic;
import yk.web.myyk.backend.service.member.FindAllMemberByIdx;
import yk.web.myyk.util.errorCode.ErrorCode;
import yk.web.myyk.util.exception.AppException;
import yk.web.myyk.util.exception.SystemException;

@Service
@Scope(scopeName = ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class FindAllMemberByIdxLogic extends BaseLogic implements FindAllMemberByIdx {

    private List<Long> memberIdxList;

    private List<MemberDTO> memberList;

    @Override
    public void setMemberIdxList(List<Long> memberIdxList) {
        this.memberIdxList = memberIdxList;
    }

    @Override
    public void validate() throws SystemException, AppException {

        List<MemberEntity> memberEntityList = getRepository().getMember().findAllById(memberIdxList);

        // 권한을 부여하려는 회원 인덱스 수와, 실제 회원 수가 맞지 않을 때
        if (memberEntityList.size() != memberIdxList.size()) {
            throw new AppException(ErrorCode.ME_101);
        }
    }

    @Override
    public void excute() throws SystemException, AppException {
        validate();

        List<MemberEntity> memberEntityList = getRepository().getMember().findAllById(memberIdxList);
        List<MemberDTO> memberList = new ArrayList<>();

        for (MemberEntity entity : memberEntityList) {
            MemberDTO dto = new MemberDTO(entity);
            memberList.add(dto);
        }
        this.memberList = memberList;
    }

    @Override
    public List<MemberDTO> getMemberList() {
        return memberList;
    }

}
