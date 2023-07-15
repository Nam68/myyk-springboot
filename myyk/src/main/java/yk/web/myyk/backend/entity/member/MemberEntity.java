package yk.web.myyk.backend.entity.member;

import org.hibernate.annotations.NaturalId;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import yk.web.myyk.backend.dto.MemberDTO;
import yk.web.myyk.backend.entity.BaseEntityWithTime;
import yk.web.myyk.config.AppConstants;
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
}
