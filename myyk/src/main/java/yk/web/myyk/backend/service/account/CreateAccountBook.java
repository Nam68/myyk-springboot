package yk.web.myyk.backend.service.account;

import java.util.List;

import yk.web.myyk.backend.dto.AccountBookDTO;
import yk.web.myyk.backend.service.BaseService;
import yk.web.myyk.util.enumerated.Currency;

/**
 * <p>가계부 생성 서비스.</p>
 */
public interface CreateAccountBook extends BaseService {

    /**
     * <p>가계부 이름(한국어)을 설정한다.</p>
     *
     * @param accountBookNameKr 가계부 이름(한국어)
     */
    public void setAccountBookNameKr(String accountBookNameKr);

    /**
     * <p>가계부 이름(일본어)을 설정한다.</p>
     *
     * @param accountBookNameJp 가계부 이름(일본어)
     */
    public void setAccountBookNameJp(String accountBookNameJp);

    /**
     * <p>통화단위를 설정한다.</p>
     *
     * @param currency 통화단위
     */
    public void setCurrency(Currency currency);

    /**
     * <p>읽기권한 리스트를 설정한다.</p>
     *
     * @param readAuthList 읽기권한 리스트
     */
    public void setReadAuthList(List<Long> readAuthList);

    /**
     * <p>쓰기권한 리스트를 설정한다.</p>
     *
     * @param writeAuthList 쓰기권한 리스트
     */
    public void setWriteAuthList(List<Long> writeAuthList);

    /**
     * <p>가계부를 반환한다.</p>
     *
     * @return 가계부
     */
    public AccountBookDTO getAccountBook();
}
