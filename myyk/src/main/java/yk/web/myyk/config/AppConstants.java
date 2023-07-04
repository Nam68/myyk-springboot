package yk.web.myyk.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class AppConstants {
	
	@Value("${value.hashing.times}")
	private int hashingTimes;
	
	@Value("${value.hashing.salt}")
	private String hashingSalt;

	@Value("${value.tmpCode.limit.minutes}")
	private int tmpCodeLimitMinutes;
	
	@Value("${value.tmpCode.limit.times}")
	private int tmpCodeLimitTimes;
	
	@Value("${value.member.password.saltLength}")
	private int memberPasswordSaltLength;
	
	@Value("${value.member.password.hashingTimes}")     
	private int memberPasswordHashingTimes;
	
	@Value("${value.member.Icon.default}")
	private String memberIconDefault;
	
	public int getHashingTimes() {
		return hashingTimes;
	}
	
	public String getHashingSalt() {
		return hashingSalt;
	}
	
	public int getTmpCodeLImitMinutes() {
		return tmpCodeLimitMinutes;
	}
	
	public int getTmpCodeLImitTimes() {
		return tmpCodeLimitTimes;
	}
	
	public int getMemberPasswordSaltLength() {
		return memberPasswordSaltLength;
	}
	
	public int getMemberPasswordHashingTimes() {
		return memberPasswordHashingTimes;
	}
	
	public String getMemberIconDefault() {
		return memberIconDefault;
	}
	
}
