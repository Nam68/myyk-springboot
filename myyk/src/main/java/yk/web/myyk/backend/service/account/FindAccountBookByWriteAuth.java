package yk.web.myyk.backend.service.account;

import yk.web.myyk.backend.dto.AccountBookDTO;
import yk.web.myyk.backend.service.BaseService;

/**
 * 쓰기권한이 있는 한 개의 가계부를 검색한다.
 */
public interface FindAccountBookByWriteAuth extends BaseService {

    /**
     * <p>가계부 인덱스를 설정한다.</p>
     *
     * @param accountBookIdx 가계부 인덱스
     */
    public void setAccountBookIdx(long accountBookIdx);

    /**
     * <p>회원 인덱스를 설정한다.</p>
     *
     * @param memberIdx 회원 인덱스
     */
    public void setMemberIdx(long memberIdx);

    /**
     * <p>가계부를 반환한다.</p>
     *
     * @return 가계부
     */
    public AccountBookDTO getAccountBook();
}
