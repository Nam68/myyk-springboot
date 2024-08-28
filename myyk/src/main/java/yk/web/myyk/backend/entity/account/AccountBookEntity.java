package yk.web.myyk.backend.entity.account;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import yk.web.myyk.backend.dto.form.account.CreateAccountBookForm;
import yk.web.myyk.backend.entity.BaseEntityWithTime;
import yk.web.myyk.backend.entity.category.CategoryEntity;
import yk.web.myyk.util.enumerated.Currency;
import yk.web.myyk.util.enumerated.TaxRate;

@Entity
@Table(name = "ACCOUNT_BOOK_TBL")
public class AccountBookEntity extends BaseEntityWithTime {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ACCOUNT_BOOK_IDX")
    private Long accountBookIdx;

    @Column(name = "ACCOUNT_BOOK_NAME_KR")
    private String accountBookNameKr;

    @Column(name = "ACCOUNT_BOOK_NAME_JP")
    private String accountBookNameJp;

    @Column(name = "CURRENCY")
    @Enumerated(EnumType.STRING)
    private Currency currency;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "accountBook")
    private List<AccountBookAuthEntity> accountBookAuthList = new ArrayList<>();

    @ManyToMany(fetch = FetchType.LAZY, targetEntity = CategoryEntity.class)
    @JoinTable(
            name = "ACCOUNT_BOOK_CATEGORY_RTBL",
            joinColumns = @JoinColumn(name = "ACCOUNT_BOOK_IDX"),
            inverseJoinColumns = @JoinColumn(name = "CATEGORY_IDX"))
    private List<CategoryEntity> categoryList;

    @Deprecated
    public AccountBookEntity() {
        // 하이버네이트용
    }

    public AccountBookEntity(CreateAccountBookForm form) {
        this.currency = form.getCurrency();
    }

    public AccountBookEntity(String accountBookNameKr, String accountBookNameJp, Currency currency) {
        setAccountBookNameKr(accountBookNameKr);
        setAccountBookNameJp(accountBookNameJp);
        setCurrency(currency);
    }

    /**
     * <p>가계부 이름(한국어)을 반환한다.</p>
     *
     * @return 가계부 이름
     */
    public String getAccountBookNameKr() {
        return accountBookNameKr;
    }

    /**
     * <p>가계부 이름을 설정한다.</p>
     *
     * @param accountBookNameKr 가계부 이름
     */
    public void setAccountBookNameKr(String accountBookNameKr) {
        this.accountBookNameKr = accountBookNameKr;
    }

    /**
     * <p>가계부 이름(일본어)을 반환한다.</p>
     *
     * @return 가계부 이름
     */
    public String getAccountBookNameJp() {
        return accountBookNameJp;
    }

    /**
     * <p>가계부 이름을 설정한다.</p>
     *
     * @param accountNameJp 가계부 이름
     */
    public void setAccountBookNameJp(String accountBookNameJp) {
        this.accountBookNameJp = accountBookNameJp;
    }

    /**
     * <p>통화단위를 설정한다.</p>
     *
     * @param currency 통화단위
     */
    public void setCurrency(Currency currency) {
        this.currency = currency;
    }

    /**
     * <p>통화단위를 반환한다.</p>
     *
     * @return 통화단위
     */
    public Currency getCurrency() {
        return currency;
    }

    /**
     * <p>카테고리 리스트를 반환한다.</p>
     *
     * @deprecated 정렬이 가능하도록 가급적 쿼리를 통해 반환받는다.
     * @return 카테고리 리스트
     */
    @Deprecated
    public List<CategoryEntity> getCategoryList() {
        return categoryList;
    }
}
