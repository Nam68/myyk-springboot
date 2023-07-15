package yk.web.myyk.backend.entity.member;

import org.hibernate.annotations.NaturalId;

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

@Entity
@Table(name = "AUTO_LOGIN_TBL")
public class AutoLoginEntity extends BaseEntityWithTime {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "AUTO_LOGIN_IDX")
	private Long autoLoginIdx;
	
	@NaturalId
	@Column(name = "SESSION_ID")
	private String sessionId;
	
	@ManyToOne(fetch = FetchType.LAZY, targetEntity = MemberEntity.class)
	@JoinColumn(name = "MEMBER_IDX")
	private MemberEntity memberEntity;	
	
	@Deprecated
	public AutoLoginEntity() {
		// 하이버네이트용
	}
	
	public AutoLoginEntity(MemberEntity memberEntity) {
		this.sessionId = getRandomString(20);
		this.memberEntity = memberEntity;
	}
	
	public String getSessionId() {
		return sessionId;
	}
	
	public MemberEntity getMemberEntity() {
		return memberEntity;
	}
	
}
