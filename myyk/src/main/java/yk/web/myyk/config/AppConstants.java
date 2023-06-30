package yk.web.myyk.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class AppConstants {
	
	@Value("${value.hashing.times}")
	private int hashingTimes;
	
	@Value("${value.hashing.salt}")
	private String hashingSalt;

	@Value("${value.tmpCode.limit}")
	private int tmpCodeLimitMinute;
	
	@Value("${value.member.password.saltLength}")
	private int memberPasswordSaltLength;
	
	@Value("${value.member.password.hashingTimes}")     
	private int memberPasswordHashingTimes;
	
	public int getHashingTimes() {
		return hashingTimes;
	}
	
	public String getHashingSalt() {
		return hashingSalt;
	}
	
	public int getTmpCodeLImitMinute() {
		return tmpCodeLimitMinute;
	}
	
	public int getMemberPasswordSaltLength() {
		return memberPasswordSaltLength;
	}
	
	public int getMemberPasswordHashingTimes() {
		return memberPasswordHashingTimes;
	}
	
}
