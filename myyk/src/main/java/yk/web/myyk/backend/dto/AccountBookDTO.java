package yk.web.myyk.backend.dto;

import java.util.List;

import yk.web.myyk.backend.entity.account.AccountBookEntity;
import yk.web.myyk.util.enumerated.Currency;

public class AccountBookDTO extends BaseDTO {

    /**
     * <p>가계부 인덱스.</p>
     */
    private long accountBookIdx;

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
     * <p>카테고리 리스트.</p>
     */
    private List<CategoryDTO> categoryList;

    /**
     * <p>서브 카테고리 리스트.</p>
     */
    private List<SubCategoryDTO> subCategoryList;

    /**
     * <p>생성자.</p>
     *
     * @param entity 엔티티
     */
    public AccountBookDTO(AccountBookEntity entity) {
        this.accountBookIdx = entity.getAccountBookIdx();
        this.accountBookNameKr = entity.getAccountBookNameKr();
        this.accountBookNameJp = entity.getAccountBookNameJp();
        this.currency = entity.getCurrency();
    }

    /**
     * <p>생성자.</p>
     *
     * @param entity 엔티티
     * @param categoryList 카테고리 리스트
     * @param subCategoryList 서브 카테고리 리스트
     */
    public AccountBookDTO(AccountBookEntity entity, List<CategoryDTO> categoryList, List<SubCategoryDTO> subCategoryList) {
        this(entity);
        this.categoryList = categoryList;
        this.subCategoryList = subCategoryList;
    }

    /**
     * <p>가계부 인덱스를 반환한다.</p>
     *
     * @return 가계부 인덱스
     */
    public long getAccountBookIdx() {
        return accountBookIdx;
    }

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
