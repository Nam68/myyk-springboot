package yk.web.myyk.backend.entity.account;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
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
    private AccountBookEntity accountBook;

    @ManyToOne(fetch = FetchType.EAGER, targetEntity = MemberEntity.class)
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
     * @param accountBookEntity 가계부 엔티티
     * @param memberEntity 회원 엔티티
     */
    public AccountBookAuthEntity(AccountBookEntity accountBookEntity, MemberEntity memberEntity) {
        this.accountBook = accountBookEntity;
        this.member = memberEntity;
        setDeleted(false);
    }

    /**
     * <p>가계부를 반환한다.</p>
     *
     * @return 가계부
     */
    public AccountBookEntity getAccount() {
        return accountBook;
    }

    /**
     * <p>쓰기권한 여부를 설정한다.</p>
     *
     * @param writable 쓰기권한 여부
     */
    public void setWritable(boolean writable) {
        this.writable = writable;
    }

    /**
     * <p>쓰기권한 여부를 반환한다.</p>
     *
     * @return 쓰기권한 여부
     */
    public boolean isWritable() {
        return writable;
    }

    /**
     * <p>회원을 반환한다.</p>
     *
     * @return 회원
     */
    public MemberEntity getMember() {
        return member;
    }
}
