package yk.web.myyk.backend.entity.account;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import yk.web.myyk.backend.entity.BaseEntityWithTime;
import yk.web.myyk.backend.entity.member.MemberEntity;

@Entity
@Table(name = "ACCOUNT_AUTH_TBL")
public class AccountAuthEntity extends BaseEntityWithTime {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ACCOUNT_AUTH_IDX")
    private Long accountAuthIdx;

    @ManyToOne(fetch = FetchType.EAGER, targetEntity = AccountEntity.class)
    @JoinColumn(name = "ACCOUNT_IDX")
    private AccountEntity account;

    @ManyToOne(fetch = FetchType.EAGER, targetEntity = MemberEntity.class)
    @JoinColumn(name = "MEMBER_IDX")
    private MemberEntity member;

    @Column(name = "WRITABLE")
    private boolean writable;

    @Deprecated
    public AccountAuthEntity() {
        // 하이버네이트용
    }

    /**
     * <p>생성자.</p>
     *
     * @param memberEntity 회원 엔티티
     */
    public AccountAuthEntity(MemberEntity memberEntity) {

    }

    public AccountEntity getAccount() {
        return account;
    }

    public void setWritable(boolean writable) {
        this.writable = writable;
    }
}
