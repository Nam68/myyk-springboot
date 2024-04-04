package yk.web.myyk.backend.logic.member;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import yk.web.myyk.backend.dto.MemberDto;
import yk.web.myyk.backend.entity.member.MemberEntity;
import yk.web.myyk.backend.logic.BaseLogic;
import yk.web.myyk.backend.service.member.FindAllMemberByIdx;
import yk.web.myyk.util.exception.AppException;
import yk.web.myyk.util.exception.SystemException;

@Service
@Scope(scopeName = ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class FindAllMemberByIdxLogic extends BaseLogic implements FindAllMemberByIdx {

    private List<Long> memberIdxList;

    private List<MemberDto> memberList;

    @Override
    public void setMemberIdxList(List<Long> memberIdxList) {
        this.memberIdxList = memberIdxList;
    }

    @Override
    public void validate() throws SystemException, AppException {
        // nop
    }

    @Override
    public void excute() throws SystemException, AppException {
        validate();

        List<MemberEntity> memberEntityList = getRepository().getMember().findAllById(memberIdxList);
        List<MemberDto> memberList = new ArrayList<>();

        for (MemberEntity entity : memberEntityList) {
            MemberDto dto = new MemberDto(entity);
            memberList.add(dto);
        }
        this.memberList = memberList;
    }

    @Override
    public List<MemberDto> getMemberList() {
        return memberList;
    }

}
