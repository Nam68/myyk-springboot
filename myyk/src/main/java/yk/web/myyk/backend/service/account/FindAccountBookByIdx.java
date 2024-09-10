package yk.web.myyk.backend.service.account;

import yk.web.myyk.backend.dto.AccountBookDTO;
import yk.web.myyk.backend.service.BaseService;

/**
 * <p>인덱스를 통해 가계부를 검색한다.</p>
 */
public interface FindAccountBookByIdx extends BaseService {

    /**
     * <p>가계부 인덱스를 설정한다.</p>
     *
     * @param accountBookIdx 가계부 인덱스
     */
    public void setAccountBookIdx(long accountBookIdx);

    /**
     * <p>가계부를 반환한다.</p>
     *
     * @return 가계부
     */
    public AccountBookDTO getAccountBook();
}
