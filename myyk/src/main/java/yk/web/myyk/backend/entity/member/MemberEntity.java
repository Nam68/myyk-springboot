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
import yk.web.myyk.backend.dto.MemberDTO;
import yk.web.myyk.backend.entity.BaseEntityWithTime;
import yk.web.myyk.backend.entity.account.AccountBookAuthEntity;
import yk.web.myyk.config.AppConstants;
import yk.web.myyk.util.comparator.MyComparator;
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
	
	@Column(name = "PASSWORD")
	private String password;
	
	@Column(name = "PASSWORD_SALT")
	private String passwordSalt;
	
	@NaturalId
	@Column(name = "EMAIL")
	private String email;
	
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
//	@ManyToMany(fetch = FetchType.LAZY, targetEntity = AccountBookEntity.class)
//	@JoinTable(
//			name = "ACCOUNT_BOOK_MEMBER_RTBL", 
//			joinColumns = @JoinColumn(name = "MEMBER_IDX"), 
//			inverseJoinColumns = @JoinColumn(name = "ACCOUNT_BOOK_IDX"))
//	private List<AccountBookEntity> accountBookList;
	@OneToMany(fetch = FetchType.LAZY, targetEntity = AccountBookAuthEntity.class, mappedBy = "member")
	private List<AccountBookAuthEntity> accountBookAuthList = new ArrayList<>();
	
	@Deprecated
	public MemberEntity() {
		// nop
	}
	
	public MemberEntity(MemberDTO dto) {
		this(dto, AppConstants.getMemberPasswordSaltLength(), AppConstants.getMemberPasswordHashingTimes(), AppConstants.getMemberIconDefault());
	}
	
	public MemberEntity(MemberDTO dto, String memberIcon) {
		this(dto, AppConstants.getMemberPasswordSaltLength(), AppConstants.getMemberPasswordHashingTimes(), memberIcon);
	}

	public MemberEntity(MemberDTO dto, int saltLength, int hashingTimes, String memberIcon) {
		this.email = encrypt(dto.getEmail());
		this.passwordSalt = getRandomString(saltLength);
		this.password = hashing(dto.getPassword(), passwordSalt, hashingTimes);
		this.nickname = dto.getNickname();
		this.region = dto.getRegion();
		this.memberType = MemberType.TMP_MEMBER;
		this.memberIcon = memberIcon;
	}
	
	public long getMemberIdx() {
		return memberIdx;
	}
	
	public String getEncryptedEmail() {
		return decrypt(email);
	}
	
	public String getNickname() {
		return nickname;
	}
	
	public Region getRegion() {
		return region;
	}
	
	public MemberType getMemberType() {
		return memberType;
	}
	
	public String memberIcon() {
		return memberIcon;
	}
	
	public boolean passwordValidate(String password) {
		String hashedPassword = hashing(password, passwordSalt, AppConstants.getMemberPasswordHashingTimes());
		return hashedPassword.equals(this.password);
	}
	
	/**
	 * @Deprecated 가급적 레포지토리를 통해서 정렬해서 불러올 것.
	 */
	@Deprecated
	public List<AccountBookAuthEntity> getAccountBookAuthList() {
		return accountBookAuthList;
	}
	
}
