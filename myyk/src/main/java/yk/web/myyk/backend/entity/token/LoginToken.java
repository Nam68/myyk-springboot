package yk.web.myyk.backend.entity.token;

import java.time.LocalDateTime;

import org.hibernate.annotations.NaturalId;

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
@Table(name = "LOGIN_TOKEN")
public class LoginToken extends BaseEntityWithTime {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "LOGIN_TOKEN_IDX")
    private Long loginTokenIdx;

    @NaturalId
    @Column(name = "TOKEN_ID")
    private String tokenId;

    @Column(name = "LAST_USED_TIME")
    private LocalDateTime lastUsedTime;

    @ManyToOne(fetch = FetchType.LAZY, targetEntity = MemberEntity.class)
    private MemberEntity member;

    /**
     * @deprecated 하이버네이트용
     */
    @Deprecated
    public LoginToken() {
        // nop
    }

    /**
     * <p>생성자.</p>
     * 
     * @param member 회원 엔티티
     */
    public LoginToken(MemberEntity member) {
        this.tokenId = getRandomString(20);
        this.member = member;
        this.lastUsedTime = LocalDateTime.now();
    }

    /**
     * <p>토큰 아이디를 반환한다.</p>
     * 
     * @return 토큰 아이디
     */
    public String getTokenId() {
        return tokenId;
    }

    /**
     * <p>회원 엔티티를 반환한다.</p>
     * 
     * @return 회원 엔티티
     */
    public MemberEntity getMemberEntity() {
        return member;
    }

    /**
     * <p>마지막 사용 시각을 반환한다.</p>
     * 
     * @return 마지막 사용 시각
     */
    public LocalDateTime getLastUsedTime() {
        return lastUsedTime;
    }
}
