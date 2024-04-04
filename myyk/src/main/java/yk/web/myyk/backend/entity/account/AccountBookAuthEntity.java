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
@Table(name = "ACCOUNT_BOOK_AUTH_TBL")
public class AccountBookAuthEntity extends BaseEntityWithTime {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ACCOUNT_BOOK_AUTH_IDX")
    private Long accountBookAuthIdx;

    @ManyToOne(fetch = FetchType.EAGER, targetEntity = AccountBookEntity.class)
    @JoinColumn(name = "ACCOUNT_BOOK_IDX")
    private AccountBookEntity accountBook;

    @ManyToOne(fetch = FetchType.EAGER, targetEntity = MemberEntity.class)
    @JoinColumn(name = "MEMBER_IDX")
    private MemberEntity member;

    @Column(name = "WRITABLE")
    private boolean writable;

    @Deprecated
    public AccountBookAuthEntity() {
        // 하이버네이트용
    }

    /**
     * <p>생성자.</p>
     *
     * @param memberEntity 회원 엔티티
     */
    public AccountBookAuthEntity(MemberEntity memberEntity) {

    }

    public AccountBookEntity getAccount() {
        return accountBook;
    }

    public void setWritable(boolean writable) {
        this.writable = writable;
    }
}
