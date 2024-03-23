package yk.web.myyk.backend.entity.account;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.annotations.NaturalId;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import yk.web.myyk.backend.dto.form.account.CreateAccountForm;
import yk.web.myyk.backend.entity.BaseEntityWithTime;
import yk.web.myyk.util.enumerated.Currency;
import yk.web.myyk.util.enumerated.TaxRate;

@Entity
@Table(name = "ACCOUNT_TABLE")
public class AccountEntity extends BaseEntityWithTime {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ACCOUNT_IDX")
    private Long accountIdx;

    @NaturalId
    @Column(name = "ACCOUNT_NAME")
    private String accountName;

    @Column(name = "TAX_INCLUDE")
    private boolean taxInclude;

    @Column(name = "TAX_RATE")
    @Enumerated(EnumType.STRING)
    private TaxRate taxRate;

    @Column(name = "CURRENCY")
    @Enumerated(EnumType.STRING)
    private Currency currency;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "account")
    private List<AccountAuthEntity> accountAuthList = new ArrayList<>();

    @Deprecated
    public AccountEntity() {
        // 하이버네이트용
    }

    public AccountEntity(CreateAccountForm form) {
        this.taxRate = form.getTax();
        this.currency = form.getCurrency();
    }
    
    public String getAccountName() {
        return accountName;
    }
}
