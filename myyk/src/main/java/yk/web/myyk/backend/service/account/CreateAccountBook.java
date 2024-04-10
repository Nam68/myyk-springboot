package yk.web.myyk.backend.service.account;

import java.util.List;

import yk.web.myyk.backend.service.BaseService;
import yk.web.myyk.util.enumerated.Currency;
import yk.web.myyk.util.enumerated.TaxRate;

/**
 * <p>가계부 생성 서비스.</p>
 */
public interface CreateAccountBook extends BaseService {

    /**
     * <p>가계부 이름(한국어)을 설정한다.</p>
     *
     * @param accountBookNameKo 가계부 이름(한국어)
     */
    public void setAccountBookNameKo(String accountBookNameKo);

    /**
     * <p>가계부 이름(일본어)을 설정한다.</p>
     *
     * @param accountBookNameJp 가계부 이름(일본어)
     */
    public void setAccountBookNameJp(String accountBookNameJp);

    /**
     * <p>세금포함 여부를 설정한다.</p>
     *
     * @param taxInclude 세금포함 여부
     */
    public void setTaxInclude(boolean taxInclude);

    /**
     * <p>세율을 설정한다.</p>
     *
     * @param taxRate 세울
     */
    public void setTaxRate(TaxRate taxRate);

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
}
