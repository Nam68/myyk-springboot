package yk.web.myyk.backend.service.member;

import java.util.List;

import yk.web.myyk.backend.dto.MemberDTO;
import yk.web.myyk.backend.service.BaseService;

/**
 * <p>로그인한 회원 이외의 회원 리스트를 반환한다.</p>
 */
public interface FindAllMemberExceptMyself extends BaseService {

    /**
     * <p>로그인한 회원의 회원 인덱스를 설정한다.</p>
     *
     * @param memberIdx
     * @return
     */
    public void setMemberIdx(long memberIdx);

    /**
     * <p>회원 리스트를 반환한다.</p>
     *d
     * @return 회원 리스트
     */
    public List<MemberDTO> getMemberList();
}
