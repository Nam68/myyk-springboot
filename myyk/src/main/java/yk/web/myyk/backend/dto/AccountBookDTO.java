package yk.web.myyk.backend.dto;

import yk.web.myyk.backend.entity.account.AccountBookEntity;
import yk.web.myyk.util.enumerated.Currency;

public class AccountBookDTO extends BaseDTO {

    /**
     * <p>가계부 이름(한국어).</p>
     */
    private String accountBookNameKr;

    /**
     * <p>가계부 이름(일본어).</p>
     */
    private String accountBookNameJp;

    /**
     * <p>통화단위.</p>
     */
    private Currency currency;

    /**
     * <p>생성자.</p>
     *
     * @param entity 엔티티
     */
    public AccountBookDTO(AccountBookEntity entity) {
        this.accountBookNameKr = entity.getAccountBookNameKr();
        this.accountBookNameJp = entity.getAccountBookNameJp();
        this.currency = entity.getCurrency();
    }
//    public AccountBookDTO(AccountBookEntity entity, List<AccountBookAuthEntity> authList) {
//        this(entity);
//        // 권한 세팅
//    }

    /**
     * <p>가계부 이름(한국어)을 반환한다.</p>
     *
     * @return 가계부 이름(한국어)
     */
    public String getAccountBookNameKr() {
        return accountBookNameKr;
    }

    /**
     * <p>가계부 이름(일본어)을 반환한다.</p>
     *
     * @return 가계부 이름(일본어)
     */
    public String getAccountBookNameJp() {
        return accountBookNameJp;
    }

    /**
     * <p>통화단위를 반환한다.</p>
     *
     * @return 통화단위
     */
    public Currency getCurrency() {
        return currency;
    }

}
