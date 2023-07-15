package yk.web.myyk.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import jakarta.annotation.PostConstruct;

@Component
public class AppConstants {

	private static String staticHashingSalt;
	private static int staticHashingTimes;
	
	private static String staticEncryptKey;
	
	private static int staticCookieDefaultTime;
	private static int staticCookieOneDay;

	private static int staticMemberPasswordSaltLength;
	private static int staticMemberPasswordHashingTimes;
	private static String staticMemberIconDefault;
	
	@PostConstruct
	public void init() {
		AppConstants.staticHashingSalt = hashingSalt;
		
		AppConstants.staticHashingTimes = hashingTimes;
		
		AppConstants.staticEncryptKey = encryptKey;
		
		AppConstants.staticCookieDefaultTime = cookieDefaultTime;
		AppConstants.staticCookieOneDay = cookieOneDay;
		
		AppConstants.staticMemberPasswordSaltLength = memberPasswordSaltLength;
		AppConstants.staticMemberPasswordHashingTimes = memberPasswordHashingTimes;
		AppConstants.staticMemberIconDefault = memberIconDefault;
	}

	//
	// static 대상
	//
	
	@Value("${value.hashing.salt}")
	private String hashingSalt;
	
	@Value("${value.hashing.times}")
	private int hashingTimes;
	
	@Value("${value.encrypt.key}")
	private String encryptKey;
	
	@Value("${value.cookie.defaultTime}")
	private int cookieDefaultTime;
	
	@Value("${value.cookie.oneDay}")
	private int cookieOneDay;
	
	@Value("${value.member.password.saltLength}")
	private int memberPasswordSaltLength;
	
	@Value("${value.member.password.hashingTimes}")     
	private int memberPasswordHashingTimes;
	
	@Value("${value.member.icon.default}")
	private String memberIconDefault;

	//
	// 인스턴스
	//
	
	@Value("${value.tmpCode.limit.minutes}")
	private int tmpCodeLimitMinutes;
	
	@Value("${value.tmpCode.limit.times}")
	private int tmpCodeLimitTimes;
	
	//
	// static getter
	//
	
	public static int getHashingTimes() {
		return staticHashingTimes;
	}
	
	public static String getHashingSalt() {
		return staticHashingSalt;
	}
	
	public static String getEncryptKey() {
		return staticEncryptKey;
	}
	
	public static int getCookieDefaultTime() {
		return staticCookieDefaultTime;
	}
	
	public static int getCookieOneDay() {
		return staticCookieOneDay;
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
	
	//
	// non static getter
	//
	
	public int getTmpCodeLImitMinutes() {
		return tmpCodeLimitMinutes;
	}
	
	public int getTmpCodeLImitTimes() {
		return tmpCodeLimitTimes;
	}
	
}
