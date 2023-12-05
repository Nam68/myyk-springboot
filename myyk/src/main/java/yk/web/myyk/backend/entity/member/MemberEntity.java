package yk.web.myyk.backend.entity.member;

import java.util.ArrayList;
import java.util.Comparator;
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
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import yk.web.myyk.backend.dto.MemberDto;
import yk.web.myyk.backend.dto.form.member.MemberForm;
import yk.web.myyk.backend.dto.login.AdminInfo;
import yk.web.myyk.backend.dto.login.LoginInfo;
import yk.web.myyk.backend.dto.login.MemberInfo;
import yk.web.myyk.backend.entity.BaseEntityWithTime;
import yk.web.myyk.backend.entity.account.AccountBookAuthEntity;
import yk.web.myyk.util.comparator.MyComparator;
import yk.web.myyk.util.constant.Constant;
import yk.web.myyk.util.enumerated.MemberType;
import yk.web.myyk.util.enumerated.Region;

/**
 * <p>회원 엔티티.</p>
 */
@Entity
@Table(name = "MEMBER_TBL")
public class MemberEntity extends BaseEntityWithTime {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "MEMBER_IDX")
    private Long memberIdx;

    @NaturalId
    @Column(name = "EMAIL")
    private String email;

    @Column(name = "PASSWORD")
    private String password;

    @Column(name = "PASSWORD_SALT")
    private String passwordSalt;

    @Column(name = "NICKNAME")
    private String nickname;

    @Column(name = "REGION")
    @Enumerated(EnumType.STRING)
    private Region region;

    @Column(name = "MEMBER_TYPE")
    @Enumerated(EnumType.STRING)
    private MemberType memberType;

    @Column(name = "MEMBER_ICON")
    private String memberIcon;

    // 단순한 다대다이므로 사용하기 어려워서 패스
//  @ManyToMany(fetch = FetchType.LAZY, targetEntity = AccountBookEntity.class)
//  @JoinTable(
//          name = "ACCOUNT_BOOK_MEMBER_RTBL", 
//          joinColumns = @JoinColumn(name = "MEMBER_IDX"), 
//          inverseJoinColumns = @JoinColumn(name = "ACCOUNT_BOOK_IDX"))
//  private List<AccountBookEntity> accountBookList;
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "member")
    private List<AccountBookAuthEntity> accountBookAuthList = new ArrayList<>();

    /**
     * <p>생성자.</p>
     */
    @Deprecated
    public MemberEntity() {
        // nop
    }

    /**
     * <p>생성자.</p>
     * 
     * @param dto DTO
     */
    public MemberEntity(MemberDto dto) {
        this(dto, Constant.getMemberIconDefault());
    }

    /**
     * <p>생성자.</p>
     * 
     * @param dto DTO
     * @param memberIcon 회원 아이콘
     */
    public MemberEntity(MemberDto dto, String memberIcon) {

        int saltLength = Constant.getMemberPasswordSaltLength();
        int hashingTimes = Constant.getMemberPasswordHashingTimes();

        this.email = dto.getEmail();
        this.passwordSalt = getRandomString(saltLength);
        this.password = hashing(dto.getPassword(), passwordSalt, hashingTimes);
        this.nickname = dto.getNickname();
        this.region = dto.getRegion();
        this.memberType = MemberType.TMP_MEMBER;
        this.memberIcon = memberIcon;
    }

    /**
     * <p>회원 IDX를 반환한다.</p>
     * 
     * @return 회원 IDX
     */
    public long getMemberIdx() {
        return memberIdx;
    }

    /**
     * <p>이메일을 반환한다.</p>
     * 
     * @return 이메일
     */
    public String getEmail() {
        return email;
    }

    /**
     * <p>비밀번호 솔트를 반환한다.</p>
     * 
     * @return 비밀번호 솔트
     */
    public String getPasswordSalt() {
        return passwordSalt;
    }

    /**
     * <p>비밀번호를 반환한다.</p>
     * 
     * @return 비밀번호
     */
    public String getPassword() {
        return password;
    }

    /**
     * <p>닉네임을 반환한다.</p>
     * 
     * @return 닉네임
     */
    public String getNickname() {
        return nickname;
    }

    /**
     * <p>지역을 반환한다.</p>
     * 
     * @return 지역
     */
    public Region getRegion() {
        return region;
    }

    /**
     * <p>회원 등급을 반환한다.</p>
     * 
     * @return 회원 등급
     */
    public MemberType getMemberType() {
        return memberType;
    }

    /**
     * <p>회원 아이콘을 반환한다.</p>
     * 
     * @return 회원 아이콘
     */
    public String getMemberIcon() {
        return memberIcon;
    }

    /**
     * <p>가계부 권한 엔티티 리스트를 반환한다.</p>
     * 
     * @return 가계부 권한 엔티티 리스트
     * @deprecated 가급적 레포지토리를 통해서 정렬해서 불러올 것
     */
    @Deprecated
    public List<AccountBookAuthEntity> getAccountBookAuthList() {
        return accountBookAuthList;
    }

    public LoginInfo getLoginInfo() {
        LoginInfo loginInfo = null;
        if (MemberType.ADMIN.equals(memberType)) {
            loginInfo = new AdminInfo();
        } else {
            loginInfo = new MemberInfo();
        }
        loginInfo.setByLoginForm(this);
        return loginInfo;
    }
}
