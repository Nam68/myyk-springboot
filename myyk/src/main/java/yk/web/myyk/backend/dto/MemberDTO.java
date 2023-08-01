package yk.web.myyk.backend.dto;

import yk.web.myyk.backend.entity.member.MemberEntity;
import yk.web.myyk.util.enumerated.Region;

public class MemberDTO extends BaseDTO {
	
	private long memberIdx;

	private String email;
	
	private String password;
	
	private String nickname;
	
	private Region region;
	
	@Deprecated
	public MemberDTO() {
		// nop
	}
	
	public MemberDTO(long memberIdx, String email, String nickname, Region region) {
		this.memberIdx = memberIdx;
		this.email = email;
		this.nickname = nickname;
		this.region = region;
	}
	
	public MemberDTO(String email, String nickname, Region region) {
		this.email = email;
		this.nickname = nickname;
		this.region = region;
	}
	
	public MemberDTO(MemberEntity entity) {
		this(entity.getMemberIdx(), entity.getEncryptedEmail(), entity.getNickname(), entity.getRegion());
	}
	
	public long getMemberIdx() {
		return memberIdx;
	}
	
	public String getEmail() {
		return decrypt(email);
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getNickname() {
		return nickname;
	}
	
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	
	public Region getRegion() {
		return region;
	}
	
	public void setRegion(Region region) {
		this.region = region;
	}
	
}
