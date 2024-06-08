package yk.web.myyk.backend.entity.member;

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
import jakarta.transaction.Transactional;
import yk.web.myyk.backend.dto.MemberDTO;
import yk.web.myyk.backend.dto.login.AdminInfo;
import yk.web.myyk.backend.dto.login.LoginInfo;
import yk.web.myyk.backend.dto.login.MemberInfo;
import yk.web.myyk.backend.entity.BaseEntityWithTime;
import yk.web.myyk.backend.entity.account.AccountBookAuthEntity;
import yk.web.myyk.backend.entity.account.CategoryEntity;
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

    @Column(name = "NICKNAME_LANG")
    private String nicknameLang;

    @Column(name = "REGION")
    @Enumerated(EnumType.STRING)
    private Region region;

    @Column(name = "MEMBER_TYPE")
    @Enumerated(EnumType.STRING)
    private MemberType memberType;

    @Column(name = "MEMBER_ICON")
    private String memberIcon;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "member")
    private List<AccountBookAuthEntity> accountBookAuthList;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "member")
    private List<CategoryEntity> categoryList;

    /**
     * <p>생성자.</p>
     */
    @Deprecated
    public MemberEntity() {
        // nop
    }

    public MemberEntity(long memberIdx) {
        setMemberIdx(memberIdx);
    }

    /**
     * <p>생성자.</p>
     *
     * @param dto DTO
     */
    public MemberEntity(MemberDTO dto) {
        this(dto, Constant.getMemberIconDefault());
    }

    /**
     * <p>생성자.</p>
     *
     * @param dto DTO
     * @param memberIcon 회원 아이콘
     */
    public MemberEntity(MemberDTO dto, String memberIcon) {
        setEmail(dto.getEmail());
        setPasswordSalt(createPasswordSalt());
        setPassword(dto.getPassword());
        setNickname(dto.getNickname());
        setNicknameLang(dto.getNicknameLang());
        setRegion(dto.getRegion());
        setMemberType(MemberType.TMP_MEMBER);
        setMemberIcon(memberIcon);
    }

    /**
     * <p>회원 IDX를 설정한다.</p>
     *
     * @param memberIdx 회원 IDX
     */
    public void setMemberIdx(long memberIdx) {
        this.memberIdx = memberIdx;
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
     * <p>이메일을 설정한다.</p>
     *
     * @param email 이메일
     */
    private void setEmail(String email) {
        this.email = encrypt(email);
    }

    /**
     * <p>이메일을 반환한다.</p>
     *
     * @return 이메일
     */
    public String getEmail() {
        return decrypt(email);
    }

    /**
     * <p>비밀번호 솔트를 설정한다.</p>
     *
     * @param passwordSalt 비밀번호 솔트
     */
    public void setPasswordSalt(String passwordSalt) {
        this.passwordSalt = passwordSalt;
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
     * <p>비밀번호를 설정한다.</p>
     *
     * @param password 비밀번호
     */
    public void setPassword(String password) {
        this.password = getHashedPassword(password);
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
     * <p>비밀번호 솔트를 생성한다.</p>
     *
     * @return 비밀번호 솔트
     */
    private String createPasswordSalt() {
        int saltLength = Constant.getMemberPasswordSaltLength();
        return getRandomString(saltLength);
    }

    /**
     * <p>비밀번호를 해싱한다.</p>
     *
     * @param password 비밀번호
     * @return 해싱된 비밀번호
     */
    private String getHashedPassword(String password) {
        int hashingTimes = Constant.getMemberPasswordHashingTimes();
        return hashing(password, passwordSalt, hashingTimes);
    }

    /**
     * <p>비밀번호를 리셋한다.</p>
     */
    public void resetPassword() {
        setPasswordSalt(createPasswordSalt());
        setPassword("1234");
    }

    /**
     * <p>닉네임을 설정한다.</p>
     *
     * @param nickname 닉네임
     */
    public void setNickname(String nickname) {
        this.nickname = nickname;
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
     * <p>닉네임 타언어를 설정한다.</p>
     *
     * @param nicknameLang 닉네임 타언어
     */
    public void setNicknameLang(String nicknameLang) {
        this.nicknameLang = nicknameLang;
    }

    /**
     * <p>닉네임 타언어를 반환한다.</p>
     *
     * @return 닉네임 타언어
     */
    public String getNicknameLang() {
        return nicknameLang;
    }

    /**
     * <p>지역을 설정한다.</p>
     *
     * @param region 지역
     */
    public void setRegion(Region region) {
        this.region = region;
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
     * <p>회원 등급을 설정한다.</p>
     *
     * @param memberType 회원 등급
     */
    public void setMemberType(MemberType memberType) {
        this.memberType = memberType;
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
     * <p>회원 아이콘을 설정한다.</p>
     *
     * @param memberIcon 회원 아이콘
     */
    public void setMemberIcon(String memberIcon) {
        this.memberIcon = memberIcon;
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

    /**
     * <p>카테고리 리스트를 반환한다.</p>
     *
     * @return 카테고리 리스트
     */
    @Transactional
    public List<CategoryEntity> getCategoryList() {
        return categoryList;
    }

    /**
     * <p>인스턴스를 로그인 정보로 변환해서 반환한다.</p>
     *
     * @return 로그인 정보
     */
    public LoginInfo createLoginInfo() {
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
