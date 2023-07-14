package yk.web.myyk.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import jakarta.annotation.PostConstruct;

@Component
public class AppConstants {
	
	private static int staticHashingTimes;
	private static String staticHashingSalt;
	private static int staticCookieDefaultTime;
	private static int staticCookieOneDay;
	private static int staticMemberPasswordSaltLength;
	private static int staticMemberPasswordHashingTimes;
	private static String staticMemberIconDefault;
	
	@PostConstruct
	public void init() {
		AppConstants.staticHashingTimes = hashingTimes;
		AppConstants.staticHashingSalt = hashingSalt;
		AppConstants.staticCookieDefaultTime = cookieDefaultTime;
		AppConstants.staticCookieOneDay = cookieOneDay;
		AppConstants.staticMemberPasswordSaltLength = memberPasswordSaltLength;
		AppConstants.staticMemberPasswordHashingTimes = memberPasswordHashingTimes;
		AppConstants.staticMemberIconDefault = memberIconDefault;
	}
	
	@Value("${value.hashing.times}")
	private int hashingTimes;
	
	@Value("${value.hashing.salt}")
	private String hashingSalt;
	
	@Value("${value.cookie.defaultTime}")
	private int cookieDefaultTime;
	
	@Value("${value.cookie.oneDay}")
	private int cookieOneDay;

	@Value("${value.tmpCode.limit.minutes}")
	private int tmpCodeLimitMinutes;
	
	@Value("${value.tmpCode.limit.times}")
	private int tmpCodeLimitTimes;
	
	@Value("${value.member.password.saltLength}")
	private int memberPasswordSaltLength;
	
	@Value("${value.member.password.hashingTimes}")     
	private int memberPasswordHashingTimes;
	
	@Value("${value.member.icon.default}")
	private String memberIconDefault;
	
	public static int getHashingTimes() {
		return staticHashingTimes;
	}
	
	public static String getHashingSalt() {
		return staticHashingSalt;
	}
	
	public static int getCookieDefaultTime() {
		return staticCookieDefaultTime;
	}
	
	public static int getCookieOneDay() {
		return staticCookieOneDay;
	}
	
	public int getTmpCodeLImitMinutes() {
		return tmpCodeLimitMinutes;
	}
	
	public int getTmpCodeLImitTimes() {
		return tmpCodeLimitTimes;
	}
	
	public static int getMemberPasswordSaltLength() {
		return staticMemberPasswordSaltLength;
	}
	
	public static int getMemberPasswordHashingTimes() {
		return staticMemberPasswordHashingTimes;
	}
	
	public static String getMemberIconDefault() {
		return staticMemberIconDefault;
	}
	
}
