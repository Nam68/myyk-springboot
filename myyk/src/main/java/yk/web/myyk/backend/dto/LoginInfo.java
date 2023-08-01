package yk.web.myyk.backend.dto;

import yk.web.myyk.backend.entity.member.MemberEntity;
import yk.web.myyk.util.enumerated.MemberType;
import yk.web.myyk.util.enumerated.Region;

public class LoginInfo extends BaseDTO {

	private Long memberIdx;
	
	private String email;
	
	private String nickname;
	
	private Region region;
	
	private MemberType memberType;
	
	private String memberIcon;
	
	@Deprecated
	public LoginInfo() {
		// 하이버네이트용
	}
	
	public LoginInfo(MemberEntity entity) {
		this.memberIdx = entity.getMemberIdx();
		this.email = entity.getEncryptedEmail();
		this.nickname = entity.getNickname();
		this.region = entity.getRegion();
		this.memberType = entity.getMemberType();
		this.memberIcon = entity.memberIcon();
	}
	
	public long getMemberIdx() {
		return memberIdx;
	}
	
	public String getEmail() {
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
	
	public String getMemberIcon() {
		return memberIcon;
	}
	
	public boolean isAdmin() {
		return MemberType.hasAdminAuthority(memberType);
	}
}
