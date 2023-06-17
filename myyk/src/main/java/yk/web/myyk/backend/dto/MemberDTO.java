package yk.web.myyk.backend.dto;

import yk.web.myyk.util.enumerated.Region;

public class MemberDTO {

	private String email;
	
	private String password;
	
	private String nickname;
	
	private Region region;
	
	@Deprecated
	public MemberDTO() {
		// nop
	}
	
	public String getEmail() {
		return email;
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
