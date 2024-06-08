package yk.web.myyk.backend.service.member;

import java.util.List;

import yk.web.myyk.backend.dto.MemberDTO;
import yk.web.myyk.backend.service.BaseService;

public interface FindAllMemberExceptMyself extends BaseService {

    /**
     * <p>회원 리스트를 반환한다.</p>
     *d
     * @return 회원 리스트
     */
    public List<MemberDTO> getMemberList();
}
