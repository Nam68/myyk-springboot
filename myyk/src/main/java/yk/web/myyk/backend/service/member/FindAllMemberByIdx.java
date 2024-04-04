package yk.web.myyk.backend.service.member;

import java.util.List;

import yk.web.myyk.backend.dto.MemberDto;
import yk.web.myyk.backend.service.BaseService;

public interface FindAllMemberByIdx extends BaseService {

    /**
     * <p>회원 인덱스 리스트르를 설정한다.</p>
     *
     * @param memberIdxList 회원 인덱스 리스트
     */
    public void setMemberIdxList(List<Long> memberIdxList);

    /**
     * <p>회원 리스트를 반환한다.</p>
     *
     * @return 회원 리스트
     */
    public List<MemberDto> getMemberList();
}
